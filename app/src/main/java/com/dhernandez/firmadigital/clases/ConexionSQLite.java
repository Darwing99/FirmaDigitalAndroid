package com.dhernandez.firmadigital.clases;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dhernandez.firmadigital.MainActivity;

public class ConexionSQLite extends SQLiteOpenHelper {


    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE firmadigital(_id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT, imagen Blob)";
    private static final String database_name = "firmasqlite.sqlite";
    private static final int version_database = 1;


    public ConexionSQLite(MainActivity context) {
        super(context, database_name, null, version_database);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(COMMENTS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
