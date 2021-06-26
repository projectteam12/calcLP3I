package com.lp3i.myapps.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lp3i.myapps.R;
import com.lp3i.myapps.perpustakaan.sqlite.BukuTable;

public class BukuDetailActivity extends AppCompatActivity {

    /**
     * definisi
     */
    TextView tvNamaBuku, tvDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_detail);

        /**
         * find
         */
        tvNamaBuku = findViewById(R.id.tvNamaBuku);
        tvDeskripsi = findViewById(R.id.tvDesc);

        /**
         * ambil nilai dari parameter yg di kirim
         */
        String namaBuku = getIntent().getStringExtra(BukuTable.FeedEntry.NAMA_BUKU);
        String penulis = getIntent().getStringExtra(BukuTable.FeedEntry.PENULIS);
        String tahunTerbit = getIntent().getStringExtra(BukuTable.FeedEntry.TAHUN_TERBIT);

        tvNamaBuku.setText( namaBuku );
        tvDeskripsi.setText( penulis +"\n"+tahunTerbit );

    }



}