package ar.edu.unq.po2.tpFinal.servicioContainer;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioPesado extends ServicioContainer {
	
	public ServicioPesado(Container container) {
		super(container);
	}
	
	@Override
	public double costoDelServicio() {
		return 500;
	}
}
