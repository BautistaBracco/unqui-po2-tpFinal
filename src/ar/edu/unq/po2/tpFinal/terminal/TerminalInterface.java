package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.ConsigneeInterface;
import ar.edu.unq.po2.tpFinal.LineaNavieraInterface;
import ar.edu.unq.po2.tpFinal.ShipperInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

public interface TerminalInterface {

    String getNombre();

    void registrarLineaNaviera(LineaNavieraInterface lineaNaviera);

    void registrarShipper(ShipperInterface shipper);

    void registrarConsignee(ConsigneeInterface consignee);

    void registrarCamion(CamionInterface camion);

    boolean estaElCamionRegistrado(CamionInterface camion);

    void registrarChofer(ChoferInterface chofer);

    boolean estaElChoferRegistrado(ChoferInterface chofer);

}
