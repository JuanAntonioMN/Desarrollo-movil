package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSumar,btnRestar;
    EditText txtN1,txtN2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        btnSumar=findViewById(R.id.btnSumar);
        btnRestar=findViewById(R.id.btnRestar);
        txtN1=findViewById(R.id.txtN1);
        txtN2=findViewById(R.id.txtN2);
        txtResult=findViewById(R.id.txtResult);
        btnSumar.setOnClickListener(evento);
        btnRestar.setOnClickListener(evento);
    }
    private View.OnClickListener evento= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view==btnSumar){
                int n1=Integer.parseInt(txtN1.getText().toString());
                int n2=Integer.parseInt(txtN2.getText().toString());
                txtResult.setText(n1+n2+"");
            }
            if(view==btnRestar){
                int n1=Integer.parseInt(txtN1.getText().toString());
                int n2=Integer.parseInt(txtN2.getText().toString());
                txtResult.setText(n1-n2+"");
            }
        }
    };

}