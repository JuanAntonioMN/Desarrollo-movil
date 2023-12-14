package com.example.practica3_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    float numero1=0.0f;
    float numero2=0.0f;
    String operador="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        resultado=findViewById(R.id.txt);
    }

    public void cero(View view) {
        String currentText = resultado.getText().toString();
        if (!currentText.equals("0")) {
            resultado.setText(currentText + "0");
        }

    }
    public void uno(View view) {
        if(resultado.getText().toString().equals("1")){
            resultado.setText("1");
        }
        else{
            resultado.setText(resultado.getText()+"1");
        }

    }
    public void dos(View view) {
        if(resultado.getText().toString().equals("2")){
            resultado.setText("2");
        }
        else{
            resultado.setText(resultado.getText()+"2");
        }

    }

    public void tres(View view) {
        if(resultado.getText().toString().equals("3")){
            resultado.setText("3");
        }
        else{
            resultado.setText(resultado.getText()+"3");
        }

    }

    public void cuatro(View view) {
        if(resultado.getText().toString().equals("4")){
            resultado.setText("4");
        }
        else{
            resultado.setText(resultado.getText()+"4");
        }

    }

    public void cinco(View view) {
        if(resultado.getText().toString().equals("5")){
            resultado.setText("5");
        }
        else{
            resultado.setText(resultado.getText()+"5");
        }

    }

    public void seis(View view) {
        if(resultado.getText().toString().equals("6")){
            resultado.setText("6");
        }
        else{
            resultado.setText(resultado.getText()+"6");
        }

    }

    public void siete(View view) {
        if(resultado.getText().toString().equals("7")){
            resultado.setText("7");
        }
        else{
            resultado.setText(resultado.getText()+"7");
        }
    }

    public void ocho(View view) {
        if(resultado.getText().toString().equals("8")){
            resultado.setText("8");
        }
        else{
            resultado.setText(resultado.getText()+"8");
        }
    }

    public void nueve(View view) {
        if(resultado.getText().toString().equals("9")){
            resultado.setText("9");
        }
        else{
            resultado.setText(resultado.getText()+"9");
        }
    }


    public void dividir(View view) {
        operador="/";
        guardarNumero1(view);
        resultado.setText("0");
    }

    public void multiplicar(View view) {
        operador="*";
        guardarNumero1(view);
        resultado.setText("0");
    }

    public void restar(View view) {
        operador="-";
        guardarNumero1(view);
        resultado.setText("0");
    }

    public void suma(View view) {
        operador="+";
        guardarNumero1(view);
        resultado.setText("0");
    }

    public void porcentaje(View view) {
        operador="%";
        guardarNumero1(view);
        resultado.setText("0");
    }

    public void borrar(View view) {
        resultado.setText("0");
        numero1=0.0f;
        numero2=0.0f;
        operador="";
    }
    public void guardarNumero1(View view) {
        numero1=Float.parseFloat(resultado.getText().toString());
        resultado.setText("0");
    }

    public void igual(View view) {
        Float resultadofinal=0.0f;
        numero2=Float.parseFloat(resultado.getText().toString());
        switch (operador){
            case "+":resultadofinal=numero1+numero2; resultado.setText(resultadofinal.toString());break;
            case "-":resultadofinal=numero1-numero2; resultado.setText(resultadofinal.toString());break;
            case "*":resultadofinal=numero1*numero2; resultado.setText(resultadofinal.toString());break;
            case "/":resultadofinal=numero1/numero2; resultado.setText(resultadofinal.toString());break;
            case "%":resultadofinal=numero1%numero2; resultado.setText(resultadofinal.toString());break;
        }
    }
}