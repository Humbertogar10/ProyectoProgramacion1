
package sistematickets;

import java.time.LocalDateTime;
import java.util.Stack;

public class Ticket {
    private String titulo;
    private String descripcion;
    private String estado;
    private Usuario creador;
    private LocalDateTime fechaCreacion;
    private Stack<String> historialEstados;

    public Ticket(String titulo, String descripcion, Usuario creador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
        this.creador = creador;
        this.fechaCreacion = LocalDateTime.now();
        this.historialEstados = new Stack<>();
        historialEstados.push(estado);
    }

    public void setEstado(String nuevoEstado) {
        historialEstados.push(nuevoEstado);
        this.estado = nuevoEstado;
    }

    public void deshacerCambioEstado() {
        if (historialEstados.size() > 1) {
            historialEstados.pop();
            this.estado = historialEstados.peek();
        }
    }
}
