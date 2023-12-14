package com.example.controlesdeseleccinmaslistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductoAdapter extends ArrayAdapter {

    Activity context;
    Producto []datos;

    ProductoAdapter(Activity context,Producto []datos){
        super(context,R.layout.producto_layout,datos);
        this.context=context;
        this.datos=datos;
    }
    public View getView(int position, View ConvertView, ViewGroup parent){
        View item=ConvertView;
        if(item==null){
            LayoutInflater inflater=context.getLayoutInflater();
            item=inflater.inflate(R.layout.producto_layout,null);
        }
        TextView txtNombre=item.findViewById(R.id.nombre);
        txtNombre.setText(datos[position].getNombre());
        TextView lblsubtitulo=item.findViewById(R.id.precio);
        lblsubtitulo.setText(datos[position].getPrecio()+"");
        ImageView imagen=item.findViewById(R.id.imagen);
        imagen.setImageResource(datos[position].getImagen());
        return  (item);
    }
}
