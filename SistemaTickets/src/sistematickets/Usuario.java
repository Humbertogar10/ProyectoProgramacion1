
package sistematickets;

public class Usuario extends Persona {
    public Usuario(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    @Override
    public void cambiarEstadoTicket(Ticket ticket, String nuevoEstado) {
        if (nuevoEstado.equals("Cerrado")) {
            ticket.setEstado(nuevoEstado);
        }
    }
}
