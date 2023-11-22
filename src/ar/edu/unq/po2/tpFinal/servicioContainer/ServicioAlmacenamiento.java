package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioAlmacenamiento extends ServicioContainer{	
	
	private int costoDeAlmacenamiento;
	private LocalDateTime fechaInicial;
	private LocalDateTime fechaFinal;
	
	public ServicioAlmacenamiento(Container container, LocalDateTime fechaInicial, LocalDateTime fechaFinal, int costoDeAlmacenamiento) {
		super(container);
		this.costoDeAlmacenamiento = costoDeAlmacenamiento;
		this.fechaFinal = fechaFinal;
		this.fechaInicial = fechaInicial;
	}
	
	@Override
	public double costoDelServicio() {
		return cantidadDeDiasExcedentes(fechaInicial, fechaFinal) * costoDeAlmacenamiento;
	}
	
}