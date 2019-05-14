/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import MyTDAs.SimpleCircularLinkedList;

/**
 *
 * @author Cristian Meoño
 */
public class Cliente {
    private static int ids=200;
    private String ID,Nombre,Tipo,User,Password;
    private SimpleCircularLinkedList ListaAuto;
    
    
    public Cliente(){
        ListaAuto= new SimpleCircularLinkedList();
        
    }
    public Cliente(String name,String tipo,String user,String passwd){
        this.ID=Integer.toString(ids);
        ids++;       
        this.Nombre=name;
        this.Tipo=tipo;
        this.User=user;
        this.Password=passwd;
    }
    
    public String getID(){
        return this.ID;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getTipo(){
        return this.Tipo;
    }
    public String getUser(){
        return this.User;
    }
    public String getPassword(){
        return this.Password;
    }
    public SimpleCircularLinkedList getAutos(){
        return this.ListaAuto;
    }
    
    public void setID(String arg1){
        this.ID=arg1;
    }
    public void setNombre(String arg1){
        this.Nombre=arg1;
    }
    public void setTipo(String arg1){
        this.Tipo=arg1;
    }
    public void setUser(String arg1){
        this.User=arg1;
    }
    public void setPassword(String arg1){
        this.Password=arg1;
    }
    public void setAutos(SimpleCircularLinkedList arg1){
        this.ListaAuto=arg1;
    }
    
    
}
