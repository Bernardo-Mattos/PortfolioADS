package com.example.calculadorahoras;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText horaInicial, horaFinal, minutoInical, minutoFinal;
    TextView resultadoHora, doisPontos, resultadoMinuto;
    int horaI;
    int horaF;
    int minI;
    int minF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        horaInicial = findViewById(R.id.horaInicial);
        horaFinal = findViewById(R.id.horaFinal);
        minutoInical = findViewById(R.id.minutoInicial);
        minutoFinal = findViewById(R.id.minutoFinal);
        resultadoHora = findViewById(R.id.resultadoHora);
        doisPontos.setVisibility(View.INVISIBLE);
        resultadoMinuto = findViewById(R.id.resultadoMinuto);
    }

    public void somar(View v) {
        cataCampos();

        int rH = horaI + horaF;
        int rM = minI + minF;

        while (rM > 59) {
            rM -= 60;
            rH++;
        }

        resultadoHora.setText(rH + "");
        doisPontos.setVisibility(View.VISIBLE);
        resultadoMinuto.setText(rM + "");
    }

    public void subtrair(View v) {
        cataCampos();

        while (minF > 59) {
            minF -= 60;
            horaF++;
        }

        while (minI > 59) {
            minI -= 60;
            horaI++;
        }

        int rH = horaF - horaI;
        int rM = minF - minI;

        if (horaI > horaF) {
            rH = horaI - horaF;
            rM = minI - minF;
        }

        while (rM < 0) {
            rM += 60;
            rH--;
        }

        while (rM > 59) {
            rM -= 60;
            rH++;
            horaF++;
        }

        resultadoHora.setText(rH + "");
        doisPontos.setVisibility(View.VISIBLE);
        resultadoMinuto.setText(rM + "");
    }

    public void limpar(View v) {
        horaInicial.setText(null);
        horaFinal.setText(null);
        minutoInical.setText(null);
        minutoFinal.setText(null);

        resultadoHora.setText(null);
        doisPontos.setVisibility(View.INVISIBLE);
        resultadoMinuto.setText(null);
    }

    public void cataCampos() {
        try {
            horaI = Integer.parseInt(horaInicial.getText().toString());
            horaF = Integer.parseInt(horaFinal.getText().toString());
            minI = Integer.parseInt(minutoInical.getText().toString());
            minF = Integer.parseInt(minutoFinal.getText().toString());
        } catch (Exception e) {
            horaI = 0;
            horaF = 0;
            minI = 0;
            minF = 0;
            Toast.makeText(this, "Preencha corretamente", Toast.LENGTH_SHORT).show();
        }

    }
}
