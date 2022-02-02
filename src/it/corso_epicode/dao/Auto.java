package it.corso_epicode.dao;

// Classe POJO Auto
public class Auto {
	
	private String targa;
	private String marca;
	private String modello;
	
	public Auto() {}
	
	public Auto(String targa) {
		this.targa = targa;
	}

	public Auto(String targa, String marca, String modello) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public Auto setTarga(String targa) {
		this.targa = targa;
		return this;
	}

	public Auto setMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public Auto setModello(String modello) {
		this.modello = modello;
		return this;
	}

	@Override
	public String toString() {
		String s = "";
		s += "\n" + "Targa: " + this.targa + " Marca: " + this.marca + " Modello: " + this.modello + "\n";
		return s;
	}
	
	

}
