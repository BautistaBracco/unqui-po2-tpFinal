package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import ar.edu.unq.po2.tpFinal.container.Container;

/*
   Un container pueden recibir varios servicios, en general contratados explícitamente a
   la terminal y registrados en la orden de exportación o importación, mientras se encuentra
   dentro de la misma; todos ellos irán a costo del shipper o consignee (según la carga esté allí
   para una exportación o importación, respectivamente).
   
   ?? Modificar UML, la orden tiene muchos servicios NO el container.
    
 */

public abstract class ServicioContainer {

	private Container container;
	private LocalDateTime fechaHoraLlegada;
	
	public ServicioContainer(Container container, LocalDateTime fechaHoraLlegada) {
		this.container = container;
		this.fechaHoraLlegada = fechaHoraLlegada;
	}
	
	public Container getContainer() {
		return this.container;
	}
	
	public int cantidadDeDiasExcedentes() {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaLlegada = fechaHoraLlegada.toLocalDate();
		
		Period periodo = Period.between(fechaLlegada, fechaActual);
		return periodo.getDays();
	}
	
	public int cantidadDeHorasExcedentes() {
		int horas = fechaHoraLlegada.toLocalTime().getHour();
		
		int horasExtras = horas + (cantidadDeDiasExcedentes() * 24);
		return horasExtras;
	}
	
	public abstract double costoDelServicio();
	
}