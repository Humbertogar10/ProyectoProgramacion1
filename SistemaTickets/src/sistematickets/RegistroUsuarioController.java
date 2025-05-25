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
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            lblMensaje.setText("Por favor, complete todos los campos.");
            return;
        }

        boolean exito = UsuarioDAO.insertarUsuario(nombre, correo, contrasena);
        if (exito) {
            lblMensaje.setText("✅ Usuario registrado con éxito.");
            txtNombre.clear();
            txtCorreo.clear();
            txtContrasena.clear();
        } else {
            lblMensaje.setText("❌ Error al registrar. ¿Correo ya registrado?");
        }
    }
}