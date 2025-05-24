
package sistematickets;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.List;

public class EstadisticasController {

    @FXML private Label lblPendientes;
    @FXML private Label lblProceso;
    @FXML private Label lblResueltos;
    @FXML private Label lblCerrados;

    @FXML
    public void initialize() {
        List<Ticket> tickets = Sistema.getTickets();

        lblPendientes.setText("Pendientes: " + Estadisticas.contarTicketsPorEstado(tickets, "Pendiente"));
        lblProceso.setText("En Proceso: " + Estadisticas.contarTicketsPorEstado(tickets, "En proceso"));
        lblResueltos.setText("Resueltos: " + Estadisticas.contarTicketsPorEstado(tickets, "Resuelto"));
        lblCerrados.setText("Cerrados: " + Estadisticas.contarTicketsPorEstado(tickets, "Cerrado"));
    }

    @FXML
    public void cerrarVentana() {
        Stage stage = (Stage) lblPendientes.getScene().getWindow();
        stage.close();
    }
}
