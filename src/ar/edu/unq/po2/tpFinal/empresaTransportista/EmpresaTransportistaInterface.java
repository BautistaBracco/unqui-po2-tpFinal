package ar.edu.unq.po2.tpFinal.empresaTransportista;

public interface EmpresaTransportistaInterface {
    void agregarCamion(CamionInterface camion);
    void agregarChofer(ChoferInterface chofer);

    int cantidadDeCamiones();
    int cantidadDeChoferes();
}
