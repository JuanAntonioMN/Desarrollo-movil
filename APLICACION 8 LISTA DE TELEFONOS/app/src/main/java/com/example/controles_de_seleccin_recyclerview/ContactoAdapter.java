package com.example.controles_de_seleccin_recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import  android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import  android.widget.TextView;
import  android.view.LayoutInflater;
import  android.view.ViewGroup;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {


    ArrayList<Contacto> datos;
    OnItemClickListener Listener;

    public  interface OnItemClickListener{
        void onItemClick(Contacto item);
    }
    class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView lblImagen;
        TextView LblNombre;
        TextView lblTelefono;
        TextView lblEmail;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            lblImagen=itemView.findViewById(R.id.lblImagen);
            LblNombre = itemView.findViewById(R.id.lblNombre);
            lblTelefono = itemView.findViewById(R.id.lblTelefono);
            lblEmail = itemView.findViewById(R.id.lblEmail);

        }

        public void bindContacto(Contacto contacto,OnItemClickListener Listener) {
            lblImagen.setImageResource(contacto.getImagen());
            LblNombre.setText(contacto.getNombre());
            lblTelefono.setText(contacto.getTelefono());
            lblEmail.setText(contacto.getEmail());
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

        Contacto contacto= datos.get(position);
        holder.bindContacto(contacto,Listener);
    }
    @Override
    public int getItemCount(){
        return datos.size();
    }


}
