
package sistematickets;

import java.util.ArrayList;

public class Sistema {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void registrarUsuario(Usuario usuario) throws Exception {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(usuario.getCorreo())) {
                throw new Exception("Ya existe un usuario con ese correo.");
            }
        }
        usuarios.add(usuario);
    }

    public static void registrarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
