package com.example.conversiondeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double resultado;
    RadioButton boton1,boton2,boton3,boton4;
    EditText numero;
    TextView vista;
    RadioButton btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversiones);

        RadioGroup grupo1 = findViewById(R.id.radioGroup);
        boton1=findViewById(R.id.radioButton);
        boton2=findViewById(R.id.radioButton2);
        boton3=findViewById(R.id.radioButton3);
        boton4=findViewById(R.id.radioButton20);

        numero=findViewById(R.id.editTextValue);
        vista=findViewById(R.id.textView);

        btn1=findViewById(R.id.radioButtonuno);
        btn2=findViewById(R.id.radioButtondos);
        btn3=findViewById(R.id.radioButtontres);
        btn4=findViewById(R.id.radioButtoncuatro);
        btn5=findViewById(R.id.radioButtoncinco);
        btn6=findViewById(R.id.radioButtonseis);

        grupo1.clearCheck();

        boton1.setOnClickListener(evento);
        boton2.setOnClickListener(evento);
        boton3.setOnClickListener(evento);
        boton4.setOnClickListener(evento);

        btn1.setOnClickListener(evento);
        btn2.setOnClickListener(evento);
        btn3.setOnClickListener(evento);
        btn4.setOnClickListener(evento);
        btn5.setOnClickListener(evento);
        btn6.setOnClickListener(evento);
    }
    private View.OnClickListener evento= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RadioGroup grupo2 = findViewById(R.id.radioGroup2);
            RadioGroup grupo3 = findViewById(R.id.radioGroup3);


            if(view==boton1 || view==boton2 || view==boton3){
                grupo2.setVisibility(View.VISIBLE);
                grupo3.setVisibility(View.VISIBLE);

                if (view==boton1) {

                    btn1.setText("Metros");
                    btn2.setText("Centimetros");
                    btn3.setText("Kilometros");

                    btn4.setText("Metros");
                    btn5.setText("Centimetros");
                    btn6.setText("Kilometros");



                    //Conversion de metros a metros
                    if(btn1.isChecked() && btn4.isChecked()){
                        vista.setText(numero.getText());
                    }
                    //Conversion de metros a centimetros
                    if(btn1.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*100;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de metros a kilometros
                    if(btn1.isChecked() && btn6.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de centimetros a metros
                    if(btn2.isChecked() && btn4.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/100;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de centimetros a centimetros
                    if(btn2.isChecked() && btn5.isChecked()){
                        vista.setText(numero.getText());
                    }
                    //Conversion de centimetros a kilometros
                    if(btn2.isChecked() && btn6.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/100000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de kilometros a metros
                    if(btn3.isChecked() && btn4.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de kilometros a centimetros
                    if(btn3.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*100000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de kilometros a kilometros
                    if(btn3.isChecked() && btn6.isChecked()){
                        vista.setText(numero.getText());
                    }


                }

                if(view==boton2) {
                    btn1.setText("Kilos");
                    btn2.setText("Gramo");
                    btn3.setText("Miligramo");
                    btn4.setText("Kilos");
                    btn5.setText("Gramo");
                    btn6.setText("Miligramo");

                    //Conversion de kilos a kilos
                    if(btn1.isChecked() && btn4.isChecked()){
                        vista.setText(numero.getText());
                    }
                    //Conversion de kilos a gramos
                    if(btn1.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de kilos a miligramos
                    if(btn1.isChecked() && btn6.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*1000000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de gramos a kilos
                    if(btn2.isChecked() && btn4.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de gramos a gramos
                    if(btn2.isChecked() && btn5.isChecked()){
                        vista.setText(numero.getText());
                    }
                    //Conversion de gramos a miligramos
                    if(btn2.isChecked() && btn6.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())*1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de miligramos a kilos
                    if(btn3.isChecked() && btn4.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/1000000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de miligramos a gramos
                    if(btn3.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString())/1000;
                        vista.setText(String.valueOf(resultado));
                    }
                    //Conversion de miligramos a miligramos
                    if(btn3.isChecked() && btn6.isChecked()){
                        vista.setText(numero.getText());
                    }

                }

                if(view==boton3) {
                        btn1.setText("Celsius");
                        btn2.setText("Fahrenheit");
                        btn3.setText("Kelvin");
                        btn4.setText("Celsius");
                        btn5.setText("Fahrenheit");
                        btn6.setText("Kelvin");

                    //Conversion de celsius a celsius
                    if(btn1.isChecked() && btn4.isChecked()){
                        vista.setText(numero.getText() + " °C");
                    }
                    //Conversion de celsius a fahrenheit
                    if(btn1.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString()) * (1.8) + 32;
                        vista.setText(String.valueOf(resultado) + " °F");
                    }
                    //Conversion de celsius a kelvin
                    if(btn1.isChecked() && btn6.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString()) + 273.15;
                        vista.setText(String.valueOf(resultado) + " °K");
                    }
                    //Conversion de fahrenheit a celsius
                    if(btn2.isChecked() && btn4.isChecked()){
                        resultado=(Float.parseFloat(numero.getText().toString())-32)/1.8;
                        vista.setText(String.valueOf(resultado) + " °C");
                    }
                    //Conversion de fahrenheit a fahrenheit
                    if(btn2.isChecked() && btn5.isChecked()){
                        vista.setText(numero.getText() + " °F");
                    }
                    //Conversion de fahrenheit a kelvin
                    if(btn2.isChecked() && btn6.isChecked()){
                        resultado=(Float.parseFloat(numero.getText().toString()) + 459.67) * (5/9);
                        vista.setText(String.valueOf(resultado) + " °K");
                    }
                    //Conversion de kelvin a celsius
                    if(btn3.isChecked() && btn4.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString()) - 273.15;
                        vista.setText(String.valueOf(resultado) +  " °C");
                    }
                    //Conversion de kelvin a fehrenheit
                    if(btn3.isChecked() && btn5.isChecked()){
                        resultado=Float.parseFloat(numero.getText().toString()) * (7/5) - 459.67;
                        vista.setText(String.valueOf(resultado) + "°F");
                    }
                    //Conversion de kelvin a kelvin
                    if(btn3.isChecked() && btn6.isChecked()){
                        vista.setText(numero.getText() + " °K");
                    }

                }

            }
            else if(view==boton4){
                grupo2.setVisibility(View.GONE);
                grupo3.setVisibility(View.GONE);
            }



        }
    };
}