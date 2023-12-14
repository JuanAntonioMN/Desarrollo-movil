package com.example.controles_de_seleccin_listview;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private String descripcion;
    private  float precio;
    private int imagen;

    public Producto(String nombre,String descripcion,float precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;


    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
