package com.pucpr.amigodobairro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textoAviso;
    Button anteriorButton;
    Button proximoButton;

    int index = 0;
    String []images = new String[]{"buraco","ruadanificada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = findViewById(R.id.imageView);
        textoAviso = findViewById(R.id.textoAviso);
        anteriorButton = findViewById(R.id.anteriorButton);
        proximoButton = findViewById(R.id.proximoButton);
    }
}
