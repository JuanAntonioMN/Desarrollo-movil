package com.example.controles_de_seleccin_recyclerview;

public class Contacto {
    private String nombre;
    private String apePat;
    private String apeMat;
    private  static  int  nContacto=0;

    public  Contacto(){
        nContacto++;
        this.nombre="nombre"+nContacto;
        this.apePat="apePat"+nContacto;
        this.apeMat="apeMat"+nContacto;
    }
    public Contacto(String nombre,String apePat,String apeMat){
        this.nombre=nombre;
        this.apeMat=apeMat;
        this.apePat=apePat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }
}
