package com.dhernandez.firmadigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.dhernandez.firmadigital.clases.Adaptador;
import com.dhernandez.firmadigital.clases.Asignaturess;
import com.dhernandez.firmadigital.clases.ConexionSQLite;

import java.util.ArrayList;
import java.util.List;

public class List_Firmas extends AppCompatActivity {
    List<Asignaturess> listaItem= new ArrayList<>();;
    RecyclerView recyclerViewItem;
    ConexionSQLite sql;
    Adaptador adaptador;
    LinearLayoutManager layoutManager;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sql=new ConexionSQLite(this);
        setContentView(R.layout.activity_list_firmas);
        listaItem=sql.getData();
        recyclerViewItem = findViewById(R.id.recycler);
        recyclerViewItem.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewItem.setLayoutManager(layoutManager);
        adaptador= new Adaptador(this, listaItem, recyclerViewItem);
        recyclerViewItem.setAdapter(adaptador);




    }



}