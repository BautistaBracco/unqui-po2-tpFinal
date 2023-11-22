package ar.edu.unq.po2.tpFinal.servicioContainer;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioElectricidad extends ServicioContainer{
	
	private LocalDateTime fechaInicial;
	private LocalDateTime fechaFinal;
	
	public ServicioElectricidad(Container container, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		super(container);
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
	
//	Resolver problema de identificar los contenedores de alguna forma.
	@Override
	public double costoDelServicio() {
		return getContainer().getKWPorHoras() * cantidadDeHorasExcedentes(fechaInicial, fechaFinal);
	}
}