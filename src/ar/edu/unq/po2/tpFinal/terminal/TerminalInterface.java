package ar.edu.unq.po2.tpFinal.terminal;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

public interface TerminalInterface {

    String getNombre();

    void registrarLineaNaviera(NavieraInterface lineaNaviera);

    void registrarShipper(Cliente cliente);

    void registrarConsignee(Cliente cliente);

    void registrarOrdenDeExportacion(OrdenDeExportacion ordenDeExportacion);

    void registrarOrdenDeImportacion(OrdenDeImportacion ordenDeImportacion);

    void registrarCamion(CamionInterface camion);

    boolean estaElCamionRegistrado(CamionInterface camion);

    void registrarChofer(ChoferInterface chofer);

    void registrarCircuitoMaritimo(CircuitoMaritimoInterface circuitoMaritimo);

    boolean estaElChoferRegistrado(ChoferInterface chofer);

    double costoDeServiciosDeOrdenExportacion(OrdenDeExportacion ordenDeExportacion);

    double costoDeServiciosDeOrdenImportacion(OrdenDeImportacion ordenDeImportacion);

    List<OrdenDeImportacion> ordenesDeImportacionDelViaje(Viaje viaje);

    List<OrdenDeExportacion> ordenesDeExportacionDelViaje(Viaje viaje);

    void informarConsigneesDelViaje(Viaje viaje);

    void informarShippersDelViaje(Viaje viaje);

    Duration cuantoTardaNavieraEnIrA(TerminalInterface destino, NavieraInterface naviera);

    CircuitoMaritimoInterface getMejorCircuito(TerminalInterface destino);

    LocalDateTime fechaDeProximoBuqueA(TerminalInterface destino, LocalDateTime now);

    List<NavieraInterface> getLineasNavierasRegistradas();
}
