package com.app.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.ChipGroup;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private String[] listPalabras;
    private Random random;

    private String palabraActual;

    private ChipGroup casillasPalabra;
    private TextView[] viewLetra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listPalabras = getResources().getStringArray(R.array.palabras);
        random = new Random();
        casillasPalabra = findViewById(R.id.casillas);

        initGame();

    }


    private void initGame(){

        String palabraOculta = listPalabras[random.nextInt(listPalabras.length)];
        Log.d("INFO", "Palabra Aleatoria:" + " " + palabraOculta);

        while (palabraOculta.equals(palabraActual)) {
            palabraOculta = listPalabras[random.nextInt(listPalabras.length)];
        }

        palabraActual = palabraOculta;

        viewLetra = new TextView[palabraActual.length()];

        for (int i = 0; i<palabraActual.length(); i++){
            viewLetra[i] = new TextView(this);
            viewLetra[i].setText(String.valueOf(palabraActual.charAt(i)));
            viewLetra[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            viewLetra[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            viewLetra[i].setGravity(Gravity.CENTER);
            viewLetra[i].setTextColor(Color.BLACK);

            casillasPalabra.addView(viewLetra[i]);
        }

    }

    private void GetLetters() {

        // Aqui iría un método para entender cada click en el teclado como un String y comparar con la palabraOculta.

    }


    private void checkLetter(){
        for (int i = 0; i<palabraActual.length(); i++){
            viewLetra[i] = new TextView(this);
            viewLetra[i].setText(palabraActual.charAt(i));
            viewLetra[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            viewLetra[i].setGravity(Gravity.CENTER);
            viewLetra[i].setTextColor(Color.BLACK);

            casillasPalabra.addView(viewLetra[i]);
        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.back){
            Log.d("msgOptMainMenu","Return");
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if (item.getItemId() == R.id.stats){
            Log.d("msgOptMainMenu","Stats");
            return true;
        }

        return super .onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu,menu);
        return true;
    }
}