package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
 * Electricidad: mientras permanecen en la terminal, los contenedores reefers deben
 * recibir electricidad para mantener la temperatura adecuada. La terminal define un
 * precio fijo por cada kilowatt consumido. La terminal registra el día/hora de inicio y fin
 * de la conexión de cada reefer, y conociendo el consumo kw/hora propio del reefer se
 * calcula el monto final.
 * 
 * Lo paga el 
 */
public class ServicioElectricidad extends ServicioContainer{
	
	public ServicioElectricidad(Container container, LocalDateTime fechaHoraLlegada) {
		super(container, fechaHoraLlegada);
	}
	
//	Resolver problema de identificar los contenedores de alguna forma.
	@Override
	public double costoDelServicio() {
		return getContainer().getKWPorHoras() * cantidadDeHorasExcedentes();
	}
}