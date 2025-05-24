package sistematickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Pre-cargar un usuario y un ticket
        Usuario admin = new Usuario("Admin", "admin@mail.com", "admin123");
        Sistema.registrarUsuario(admin);

        Ticket ejemplo = new Ticket("Problema de red", "No hay internet", admin);
        Sistema.registrarTicket(ejemplo);

        // Cargar la vista de Login
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