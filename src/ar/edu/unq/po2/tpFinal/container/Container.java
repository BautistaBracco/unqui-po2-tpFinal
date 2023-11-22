package ar.edu.unq.po2.tpFinal.container;

public abstract class Container {

	private int ancho;
	private int largo;
	private int alto;
	private int peso;
	
	public Container(int ancho, int largo, int alto, int peso) {
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.peso = peso;
	}

	public int getPesoTotal() {
		return this.peso;
	}
	
	public int metrosCubicos() {
		return this.ancho * this.largo * this.alto;
	}
	
	public int getKWPorHoras() {
		return 0;
	}

}