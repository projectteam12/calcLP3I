package com.lp3i.myapps.resto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp3i.myapps.R;
import com.lp3i.myapps.resto.model.Order;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    /*membuat variabel*/
    private ArrayList<Order> orderList;

    /*membuat constructor untuk memberikan nilai dari class yang lain*/
    public OrderAdapter(ArrayList<Order> orderList){
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*untuk memberitahu layout apa yang digunakan*/
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_list_menu, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.MyViewHolder holder, int position) {
        /*untuk memberikan nilai ke layout list*/
        holder.tvOrderId.setText( "Order #"+orderList.get(position).id );
        holder.tvNama.setText( "Nama: "+orderList.get(position).nama );
        holder.tvHarga.setText( "@"+String.valueOf(orderList.get(position).harga) );
        holder.tvQty.setText( "Qty: "+String.valueOf(orderList.get(position).qty) );

        holder.tvSubtotal.setText( "Subtotal:"+String.valueOf(orderList.get(position).harga * orderList.get(position).qty) );
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        /*membuat variabel layout item list*/
        TextView tvOrderId;
        TextView tvNama;
        TextView tvHarga;
        TextView tvSubtotal;
        TextView tvQty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tvOrderID);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvQty = itemView.findViewById(R.id.tvQty);
            tvSubtotal = itemView.findViewById(R.id.tvSubtotal);
        }
    }
}
