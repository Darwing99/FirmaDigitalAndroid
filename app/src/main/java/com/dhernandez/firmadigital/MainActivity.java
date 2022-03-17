package com.dhernandez.firmadigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dhernandez.firmadigital.clases.Asignaturess;
import com.dhernandez.firmadigital.clases.CaptureImageView;
import com.dhernandez.firmadigital.clases.ConexionSQLite;

import android.app.usage.UsageEvents;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private CaptureImageView mSig;
    private EditText editText;
    private Button button,btnclear;
    ConexionSQLite dbHelper;


    Asignaturess asignaturess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        button=findViewById(R.id.guardar);
        btnclear=findViewById(R.id.limpiar);

        editText=findViewById(R.id.descripcion);
        LinearLayout mContent = (LinearLayout) findViewById(R.id.view);
        mSig = new CaptureImageView(this, null);
        mContent.addView(mSig, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        dbHelper = new ConexionSQLite(this);


        button.setOnClickListener(view -> {
            Bitmap img=  mSig.getBitmap();

          if(validarCampos()){
              boolean estate=dbHelper.insertSQL(editText.getText().toString(),
                      setFrom(img));
              if(estate){
                  Toast.makeText(this, "Firma de "+editText.getText().toString()+" agregada", Toast.LENGTH_SHORT).show();

              }
          }



        });
    btnclear.setOnClickListener(view -> {
        mSig.ClearCanvas();
        editText.setText("");
    });
    }
    public boolean validarCampos(){
        boolean estado=true;
        if(editText.getText().toString().isEmpty() ){
            Toast.makeText(this, "Campo de descripcion vacio", Toast.LENGTH_SHORT).show();
            estado=false;
            return estado;
        }


        if(!mSig.isStatus()){
            Toast.makeText(this, "Debe crear firma", Toast.LENGTH_SHORT).show();
            estado=false;
            return estado;
        }
        return estado;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_superior, menu);
        return true;
    }
    public static byte[] setFrom(Bitmap imagen){
        if(imagen!=null){

            ByteArrayOutputStream stream =new ByteArrayOutputStream();
            imagen.compress(Bitmap.CompressFormat.JPEG,70,stream);
            return stream.toByteArray();

        }
        return null;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId()==R.id.lista_item){
            Intent intent=new Intent(this,List_Firmas.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}