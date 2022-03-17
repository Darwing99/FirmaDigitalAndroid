package com.dhernandez.firmadigital.clases;

import java.sql.Blob;

public class Asignaturess {
    public  String descripcion;
    public Blob firmadigital;
    public Asignaturess(String descripcion,Blob firmadigital){
        this.descripcion=descripcion;
        this.firmadigital=firmadigital;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Blob getFirmadigital() {
        return firmadigital;
    }
}
