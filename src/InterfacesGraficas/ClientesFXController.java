/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Clases.AutoMovil;
import Clases.Cliente;
import MyTDAs.DoubleCircularLinkedList;
import MyTDAs.SimpleCircularLinkedList;
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
public class ClientesFXController implements Initializable {
    
    public DoubleCircularLinkedList ClientesLS;
    
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
        fileChooser.setTitle("Cargar archivo .tmca");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Config File .tmca", "*.tmca"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            String FileName =selectedFile.getAbsolutePath();
            System.out.println("Location: "+ FileName);
            try{           
                BufferedReader buffer = new BufferedReader(new FileReader(FileName));
                while(linea != null){                   
                    //Objetos Temporales
                    Cliente tempCliente = new Cliente();
                    AutoMovil tempAuto = new AutoMovil();
                    SimpleCircularLinkedList tempList = new SimpleCircularLinkedList();
                    //Lectura Primaria
                    linea = buffer.readLine();
                    if(linea!=null){
                        System.out.println(linea);
                        auxVector=linea.split(delimiter);
                        //Asginacion de Valores
                        tempCliente.setID(auxVector[0]);
                        tempCliente.setNombre(auxVector[1]);
                        tempCliente.setUser(auxVector[2]);
                        tempCliente.setPassword(auxVector[3]);
                        tempCliente.setTipo(auxVector[4]);
                        //Lectura Secundaria
                        auxVector2=auxVector[5].split("\\;");
                        for(int i =0;i<auxVector2.length;i++){
                            auxVector=auxVector2[i].split("\\,");
                            tempAuto.setPlaca(auxVector[0]);
                            tempAuto.setMarca(auxVector[1]);
                            tempAuto.setModelo(auxVector[2]);
                            tempAuto.setImg(auxVector[3]);
                            tempList=tempCliente.getAutos();
                            tempList.addEnd(tempAuto);
                            tempCliente.setAutos(tempList);                       
                        } 
                        ClientesLS.addEnd(tempCliente);
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClientesLS= new DoubleCircularLinkedList();
    }    
    
}
