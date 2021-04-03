package com.lp3i.myapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    ListView listView;

    /*utk object data list*/
    List<String> list = new ArrayList<String>();
    String listString = "";
    ArrayAdapter adapter;

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
        listView = findViewById(R.id.listView);

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

        btnSamaDengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("=");
            }
        });

        /*
        * membuat adapter utk listView
        * */

        /*utk menampung object data list*/
        adapter =
                new ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        list);

        /*untuk menampilkan*/
        listView.setAdapter( adapter );

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

            listString = input1 + " * " + input2 + " = " + hasil;

        }else if (operator.equals("/")){
            hasil = input1 / input2;

            listString = input1 + " / " + input2 + " = " + hasil;

        }else if (operator.equals("+")){
            hasil = input1 + input2;

            listString = input1 + " + " + input2 + " = " + hasil;

        }else if (operator.equals("-")){
            hasil = input1 - input2;

            listString = input1 + " - " + input2 + " = " + hasil;

        }else{
            /*utk sama dengan*/
            list.add( listString );

            /*refresh*/
            adapter.notifyDataSetChanged();

            /*
             * set hasil ke label
             * */
            tvHasil.setText( listString );
            listString = "";

            Log.d("DEBUGGG", list.toString());
        }


    }


}