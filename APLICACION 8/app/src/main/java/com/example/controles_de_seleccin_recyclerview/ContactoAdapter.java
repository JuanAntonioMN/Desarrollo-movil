package com.example.controles_de_seleccin_recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import  android.view.View;
import android.widget.AdapterView;
import  android.widget.TextView;
import  android.view.LayoutInflater;
import  android.view.ViewGroup;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    //Contacto[] datos;
    ArrayList<Contacto> datos;
    OnItemClickListener Listener;

    public  interface OnItemClickListener{
        void onItemClick(Contacto item);
    }
    class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView lblApePat;
        TextView lblApeMat;
        TextView lblNombre;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblApeMat = itemView.findViewById(R.id.lblApeMat);
            lblApePat = itemView.findViewById(R.id.lblApePat);

        }

        public void bindContacto(Contacto contacto,OnItemClickListener Listener) {
            lblNombre.setText(contacto.getNombre());
            lblApePat.setText(contacto.getApePat());
            lblApeMat.setText(contacto.getApeMat());
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Listener.onItemClick(contacto);
                }
            });
        }
    }

    ContactoAdapter(ArrayList<Contacto> datos,OnItemClickListener Listener) {
        super();
        this.datos = datos;
        this.Listener=Listener;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        //Contacto contacto = datos[position];
        Contacto contacto= datos.get(position);
        holder.bindContacto(contacto,Listener);
    }
    @Override
    public int getItemCount(){
        return datos.size();
    }


}
