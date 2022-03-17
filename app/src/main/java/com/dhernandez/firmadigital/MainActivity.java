package com.dhernandez.firmadigital;

import androidx.appcompat.app.AppCompatActivity;
import com.dhernandez.firmadigital.clases.CaptureImageView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private CaptureImageView mSig;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.guardar);
        LinearLayout mContent = (LinearLayout) findViewById(R.id.view);
        mSig = new CaptureImageView(this, null);
        mContent.addView(mSig, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        button.setOnClickListener(view -> {
            Bitmap img=  mSig.getBitmap();


        });
    }

}