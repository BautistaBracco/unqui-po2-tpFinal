package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.terminal.MejorCircuitoStrategy;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class TerminalTest {

    private Terminal terminal;
    private Terminal terminalDestino;
    private Camion camionMock;
    private Viaje viajeMock;
    private OrdenDeExportacion ordenDeExportacionMock;
    private OrdenDeImportacion ordenDeImportacionMock;
    private MejorCircuitoStrategy circuito;

    @Before
    public void setUp() {
        camionMock = mock(Camion.class);
        viajeMock = viajeMock();
        ordenDeExportacionMock = ordenDeExportacionMock(viajeMock, 500.00);
        ordenDeImportacionMock = ordenDeImportacionMock(viajeMock, 700.00);
        terminalDestino = new Terminal("terminalDos");
        circuito = mock(MejorCircuitoStrategy.class);

        terminal = new Terminal("terminalUno");
        terminal.registrarOrdenDeExportacion(ordenDeExportacionMock);
        terminal.registrarOrdenDeImportacion(ordenDeImportacionMock);
        terminal.registrarChofer(choferMock("Juan"));

        terminal.registrarConsignee(clienteMock());
        terminal.registrarShipper(clienteMock());
        terminal.registrarLineaNaviera(lineaNavieraMock());
        terminal.registrarCamion(camionMock);
    }

    @Test
    public void testTerminalCostoDeServicios() {
        assertEquals(500.00, terminal.costoDeServiciosDeOrdenExportacion(ordenDeExportacionMock), 0.01);
        assertEquals(700.00, terminal.costoDeServiciosDeOrdenImportacion(ordenDeImportacionMock), 0.01);
    }

    @Test
    public void testOrdenesDeExportacion() {
        // Lista simulada para el assert
        List<OrdenDeExportacion> ordenesDeExportacion = new ArrayList<>();
        ordenesDeExportacion.add(ordenDeExportacionMock);
        // Verifico que ambas listas sean iguales
        assertEquals(ordenesDeExportacion, terminal.ordenesDeExportacionDelViaje(viajeMock));
    }

    @Test
    public void testOrdenesDeImportacion() {
        List<OrdenDeImportacion> ordenesDeImportacion = new ArrayList<>();
        ordenesDeImportacion.add(ordenDeImportacionMock);
        assertEquals(ordenesDeImportacion, terminal.ordenesDeImportacionDelViaje(viajeMock));
    }

    @Test
    public void testGettersYRegistrar() {
        assertEquals("terminalUno", terminal.getNombre());
        assertEquals(1, terminal.getLineasNavierasRegistradas().size());
        assertEquals(1, terminal.getConsigneesRegistrados().size());
        assertEquals(1, terminal.getShippersRegistrados().size());
        assertTrue(terminal.estaElCamionRegistrado(camionMock));
        assertTrue(terminal.estaElChoferRegistrado(choferMock("Juan")));
//    	assertEquals(circuito, terminal.getMejorCircuito(terminalDestino));
    }

    private OrdenDeExportacion ordenDeExportacionMock(Viaje viaje, double costo) {
        OrdenDeExportacion ordenDeExportacion = mock(OrdenDeExportacion.class);
        when(ordenDeExportacion.costoDeServicios()).thenReturn(costo);
        when(ordenDeExportacion.getViaje()).thenReturn(viaje);
        return ordenDeExportacion;
    }

    private Viaje viajeMock() {
        Viaje viaje = mock(Viaje.class);
        LocalDateTime fechaSalida = LocalDateTime.now();
        when(viaje.costoDeViaje(terminal)).thenReturn(100);
        when(viaje.getFechaDeSalida()).thenReturn(fechaSalida);
        return viaje;
    }

    private OrdenDeImportacion ordenDeImportacionMock(Viaje viaje, double costo) {
        OrdenDeImportacion ordenDeImportacion = mock(OrdenDeImportacion.class);
        when(ordenDeImportacion.getViaje()).thenReturn(viaje);
        when(ordenDeImportacion.getViaje().costoDeViaje(terminal)).thenReturn(100);
        when(ordenDeImportacion.costoDeServicios()).thenReturn(costo);
        return ordenDeImportacion;
    }

    private Chofer choferMock(String nombre) {
        Chofer chofer = mock(Chofer.class);
        when(chofer.getNombre()).thenReturn(nombre);
        return chofer;
    }

    private Cliente clienteMock() {
        return mock(Cliente.class);
    }

    private Naviera lineaNavieraMock() {
        return mock(Naviera.class);
    }

}
