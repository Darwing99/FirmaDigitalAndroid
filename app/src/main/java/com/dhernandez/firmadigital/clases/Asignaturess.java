package com.dhernandez.firmadigital.clases;

public class Asignaturess {
    public int id;
    public  String descripcion;
    public byte[] firmadigital;
    public Asignaturess(int id,String descripcion, byte[] firmadigital){
        this.id=id;
        this.descripcion=descripcion;
        this.firmadigital=firmadigital;
    }
    public Asignaturess(){

    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public byte[] getFirmadigital() {
        return firmadigital;
    }
}
