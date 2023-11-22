package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import ar.edu.unq.po2.tpFinal.container.Container;

public abstract class ServicioContainer {

	private Container container;
	
	public ServicioContainer(Container container) {
		this.container = container;
	}
	
	public Container getContainer() {
		return this.container;
	}
	
	public int cantidadDeDiasExcedentes(LocalDateTime fecha1, LocalDateTime fecha2) {
		LocalDate fechaLlegada = fecha1.toLocalDate();
		LocalDate fechaRetiro = fecha2.toLocalDate();
		
		Period periodo = Period.between(fechaLlegada, fechaRetiro);
		return periodo.getDays();
	}
	
	public int cantidadDeHorasExcedentes(LocalDateTime fecha1, LocalDateTime fecha2) {
		int horas = fecha1.toLocalTime().getHour();
		
		int horasExtras = horas + (cantidadDeDiasExcedentes(fecha1, fecha2) * 24);
		return horasExtras;
	}
	
	public abstract double costoDelServicio();
	
}