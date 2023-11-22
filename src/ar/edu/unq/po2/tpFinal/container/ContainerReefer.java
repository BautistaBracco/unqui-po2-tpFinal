package ar.edu.unq.po2.tpFinal.container;

public class ContainerReefer extends Container{

	private int kwPorHora;
	
	public ContainerReefer(int ancho, int largo, int alto, int peso, int kwPorHora) {
		super(ancho, largo, alto, peso);
		this.kwPorHora = kwPorHora;
	}
	
	@Override
	public int getKWPorHoras() {
		return this.kwPorHora;
	}
}