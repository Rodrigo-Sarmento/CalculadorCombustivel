package com.digo.calculadorgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etGasolina;
    private EditText etEtanol;
    private TextView teResultado;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        teResultado = findViewById(R.id.teResultado);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCalcularOnClick();
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLimparOnClick();
            }
        });

    }
    private void btCalcularOnClick(){
        if (etGasolina.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo de Gasolina precisa ser preenchido",
                    Toast.LENGTH_LONG).show();
            etGasolina.requestFocus();
            return;
        }
        if (etEtanol.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo de Etanol precisa ser preenchido" ,
                    Toast.LENGTH_LONG).show();
            etEtanol.requestFocus();
            return;
        }
        double gasolina = Double.parseDouble(etGasolina.getText().toString());
        double etanol = Double.parseDouble(etEtanol.getText().toString());

        double consumoGasolina = gasolina * 0.70;

        if(consumoGasolina <= etanol){
            teResultado.setText("É melhor abastecer com gasolina!");
        }else{
            teResultado.setText("É melhor abastecer com etanol!");
        }
    }
    private void btLimparOnClick(){
        etEtanol.setText("");
        etGasolina.setText("");
        teResultado.setText("Resultado");
    }
}