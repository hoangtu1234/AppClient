package com.example.appclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appclient.R;
import com.example.appclient.model.MatHang;

import java.util.List;

public class MatHangAdapter extends RecyclerView.Adapter<MatHangAdapter.MatHangViewHolder> {
    private Context context;
    private List<MatHang> list;

    public MatHangAdapter(Context context, List<MatHang> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mat_hang, parent, false);
        return new MatHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatHangViewHolder holder, int position) {
        MatHang matHang = list.get(position);
        if (matHang != null){
            holder.textView_ten_hang.setText(matHang.getTen());
            holder.textView_gia.setText(String.valueOf(matHang.getGia()));
            holder.textView_so_luong_hang.setText(matHang.getSoLuong());
            holder.textView_noi_ban_hang.setText(matHang.getNoiBan());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MatHangViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_ten_hang, textView_gia, textView_so_luong_hang, textView_noi_ban_hang;
        public MatHangViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_ten_hang = itemView.findViewById(R.id.textView_ten_hang);
            textView_gia = itemView.findViewById(R.id.textView_gia);
            textView_so_luong_hang = itemView.findViewById(R.id.textView_so_luong_hang);
            textView_noi_ban_hang = itemView.findViewById(R.id.textView_noi_ban_hang);
        }
    }
}
