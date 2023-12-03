package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.Departing;
import ar.edu.unq.po2.tpFinal.buque.Working;
import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;
import ar.edu.unq.po2.tpFinal.busquedaMaritima.Filtro;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.Turno;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private String nombre;
    private MejorCircuitoStrategy mejorCircuitoStrategy;
    private List<Naviera> lineasNavierasRegistradas;
    private List<CircuitoMaritimo> circuitosMaritimos;
    
    private List<Camion> camionesRegistrados;
    private List<Chofer> choferesRegistrados;
    private List<Cliente> shippersRegistrados;
    private List<Cliente> consigneesRegistrados;
    private List<OrdenDeExportacion> ordenesDeExportacion;
    private List<OrdenDeImportacion> ordenesDeImportacion;
    private List<Buque> buquesAEsperaDeOrdenDeparting;
    private List<Buque> buquesAEsperaDeOrdenWorking;
    private List<Turno> turnosDeExportacion;
    private List<Turno> turnosDeImportacion;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.mejorCircuitoStrategy = new MenorTiempoStrategy();
        this.lineasNavierasRegistradas = new ArrayList<>();
        this.circuitosMaritimos = new ArrayList<>();
        
        this.camionesRegistrados = new ArrayList<>();
        this.choferesRegistrados = new ArrayList<>();
        this.shippersRegistrados = new ArrayList<>();
        this.consigneesRegistrados = new ArrayList<>();
        this.ordenesDeExportacion = new ArrayList<>();
        this.ordenesDeImportacion = new ArrayList<>();
        this.buquesAEsperaDeOrdenDeparting = new ArrayList<>();
        this.buquesAEsperaDeOrdenWorking = new ArrayList<>();
        this.turnosDeExportacion = new ArrayList<>();
        this.turnosDeImportacion = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Naviera> getLineasNavierasRegistradas() {
        return lineasNavierasRegistradas;
    }

    public List<Cliente> getShippersRegistrados() {
        return shippersRegistrados;
    }

    public List<Cliente> getConsigneesRegistrados() {
        return consigneesRegistrados;
    }

    public void registrarLineaNaviera(Naviera lineaNaviera) {
        this.lineasNavierasRegistradas.add(lineaNaviera);
    }

    public void registrarShipper(Cliente shipper) {
        this.shippersRegistrados.add(shipper);
    }

    public void registrarConsignee(Cliente consignee) {
        this.consigneesRegistrados.add(consignee);
    }

    public void registrarCamion(Camion camion) {
        this.camionesRegistrados.add(camion);
    }

    public boolean estaElCamionRegistrado(Camion camion) {
        return this.camionesRegistrados.stream().anyMatch(c -> c.equals(camion));
    }

    public void registrarChofer(Chofer chofer) {
        this.choferesRegistrados.add(chofer);
    }

    public boolean estaElChoferRegistrado(Chofer chofer) {
        return this.choferesRegistrados.stream().anyMatch(c -> c.getNombre().equals(chofer.getNombre()));
    }

    public void registrarCircuitoMaritimo(CircuitoMaritimo circuitoMaritimo) {
        this.circuitosMaritimos.add(circuitoMaritimo);

    }

    public void setMejorCircuitoStrategy(MejorCircuitoStrategy mejorCircuitoStrategy) {
        this.mejorCircuitoStrategy = mejorCircuitoStrategy;
    }

    public void registrarOrdenDeExportacion(OrdenDeExportacion ordenDeExportacion) {
        ordenesDeExportacion.add(ordenDeExportacion);
    }

    public void registrarOrdenDeImportacion(OrdenDeImportacion ordenDeImportacion) {
        ordenesDeImportacion.add(ordenDeImportacion);
    }

    public double costoDeServiciosDeOrdenExportacion(OrdenDeExportacion ordenDeExportacion) {
        return ordenDeExportacion.costoDeServicios();
    }

    public double costoDeServiciosDeOrdenImportacion(OrdenDeImportacion ordenDeImportacion) {
        return ordenDeImportacion.costoDeServicios() + ordenDeImportacion.getViaje().costoDeViaje(this);
    }

    public List<OrdenDeImportacion> ordenesDeImportacionDelViaje(Viaje viaje) {
        return ordenesDeImportacion.stream().filter(orden -> orden.getViaje().equals(viaje)).toList();
    }

    public List<OrdenDeExportacion> ordenesDeExportacionDelViaje(Viaje viaje) {
        return ordenesDeExportacion.stream().filter(orden -> orden.getViaje().equals(viaje)).toList();
    }

    public void informarConsigneesDelViaje(Viaje viaje) {
        List<String> consigneesDelViaje = ordenesDeImportacionDelViaje(viaje)
                .stream()
                .map(orden -> orden.getCliente().getNombre())
                .toList();
        for (String nombreCliente : consigneesDelViaje) {
            System.out.println("Señor " + nombreCliente + " su carga ha arribado al puerto");
        }
    }
    
    public void informarCostoAConsigneesDelViaje(Viaje viaje) {
        List<OrdenDeImportacion> consigneesDelViaje = ordenesDeImportacionDelViaje(viaje);
        for (OrdenDeImportacion orden : consigneesDelViaje) {
            System.out.println("Estimado " + orden.getCliente().getNombre() + " el monto a pagar por servicios de container es de: " + orden.costoDeServicios());
        }
    }

    public void informarCostoAShippersDelViaje(Viaje viaje) {
        List<OrdenDeExportacion> shippersDelViaje = ordenesDeExportacionDelViaje(viaje);
        for (OrdenDeExportacion orden : shippersDelViaje) {
            System.out.println("Estimado " + orden.getCliente().getNombre() + ", el buque con su carga acaba de zarpar."
            		+ " El monto a pagar por servicios de container es de: " + orden.costoDeServicios());
        }
    }

    public CircuitoMaritimo getMejorCircuito(Terminal destino) {
        return this.mejorCircuitoStrategy.getMejorCircuitoPara(this, destino, this.circuitosMaritimos);
    }

    public LocalDateTime fechaDeLLegadaDelCircuitoA(
            CircuitoMaritimo circuitoMaritimo, Terminal destino, LocalDateTime fechaDeSalida
    ) {
        return fechaDeSalida.plus(circuitoMaritimo.tiempoEntreTramos(this, destino));
    }

    public Duration cuantoTardaNavieraEnIrA(Terminal destino, Naviera naviera) {
        return naviera.getTiempoDeViaje(this, destino);
    }

    public LocalDateTime fechaDeProximoBuqueA(Terminal destino, LocalDateTime fecha) {
        return this.lineasNavierasRegistradas
                .stream()
                .map(lineaNaviera -> lineaNaviera.getFechaDeProximoViaje(this, destino, fecha))
                .min(LocalDateTime::compareTo)
                .get();

    }
    
    public void registrarBuqueAEsperaDeDeparting(Buque buque) {
    	this.buquesAEsperaDeOrdenDeparting.add(buque);
    }
    
    public void registrarBuqueAEsperaDeWorking(Buque buque) {
    	this.buquesAEsperaDeOrdenWorking.add(buque);
    }
    
    public void darOrdenDeWorkingAlBuque(Buque buque) {
    	if (this.buquesAEsperaDeOrdenWorking.stream().anyMatch(c -> c.equals(buque))) {
    		buque.setEstado(new Working());
    		this.buquesAEsperaDeOrdenWorking.remove(buque);
    	}
  
    }
    
    public void darOrdenDeDepartingAlBuque(Buque buque) {
    	if (this.buquesAEsperaDeOrdenDeparting.stream().anyMatch(c -> c.equals(buque))) {
    		buque.setEstado(new Departing());
    		this.buquesAEsperaDeOrdenDeparting.remove(buque);
    	}
    	
    }
    
    public List<RutaMaritima> busquedaMaritima(Filtro filtro, List<RutaMaritima> rutasMaritimas) {
        return rutasMaritimas.stream().filter(ruta -> filtro.aplicar(ruta)).toList();
    }
 
    public void registrarTurnoDeExportacion(Turno turno) {
    	this.turnosDeExportacion.add(turno);
    }
}
