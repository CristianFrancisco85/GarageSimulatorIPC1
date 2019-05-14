/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Cristian Meoño
 */
public class Repuesto {
    
    private static int ids;
    private String ID,Nombre,Marca,Modelo;
    private int Existencias;
    private double Precio;
    
    Repuesto(String nombre,String marca,String modelo,int ext,int precio){
        this.ID = Integer.toString(ids);
        ids++;
        this.Nombre=nombre;
        this.Marca=marca;
        this.Modelo=modelo;
        this.Existencias=ext;
        this.Precio=precio;      
    }

    public Repuesto() {
        this.ID = Integer.toString(ids);
        ids++;
    }
    
    public String getID(){
        return this.ID;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getMarca(){
        return this.Marca;
    }
    public String getModelo(){
        return this.Modelo;
    }
    public int getExistencias(){
        return this.Existencias;
    }
    public double getPrecio(){
        return this.Precio;
    }
    
    public void setID(String arg1){
        this.ID=arg1;
    }
    public void setNombre(String arg1){
        this.Nombre=arg1;
    }
    public void setMarca(String arg1){
        this.Marca=arg1;
    }
    public void setModelo(String arg1){
        this.Modelo=arg1;
    }
    public void setExistencias(int arg1){
        this.Existencias=arg1;
    }
    public void setPrecio(double arg1){
        this.Precio=arg1;
    }
    
}
