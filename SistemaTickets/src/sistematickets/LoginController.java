
package sistematickets;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtContrasena;
    @FXML private Label lblMensaje;

    @FXML
    public void iniciarSesion() {
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        if (correo.equals("admin") && contrasena.equals("admin")) {
            lblMensaje.setText("Login exitoso (simulado).");
        } else {
            lblMensaje.setText("Correo o contraseña incorrectos.");
        }
    }
}
