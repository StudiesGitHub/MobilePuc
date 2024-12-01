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
    String[] images = new String[]{"buraco", "ruadanificada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView = findViewById(R.id.imageView);
        textoAviso = findViewById(R.id.textoAviso);
        anteriorButton = findViewById(R.id.anteriorButton);
        proximoButton = findViewById(R.id.proximoButton);

        // Definir ação do botão "Anterior"
        anteriorButton.setOnClickListener(v -> {
            index--;
            if (index < 0) {
                index = images.length - 1; // Volta para a última imagem se o índice for negativo
            }
            atualizarImagem();
        });

        // Definir ação do botão "Próximo"
        proximoButton.setOnClickListener(v -> {
            index++;
            if (index >= images.length) {
                index = 0; // Volta para a primeira imagem se o índice for maior ou igual ao tamanho
            }
            atualizarImagem();
        });

        // Atualizar a imagem e o texto de aviso no início
        atualizarImagem();
    }

    // Método para atualizar a imagem e o texto
    private void atualizarImagem() {
        // Atualize a imagem no ImageView
        int imageResId = getResources().getIdentifier(images[index], "drawable", getPackageName());
        imageView.setImageResource(imageResId);

        // Atualize o texto de aviso
        textoAviso.setText("Imagem: " + images[index]);
    }
}
