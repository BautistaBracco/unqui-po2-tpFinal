package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.serviciosDeContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.serviciosDeContainer.ServicioContainer;

/*
 * mock(nameClass.class)
 * spy(new ArrayList<Receta>())
 * orden.verify(spyListaDeRecetas).add(dummyReceta)
 * when(recetaAptaCeliaco.costoTotal()).thenReturn(30);
 */

class ServicioDeContainerTest {

	private LocalDateTime fechaHoraLlegada;
	private Container container;
	
	private ServicioContainer servicioContainer;
	
	@BeforeEach
	public void setUp() {
		fechaHoraLlegada = mock(LocalDateTime.class);
		container = mock(Container.class);
		
		servicioContainer = new ServicioAlmacenamiento(container);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
