package com.app.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.ChipGroup;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    private ArrayList<String> historialResultados = new ArrayList<>();
    private String estadoGame = "PLAYING";

    private String[] listPalabras;
    private Random random;

    private String palabraActual;
    private ArrayList<String> letrasDescubiertas;
    int contadorMatchs;
    private int vidas;

    private ChipGroup casillasPalabra;
    private TextView[] viewLetra;

    LinearLayout resultText;

    // Cronómetro de juego
    private Instant inicio;
    private Instant fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setTitle("TeleGame");

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonA = findViewById(R.id.A);
        buttonA.setOnClickListener(view -> handleClickTeclado("A", buttonA));

        Button buttonB = findViewById(R.id.B);
        buttonB.setOnClickListener(view -> handleClickTeclado("B", buttonB));

        Button buttonC = findViewById(R.id.C);
        buttonC.setOnClickListener(view -> handleClickTeclado("C", buttonC));

        Button buttonD = findViewById(R.id.D);
        buttonD.setOnClickListener(view -> handleClickTeclado("D", buttonD));

        Button buttonE = findViewById(R.id.E);
        buttonE.setOnClickListener(view -> handleClickTeclado("E", buttonE));

        Button buttonF = findViewById(R.id.F);
        buttonF.setOnClickListener(view -> handleClickTeclado("F", buttonF));

        Button buttonG = findViewById(R.id.G);
        buttonG.setOnClickListener(view -> handleClickTeclado("G", buttonG));

        Button buttonH = findViewById(R.id.H);
        buttonH.setOnClickListener(view -> handleClickTeclado("H", buttonH));

        Button buttonI = findViewById(R.id.I);
        buttonI.setOnClickListener(view -> handleClickTeclado("I", buttonI));

        Button buttonJ = findViewById(R.id.J);
        buttonJ.setOnClickListener(view -> handleClickTeclado("J", buttonJ));

        Button buttonK = findViewById(R.id.K);
        buttonK.setOnClickListener(view -> handleClickTeclado("K", buttonK));

        Button buttonL = findViewById(R.id.L);
        buttonL.setOnClickListener(view -> handleClickTeclado("L", buttonL));

        Button buttonM = findViewById(R.id.M);
        buttonM.setOnClickListener(view -> handleClickTeclado("M", buttonM));

        Button buttonN = findViewById(R.id.N);
        buttonN.setOnClickListener(view -> handleClickTeclado("N", buttonN));

        Button buttonO = findViewById(R.id.O);
        buttonO.setOnClickListener(view -> handleClickTeclado("O", buttonO));

        Button buttonP = findViewById(R.id.P);
        buttonP.setOnClickListener(view -> handleClickTeclado("P", buttonP));

        Button buttonQ = findViewById(R.id.Q);
        buttonQ.setOnClickListener(view -> handleClickTeclado("Q", buttonQ));

        Button buttonR = findViewById(R.id.R);
        buttonR.setOnClickListener(view -> handleClickTeclado("R", buttonR));

        Button buttonS = findViewById(R.id.S);
        buttonS.setOnClickListener(view -> handleClickTeclado("S", buttonS));

        Button buttonT = findViewById(R.id.T);
        buttonT.setOnClickListener(view -> handleClickTeclado("T", buttonT));

        Button buttonU = findViewById(R.id.U);
        buttonU.setOnClickListener(view -> handleClickTeclado("U", buttonU));

        Button buttonV = findViewById(R.id.V);
        buttonV.setOnClickListener(view -> handleClickTeclado("V", buttonV));

        Button buttonW = findViewById(R.id.W);
        buttonW.setOnClickListener(view -> handleClickTeclado("W", buttonW));

        Button buttonX = findViewById(R.id.X);
        buttonX.setOnClickListener(view -> handleClickTeclado("X", buttonX));

        Button buttonY = findViewById(R.id.Y);
        buttonY.setOnClickListener(view -> handleClickTeclado("Y", buttonY));

        Button buttonZ = findViewById(R.id.Z);
        buttonZ.setOnClickListener(view -> handleClickTeclado("Z", buttonZ));

        listPalabras = getResources().getStringArray(R.array.palabras);
        random = new Random();
        casillasPalabra = findViewById(R.id.casillas);
        resultText = findViewById(R.id.resultados);

        recibirBundleNombre();

        initGame();


        // Jugar de Nuevo

        Button playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(view -> {
            casillasPalabra.removeAllViews();
            resultText.removeAllViews();

            findViewById(R.id.A).setEnabled(true);
            findViewById(R.id.B).setEnabled(true);
            findViewById(R.id.C).setEnabled(true);
            findViewById(R.id.D).setEnabled(true);
            findViewById(R.id.E).setEnabled(true);
            findViewById(R.id.F).setEnabled(true);
            findViewById(R.id.G).setEnabled(true);
            findViewById(R.id.H).setEnabled(true);
            findViewById(R.id.I).setEnabled(true);
            findViewById(R.id.J).setEnabled(true);
            findViewById(R.id.K).setEnabled(true);
            findViewById(R.id.L).setEnabled(true);
            findViewById(R.id.M).setEnabled(true);
            findViewById(R.id.N).setEnabled(true);
            findViewById(R.id.O).setEnabled(true);
            findViewById(R.id.P).setEnabled(true);
            findViewById(R.id.Q).setEnabled(true);
            findViewById(R.id.R).setEnabled(true);
            findViewById(R.id.S).setEnabled(true);
            findViewById(R.id.T).setEnabled(true);
            findViewById(R.id.U).setEnabled(true);
            findViewById(R.id.V).setEnabled(true);
            findViewById(R.id.W).setEnabled(true);
            findViewById(R.id.X).setEnabled(true);
            findViewById(R.id.Y).setEnabled(true);
            findViewById(R.id.Z).setEnabled(true);

            if (estadoGame.equals("PLAYING")){
                historialResultados.add("Canceló");
            }

            initGame();

        });


    }

    private void initGame(){

        // Cronómetro de juego
        inicio = Instant.now();

        letrasDescubiertas = new ArrayList<>();
        vidas = 6;

        // No hay piezas de teleco (full vida)
        findViewById(R.id.cabeza).setVisibility(View.INVISIBLE);
        findViewById(R.id.torso).setVisibility(View.INVISIBLE);
        findViewById(R.id.brazoDerecha).setVisibility(View.INVISIBLE);
        findViewById(R.id.brazoIzquierda).setVisibility(View.INVISIBLE);
        findViewById(R.id.piernaIzquierda).setVisibility(View.INVISIBLE);
        findViewById(R.id.piernaDerecha).setVisibility(View.INVISIBLE);


        String palabraOculta = listPalabras[random.nextInt(listPalabras.length)];

        while (palabraOculta.equals(palabraActual)) {
            palabraOculta = listPalabras[random.nextInt(listPalabras.length)];
        }

        palabraActual = palabraOculta;
        Log.d("INFO", "Palabra Aleatoria:" + " " + palabraActual);

        viewLetra = new TextView[palabraActual.length()];

        for (int i = 0; i<palabraActual.length(); i++){
            viewLetra[i] = new TextView(this);
            viewLetra[i].setBackgroundResource(R.drawable.bg_letras);

            casillasPalabra.addView(viewLetra[i]);
        }
    }

    private void handleClickTeclado(String letra, Button boton) {
        if (palabraActual.contains(letra)) {
            letrasDescubiertas.add(letra);
            showLetters();
        } else {
            vidas = vidas - 1;
            badLetter();
        }
        boton.setEnabled(false);
    }


    private void showLetters(){

        Log.d("LETRAS_DESC", String.valueOf(letrasDescubiertas));

        contadorMatchs = 0;

        for (String letra : letrasDescubiertas) {

            for (int i = 0; i < palabraActual.length(); i++) {

                if (letra.equals(String.valueOf(palabraActual.charAt(i)))) {

                    viewLetra[i].setText(String.valueOf(palabraActual.charAt(i)));
                    viewLetra[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    viewLetra[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                    viewLetra[i].setGravity(Gravity.CENTER);
                    viewLetra[i].setTextColor(Color.BLACK);
                    viewLetra[i].setBackgroundResource(R.drawable.bg_letras);

                    contadorMatchs = contadorMatchs+1;
                }
            }
        }

        if (contadorMatchs == palabraActual.length()){
            Log.d("GANO", "Entrada a endGame ganando.");
            estadoGame = "WIN";
            endGame();
        } else {
            estadoGame = "PLAYING";
        }

    }


    private void badLetter() {

        if (vidas == 5){
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            estadoGame = "PLAYING";
        } else if (vidas == 4){
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            findViewById(R.id.torso).setVisibility(View.VISIBLE);
            estadoGame = "PLAYING";
        } else if (vidas == 3) {
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            findViewById(R.id.torso).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoDerecha).setVisibility(View.VISIBLE);
            estadoGame = "PLAYING";
        } else if (vidas == 2) {
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            findViewById(R.id.torso).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoDerecha).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoIzquierda).setVisibility(View.VISIBLE);
            estadoGame = "PLAYING";
        } else if (vidas == 1) {
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            findViewById(R.id.torso).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoDerecha).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoIzquierda).setVisibility(View.VISIBLE);
            findViewById(R.id.piernaIzquierda).setVisibility(View.VISIBLE);
            estadoGame = "PLAYING";
        } else if (vidas == 0){
            findViewById(R.id.cabeza).setVisibility(View.VISIBLE);
            findViewById(R.id.torso).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoDerecha).setVisibility(View.VISIBLE);
            findViewById(R.id.brazoIzquierda).setVisibility(View.VISIBLE);
            findViewById(R.id.piernaIzquierda).setVisibility(View.VISIBLE);
            findViewById(R.id.piernaDerecha).setVisibility(View.VISIBLE);
            Log.d("PERDIO", "Entrada a endGame perdiendo.");
            estadoGame = "LOSS";
            endGame();
        }

    }

    private void recibirBundleNombre() {
        Bundle recibeNombre = getIntent().getExtras();
        String nombre = recibeNombre.getString("usuarioNombre");
        Log.d("NOMBRE_USUARIO", nombre);
    }


    private void endGame() {

        // Cronómetro de juego
        fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toSeconds();

        findViewById(R.id.A).setEnabled(false);
        findViewById(R.id.B).setEnabled(false);
        findViewById(R.id.C).setEnabled(false);
        findViewById(R.id.D).setEnabled(false);
        findViewById(R.id.E).setEnabled(false);
        findViewById(R.id.F).setEnabled(false);
        findViewById(R.id.G).setEnabled(false);
        findViewById(R.id.H).setEnabled(false);
        findViewById(R.id.I).setEnabled(false);
        findViewById(R.id.J).setEnabled(false);
        findViewById(R.id.K).setEnabled(false);
        findViewById(R.id.L).setEnabled(false);
        findViewById(R.id.M).setEnabled(false);
        findViewById(R.id.N).setEnabled(false);
        findViewById(R.id.O).setEnabled(false);
        findViewById(R.id.P).setEnabled(false);
        findViewById(R.id.Q).setEnabled(false);
        findViewById(R.id.R).setEnabled(false);
        findViewById(R.id.S).setEnabled(false);
        findViewById(R.id.T).setEnabled(false);
        findViewById(R.id.U).setEnabled(false);
        findViewById(R.id.V).setEnabled(false);
        findViewById(R.id.W).setEnabled(false);
        findViewById(R.id.X).setEnabled(false);
        findViewById(R.id.Y).setEnabled(false);
        findViewById(R.id.Z).setEnabled(false);

        TextView resultados = new TextView(this);
        resultados.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        resultados.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        resultados.setGravity(Gravity.CENTER);
        resultados.setTextColor(Color.BLACK);

        String tiempo = String.valueOf(duracion);

        String resultadoTiempo = null;

        if (vidas == 0){
            resultadoTiempo = "Perdió en " + tiempo + " segundos.";
        } else if (contadorMatchs == palabraActual.length()){
            resultadoTiempo = "Ganó en " + tiempo + " segundos.";
        }
        resultados.setText(resultadoTiempo);

        historialResultados.add(resultadoTiempo);
        Log.d("HISTORIAL", historialResultados.get(historialResultados.size()-1));
        resultText.addView(resultados);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.stats){
            Log.d("STATISTICS", "To stats page.");

            Bundle historialBundle = new Bundle();

            historialBundle.putStringArrayList("historialResultados", historialResultados);

            Intent intent = new Intent(GameActivity.this, StatsActivity.class);
            intent.putExtras(historialBundle);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu,menu);
        return true;
    }
}