package ar.edu.unq.po2.tpFinal.servicioContainer;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioLavado extends ServicioContainer {
	
	public ServicioLavado(Container container) {
		super(container);
	}
	
	@Override
	public double costoDelServicio() {
		if (getContainer().metrosCubicos() > 70) {
			return 10;
		} else {
			return 5;
		}
	}
}