package Clases;

import java.io.File;

/**
 *
 * @author Cristian Meoño
 */
public class AutoMovil {
    private String Placa,Marca,Modelo;
    private File Imagen;
    
    public AutoMovil(){
        
    }
    
    public AutoMovil(String placa,String marca,String modelo,File img){
       this.Placa= placa;
       this.Marca=marca;
       this.Modelo=modelo;
       this.Imagen =img;     
    }
    
    public String getPlaca(){
       return this.Placa; 
    }
    public String getMarca(){
       return this.Marca; 
    }
    public String getModelo(){
       return this.Modelo; 
    }
    public File getImg(){
       return this.Imagen; 
    }
    public void setPlaca(String arg1){
       this.Placa=arg1; 
    }
    public void setMarca(String arg1){
       this.Marca=arg1; 
    }
    public void setModelo(String arg1){
       this.Modelo=arg1; 
    }
    public void setImg(String arg1){
       File temp = new File(arg1);
       this.Imagen=temp; 
    }
    
}
