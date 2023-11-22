package ar.edu.unq.po2.tpFinal.orden;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public abstract class Orden {

	/*
	 * Por último, resta mencionar a los extremos de la cadena logística: el shipper (exportador) 
	 * y el consignee (consignatario o importador). El primero es la persona que envía la carga 
	 * mientras que el segundo es quien la recibe, y es reconocido como el dueño de la misma
	 * 
	 * Hay servicios que son solo de shipper y otros solo de consignee:
	 * 	- ServicioAlmacenamiento (solo se le cobra al consignee)
	 * 	- ServicioLavado y ServicioPesado (solo se le cobra al shipper)
	 * 	- ServicioElectricidad (ambos)
	 */

	private Container container;
	private Camion camion;
	private Chofer chofer;
	private Viaje viaje;
	private Cliente cliente;
	private List<ServicioContainer> serviciosDeContainer;

	public Orden(Container container, Cliente cliente, Camion camion, Chofer chofer, Viaje viaje) {
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.viaje = viaje;
		this.cliente = cliente;
		this.serviciosDeContainer = new ArrayList<>();
	}
	
	public Container getContainer() {
		return this.container;
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
	public Chofer getChofer() {
		return this.chofer;
	}
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public List<ServicioContainer> getServiciosDeContainer() {
		return this.serviciosDeContainer;
	}
	
	public void agregarServicio(ServicioContainer servicio) {
		this.serviciosDeContainer.add(servicio);
	}
	
}