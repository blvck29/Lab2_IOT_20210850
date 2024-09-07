package com.app.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText usuarioNombre;
    Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        registerForContextMenu((TextView) findViewById(R.id.telegame));

        usuarioNombre = findViewById(R.id.nombreInput);
        buttonPlay = findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(view -> {

            if (usuarioNombre.getText().toString() != null && !usuarioNombre.getText().toString().trim().isEmpty()) {
                Bundle enviaNombre = new Bundle();
                enviaNombre.putString("usuarioNombre", Objects.requireNonNull(usuarioNombre.getText()).toString());

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtras(enviaNombre);
                startActivity(intent);
            } else {

                usuarioNombre.setError("Por favor, ingresa un nombre");
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        TextView TeleText = findViewById(R.id.telegame);

        if (item.getItemId() == R.id.verde){
            TeleText.setTextColor(Color.parseColor("#32a852"));
        }
        if (item.getItemId() == R.id.rojo){
            TeleText.setTextColor(Color.parseColor("#c92828"));
        }
        if (item.getItemId() == R.id.morado){
            TeleText.setTextColor(Color.parseColor("#6328c9"));
        }


        return super.onContextItemSelected(item);
    }
}