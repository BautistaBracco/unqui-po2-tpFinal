package ar.edu.unq.po2.tpFinal.serviciosDeContainer;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Pesado: por razones legales, antes de cargarlos en el buque todos los contenedores
 * deben ser pesados en la terminal, y su peso registrado. El servicio de pesado
 * también tiene un costo fijo.
 * 
 * Lo paga el Consignee.
 */
public class ServicioPesado extends ServicioContainer {
	public ServicioPesado(Container container) {
		super(container);
	}
	
	public double costoDelServicio() {
		return 3;
	}
}
