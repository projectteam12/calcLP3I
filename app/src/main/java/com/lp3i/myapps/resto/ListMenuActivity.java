package com.lp3i.myapps.resto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private ArrayList<Order> listOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        btnTambah = findViewById(R.id.btnTambah);
        recyclerView = findViewById(R.id.recyclerView);

        listOrder = new ArrayList<Order>();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * cara panggil activity lain
                * */
                Intent intent = new Intent(ListMenuActivity.this, TambahMenuActivity.class);
                intent.putExtra("listArray", listOrder);
                intent.putExtra("nama", "nasi goreng");
                intent.putExtra("qty", 1);
                startActivityForResult(intent, 111);

            }
        });

        Order order = new Order();
        order.id = 1;
        order.nama = "kurma";
        order.harga = 2000;
        order.qty = 2;
        listOrder.add(order);

        adapter = new OrderAdapter(listOrder);

        /*ini fungsi utk menentukan layout recylerview nya*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*ini untuk memberikan nilai ke recylerview nya*/
        recyclerView.setAdapter( adapter );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111){
            if (resultCode == RESULT_OK){
                Order order = new Order();
                order.id = data.getIntExtra("id", 0);
                order.nama = data.getStringExtra("nama");
                order.harga = data.getIntExtra("harga", 0);
                order.qty = data.getIntExtra("qty", 0);
                listOrder.add(order);

                adapter.notifyDataSetChanged();
            }
        }

        Log.d("DEBUGGG", "onActivityResult");
    }
}