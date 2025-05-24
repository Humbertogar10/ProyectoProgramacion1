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
        Usuario u = Sistema.buscarUsuario(correo, contrasena);

        if (u != null) {
            lblMensaje.setText("Bienvenido, " + u.getNombre());
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    public void irARegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroUsuario.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) txtCorreo.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void verEstadisticas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Estadisticas.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Estadísticas del Sistema");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirVistaTecnico() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaTecnico.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Vista del Técnico");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
