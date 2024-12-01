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
    String[] images = new String[]{"buraco", "ruadanificada", "casa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView = findViewById(R.id.imageView);
        textoAviso = findViewById(R.id.textoAviso);
        anteriorButton = findViewById(R.id.anteriorButton);
        proximoButton = findViewById(R.id.proximoButton);

        anteriorButton.setOnClickListener(v -> {
            index--;
            if (index < 0) {
                index = images.length - 1;
            }
            atualizarImagem();
        });

        proximoButton.setOnClickListener(v -> {
            index++;
            if (index >= images.length) {
                index = 0;
            }
            atualizarImagem();
        });

        atualizarImagem();
    }

    private void atualizarImagem() {
        int imageResId = getResources().getIdentifier(images[index], "drawable", getPackageName());
        imageView.setImageResource(imageResId);

        if (images[index].equals("buraco")) {
            textoAviso.setText("Buraco na rua Ril Vicente!");
        } else if (images[index].equals("ruadanificada")) {
            textoAviso.setText("Rua General Paolis está temporariamente interditada!");
        } else if (images[index].equals("casa")) {
            textoAviso.setText("Casa invadida durante a noite na Rua das Margaridas!");
        }
    }
}
