package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Pesado: por razones legales, antes de cargarlos en el buque todos los contenedores
 * deben ser pesados en la terminal, y su peso registrado. El servicio de pesado
 * también tiene un costo fijo.
 */

public class ServicioPesado extends ServicioContainer {
	
	public ServicioPesado(Container container, LocalDateTime fechaHoraLlegada) {
		super(container, fechaHoraLlegada);
	}
	
	@Override
	public double costoDelServicio() {
		return 500;
	}
}
