package com.lp3i.myapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    * 1. Buat variabel
    * */
    TextView tvHasil;
    Button btnKali;
    Button btnBagi;
    Button btnTambah;
    Button btnKurang;
    Button btnSamaDengan;
    EditText etInput;
    EditText etInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * 2. Definisikan variabel dengan XML
        * */
        tvHasil = findViewById(R.id.tvHasil);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnSamaDengan = findViewById(R.id.btnSamaDengan);
        etInput = findViewById(R.id.etInput);
        etInput2 = findViewById(R.id.etInput2);

        /*
        * 3. Buat eventnya
        * */
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                * panggil function
                * */
                hitung("*");

            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * panggil function
                 * */
                hitung("-");
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * panggil function
                 * */
                hitung("+");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * panggil function
                 * */
                hitung("/");
            }
        });

        /*
        * TUGAS
        *
        *
        * */

    }

    private void hitung(String operator){

        /*
         * get value input 1
         * */
        int input1 = Integer.valueOf(etInput.getText().toString());
        int input2 = Integer.valueOf(etInput2.getText().toString());

//        int hasil = input1 * input2;
        int hasil = 0;

        if (operator.equals("*")){
            hasil = input1 * input2;
        }else{
            hasil = input1 / input2;
        }

        /*
         * set hasil ke label
         * */
        tvHasil.setText( String.valueOf(hasil) );
    }


}