package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.orden.Cliente;

public abstract class Orden {

	/*
	 * Por último, resta mencionar a los extremos de la cadena logística: el shipper (exportador) 
	 * y el consignee (consignatario o importador). El primero es la persona que envía la carga 
	 * mientras que el segundo es quien la recibe, y es reconocido como el dueño de la misma
	 * 
	 * Hay servicios que son solo de shipper y otros solo de consignee:
	 * 	- ServicioAlmacenamiento (solo se le cobra al consignee)
	 * 	- ServicioLavado y ServicioPesado (solo se le cobra al shipper)
	 * 	- ServicioElectricidad (Preguntar si se cobra mientras espera al buque y tambien mientras espera a ser retirado)
	 */
	
	private Container container;
	
	private Camion camion;
	private Chofer chofer;
	
	private Buque buque;
	
	private LocalDateTime fechaDeSalida;
	private LocalDateTime fechaDeLlegada;
	
	private Cliente shipper;
	private Cliente consignee;
	private List<ServicioContainer> serviciosDeContainer;

	public Orden(Container container,Cliente shipper, Cliente consignee, Camion camion, Chofer chofer, Buque buque,
				 LocalDateTime fechaDeLlegada, LocalDateTime fechaDeSalida) {
		this.container = container;
		
		this.camion = camion;
		this.chofer = chofer;
		this.buque = buque;
		
		this.shipper = shipper;
		this.consignee = consignee;
		
		this.fechaDeLlegada = fechaDeLlegada;
		this.fechaDeSalida = fechaDeSalida;
		
		this.serviciosDeContainer = new ArrayList<>();
	}
	
	public Camion getCamion() {
		return this.camion;
	}
	
	public Chofer getChofer() {
		return this.chofer;
	}
	
	public Buque getBuque() {
		return this.buque;
	}
	
	public Cliente getShipper() {
		return this.shipper;
	}
	
	public Cliente getConsignee() {
		return this.consignee;
	}
	
	public List<ServicioContainer> getServiciosDeContainer() {
		return this.serviciosDeContainer;
	}
	
	public LocalDateTime getFechaDeSalida() {
		return this.fechaDeSalida;
	}
	
	public LocalDateTime getFechaDeLlegada() {
		return this.fechaDeLlegada;
	}
	
	// Este metodo se debe hacer en la terminal ya que de calcular el costo se ocupa la terminal, ver como resolver
	// lo de cacular el costo del servicio electrico ya que se calcula en base a dias al igual que el almacenamiento.
	public double costoTotalDeServiciosDeContainer() {
		return getServiciosDeContainer().stream()
				   .mapToDouble(servicio -> servicio.costoDelServicio())
				   .sum();
	}
	
	public abstract void agregarServicio(ServicioContainer servicio);
	
}