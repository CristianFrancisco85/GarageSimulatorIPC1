/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Clases.Empleado;
import Clases.Repuesto;
import Clases.Servicio;
import MyTDAs.Stack;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Cristian Meoño
 */
public class ServiciosFXController implements Initializable {
    
    @FXML
    JFXButton CargarBtn;
    @FXML
    JFXButton OkBtn;
    
    @FXML
    public void CargarArchivo(){
        String linea=" ";
        String [] auxVector,auxVector2;
        String delimiter="\\-";
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar archivo .tms");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Config File .tms", "*.tms"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            String FileName =selectedFile.getAbsolutePath();
            System.out.println("Location: "+ FileName);
            try{           
                BufferedReader buffer = new BufferedReader(new FileReader(FileName));
                while(linea != null){                   
                    //Objetos Temporales
                    Servicio tempServicio = new Servicio();
                    Repuesto tempRepuesto= new Repuesto();
                    double tempPrecio = 0;
                    //Pila que guarda una copia de la lista de repuestos
                    Stack auxStack = RepuestosFXController.RepuestosLS;
                    // Pila que guarda los repuestos de un servicio
                    Stack tempStack = new Stack();                   
                    //Lectura Primaria
                    linea = buffer.readLine();
                    if(linea!=null){
                        System.out.println(linea);
                        auxVector=linea.split(delimiter);
                        //Asginacion de Valores
                        tempServicio.setNombre(auxVector[0]);
                        tempServicio.setMarca(auxVector[1]);
                        tempServicio.setModelo(auxVector[2]);
                        tempServicio.setPrecioMObra(Double.parseDouble(auxVector[4]));
                        auxVector2=auxVector[3].split("\\;");
                        for(int i =0;i<auxVector2.length;i++){
                            for(int j=0;j<auxStack.getSize();j++){
                                tempRepuesto=(Repuesto) auxStack.Tope();                               
                                if(tempRepuesto.getID()==auxVector[i]){
                                    tempStack.apilar(tempRepuesto);
                                    tempPrecio= tempPrecio+tempRepuesto.getPrecio();
                                }
                                else{
                                    auxStack.retirar();
                                }
                            }                            
                        }
                        tempServicio.setPrecioTotal(Double.parseDouble(auxVector[4])+tempPrecio);
                        tempServicio.setRepuestos(tempStack);
                    }
                }
            }
            catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado "+ FileName);
            } 
            catch (IOException e) {
                System.out.println("Archivo no cargado" + FileName);
            } catch (Exception ex) {
                Logger.getLogger(ServiciosFXController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
