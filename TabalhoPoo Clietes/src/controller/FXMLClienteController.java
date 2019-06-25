/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Cliente;
import view.Palco;

public class FXMLClienteController implements Initializable {
   
 @FXML
    private TextField textCpf;

    @FXML
    private RadioButton rbF;

    @FXML
    private RadioButton rbM;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textNumero;
    @FXML
    void salvar(ActionEvent event) {
         ClienteDAO dao = new ClienteDAO();
        Cliente aluno = new Cliente();
        aluno.setNumero(Integer.valueOf(textNumero.getText()));
        aluno.setCpf(Integer.valueOf(textCpf.getText()));
        aluno.setNome(textNome.getText());
        if(rbM.isSelected()){
             aluno.setSexo("M");
        }else if(rbF.isSelected()){
            aluno.setSexo("F");
        }
       
        
         /*Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
         dialogoAviso.setHeaderText("Esse é o cabeçalho...");
         dialogoAviso.setContentText(dao.salvar(aluno));
         dialogoAviso.showAndWait();*/
        dao.salvar(aluno);
        Palco.telaPrincipal();
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
    
}
