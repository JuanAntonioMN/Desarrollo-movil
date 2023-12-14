package com.example.controles_de_seleccin_recyclerview;

import java.util.Random;

public class Contacto {
    private int imagen;
    private String nombre;
    private String telefono;
    private String email;
    private  static  int  nContacto=0;

    public  Contacto(){
        nContacto++;
        this.nombre="Nombre "+nContacto;
        this.telefono="Telefono "+nContacto;
        this.email="email "+nContacto;
    }
    public Contacto(String nombre,String telefono,String email,int imagen){
        this.imagen=imagen;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email=email;
    }

    public  int getImagen(){
        return imagen;
    }

    public void setImagen(int imagen){
        this.imagen=imagen;
    }

    int aleatorio(int numero ){
        Random random = new Random();
        int randomInt = random.nextInt(numero);
        return randomInt;
    }
}
