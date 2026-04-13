package org.example.app_com_interface;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.NordLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // Guarda o Stage principal para ser acessado de qualquer controller
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());

        // Carrega a tela inicial (login.fxml)
        trocadorDeTelas("hello-view.fxml");

        primaryStage.setTitle("Sistema genérico");
        primaryStage.show();
    }

    /**
     * Metodo estático para trocar de tela a partir de qualquer controller.
     *
     * @param telaFxml Nome do arquivo .fxml (ex: "cadastro.fxml")
     */
    public static void trocadorDeTelas(String telaFxml) throws IOException {
        // Carrega o arquivo .fxml do diretório resources/com/example/demo/
        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource(telaFxml)
        );

        // Cria a cena com o conteúdo carregado
        Scene scene = new Scene(loader.load(),600,800);

        // Define a cena no Stage principal
        primaryStage.setScene(scene);

    }

    public static void main(String[] args) {
        launch();
    }
}

