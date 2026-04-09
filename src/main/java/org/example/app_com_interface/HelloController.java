package org.example.app_com_interface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    TextField txtUsuario;
    @FXML
    PasswordField txtSenha;
    @FXML
    Button btnLogin;
    @FXML
    Label labelLogin;
    @FXML
    private 

    @FXML
    protected void irParaTelaCadastro() throws IOException {
        HelloApplication.trocadorDeTelas("cadastro.fxml");
    }


    @FXML
    protected void onButtonLoginClick(){
        LoginDAO usuario = new LoginDAO();

        String usuarioDigitado = txtUsuario.getText();
        String senhaDigitada = txtSenha.getText();

        boolean autenticado = usuario.autenticar(usuarioDigitado,senhaDigitada);

        if (autenticado == true){
            labelLogin.setText("Usuário e senha carretos");
        }
        else{
            labelLogin.setText("Usuário ou senha incorreta!");

        }

    }
}
