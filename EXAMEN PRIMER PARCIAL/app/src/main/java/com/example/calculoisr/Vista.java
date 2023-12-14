package com.example.calculoisr;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Vista extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista);
        //Declaramos una variable de ListView y obtenemos su id para pasarle la informacion.
        ListView listView=findViewById(R.id.lista);

        //Cree una variable de ArrayList string el cual recuperara los valores que se le envian desde la vista anterior
        ArrayList<String> resultado = getIntent().getStringArrayListExtra("clave_resultado");

        //Se crea el adaptador de tipo string y se le asigna la informacion por medio de resultado
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,resultado);
        listView.setAdapter(adapter);// se setea el listView con el adaptador

    }
}
