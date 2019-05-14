/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Clases.Repuesto;
import MyTDAs.Stack;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Cristian Meoño
 */
public class RepuestosFXController implements Initializable {
    
    public static Stack RepuestosLS;

    @FXML
    JFXButton CargarBtn;
    @FXML
    JFXButton OkBtn;
   
    @FXML
    public void CargarArchivo(){
        String linea=" ";
        String [] auxVector;
        String delimiter="\\-";
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar archivo .tmr");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Config File .tmr", "*.tmr"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            String FileName =selectedFile.getAbsolutePath();
            System.out.println("Location: "+ FileName);
            try{           
                BufferedReader buffer = new BufferedReader(new FileReader(FileName));
                while(linea != null){                   
                    //Objetos Temporales
                    Repuesto tempRepuesto = new Repuesto();
                    //Lectura Primaria
                    linea = buffer.readLine();
                    if(linea!=null){
                        System.out.println(linea);
                        auxVector=linea.split(delimiter);
                        //Asignacion de valores
                        tempRepuesto.setNombre(auxVector[0]);
                        tempRepuesto.setMarca(auxVector[1]);
                        tempRepuesto.setModelo(auxVector[2]);
                        tempRepuesto.setExistencias(Integer.parseInt(auxVector[3]));
                        tempRepuesto.setPrecio(Double.parseDouble(auxVector[4]));
                        RepuestosLS.apilar(tempRepuesto);
                    }
                }
            }
            catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado "+ FileName);
            } 
            catch (IOException e) {
                System.out.println("Archivo no cargado" + FileName);
            } 
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RepuestosLS= new Stack();
    }    
    
}
