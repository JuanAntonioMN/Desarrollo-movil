package com.example.controles_de_seleccin_listview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        TextView nombre=findViewById(R.id.nombre_producto);
        TextView precio=findViewById(R.id.precio_producto);
        TextView detalle=findViewById(R.id.detalle_producto);

        if(getIntent().getExtras()!=null){
            Producto producto=(Producto) getIntent().getSerializableExtra("Producto");
            nombre.setText(producto.getNombre());
            precio.setText("$"+producto.getPrecio());
            detalle.setText(producto.getDescripcion());

        }
    }
}
