package com.lp3i.myapps.perpustakaan.sqlite;

import android.provider.BaseColumns;

public final class BukuTable {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private BukuTable() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "buku";
        public static final String NAMA_BUKU = "nama_buku";
        public static final String TAHUN_TERBIT = "tahun_terbit";
        public static final String PENULIS = "penulis";
    }
}