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
	
	public int cantidadDeServicios() {
		return this.serviciosDeContainer.size();
	}
	
	public void agregarServicio(ServicioContainer servicio) {
		this.serviciosDeContainer.add(servicio);
	}
	
	public double costoDeServicios() {
		return serviciosDeContainer.stream().mapToDouble(servicio -> servicio.costoDelServicio()).sum();
	}
	
}