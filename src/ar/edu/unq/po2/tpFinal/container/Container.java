package ar.edu.unq.po2.tpFinal.container;

/*
	El container es la forma más utilizada de transporte; la mercancía se transporta
	dentro de ellos, usualmente cerrados mediante trabas y candados, y también precintados.
	De cada container se conoce sus dimensiones (ancho, largo y altura) y su peso total.
	Entendemos como “carga” a un container. Es decir, no interesa saber qué contiene
	dentro; el container es la carga.
 */

// ☑ De cada container se conoce sus dimensiones (ancho, largo y altura) y su peso total.

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

}