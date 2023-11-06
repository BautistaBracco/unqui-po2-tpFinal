package ar.edu.unq.po2.tpFinal.serviciosDeContainer;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Lavado: Consiste en el lavado de un container (exterior, no mercadería interna). Se
 * establece un precio fijo según capacidad del container, un monto si el mismo supera
 * 70 metros cúbicos y otro monto si está por debajo de ese volumen.
 */
public class ServicioLavado extends ServicioContainer {

	public ServicioLavado(Container container) {
		super(container);
	}
	
	public double costoDelServicio() {
		if (getContainer().metrosCubicos() > 70) {
			return 2;
		} else {
			return 1;
		}
	}

}
