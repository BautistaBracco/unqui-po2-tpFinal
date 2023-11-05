package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.ContenedorInterface;

public interface CamionInterface {
    void agregarContenedor(ContenedorInterface contenedor);
    ChoferInterface getChofer();

    int cantidadDeContenedores();

    Object getPatente();
}
