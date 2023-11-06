package ar.edu.unq.po2.tpFinal.serviciosDeContainer;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Almacenamiento excedente: cuando un consignee se demora en retirar de la
 * terminal la carga que le llegó en un buque, se le cobra un alto costo de
 * almacenamiento por día excedente.
 * 
 * Lo paga el shipper
 */
public class ServicioAlmacenamiento extends ServicioContainer{	
	
	public ServicioAlmacenamiento(Container container) {
		super(container);
	}
	
	// queda mejor utilizando un setter para setear el monto por dia excedente
	public double costoDelServicio() {
		return cantidadDeDiasExcedentes() * 50;
	}
	
}
