
package sistematickets;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistroUsuarioController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtContrasena;
    @FXML private Label lblMensaje;

    @FXML
    public void registrarUsuario() {
        try {
            Usuario usuario = new Usuario(
                txtNombre.getText(),
                txtCorreo.getText(),
                txtContrasena.getText()
            );
            Sistema.registrarUsuario(usuario);
            lblMensaje.setText("Usuario registrado con éxito.");
            lblMensaje.setTextFill(javafx.scene.paint.Color.GREEN);
        } catch (Exception e) {
            lblMensaje.setText(e.getMessage());
            lblMensaje.setTextFill(javafx.scene.paint.Color.RED);
        }
    }
}
