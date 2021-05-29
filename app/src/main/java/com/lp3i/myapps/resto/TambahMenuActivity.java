package com.lp3i.myapps.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lp3i.myapps.R;
import com.lp3i.myapps.resto.model.Order;

import java.util.ArrayList;

public class TambahMenuActivity extends AppCompatActivity {

    private Button btnSimpan;
    private ArrayList<Order> listOrder = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_menu);

        btnSimpan = findViewById(R.id.btnSimpan);

        listOrder = (ArrayList<Order>) getIntent().getSerializableExtra("listArray");

        Log.d("DEBUGGG", String.valueOf(listOrder.get(0).nama) );
        Log.d("DEBUGGG", getIntent().getStringExtra("nama") );
        Log.d("DEBUGGG", String.valueOf(getIntent().getIntExtra("qty", 0)) );

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * cara hapus activity
                 * */
                Intent intent = new Intent();
                intent.putExtra("id", listOrder.size() + 1);
                intent.putExtra("nama", "bubur ayam");
                intent.putExtra("qty", 1);
                intent.putExtra("harga", 15000);

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}