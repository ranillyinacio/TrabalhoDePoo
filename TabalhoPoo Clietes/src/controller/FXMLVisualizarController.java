/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;


public class FXMLVisualizarController implements Initializable {

    
    @FXML
    private TableColumn<?, ?> ColCpf;

    @FXML
    private TableColumn<?, ?> ColNome;

    @FXML
    private TableColumn<?, ?> ColSexo;

    @FXML
    private TableColumn<?, ?> ColN;
       @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void Excluir(ActionEvent event) {

    }

    @FXML
    void limpar(ActionEvent event) {

    }


    @Override
  
    public void initialize(URL url, ResourceBundle rb) {
  
    }    
    
}
