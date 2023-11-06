package ar.edu.unq.po2.tpFinal.container;

/*
 * Reefer (refrigerado): se utilizan para transportar carga que debe mantenerse dentro de 
 * cierto rango de temperatura (alimentos y medicamentos, entre otros). Estos contenedores 
 * mantienen la carga dentro del rango de temperatura requerido, para lo cual deben estar 
 * contínuamente conectados a fuentes de electricidad, tanto durante el trayecto como 
 * cuando están en puerto. De cada reefer se conoce su consumo (kw/hora).
 */

public class ContainerReefer extends Container{

	private int kwPorHora;
	
	public ContainerReefer(int ancho, int largo, int alto, int peso, int kwPorHora) {
		super(ancho, largo, alto, peso);
		this.kwPorHora = kwPorHora;
	}
	
	public int getKWPorHoras() {
		return this.kwPorHora;
	}
}
