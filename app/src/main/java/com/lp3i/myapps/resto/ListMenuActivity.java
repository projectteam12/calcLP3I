package com.lp3i.myapps.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lp3i.myapps.R;
import com.lp3i.myapps.resto.adapter.OrderAdapter;
import com.lp3i.myapps.resto.model.Order;

import java.util.ArrayList;

public class ListMenuActivity extends AppCompatActivity {

    private Button btnTambah;
    private RecyclerView recyclerView;
    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        btnTambah = findViewById(R.id.btnTambah);
        recyclerView = findViewById(R.id.recyclerView);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * cara panggil activity lain
                * */
                Intent intent = new Intent(ListMenuActivity.this, TambahMenuActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Order> listOrder = new ArrayList<Order>();

        Order order = new Order();
        order.nama = "kurma";
        order.harga = 2000;
        listOrder.add(order);

        order = new Order();
        order.nama = "susu";
        order.harga = 1500;
        listOrder.add(order);

        adapter = new OrderAdapter(listOrder);

        /*ini fungsi utk menentukan layout recylerview nya*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*ini untuk memberikan nilai ke recylerview nya*/
        recyclerView.setAdapter( adapter );

    }
}