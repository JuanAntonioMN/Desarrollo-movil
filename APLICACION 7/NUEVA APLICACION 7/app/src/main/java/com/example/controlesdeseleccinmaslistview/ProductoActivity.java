package com.example.controlesdeseleccinmaslistview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        ImageView imagen=findViewById(R.id.imageView);
        TextView nombre=findViewById(R.id.textView);
        TextView precio=findViewById(R.id.textView2);
        TextView detalles=findViewById(R.id.textView3);

        if(getIntent().getExtras()!=null){
            Producto producto=(Producto) getIntent().getSerializableExtra("producto");
            nombre.setText("Nombre: "+producto.getNombre());
            precio.setText("Numero: "+producto.getPrecio());
            detalles.setText("Descripcion:"+producto.getDescripcion());
            imagen.setImageResource(producto.getImagen());
        }

    }
}
