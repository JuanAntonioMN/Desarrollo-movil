package com.example.controlesdeseleccinmasdaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ImageView imagen1,imagen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uso_de_spinner);
        String[] datos={"Elemento 1","Elemento 2","Elemento 3","Elemento 4","Elemento 5"};

        ArrayAdapter<String> adaptadorDatos=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);


        Spinner cmbOpciones1=findViewById(R.id.cmbOpciones1);
        adaptadorDatos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones1.setAdapter(adaptadorDatos);

        ArrayAdapter<CharSequence> adaptadorDatosArray=

                ArrayAdapter.createFromResource(this,R.array.datosArray, android.R.layout.simple_spinner_item);


        Spinner cmbOpciones2=findViewById(R.id.cmpOpciones2);
        adaptadorDatosArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones2.setAdapter(adaptadorDatosArray);

        cmbOpciones1.setOnItemSelectedListener(evento1);
        cmbOpciones2.setOnItemSelectedListener(evento2);

        imagen1=findViewById(R.id.imagen1);
        imagen2=findViewById(R.id.imagen2);
    }

    private AdapterView.OnItemSelectedListener evento1= new  AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>adapterView,View view,int i,long l){
                Toast.makeText(getApplicationContext(),"Spinner 1 pos "+i,Toast.LENGTH_SHORT).show();
                switch(i){
                    case 0:
                        imagen1.setImageResource(R.drawable.cara1);
                        break;
                    case 1:
                        imagen1.setImageResource(R.drawable.cara2);
                        break;
                    case 2:
                        imagen1.setImageResource(R.drawable.cara3);
                        break;
                    case 3:
                        imagen1.setImageResource(R.drawable.cara4);
                        break;
                    case 4:
                        imagen1.setImageResource(R.drawable.cara5);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>adapterView){
                Toast.makeText(getApplicationContext(),"Sin seleccionar Spinner 1",Toast.LENGTH_SHORT).show();

            }

        };
        private AdapterView.OnItemSelectedListener evento2= new  AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?>adapterView,View view,int i,long l){
                Toast.makeText(getApplicationContext(),"Spinner 2 pos "+i,Toast.LENGTH_SHORT).show();
                switch(i){
                    case 0:
                        imagen2.setImageResource(R.drawable.cuerpo1);
                        break;
                    case 1:
                        imagen2.setImageResource(R.drawable.cuerpo2);
                        break;
                    case 2:
                        imagen2.setImageResource(R.drawable.cuerpo3);
                        break;
                    case 3:
                        imagen2.setImageResource(R.drawable.cuerpo4);
                        break;
                    case 4:
                        imagen2.setImageResource(R.drawable.cuerpo5);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>adapterView){
                Toast.makeText(getApplicationContext(),"Sin seleccionar Spinner 2",Toast.LENGTH_SHORT).show();
            }


        };
}