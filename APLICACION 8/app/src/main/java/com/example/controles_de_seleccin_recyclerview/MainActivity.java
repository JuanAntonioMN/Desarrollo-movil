package com.example.controles_de_seleccin_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button eliminar;
    Button modificar;
    Button insertar;
    ContactoAdapter adaptador;
    ArrayList<Contacto> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertar=findViewById(R.id.button1);
        modificar=findViewById(R.id.button2);
        eliminar=findViewById(R.id.button3);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);

        int n=50;
        /*Contacto datos[]=new Contacto[n];

        for (int i=0;i<n;i++){
            datos[i]=new Contacto();
        }*/

        datos=new ArrayList<Contacto>();
        for(int i=0;i<n;i++){
            datos.add(new Contacto());
        }

        insertar.setOnClickListener(evento);
        modificar.setOnClickListener(evento);
        eliminar.setOnClickListener(evento);

        //ContactoAdapter adaptador=new ContactoAdapter(datos);
         adaptador=new ContactoAdapter(datos, new ContactoAdapter.OnItemClickListener() {
            @Override public void onItemClick(Contacto item) {
                Toast.makeText(getApplicationContext(),"Elemento: "+item.getNombre(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        /*recyclerView.setLayoutManager(new GridLayoutManager(this,3));


        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        */
        recyclerView.setAdapter(adaptador);
        
    }

    private View.OnClickListener evento= new View.OnClickListener(){
        @Override
        public void onClick( View v){
            if(v==insertar){
                datos.add(1,new Contacto());
                adaptador.notifyItemInserted(1);
            }
            if(v==modificar){
                datos.set(1,new Contacto());
                adaptador.notifyItemChanged(1);
            }
            if(v==eliminar){

                datos.remove(1);
                adaptador.notifyItemRemoved(1);

            }
        }
    };

}