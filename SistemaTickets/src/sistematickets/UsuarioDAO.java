
package sistematickets;

import java.sql.*;

public class UsuarioDAO {

    public static void insertarUsuario(String nombre, String correo, String contrasena) {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasena) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
            System.out.println("✅ Usuario insertado con éxito");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
        }
    }

    public static boolean autenticar(String correo, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("❌ Error al autenticar: " + e.getMessage());
            return false;
        }
    }
}
