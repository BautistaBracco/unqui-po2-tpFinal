package ar.edu.unq.po2.tpFinal.cliente;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;

public class Turno {
	// podemos hacer que cuando se haga un pedido de exportacion se genere un turno para llevar la carga
	// y en el caso de importacion se genere un turno al igual que en el de exportacion
	private LocalDateTime fechaHoraAsignada;
	private Cliente cliente;
	private Chofer chofer;
	private Camion camion;
	
	public Turno(LocalDateTime fechaHoraAsignada, Cliente cliente, Chofer chofer, Camion camion) {
		this.fechaHoraAsignada = fechaHoraAsignada;
		this.cliente = cliente;
		this.chofer = chofer;
		this.camion = camion;
	}
	
	public LocalDateTime getFechaHoraAsignada() {
		return this.fechaHoraAsignada;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Chofer getChofer() {
		return this.chofer;
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
}