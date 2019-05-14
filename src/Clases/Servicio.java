package Clases;

import MyTDAs.Stack;

/**
 *
 * @author Cristian Meoño
 */
public class Servicio {
    
    private static int ids;
    private String ID,Nombre,Marca,Modelo;
    private Stack Repuestos;
    private double PrecioMano,PrecioTotal;
    
    Servicio(String nombre,String marca,String modelo,int precioM,int precioT,Stack rep){
        this.ID=Integer.toString(ids);
        ids++;
        this.Nombre=nombre;
        this.Marca=marca;
        this.Modelo=modelo;
        this.PrecioMano=precioM;
        this.PrecioTotal=precioT; 
        this.Repuestos= rep;
    }

    public Servicio() {
        this.ID=Integer.toString(ids);
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
    public Stack getRespuestos(){
        return this.Repuestos;
    }
    public double getPrecioMObra(){
        return this.PrecioMano;
    }
    public double getPrecioTotal(){
        return this.PrecioTotal;
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
    public void setRepuestos(Stack arg1){
        this.Repuestos=arg1;
    }
    public void setPrecioMObra(double arg1){
        this.PrecioMano=arg1;
    }
    public void setPrecioTotal(double arg1){
        this.PrecioTotal=arg1;
    }
    
    
}
