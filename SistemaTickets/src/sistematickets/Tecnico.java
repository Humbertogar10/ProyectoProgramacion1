
package sistematickets;

public class Tecnico extends Persona {
    public Tecnico(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    @Override
    public void cambiarEstadoTicket(Ticket ticket, String nuevoEstado) {
        if (nuevoEstado.equals("Resuelto") || nuevoEstado.equals("En proceso")) {
            ticket.setEstado(nuevoEstado);
        }
    }
}
