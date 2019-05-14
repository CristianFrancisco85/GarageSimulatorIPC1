package Clases;

/**
 *
 * @author Cristian Meoño
 */
public class Empleado {
    private static int ids=100;
    private String ID,Nombre,Rol,User,Password;
    
    Empleado(String name,String rol,String user,String passwd){
        this.ID=Integer.toString(ids);
        ids++;       
        this.Nombre=name;
        this.Rol=rol;
        this.User=user;
        this.Password=passwd;
    }

    public Empleado() {
        this.ID=Integer.toString(ids);
        ids++;  
    }
    
    public String getID(){
        return this.ID;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getRol(){
        return this.Rol;
    }
    public String getUser(){
        return this.User;
    }
    public String getPassword(){
        return this.Password;
    }
    
    public void setID(String arg1){
        this.ID=arg1;
    }
    public void setNombre(String arg1){
        this.Nombre=arg1;
    }
    public void setRol(String arg1){
        this.Rol=arg1;
    }
    public void setUser(String arg1){
        this.User=arg1;
    }
    public void setPassword(String arg1){
        this.Password=arg1;
    }
    
    
    
}
