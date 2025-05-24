
package sistematickets;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

public class VistaTecnicoController {

    @FXML private TableView<Ticket> tablaTickets;
    @FXML private TableColumn<Ticket, String> colTitulo;
    @FXML private TableColumn<Ticket, String> colEstado;

    private Departamento departamento;
    private Tecnico tecnico;

    @FXML
    public void initialize() {
        departamento = new Departamento("Soporte");
        tecnico = new Tecnico("Técnico Juan", "juan@mail.com", "abc123");

        // Simulación de tickets
        Usuario u = new Usuario("Cliente", "cliente@mail.com", "pass");
        Ticket t1 = new Ticket("Pantalla negra", "No se ve la imagen", u);
        Ticket t2 = new Ticket("No imprime", "La impresora no responde", u);
        departamento.agregarTicket(t1);
        departamento.agregarTicket(t2);

        ObservableList<Ticket> lista = FXCollections.observableArrayList(departamento.getColaTickets());
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstado()));
        tablaTickets.setItems(lista);
    }

    @FXML
    public void marcarEnProceso() {
        Ticket ticket = tablaTickets.getSelectionModel().getSelectedItem();
        if (ticket != null) {
            tecnico.cambiarEstadoTicket(ticket, "En proceso");
            tablaTickets.refresh();
        }
    }

    @FXML
    public void marcarResuelto() {
        Ticket ticket = tablaTickets.getSelectionModel().getSelectedItem();
        if (ticket != null) {
            tecnico.cambiarEstadoTicket(ticket, "Resuelto");
            tablaTickets.refresh();
        }
    }
}
