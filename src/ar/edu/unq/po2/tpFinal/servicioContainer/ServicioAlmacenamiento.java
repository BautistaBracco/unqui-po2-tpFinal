package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Almacenamiento excedente: cuando un consignee se demora en retirar de la
 * terminal la carga que le llegó en un buque, se le cobra un alto costo de
 * almacenamiento por día excedente.
 * 
 * Lo paga el shipper
 */
public class ServicioAlmacenamiento extends ServicioContainer{	
	
	private int costoDeAlmacenamiento;
	
	public ServicioAlmacenamiento(Container container, LocalDateTime fechaHoraLlegada, int costoDeAlmacenamiento) {
		super(container, fechaHoraLlegada);
		this.costoDeAlmacenamiento = costoDeAlmacenamiento;
	}
	
	@Override
	public double costoDelServicio() {
		return cantidadDeDiasExcedentes() * costoDeAlmacenamiento;
	}
	
}