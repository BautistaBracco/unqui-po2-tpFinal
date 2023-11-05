package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

public interface EmpresaTransportistaInterface {
    void agregarCamion(CamionInterface camion);
    void agregarChofer(ChoferInterface chofer);

    int cantidadDeCamiones();
    int cantidadDeChoferes();
}
