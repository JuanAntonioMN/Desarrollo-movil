package com.example.controlesdeseleccinmaslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lvfrutas);
        Producto []datos= new Producto[]{
                new Producto("Manjiro Sano (Mikey)","Conocido principalmente como Mikey, Sano es el fundador de la pandilla Tokyo Manji, también llamada \"Toman\".",1,R.drawable.imagen4),
                new Producto("Takemichi Hanagaki","Takemichi es un joven que añora su época dorada, cuando era pequeño y tenía amigos e incluso una novia.",2,R.drawable.imagen2),
                new Producto("Ken Ryuguji (Draken)","Es el vice-presidente y uno de los fundadores de la pandilla Tokyo Manji. Se parece mucho a Mikey, ya que es despreocupado.",3,R.drawable.imagen6),
                new Producto("Keisuke Baji","Es uno de los miembros fundadores de Tokyo Manji, y se destaca como el capitán de la primera división.",4,R.drawable.imagen1),
                new Producto("Kazutora Hanemiya","Uno de los miembros fundadores de Tokyo Manji. Es el antagonista del arco de Vallhalla.",5,R.drawable.imagen3),
                new Producto("Takashi Mitsuya","Capitán de la segunda división de la pandilla Tokyo Manji, es uno de sus miembros fundadores.",6,R.drawable.imagen5),




        };
        ProductoAdapter producto= new ProductoAdapter(this,datos);
        listView.setAdapter(producto);




        listView.setOnItemClickListener(((adapterView, view, i, l) ->{
            Producto prod=(Producto) adapterView.getItemAtPosition(i);
            Intent intent=new Intent(MainActivity.this,ProductoActivity.class);
            intent.putExtra("producto",prod);
            startActivity(intent);
        }));


        /* // Agregar un listener al ListView
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
    }


}