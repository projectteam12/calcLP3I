package com.lp3i.myapps.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.lp3i.myapps.R;

import java.util.ArrayList;

public class ListBukuActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ListBukuAdapter adapter;
    ArrayList<Buku> listBuku = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);

        recyclerView = findViewById(R.id.recyclerView);

        Buku buku = new Buku();
        buku.id = 1;
        buku.namaBuku = "VB NET";
        buku.tahunTerbit = "2001";
        buku.penulis = "Abdul";
        listBuku.add(buku);

        adapter = new ListBukuAdapter(listBuku);
        /*ini fungsi utk menentukan layout recylerview nya*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*ini untuk memberikan nilai ke recylerview nya*/
        recyclerView.setAdapter( adapter );
    }

}