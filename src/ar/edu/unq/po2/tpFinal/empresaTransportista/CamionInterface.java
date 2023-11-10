package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.container.ContainerInterface;

public interface CamionInterface {
    void agregarContenedor(ContainerInterface contenedor);
    ChoferInterface getChofer();

    int cantidadDeContenedores();

    Object getPatente();
}
