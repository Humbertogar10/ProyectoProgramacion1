package sistematickets;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistroUsuarioController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtContrasena;
    @FXML private Label lblMensaje;

    @FXML
    public void registrar() {
        Usuario nuevo = new Usuario(txtNombre.getText(), txtCorreo.getText(), txtContrasena.getText());
        Sistema.registrarUsuario(nuevo);
        lblMensaje.setText("¡Usuario registrado!");
    }
}
