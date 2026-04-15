package org.example.app_com_interface;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CadastroController {
    @FXML
    private TextField campoUsuario;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private PasswordField campoConfimarSenha;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCriarConta;

    @FXML
    protected void onVoltarClick() throws IOException {
        HelloApplication.trocadorDeTelas("hello-view.fxml");
    }

    @FXML
    public void onCadastrarClick() {
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String confirmarsenha = campoConfimarSenha.getText();

        if (usuario.isBlank ()|| senha.isBlank() || confirmarsenha.isBlank()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatório");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, preencha todos os campos antes de cadastrar ");
            alerta.showAndWait();

            return;
        }

        if(!(senha.equals(confirmarsenha))){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Senhas não conferem");
            alerta.setHeaderText(null);
            alerta.setContentText("As senhas não conferem, digite a senha novamente! ");
            alerta.showAndWait();

            return;
        }
        CadastroDAO dao = new CadastroDAO();

    }

}
