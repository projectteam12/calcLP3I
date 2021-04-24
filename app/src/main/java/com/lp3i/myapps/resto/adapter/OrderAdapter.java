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
        holder.tvOrderId.setText( orderList.get(position).nama );
        holder.tvHarga.setText( String.valueOf(orderList.get(position).harga) );

        int qty = 2;

        holder.tvSubtotal.setText( String.valueOf(orderList.get(position).harga * qty) );
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        /*membuat variabel layout item list*/
        TextView tvOrderId;
        TextView tvHarga;
        TextView tvSubtotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tvOrderID);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvSubtotal = itemView.findViewById(R.id.tvSubtotal);
        }
    }
}
