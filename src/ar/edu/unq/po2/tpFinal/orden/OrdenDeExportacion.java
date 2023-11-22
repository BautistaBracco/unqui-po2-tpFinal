package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class OrdenDeExportacion extends Orden {
	
	private LocalDateTime fechaDeSalida;
	private LocalDateTime fechaDeLlegada;
	
	public OrdenDeExportacion(Container container, Cliente cliente, Camion camion, Chofer chofer, Viaje viaje,
							  LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada) {
		super(container, cliente, camion, chofer, viaje);
		this.fechaDeLlegada = fechaDeLlegada;
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public LocalDateTime getFechaDeSalida() {
		return this.fechaDeSalida;
	}
	
	public LocalDateTime getFechaDeLlegada() {
		return this.fechaDeLlegada;
	}
	
}