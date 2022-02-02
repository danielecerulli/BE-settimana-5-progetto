package it.corso_epicode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AutoDAO {
	
	private Connection conn;
	private static final String INSERT_AUTO = "INSERT INTO auto( targa, marca, modello ) VALUES( ?, ?, ? )";
	private static final String SELECT_BY_TARGA = "SELECT * FROM auto where targa = ";
	private static final String SELECT_ALL = "SELECT * FROM auto";
	private static final String SELECT_AUTO_INFRAZIONI = "SELECT targa, marca, modello, tipo, importo, data FROM auto JOIN infrazioni ON auto.targa = infrazioni.targaf WHERE targa=";
	private static final String UPDATE_AUTO = "UPDATE auto SET marca=?, modello=? WHERE targa=?";
	private static final String DELETE_AUTO = "DELETE FROM auto WHERE targa=?";
	
	public AutoDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	// metodi AutoDAO
	
	public int insertAuto( Auto auto ) {
		int risultati = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_AUTO);
			ps.setString(1, auto.getTarga());
			ps.setString(2, auto.getMarca());
			ps.setString(3, auto.getModello());
			
			risultati = ps.executeUpdate();
			System.out.println("Auto inserita correttamente");
		} catch (SQLException e) {
			System.out.println("Problema inserimento Auto");
			e.printStackTrace();
		}
		
		return risultati;
	}

	public Auto getAuto(String targa) {
		Statement st = null;
		ResultSet rs = null;
		//Auto auto = new Auto();
		Auto auto = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_BY_TARGA + "'" + targa + "'");
			if (rs.next()) {
				auto = new Auto();
				auto.setTarga(rs.getString("targa"));
				auto.setMarca(rs.getString("marca"));
				auto.setModello(rs.getString("modello"));
														
			}
			System.out.println("Auto trovata!");
		} catch (SQLException e) {
			System.out.println("Errore nella ricerca auto!");
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return auto;
	}

	public ArrayList<Auto> getAllAuto() {
		
		ArrayList<Auto> listaAuto = new ArrayList<Auto>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				Auto auto = new Auto();
				auto.setTarga(rs.getString("targa"))
				.setMarca(rs.getString("marca"))
				.setModello(rs.getString("modello"));
				
				listaAuto.add(auto);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listaAuto;
	}
	
	public void mostraAutoEInfrazioni(String targa) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_AUTO_INFRAZIONI + "'"+ targa +"'");
			int count = 0;
			
			System.out.println("\n" + "Elenco auto e infrazioni");
			System.out.println("***");
			while(rs.next()) {
				String targaAuto = rs.getString("targa");
				String marcaAuto = rs.getString("marca");
				String modelloAuto = rs.getString("modello");
				String tipoInfrazione = rs.getString("tipo");
				int importoInfrazione = rs.getInt("importo");
				String dataInfrazione = rs.getString("data");
				System.out.println( "Targa: " + targaAuto + " " + marcaAuto + " " + modelloAuto + " - " + tipoInfrazione + " in data: " + dataInfrazione + " importo: " + importoInfrazione + "€");
				System.out.println("=======================");
				count++;				
			}
			if (count == 0) {
				System.out.println(" *|* Nessuna infrazione associata a questa targa trovata *|* ");
			}
		} catch (SQLException e) {
			System.out.println("ERRORE NELLA RICERCA TARGA-INFRAZIONE/I");
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	
	}
	
	public boolean updateAuto( Auto auto ) {
		PreparedStatement ps = null;
		//ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(UPDATE_AUTO);
			ps.setString(1, auto.getMarca());
			ps.setString(2, auto.getModello());
			ps.setString(3, auto.getTarga());
			
			int i = ps.executeUpdate();
			System.out.println("Auto modificata con successo!");
			if (i>0)
				return true;
			else return false;
			
		} catch (SQLException e) {
			System.out.println("Errore modifica auto!");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAuto(Auto auto) {
		PreparedStatement ps = null;
		
		
		try {
			ps = conn.prepareStatement(DELETE_AUTO);
			ps.setString( 1, auto.getTarga() );
			System.out.println("Auto eliminata correttamente");
			int i = ps.executeUpdate();
			if(i > 0) 
				return true;
				else return false;
				
		} catch (SQLException e) {
			System.out.println("Eliminazione auto non avvenuta!");
			e.printStackTrace();
		}
		return false;
				
	}
	
	
}
