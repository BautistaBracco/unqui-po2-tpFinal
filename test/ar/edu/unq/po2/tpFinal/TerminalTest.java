package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
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
    private Naviera naviera;
    private Viaje viajeMock;
    private OrdenDeExportacion ordenDeExportacionMock;
    private OrdenDeImportacion ordenDeImportacionMock;
    private MejorCircuitoStrategy mejorCircuitoStrategy;
    private List<CircuitoMaritimo> circuitosMaritimos;
    private CircuitoMaritimo circuitoMaritimoADevolver;

    @Before
    public void setUp() {
        camionMock = mock(Camion.class);
        viajeMock = viajeMock();
        ordenDeExportacionMock = ordenDeExportacionMock(viajeMock, 500.00);
        ordenDeImportacionMock = ordenDeImportacionMock(viajeMock, 700.00);
        terminalDestino = new Terminal("terminalDos");
        mejorCircuitoStrategy = mejorCircuitoStrategyMock();
        circuitoMaritimoADevolver = mock(CircuitoMaritimo.class);
        circuitosMaritimos = List.of(circuitoMaritimoADevolver);
        naviera = lineaNavieraMock();


        terminal = new Terminal("terminalUno");
        terminal.registrarOrdenDeExportacion(ordenDeExportacionMock);
        terminal.registrarOrdenDeImportacion(ordenDeImportacionMock);

        terminal.registrarChofer(choferMock("Juan"));
        terminal.registrarCamion(camionMock);

        terminal.registrarConsignee(clienteMock());
        terminal.registrarShipper(clienteMock());

        terminal.registrarLineaNaviera(lineaNavieraMock());
        terminal.registrarCircuitoMaritimo(circuitosMaritimos.get(0));
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
    public void testGetters() {
        assertEquals("terminalUno", terminal.getNombre());
        assertEquals(1, terminal.getLineasNavierasRegistradas().size());
        assertEquals(1, terminal.getConsigneesRegistrados().size());
        assertEquals(1, terminal.getShippersRegistrados().size());
        assertTrue(terminal.estaElCamionRegistrado(camionMock));
        assertTrue(terminal.estaElChoferRegistrado(choferMock("Juan")));
    }

    @Test
    public void testSetMejorCircuitoStrategy() {
        Terminal terminalMock = mock(Terminal.class);
        MejorCircuitoStrategy mejorCircuitoStrategy = mock(MejorCircuitoStrategy.class);

        terminalMock.setMejorCircuitoStrategy(mejorCircuitoStrategy);
        verify(terminalMock).setMejorCircuitoStrategy(mejorCircuitoStrategy);
    }

    @Test
    public void testRegistrarCircuitoMaritimo() {
        Terminal terminalMock = mock(Terminal.class);
        CircuitoMaritimo circuitoMaritimo = mock(CircuitoMaritimo.class);

        terminalMock.registrarCircuitoMaritimo(circuitoMaritimo);
        verify(terminalMock).registrarCircuitoMaritimo(circuitoMaritimo);
    }

    @Test
    public void testSetChofer() {
        Terminal terminalMock = mock(Terminal.class);
        Chofer chofer = mock(Chofer.class);

        terminalMock.registrarChofer(chofer);
        verify(terminalMock).registrarChofer(chofer);
    }

    @Test
    public void testRegistrarCamion() {
        Terminal terminalMock = mock(Terminal.class);
        Camion camion = mock(Camion.class);

        terminalMock.registrarCamion(camion);
        verify(terminalMock).registrarCamion(camion);
    }

    @Test
    public void testRegistrarLineaNaviera() {
        Terminal terminalMock = mock(Terminal.class);
        Naviera naviera = mock(Naviera.class);

        terminalMock.registrarLineaNaviera(naviera);
        verify(terminalMock).registrarLineaNaviera(naviera);
    }

    @Test
    public void testRegistrarShipper() {
        Terminal terminalMock = mock(Terminal.class);
        Cliente shipper = mock(Cliente.class);

        terminalMock.registrarShipper(shipper);
        verify(terminalMock).registrarShipper(shipper);
    }

    @Test
    public void testRegistrarConsignee() {
        Terminal terminalMock = mock(Terminal.class);
        Cliente consignee = mock(Cliente.class);

        terminalMock.registrarConsignee(consignee);
        verify(terminalMock).registrarConsignee(consignee);
    }

    @Test
    public void getMejorCircuitoMaritimo() {
        assertEquals(circuitoMaritimoADevolver, terminal.getMejorCircuito(terminalDestino));
    }

    /*@Test
    public void testGetTiempoDeViaje() {
        assertEquals(Duration.ofDays(1), terminal.cuantoTardaNavieraEnIrA(terminalDestino, naviera));
    }*/

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
        Naviera naviera = mock(Naviera.class);
        when(naviera.getTiempoDeViaje(terminal, terminalDestino)).thenReturn(Duration.ofDays(1));
        return naviera;
    }


    private MejorCircuitoStrategy mejorCircuitoStrategyMock() {
        MejorCircuitoStrategy mejorCircuitoStrategy = mock(MejorCircuitoStrategy.class);
        when(mejorCircuitoStrategy.getMejorCircuitoPara(terminal, terminalDestino, circuitosMaritimos)).thenReturn(
                circuitoMaritimoADevolver);
        return mejorCircuitoStrategy;

    }

}
