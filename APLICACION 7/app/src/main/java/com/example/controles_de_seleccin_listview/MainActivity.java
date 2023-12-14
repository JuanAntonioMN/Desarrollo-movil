package com.example.controles_de_seleccin_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView listView=findViewById(R.id.lvlista);

        Producto[]datos=new Producto[]{
                new Producto("Pan","Oferta",10.0f),
                new Producto("Latas de chiles","2x1",15.0f),
                new Producto("Refresco","Muy bueno",30.0f),
                new Producto("Frutas","Saludable",22.0f)};

                ProductoAdapter adaptadorDatos=new ProductoAdapter(this,datos);

                listView.setAdapter(adaptadorDatos);
/*
        // Agregar un listener al ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el producto seleccionado
                Producto productoSeleccionado = (Producto) parent.getItemAtPosition(position);

                // Mostrar un Toast con los datos del producto seleccionado
                String mensaje = "Nombre: " + productoSeleccionado.getNombre() + "\nDescripción: " +
                        productoSeleccionado.getDescripcion() + "\nPrecio: $" + productoSeleccionado.getPrecio();
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();

            }
        });*/

        listView.setOnItemClickListener((adapterView, view, i, l) ->{


            Producto producto=(Producto) adapterView.getItemAtPosition(i);
            Intent intent= new Intent(MainActivity.this,ProductoActivity.class);
            intent.putExtra("producto",producto);
            startActivity(intent);
        } );






/*
        String []frutas={"Cereza","Ciruela","Higo","Manzana","Pera","Uva","Melon","Mango","Sandia"};
        ArrayAdapter<String> AdaptadorFrutas= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,frutas);
        listView.setAdapter(AdaptadorFrutas);
*/
        //listView.setOnItemClickListener(evento);

/*
        listView.setOnItemClickListener((adapterView,view,i,l)->
        Toast.makeText(getApplicationContext(),"ListerView"+adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show());
*/
    }
/*
    private OnItemClickListener evento=new OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?>adapterView,View view,int i,long l){
            Toast.makeText(getApplicationContext(),"ListView"+adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
        }
    };*/

/*
    private OnItemClickListener evento=((adapterView, view, i, l) ->
        Toast.makeText(getApplicationContext(),"ListView pos" + adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();

     */




}