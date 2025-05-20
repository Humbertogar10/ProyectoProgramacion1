
package sistematickets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Departamento {
    private String nombre;
    private ArrayList<Tecnico> tecnicos;
    private Queue<Ticket> colaTickets;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.tecnicos = new ArrayList<>();
        this.colaTickets = new LinkedList<>();
    }

    public void agregarTecnico(Tecnico t) {
        tecnicos.add(t);
    }

    public void agregarTicket(Ticket t) {
        colaTickets.add(t);
    }
}
