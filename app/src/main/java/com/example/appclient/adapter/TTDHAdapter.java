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
import com.example.appclient.model.TTDH;

import java.util.List;

public class TTDHAdapter extends RecyclerView.Adapter<TTDHAdapter.TTDHViewHolder> {
    private Context context;
    private List<TTDH> list;

    public TTDHAdapter(Context context, List<TTDH> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TTDHViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ttdh, parent, false);
        return new TTDHViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TTDHViewHolder holder, int position) {
        TTDH ttdh = list.get(position);
        if (ttdh != null){
            holder.textView_dia_diem.setText(ttdh.getDia_diem());
            holder.textView_thoi_gian.setText((CharSequence) ttdh.getThoiGianCapNhat());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TTDHViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_dia_diem, textView_thoi_gian;
        public TTDHViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_dia_diem = itemView.findViewById(R.id.textView_dia_diem);
            textView_thoi_gian = itemView.findViewById(R.id.textView_thoi_gian);
        }
    }
}
