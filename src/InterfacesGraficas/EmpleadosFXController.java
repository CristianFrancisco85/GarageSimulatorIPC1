package InterfacesGraficas;

import Clases.Empleado;
import MyTDAs.DoubleLinkedList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.Group;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Cristian Meoño
 */
public class EmpleadosFXController implements Initializable {
    
    public DoubleLinkedList EmpleadosLS ;
    
    @FXML
    JFXButton CargarBtn;
    @FXML
    JFXButton OkBtn;
    @FXML
    Group grupoR;
    @FXML
    JFXRadioButton agregarR;
    @FXML
    JFXRadioButton editarR;
    @FXML
    JFXRadioButton eliminarR;
    @FXML
    JFXRadioButton buscarR;
    @FXML
    JFXTextField idTxt;
    @FXML
    JFXTextField nombreTxt;
    @FXML
    JFXTextField rolTxt;
    @FXML
    JFXTextField userTxt;
    @FXML
    JFXTextField passwordTxt;
    
    
   
    @FXML
    public void CargarArchivo(){
        String linea=" ";
        String [] auxVector;
        String delimiter="\\-";
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar archivo .tme");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Config File .tme", "*.tme"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            String FileName =selectedFile.getAbsolutePath();
            System.out.println("Location: "+ FileName);
            try{           
                BufferedReader buffer = new BufferedReader(new FileReader(FileName));
                while(linea != null){                   
                    //Objetos Temporales
                    Empleado tempEmpleado = new Empleado();
                    //Lectura Primaria
                    linea = buffer.readLine();
                    if(linea!=null){
                        System.out.println(linea);
                        auxVector=linea.split(delimiter);
                        //Asginacion de Valores
                        tempEmpleado.setNombre(auxVector[0]);
                        tempEmpleado.setRol(auxVector[1]);
                        tempEmpleado.setUser(auxVector[2]);
                        tempEmpleado.setPassword(auxVector[3]);
                        EmpleadosLS.addEnd(tempEmpleado);
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
    
    @FXML
    public void RadioButtons(){
        Empleado tempEmpleado = new Empleado();
        
        if (agregarR.isSelected()){
            tempEmpleado.setNombre(nombreTxt.getText());
            tempEmpleado.setRol(rolTxt.getText());
            tempEmpleado.setUser(userTxt.getText());
            tempEmpleado.setPassword(passwordTxt.getText());
            EmpleadosLS.addEnd(tempEmpleado);
            
        }
        else if(editarR.isSelected()){
            
        }
        else if(eliminarR.isSelected()){
            
        }
        else if(buscarR.isSelected()){
            
            for(int i=0;i<EmpleadosLS.getSize();i++){
                try {
                    tempEmpleado=(Empleado) EmpleadosLS.getValue(i);
                    if(tempEmpleado.getID()==idTxt.getText()){
                        nombreTxt.setText(tempEmpleado.getNombre());
                        rolTxt.setText(tempEmpleado.getRol());
                        userTxt.setText(tempEmpleado.getUser());
                        passwordTxt.setText(tempEmpleado.getPassword());
                        break;
                    }
                    else{
                        //SI NO SE ENCUENTRA
                    }
                }
                catch (Exception ex) {
                    Logger.getLogger(EmpleadosFXController.class.getName()).log(Level.SEVERE, null, ex);
                }                                    
            }
            
        }
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EmpleadosLS =  new DoubleLinkedList();
    }    
    
}
