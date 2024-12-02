package com.pucpr.amigodobairro;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    LinearLayoutManager layoutManager;

    Button anteriorButton, proximoButton;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        recyclerView = findViewById(R.id.recyclerView);
        anteriorButton = findViewById(R.id.anteriorButton);
        proximoButton = findViewById(R.id.proximoButton);

        // Configuração da RecyclerView
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Dados
        List<ImageItem> items = new ArrayList<>();
        items.add(new ImageItem("buraco", "Buraco na rua Ril Vicente!"));
        items.add(new ImageItem("ruadanificada", "Rua General Paolis está temporariamente interditada!"));
        items.add(new ImageItem("casa", "Casa invadida durante a noite na Rua das Margaridas!"));

        imageAdapter = new ImageAdapter(items, this);
        recyclerView.setAdapter(imageAdapter);

        // Botões de navegação
        anteriorButton.setOnClickListener(v -> navigateToItem(false));
        proximoButton.setOnClickListener(v -> navigateToItem(true));
    }

    private void navigateToItem(boolean next) {
        if (next) {
            currentIndex++;
            if (currentIndex >= imageAdapter.getItemCount()) {
                currentIndex = 0; // Volta ao início
            }
        } else {
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = imageAdapter.getItemCount() - 1; // Vai ao final
            }
        }
        recyclerView.smoothScrollToPosition(currentIndex);
    }
}
