package com.example.controles_de_seleccin_listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductoAdapter extends ArrayAdapter {

    Activity context;

    Producto []datos;

    ProductoAdapter(Activity context,Producto[] datos){
        super(context,R.layout.producto_layout,datos);
        this.context=context;
        this.datos=datos;
    }


    public  View getView(int posicion, View convertView, ViewGroup parent){
        View item=convertView;

        if(item==null){
            LayoutInflater inflater=context.getLayoutInflater();
            item=inflater.inflate(R.layout.producto_layout,null);
        }

        TextView txtNombre=item.findViewById(R.id.nombre);
        txtNombre.setText(datos[posicion].getNombre());
        TextView lblSubtitulo=item.findViewById(R.id.precio);
        lblSubtitulo.setText(datos[posicion].getPrecio()+"");
        return (item);
    }

}
