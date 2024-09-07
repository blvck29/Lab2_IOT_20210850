package com.app.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {

    private LinearLayout historialLayout;
    private TextView[] viewResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button buttonReturnGame = findViewById(R.id.returnGame);
        buttonReturnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatsActivity.this, GameActivity.class);

                // Investigué el tema de FLAGS para manejo de la pila de Activities, mencionado en el PPT Clase 02.2 y encontré la siguiente documentación:
                // https://topic.alibabacloud.com/a/flag_activity_clear_top-and-flag_activity_reorder_to_front-usage_8_8_31366808.html
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                startActivity(intent);
            }
        });

        Bundle recibeNombreUsuario = getIntent().getExtras();
        String nombreUsuario = recibeNombreUsuario.getString("usuarioNombre");
        TextView nombreText = findViewById(R.id.nombreJugador);
        nombreText.setText("Jugador: " + nombreUsuario);

        Bundle recibeHistorial = getIntent().getExtras();
        ArrayList<String> historialResultados = recibeHistorial.getStringArrayList("historialResultados");

        Log.d("HISTORIAL_RECIBIDO", String.valueOf(historialResultados));

        historialLayout = findViewById(R.id.historialLayout);
        viewResultados = new TextView[historialResultados.size()];

        for (int i = 0; i<historialResultados.size(); i++) {

            viewResultados[i] = new TextView(this);
            viewResultados[i].setText("Juego " + (i+1) + ": " + historialResultados.get(i));
            viewResultados[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            viewResultados[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            viewResultados[i].setGravity(Gravity.CENTER);
            viewResultados[i].setTextColor(Color.WHITE);

            historialLayout.addView(viewResultados[i]);

        }
    }

}