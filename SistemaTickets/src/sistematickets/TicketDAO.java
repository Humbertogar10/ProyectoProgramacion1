
package sistematickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public static void insertarTicket(String titulo, String descripcion, String estado, String usuarioCorreo) {
        String sql = "INSERT INTO tickets (titulo, descripcion, estado, usuario_correo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, descripcion);
            stmt.setString(3, estado);
            stmt.setString(4, usuarioCorreo);
            stmt.executeUpdate();
            System.out.println("✅ Ticket insertado con éxito");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar ticket: " + e.getMessage());
        }
    }

    public static List<Ticket> obtenerTickets() {
        List<Ticket> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");
                String correoUsuario = rs.getString("usuario_correo");

                Usuario u = new Usuario("Usuario", correoUsuario, "");
                Ticket t = new Ticket(titulo, descripcion, u);
                t.setEstado(estado);
                lista.add(t);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener tickets: " + e.getMessage());
        }

        return lista;
    }
}
