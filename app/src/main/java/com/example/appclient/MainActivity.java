package com.example.appclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appclient.adapter.MatHangAdapter;
import com.example.appclient.adapter.TTDHAdapter;
import com.example.appclient.api.ApiService;
import com.example.appclient.model.MatHang;
import com.example.appclient.model.TTDH;
import com.example.appclient.model.TheoDoiTrangThai;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TOKEN = "5429786210";
    private EditText edit_ma_don_hang;
    private Button button_tim_kiem;
    private TextView textView_ten_nguoi_dung, textView_ten_shipper,
            textView_sdt_shipper, textView_gioi_tinh_shipper, textView_list_mat_hang, textView_list_ttdh;

//    private MatHangAdapter matHangAdapter;
//    private TTDHAdapter ttdhAdapter;
//    private RecyclerView recyclerView_mat_hang, recyclerView_ttdh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_ma_don_hang = findViewById(R.id.edit_ma_don_hang);
        button_tim_kiem = findViewById(R.id.button_tim_kiem);

        textView_ten_nguoi_dung = findViewById(R.id.textView_ten_nguoi_dung);

        textView_ten_shipper = findViewById(R.id.textView_ten_shipper);
        textView_sdt_shipper = findViewById(R.id.textView_sdt_shipper);
        textView_gioi_tinh_shipper = findViewById(R.id.textView_gioi_tinh_shipper);

        textView_list_mat_hang = findViewById(R.id.textView_list_mat_hang);
        textView_list_ttdh = findViewById(R.id.textView_list_ttdh);

        button_tim_kiem.setOnClickListener(v -> {
            if(!edit_ma_don_hang.getText().toString().trim().isEmpty()){
                clickCallApi();
            }
            else {
                Toast.makeText(MainActivity.this, "Nhập mã đơn hàng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clickCallApi() {
        ApiService.apiService.theoDoiTrangThaiCall(edit_ma_don_hang.getText().toString().trim(), TOKEN)
                .enqueue(new Callback<TheoDoiTrangThai>() {
                    @Override
                    public void onResponse(Call<TheoDoiTrangThai> call,
                                           Response<TheoDoiTrangThai> response) {

                        TheoDoiTrangThai theoDoiTrangThai = response.body();

                        String tenKH = theoDoiTrangThai.getKh().getTen();
                        textView_ten_nguoi_dung.setText(tenKH);

                        String tenShipper = theoDoiTrangThai.getS().getTen();
                        String sdtShipper = theoDoiTrangThai.getS().getSDT();
                        Log.d("sdt", "sdt shipper: " + theoDoiTrangThai.getS().getSDT()
                                + theoDoiTrangThai.getS().getTen() + theoDoiTrangThai.getS().getGioiTinh());
                        Boolean gioiTinhShipper = theoDoiTrangThai.getS().getGioiTinh();
                        if (gioiTinhShipper){
                            textView_gioi_tinh_shipper.setText("Nam");
                        }
                        else{
                            textView_gioi_tinh_shipper.setText("Nữ");
                        }

                        textView_ten_shipper.setText(tenShipper);
                        textView_sdt_shipper.setText(sdtShipper);

                        List<MatHang> matHangList = theoDoiTrangThai.getListMh();
                        StringBuilder kqMatHang = new StringBuilder("");
                        for (MatHang x: matHangList) {
                            kqMatHang.append("Tên: ");
                            kqMatHang.append(x.getTen());
                            kqMatHang.append("\n");

                            kqMatHang.append("Giá: ");
                            kqMatHang.append(x.getGia());
                            kqMatHang.append("\n");

                            kqMatHang.append("Số lượng: ");
                            kqMatHang.append(x.getSoLuong());
                            kqMatHang.append("\n");

                            kqMatHang.append("Nơi bán: ");
                            kqMatHang.append(x.getNoiBan());
                            kqMatHang.append("\n");

                            kqMatHang.append("\n\n");
                        }
                        textView_list_mat_hang.setText(kqMatHang);

                        List<TTDH> ttdhList = theoDoiTrangThai.getListTtdh();
                        StringBuilder kqTTDH = new StringBuilder("");
                        for (TTDH x: ttdhList) {
                            kqTTDH.append("Địa điểm: ");
                            kqTTDH.append(x.getDia_diem());
                            kqTTDH.append("\n");

                            kqTTDH.append("Thời gian cập nhật: ");
                            kqTTDH.append(x.getThoiGianCapNhat());
                            kqTTDH.append("\n");

                            kqTTDH.append("\n\n");
                        }
                        textView_list_ttdh.setText(kqTTDH);

                    }

                    @Override
                    public void onFailure(Call<TheoDoiTrangThai> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("CallApi", "Error: " + t.getMessage());
                    }
                });


    }
}