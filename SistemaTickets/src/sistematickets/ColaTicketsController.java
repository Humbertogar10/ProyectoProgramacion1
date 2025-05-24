package sistematickets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

public class ColaTicketsController {

    @FXML private TableView<Ticket> tablaTickets;
    @FXML private TableColumn<Ticket, String> colTitulo;
    @FXML private TableColumn<Ticket, String> colEstado;

    @FXML
    public void initialize() {
        ObservableList<Ticket> lista = FXCollections.observableArrayList(Sistema.getTickets());
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstado()));
        tablaTickets.setItems(lista);
    }

    @FXML
    public void deshacerEstado() {
        Ticket ticketSeleccionado = tablaTickets.getSelectionModel().getSelectedItem();
        if (ticketSeleccionado != null) {
            ticketSeleccionado.deshacerCambioEstado();
            tablaTickets.refresh();
        }
    }
}
