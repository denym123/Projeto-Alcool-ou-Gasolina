package com.example.gasosa_ou_alcool_definitivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGas;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editAlcoolId);
        editPrecoGas = findViewById(R.id.editGasId);
        textResult = findViewById(R.id.textResultId);
    }

    public void calculatePrice(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGas = editPrecoGas.getText().toString();

        Boolean result = validarCampos(precoAlcool, precoGas);

        if (!result) {
            textResult.setText("Por favor, preencha os campos corretamente.");
        }
        else {
            double precoAlcoolDouble = Double.parseDouble(precoAlcool);
            double precoGasDouble = Double.parseDouble(precoGas);

            double resultado = precoAlcoolDouble / precoGasDouble;
            if(resultado >= 0.7){
                textResult.setText("Gasolina");
            }
            else{
                textResult.setText("Alcool");
            }
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true;

        if (pAlcool == null || pAlcool.isEmpty()) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.isEmpty()) {
            camposValidados = false;
        }

        return camposValidados;
    }
}