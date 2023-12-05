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
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void realizarPedidoDeExportacion(Terminal terminalGestionada, Camion camion, Chofer chofer, LocalDateTime fechaAsignada) {
		turno = new Turno(fechaAsignada, this, chofer, camion);
		terminalGestionada.registrarTurnoDeExportacion(turno);
	}
	
	public void llevarCargaALaTerminal(Terminal terminalGestionada, Terminal terminalDestino, LocalDateTime fecha, Viaje viaje, Container container, Camion camion, Chofer chofer) {
		if (terminalGestionada.estaElCamionRegistrado(camion) && terminalGestionada.estaElChoferRegistrado(chofer) 
			&& (Duration.between(fecha, turno.getFechaHoraAsignada()).toDays() <= 3)) {
			terminalGestionada.registrarOrdenDeExportacion(
					new OrdenDeExportacion(container, this, camion, chofer, viaje, viaje.getFechaDeSalida(), viaje.getFechaDeLlegada(terminalDestino)));
		}

	}
	
	public void realizarPedidoDeImportacion(Terminal terminalGestionada, Terminal terminalDestino, Viaje viaje, 
			Container container, Camion camion, Chofer chofer) {
		OrdenDeImportacion ordenDeImportacion = new OrdenDeImportacion(container, this, camion, chofer, viaje);
		terminalGestionada.registrarOrdenDeImportacion(ordenDeImportacion);
	}
	
	// FALTA LA PARTE CUANDO LA TERMINAL AVISA QUE ESTA POR LLEGAR LA CARGA Y EL CONSIGNEE DEBE ENVIARLE EL CHOFER Y CAMION
	
	// EN ESTADO DE BUQUE INBUND HACER LO DE AVISAR CONSIGNEE Y DE PASO HACER QUE INFORME A LA TERMINAL EL CAMION Y CHOFER QUE IRAN, LUEGO EN CLIENTE
	// HACER EL METODO DE IR A RECOGER CARGA A TERMINAL CON CAMION Y CHOFER. 
}
