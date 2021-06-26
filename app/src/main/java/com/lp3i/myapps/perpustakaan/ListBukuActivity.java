package com.lp3i.myapps.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;

import com.lp3i.myapps.R;
import com.lp3i.myapps.perpustakaan.sqlite.BukuTable;
import com.lp3i.myapps.perpustakaan.sqlite.DbHelper;

import java.util.ArrayList;

public class ListBukuActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ListBukuAdapter adapter;
    ArrayList<Buku> listBuku = new ArrayList<>();

    /**
     * global variabel
     */
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);

        /**
         * definisi
         */
        recyclerView = findViewById(R.id.recyclerView);

        /**
         * init
         */
        dbHelper = new DbHelper(ListBukuActivity.this);

        listBuku.clear();
        listBuku.addAll( readListBuku() );

        adapter = new ListBukuAdapter(listBuku, new ListBukuAdapter.ListBukuListener() {
            @Override
            public void onClickItem(Buku buku) {
                Log.d("DEBUGGG", "nama buku -> "+ buku.namaBuku);

                /**
                 * panggil activity lain
                 */
                Intent intent = new Intent(ListBukuActivity.this, BukuDetailActivity.class);

                /**
                 * lempar parameter
                 */
                intent.putExtra(BukuTable.FeedEntry.NAMA_BUKU, buku.namaBuku);
                intent.putExtra(BukuTable.FeedEntry.PENULIS, buku.penulis);
                intent.putExtra(BukuTable.FeedEntry.TAHUN_TERBIT, buku.tahunTerbit);

                startActivity(intent);
            }
        });


        /*ini fungsi utk menentukan layout recylerview nya*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*ini untuk memberikan nilai ke recylerview nya*/
        recyclerView.setAdapter( adapter );
    }

    private void createBuku(Buku buku){
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BukuTable.FeedEntry.NAMA_BUKU, buku.namaBuku);
        values.put(BukuTable.FeedEntry.PENULIS, buku.penulis);
        values.put(BukuTable.FeedEntry.TAHUN_TERBIT, buku.tahunTerbit);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BukuTable.FeedEntry.TABLE_NAME, null, values);

        Log.d( "DEBUGGG", "new row id -> "+newRowId );
    }

    private ArrayList<Buku> readListBuku(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        // select namabuku, penulis, tahunterbit from buku;
        String[] projection = {
                BaseColumns._ID,
                BukuTable.FeedEntry.NAMA_BUKU,
                BukuTable.FeedEntry.PENULIS,
                BukuTable.FeedEntry.TAHUN_TERBIT
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = BukuTable.FeedEntry.NAMA_BUKU + " = ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                BukuTable.FeedEntry.TAHUN_TERBIT + " DESC";

        Cursor cursor = db.query(
                BukuTable.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        ArrayList<Buku> books = new ArrayList<Buku>();
        while(cursor.moveToNext()) {

            Buku buku = new Buku();
            buku.namaBuku = cursor.getString( cursor.getColumnIndexOrThrow(BukuTable.FeedEntry.NAMA_BUKU) );
            buku.penulis = cursor.getString( cursor.getColumnIndexOrThrow(BukuTable.FeedEntry.PENULIS) );
            buku.tahunTerbit = cursor.getString( cursor.getColumnIndexOrThrow(BukuTable.FeedEntry.TAHUN_TERBIT) );

            books.add(buku);
        }
        cursor.close();

        return books;
    }

    private void createListBuku(ArrayList<Buku> bukus){
//        // Gets the data repository in write mode
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        // Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(BukuTable.FeedEntry.NAMA_BUKU, buku.namaBuku);
//        values.put(BukuTable.FeedEntry.PENULIS, buku.penulis);
//        values.put(BukuTable.FeedEntry.TAHUN_TERBIT, buku.tahunTerbit);
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId = db.insert(BukuTable.FeedEntry.TABLE_NAME, null, values);
    }

}