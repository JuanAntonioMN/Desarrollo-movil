package com.example.controles_de_seleccin_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button eliminar;
    Button insertar;
    Button favoritos;
    ContactoAdapter adaptador;
    ImageView imageView;
    ArrayList<Contacto> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertar=findViewById(R.id.button1);
        favoritos=findViewById(R.id.button2);
        eliminar=findViewById(R.id.button3);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        String[] nombres={"Juan","Jose","Carlos","Diego","Miguel","Alfredo","Jesus","Eduardo","Monica","Mario"};
        String[] telefonos={"44981819","4491237236","312824732432","23726743745","283428463728476","2834782437246"};
        String[] emails={"lopez@gmail.com","marcos@gmail.com","monica@gmail.com","sanchez@gmail.com","nepomuceno@gmail.com","lopez@gmail.com"
        ,"garcia@gmail.com","zuñiga@gmail.com","castillo@gmail.com","murillo@gmail.com","volt@gmail.com","xd@gmail.com"};
        int n=10,index=0;
        datos=new ArrayList<Contacto>();
        Contacto objeto=new Contacto();

        for(int i=0;i<n;i++){
            index=objeto.aleatorio(nombres.length);
            String nombre=nombres[index];
            index=objeto.aleatorio(telefonos.length);
            String telefono=telefonos[index];
            index=objeto.aleatorio(emails.length);
            String email=emails[index];
            datos.add(new Contacto("Nombre: "+nombre,"Telefono: "+telefono,"Correo: "+email,R.drawable.imagen));

        }

        insertar.setOnClickListener(evento);
        favoritos.setOnClickListener(evento);
        eliminar.setOnClickListener(evento);

        adaptador=new ContactoAdapter(datos, new ContactoAdapter.OnItemClickListener() {
            @Override public void onItemClick(Contacto item) {
                Toast.makeText(getApplicationContext(),"Elemento: "+item.getNombre(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        recyclerView.setAdapter(adaptador);
        
    }

    private View.OnClickListener evento= new View.OnClickListener(){
        @Override
        public void onClick( View v){
            if(v==insertar){
                datos.add(1,new Contacto());
                adaptador.notifyItemInserted(1);
            }
            if(v==favoritos){
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