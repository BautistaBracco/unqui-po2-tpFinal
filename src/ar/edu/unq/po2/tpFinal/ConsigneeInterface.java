package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.container.ContainerInterface;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

public interface ConsigneeInterface {
    ContainerInterface enviarContenedor(ContainerInterface contenedor, TerminalInterface terminal);

}
