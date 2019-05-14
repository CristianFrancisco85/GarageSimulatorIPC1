package Clases;

/**
 *
 * @author Cristian Meoño
 */
public class Orden {
    private static int ids=500;
    private AutoMovil Auto;
    private Cliente Cliente;
    private Servicio Servicio;
    private Empleado Empleado;
    private String ID,Estado;
    
    Orden(AutoMovil auto,Cliente cliente,Servicio servicio,Empleado empleado,String estado){
        this.ID=Integer.toString(ids);
        ids++;
        this.Auto= auto;
        this.Cliente=cliente;
        this.Servicio=servicio;
        this.Empleado=empleado;
        this.Estado=estado;
    }
    
    public String getID(){
        return this.ID;
    }
    public AutoMovil getAuto(){
        return this.Auto;
    }
    public Cliente getCliente(){
        return this.Cliente;
    }
    public Servicio getServicio(){
        return this.Servicio;
    }
    public Empleado getEmpleado(){
        return this.Empleado;
    }
    public String getEstado(){
        return this.Estado;
    }
    
    public void setID(String arg1){
        this.ID=arg1;
    }
    public void setAuto(AutoMovil arg1){
        this.Auto=arg1;
    }
    public void setCliente(Cliente arg1){
        this.Cliente=arg1;
    }
    public void setServicio(Servicio arg1){
        this.Servicio=arg1;
    }
    public void setEmpleado(Empleado arg1){
        this.Empleado=arg1;
    }
    public void setEstado(String arg1){
        this.Estado=arg1;
    }
    
}
