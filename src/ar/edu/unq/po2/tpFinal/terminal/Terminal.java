package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

import java.util.ArrayList;
import java.util.List;

public class Terminal implements TerminalInterface {
    private String nombre;
    private List<CamionInterface> camionesRegistrados;
    private List<ChoferInterface> choferesRegistrados;
    private List<NavieraInterface> lineasNavierasRegistradas;
    private List<Cliente> shippersRegistrados;
    private List<Cliente> consigneesRegistrados;
    private List<OrdenDeExportacion> ordenesDeExportacion;
    private List<OrdenDeImportacion> ordenesDeImportacion;
    private List<CircuitoMaritimoInterface> circuitosMaritimos;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.camionesRegistrados = new ArrayList<>();
        this.choferesRegistrados = new ArrayList<>();
        this.lineasNavierasRegistradas = new ArrayList<>();
        this.shippersRegistrados = new ArrayList<>();
        this.consigneesRegistrados = new ArrayList<>();
        this.ordenesDeExportacion = new ArrayList<>();
        this.ordenesDeImportacion = new ArrayList<>();
        this.circuitosMaritimos = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void registrarLineaNaviera(NavieraInterface lineaNaviera) {
        this.lineasNavierasRegistradas.add(lineaNaviera);
    }

    @Override
    public void registrarShipper(Cliente shipper) {
        this.shippersRegistrados.add(shipper);
    }

    @Override
    public void registrarConsignee(Cliente consignee) {
        this.consigneesRegistrados.add(consignee);
    }

    @Override
    public void registrarCamion(CamionInterface camion) {
        this.camionesRegistrados.add(camion);
    }

    @Override
    public boolean estaElCamionRegistrado(CamionInterface camion) {
        return this.camionesRegistrados.stream().anyMatch(c -> c.getPatente().equals(camion.getPatente()));
    }

    @Override
    public void registrarChofer(ChoferInterface chofer) {
        this.choferesRegistrados.add(chofer);
    }

    @Override
    public boolean estaElChoferRegistrado(ChoferInterface chofer) {
        return this.choferesRegistrados.stream().anyMatch(c -> c.getNombre().equals(chofer.getNombre()));
    }

    @Override
    public void registrarCircuitoMaritimo(CircuitoMaritimoInterface circuitoMaritimo) {
        this.circuitosMaritimos.add(circuitoMaritimo);
    }
    
    @Override
    public void registrarOrdenDeExportacion(OrdenDeExportacion ordenDeExportacion) {
    	ordenesDeExportacion.add(ordenDeExportacion);
    }
    
    @Override
    public void registrarOrdenDeImportacion(OrdenDeImportacion ordenDeImportacion) {
    	ordenesDeImportacion.add(ordenDeImportacion);
    }

    @Override
    public double costoDeServiciosDeOrdenExportacion(OrdenDeExportacion ordenDeExportacion) {
    	return ordenDeExportacion.getServiciosDeContainer().stream().mapToDouble(servicio -> servicio.costoDelServicio()).sum();
    }
    
    @Override
    public double costoDeServiciosDeOrdenImportacion(OrdenDeImportacion ordenDeImportacion) {
    	return ordenDeImportacion.getServiciosDeContainer().stream().mapToDouble(servicio -> servicio.costoDelServicio()).sum();
    }
    
    @Override
    public List<OrdenDeImportacion> ordenesDeImportacionDelViaje(Viaje viaje) {
    	return ordenesDeImportacion.stream()
    							   .filter(orden -> orden.getViaje().equals(viaje))
    							   .toList();
    }
    
    @Override
    public List<OrdenDeExportacion> ordenesDeExportacionDelViaje(Viaje viaje) {
    	return ordenesDeExportacion.stream()
    							   .filter(orden -> orden.getViaje().equals(viaje))
    							   .toList();
    }
    
    @Override
    public void informarConsigneesDelViaje(Viaje viaje) {
    	List<String> consigneesDelViaje = ordenesDeImportacionDelViaje(viaje).stream()
    																		 .map(orden -> orden.getCliente().getNombre())
    																		 .toList();
    	for (String nombreCliente : consigneesDelViaje) {
    		System.out.println("Señor " + nombreCliente + " su carga ha arribado al puerto");
    	}
    }
    
    @Override
    public void informarShippersDelViaje(Viaje viaje) {
    	List<String> shippersDelViaje = ordenesDeImportacionDelViaje(viaje).stream()
				 .map(orden -> orden.getCliente().getNombre())
				 .toList();
    	for (String nombreCliente : shippersDelViaje) {
    			System.out.println("Señor " + nombreCliente + " su carga ha arribado al puerto");
    	}
    }
    
    public CircuitoMaritimoInterface getMejorCircuito(MejorCircuitoStrategy mejorCircuitoStrategy) {
        return mejorCircuitoStrategy.getMejorCircuito();
    }
}
