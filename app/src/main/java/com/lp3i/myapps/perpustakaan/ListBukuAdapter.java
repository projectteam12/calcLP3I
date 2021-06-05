package com.lp3i.myapps.perpustakaan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp3i.myapps.R;
import com.lp3i.myapps.resto.adapter.OrderAdapter;
import com.lp3i.myapps.resto.model.Order;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.MyViewHolder> {

    /*membuat variabel*/
    private ArrayList<Buku> bukuList;

    /*membuat constructor*/
    public ListBukuAdapter(ArrayList<Buku> bukuList) {
        this.bukuList = bukuList;
    }

    @NonNull
    @Override
    public ListBukuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*untuk memberitahu layout apa yang digunakan*/
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_list_buku, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListBukuAdapter.MyViewHolder holder, int position) {
        holder.tvNamaBuku.setText( bukuList.get(position).namaBuku );
        holder.tvTahunTerbit.setText( bukuList.get(position).tahunTerbit );
    }

    @Override
    public int getItemCount() {
        return bukuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaBuku;
        TextView tvTahunTerbit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaBuku = itemView.findViewById(R.id.tvNamaBuku);
            tvTahunTerbit = itemView.findViewById(R.id.tvTahunTerbit);

        }
    }
}
