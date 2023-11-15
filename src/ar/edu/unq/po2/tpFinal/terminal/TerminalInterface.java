package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.ConsigneeInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.ShipperInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

public interface TerminalInterface {

    String getNombre();

    void registrarLineaNaviera(NavieraInterface lineaNaviera);

    void registrarShipper(ShipperInterface shipper);

    void registrarConsignee(ConsigneeInterface consignee);

    void registrarCamion(CamionInterface camion);

    boolean estaElCamionRegistrado(CamionInterface camion);

    void registrarChofer(ChoferInterface chofer);

    void registrarCircuitoMaritimo(CircuitoMaritimoInterface circuitoMaritimo);

    boolean estaElChoferRegistrado(ChoferInterface chofer);


}
