package com.example.appclient.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appclient.MainActivity;
import com.example.appclient.R;
import com.example.appclient.api.ApiService;
import com.example.appclient.databinding.FragmentHomeBinding;
import com.example.appclient.model.MatHang;
import com.example.appclient.model.TTDH;
import com.example.appclient.model.TheoDoiTrangThai;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public static final String TOKEN = "5429786210";
    FragmentHomeBinding binding;

    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);


        binding.btnSearch.setOnClickListener(view -> {

            if(!binding.edtMaDH.getText().toString().trim().isEmpty()){
                clickCallApi();
            }
            else {
            }

        });
        return binding.getRoot();
    }

    private void clickCallApi() {

        ApiService.apiService.theoDoiTrangThaiCall(binding.edtMaDH.getText().toString().trim(), TOKEN)
                .enqueue(new Callback<TheoDoiTrangThai>() {
                    @Override
                    public void onResponse(Call<TheoDoiTrangThai> call,
                                           Response<TheoDoiTrangThai> response) {

                        TheoDoiTrangThai theoDoiTrangThai = response.body();

//                        String tenKH = theoDoiTrangThai.getKh().getTen();
//                        textView_ten_nguoi_dung.setText(tenKH);



                        StringBuilder shipperInfor = new StringBuilder("");
                        shipperInfor.append("Thong tin Shipper:");
                        shipperInfor.append("\n");
                        shipperInfor.append("Ten: ");
                        shipperInfor.append(theoDoiTrangThai.getS().getTen());
                        shipperInfor.append("\n");
                        shipperInfor.append("SDT: ");
                        shipperInfor.append(theoDoiTrangThai.getS().getSDT());
                        shipperInfor.append("\n");
                        shipperInfor.append("Gioi tinh: ");
                        Log.d("sdt", "sdt shipper: " + theoDoiTrangThai.getS().getSDT()
                                + theoDoiTrangThai.getS().getTen() + theoDoiTrangThai.getS().getGioiTinh());
                        Boolean gioiTinhShipper = theoDoiTrangThai.getS().getGioiTinh();
                        if (gioiTinhShipper){
                            shipperInfor.append("Nam");
                        }
                        else{
                            shipperInfor.append("Nu");
                        }
                        binding.tvShipper.setText(shipperInfor);
                        ///
                        List<MatHang> matHangList = theoDoiTrangThai.getListMh();
                        for (MatHang x: matHangList) {
                            binding.tvProductName.setText(x.getTen());
                            binding.tvPrice.setText(x.getGia()+"");
                            binding.tvSoLuong.setText(x.getSoLuong()+"");
                            binding.tvSellLocal.setText(x.getNoiBan());
                        }

                        List<TTDH> ttdhList = theoDoiTrangThai.getListTtdh();
                        int size = ttdhList.size();
                        int count = 1;

                        if(count <= size){

                            binding.tvDiaDiem1.setText(ttdhList.get(count -1).getDia_diem()+"");
                            binding.tvTime1.setText(ttdhList.get(count -1).getThoiGianCapNhat()+"");
                            binding.imgComplete1.setImageResource(R.drawable.ic_mark);
                            count+=1;
                        }else{
                            binding.tvDiaDiem1.setText("Dang cho");
                            binding.tvTime1.setText("Dang cho");
                            binding.imgComplete1.setImageResource(R.drawable.ic_timeclock);
                        }


                        if(count <= size){

                            binding.tvDiaDiem2.setText(ttdhList.get(count -1).getDia_diem()+"");
                            binding.tvTime2.setText(ttdhList.get(count -1).getThoiGianCapNhat()+"");
                            binding.imgComplete2.setImageResource(R.drawable.ic_mark);
                            count+=1;
                        }else{
                            binding.tvDiaDiem2.setText("Dang cho");
                            binding.tvTime2.setText("Dang cho");
                            binding.imgComplete2.setImageResource(R.drawable.ic_timeclock);
                        }



                        if(count <= size){
                            binding.tvDiaDiem3.setText(ttdhList.get(count -1).getDia_diem()+"");
                            binding.tvTime3.setText(ttdhList.get(count -1).getThoiGianCapNhat()+"");
                            binding.imgComplete3.setImageResource(R.drawable.ic_mark);
                            count+=1;
                        }else{
                            binding.tvDiaDiem3.setText("Dang cho");
                            binding.tvTime3.setText("Dang cho");
                            binding.imgComplete3.setImageResource(R.drawable.ic_timeclock);
                        }

//
//                        StringBuilder kqTTDH = new StringBuilder("");
//                        for (TTDH x: ttdhList) {
//                            kqTTDH.append("Địa điểm: ");
//                            kqTTDH.append(x.getDia_diem());
//                            kqTTDH.append("\n");
//
//                            kqTTDH.append("Thời gian cập nhật: ");
//                            kqTTDH.append(x.getThoiGianCapNhat());
//                            kqTTDH.append("\n");
//
//                            kqTTDH.append("\n\n");
//                        }
//                        textView_list_ttdh.setText(kqTTDH);

                    }

                    @Override
                    public void onFailure(Call<TheoDoiTrangThai> call, Throwable t) {
                        Log.d("CallApi", "Error: " + t.getMessage());
                    }
                });
    }
}