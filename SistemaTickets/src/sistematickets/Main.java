package sistematickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Llamar al método que asegura que la tabla exista
        ConexionBD.crearTablaUsuariosSiNoExiste();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Sistema de Tickets - Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}