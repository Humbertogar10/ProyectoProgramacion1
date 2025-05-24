package sistematickets;

import java.util.ArrayList;

public class Sistema {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public static Usuario buscarUsuario(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

    public static void registrarTicket(Ticket t) {
        tickets.add(t);
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
