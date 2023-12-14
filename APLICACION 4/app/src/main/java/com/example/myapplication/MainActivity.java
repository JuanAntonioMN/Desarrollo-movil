package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chbSel;
    RadioButton rbtnOpc1,rbtnOpc2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista);

        chbSel=findViewById(R.id.checkBox);
        chbSel.setOnClickListener(evento);

        RadioGroup radioGroup=findViewById(R.id.rGroup);
        rbtnOpc1=findViewById(R.id.radioButton3);
        rbtnOpc2=findViewById(R.id.radioButton4);

        radioGroup.clearCheck();
        radioGroup.check(R.id.radioButton3);

        rbtnOpc1.setOnClickListener(evento);
        rbtnOpc2.setOnClickListener(evento);
    }
    private View.OnClickListener evento= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view==chbSel) {
                if (chbSel.isChecked()) {
                    chbSel.setText("CheckBox seleccionado");
                }
                else{
                    chbSel.setText("CheckBox no seleccionado");
                }
            }

            String opcion="";
            if(view instanceof RadioButton){
                if(view==rbtnOpc1){
                    opcion="opcion 1";
                }
                if(view==rbtnOpc2){
                    opcion="opcion 2";
                }
                Toast.makeText(getApplicationContext(),"Opcion seleccionada" + opcion,Toast.LENGTH_SHORT).show();
            }
        }
    };
}