package ar.edu.unq.po2.tpFinal.orden;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class OrdenDeImportacion extends Orden {
	
	public OrdenDeImportacion(Container container, Cliente cliente, Camion camion, Chofer chofer, Viaje viaje) {
		super(container, cliente, camion, chofer, viaje);
	}
	
}
