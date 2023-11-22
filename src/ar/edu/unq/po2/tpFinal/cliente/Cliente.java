package ar.edu.unq.po2.tpFinal.cliente;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Cliente {
	
	private String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void realizarPedidoDeExportacion(Terminal terminalGestionada, Terminal terminalDestino, Viaje viaje, 
											Container container, Camion camion, Chofer chofer) {
		OrdenDeExportacion ordenDeExportacion = new OrdenDeExportacion(container, this, camion, chofer, viaje, viaje.getFechaDeSalida(), viaje.getFechaDeLlegada(terminalDestino));
		terminalGestionada.registrarOrdenDeExportacion(ordenDeExportacion);
	}
	
	public void realizarPedidoDeImportacion(Terminal terminalGestionada, Terminal terminalDestino, Viaje viaje, 
			Container container, Camion camion, Chofer chofer) {
		OrdenDeImportacion ordenDeImportacion = new OrdenDeImportacion(container, this, camion, chofer, viaje);
		terminalGestionada.registrarOrdenDeImportacion(ordenDeImportacion);
	}
	
}
