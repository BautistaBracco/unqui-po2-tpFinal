package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;

public class OrdenDeImportacion extends Orden {
	
	public OrdenDeImportacion(Container container,Cliente shipper, Cliente consignee, Camion camion, Chofer chofer, Buque buque,
							  LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada) {
		super(container, shipper, consignee, camion, chofer, buque, fechaDeSalida, fechaDeLlegada);
	}
	
	@Override
	public void agregarServicio(ServicioContainer servicio) {
		if (servicio instanceof ServicioAlmacenamiento || servicio instanceof ServicioElectricidad) {
			getServiciosDeContainer().add(servicio);
		}
	}
}
