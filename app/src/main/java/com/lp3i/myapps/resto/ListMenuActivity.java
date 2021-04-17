package com.lp3i.myapps.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lp3i.myapps.R;

public class ListMenuActivity extends AppCompatActivity {

    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        btnTambah = findViewById(R.id.btnTambah);

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

    }
}