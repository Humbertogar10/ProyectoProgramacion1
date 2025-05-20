
package sistematickets;

public class Administrador extends Persona {
    public Administrador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    @Override
    public void cambiarEstadoTicket(Ticket ticket, String nuevoEstado) {
        ticket.setEstado(nuevoEstado);
    }
}
