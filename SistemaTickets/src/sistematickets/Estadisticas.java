package sistematickets;

import java.util.List;

public class Estadisticas {

    public static int contarTicketsPorEstado(List<Ticket> tickets, String estado) {
        int contador = 0;
        for (Ticket t : tickets) {
            if (t.getEstado().equalsIgnoreCase(estado)) {
                contador++;
            }
        }
        return contador;
    }

    public static void imprimirResumen(List<Ticket> tickets) {
        System.out.println("Tickets Pendientes: " + contarTicketsPorEstado(tickets, "Pendiente"));
        System.out.println("Tickets En proceso: " + contarTicketsPorEstado(tickets, "En proceso"));
        System.out.println("Tickets Resueltos: " + contarTicketsPorEstado(tickets, "Resuelto"));
        System.out.println("Tickets Cerrados: " + contarTicketsPorEstado(tickets, "Cerrado"));
    }
}