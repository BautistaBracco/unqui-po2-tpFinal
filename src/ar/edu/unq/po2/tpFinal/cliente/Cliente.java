package ar.edu.unq.po2.tpFinal.cliente;

import java.time.Duration;
import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Cliente {
    private String nombre;
    private Turno turno;
    
    private Camion camion;
    private Chofer chofer;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCamion(Camion camion) {
    	this.camion = camion;
    }
    
    public Camion getCamion() {
    	return this.camion;
    }
    
    public Chofer getChofer() {
    	return this.chofer;
    }
    
    public void setChofer(Chofer chofer) {
    	this.chofer = chofer;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void realizarPedidoDeExportacion(
            Terminal terminalGestionada, Camion camion, Chofer chofer, LocalDateTime fechaAsignada
    ) {
        turno = new Turno(fechaAsignada, this, chofer, camion);
        terminalGestionada.registrarTurnoDeExportacion(turno);
    }

    public void llevarCargaALaTerminal(
            Terminal terminalGestionada, Terminal terminalDestino, LocalDateTime fecha, Viaje viaje,
            Container container, Camion camion, Chofer chofer
    ) {
        if (terminalGestionada.estaElCamionRegistrado(camion) &&
            terminalGestionada.estaElChoferRegistrado(chofer) &&
            (Duration.between(fecha, turno.getFechaHoraAsignada()).toDays() <= 3)) {
            terminalGestionada.registrarOrdenDeExportacion(new OrdenDeExportacion(container,
                    this,
                    camion,
                    chofer,
                    viaje,
                    viaje.getFechaDeSalida(),
                    viaje.getFechaDeLlegada(terminalDestino)));
        }

    }
    
    public void informarATerminalCamionYChofer(Terminal terminal, Camion camion, Chofer chofer, LocalDateTime fechaAsignada) {
    	turno = new Turno(fechaAsignada, this, chofer, camion);
    	terminal.registrarTurnoDeImportacion(turno);
    }
    
    public void irARecogerCargaALaTerminal(Terminal terminalGestionada, OrdenDeImportacion orden, Camion camion, Chofer chofer) {	
    	if (terminalGestionada.estaElCamionRegistrado(camion) &&
            terminalGestionada.estaElChoferRegistrado(chofer) &&
            terminalGestionada.ordenesDeImportacionDelViaje(orden.getViaje()).contains(orden)) {
    		camion.agregarContenedor(orden.getContainer());
    	}
    }

    public void realizarPedidoDeImportacion(
            Terminal terminalGestionada, Terminal terminalDestino, Viaje viaje, Container container, Camion camion,
            Chofer chofer
    ) {
        OrdenDeImportacion ordenDeImportacion = new OrdenDeImportacion(container, this, camion, chofer, viaje);
        terminalGestionada.registrarOrdenDeImportacion(ordenDeImportacion);
    }

}
