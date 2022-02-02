package it.corso_epicode.dao;

// Classe POJO Infrazione
public class Infrazione {
	
	private int id;
	private String data;
	private String tipo;
	private int importo;
	private String targaf;
	
	public Infrazione() {}
	
	public Infrazione(int id) {
		this.id = id;
	}
	
	public Infrazione(int id, String targaf) {
		this.id = id;
		this.targaf = targaf;
	}
	
	public Infrazione(String targaf) {
		this.targaf = targaf;
	}
	
	public Infrazione(int id, String data, String tipo, int importo) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.importo = importo;
	}

	public Infrazione(String data, String tipo, int importo, String targaf) {
		this.data = data;
		this.tipo = tipo;
		this.importo = importo;
		this.targaf = targaf;
	}

	public Infrazione(int id, String data, String tipo, int importo, String targaf) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.importo = importo;
		this.targaf = targaf;
	}

	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public String getTipo() {
		return tipo;
	}

	public int getImporto() {
		return importo;
	}
	
	public String getTargaf() {
		return targaf;
	}

	public Infrazione setId(int id) {
		this.id = id;
		return this;
	}

	public Infrazione setData(String data) {
		this.data = data;
		return this;
	}

	public Infrazione setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public Infrazione setImporto(int importo) {
		this.importo = importo;
		return this;
	}
	
	public Infrazione setTargaf(String targaf) {
		this.targaf = targaf;
		return this;
	}
	@Override
	public String toString() {
		String s = "";
		s += "\n" + "ID: " + this.id + " Data: " + this.data + " Tipo: " + this.tipo + " Targa: " + this.targaf + " importo= " + this.importo + "€" +"\n";
		return s;
	}
}
