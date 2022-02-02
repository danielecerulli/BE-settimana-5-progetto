package it.corso_epicode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfrazioneDAO {
			
		private Connection conn;
		private static final String INSERT_INFRAZIONE = "INSERT INTO infrazioni( data, tipo, importo, targaf ) VALUES( ?, ?, ?, ? )";				
		private static final String UPDATE_INFRAZIONE = "UPDATE infrazioni SET data=?, tipo=?, importo=? WHERE targaf=?";
		private static final String DELETE_INFRAZIONE = "DELETE FROM infrazioni WHERE targaf=? AND id=?";
		private static final String SELECT_ALL_INFRAZIONI = "SELECT * FROM infrazioni";
		
		public InfrazioneDAO(Connection conn) {
			this.conn = conn;
		}

		public int insertInfrazione( Infrazione infraz ) {
			int risultati = 0;
			
			try {
				PreparedStatement ps = conn.prepareStatement(INSERT_INFRAZIONE);
				ps.setString(1, infraz.getData());
				ps.setString(2, infraz.getTipo());
				ps.setInt(3, infraz.getImporto());
				ps.setString( 4, infraz.getTargaf());
				
				risultati = ps.executeUpdate();
				System.out.println("Multa inserita con successo!");
			} catch (SQLException e) {
				System.out.println("Operazione inserimento sanzione fallita!");
				e.printStackTrace();
			}
			
			return risultati;
		}
		
		public boolean updateInfrazione( Infrazione infraz ) {
			PreparedStatement ps = null;			
			
			try {
				ps = conn.prepareStatement(UPDATE_INFRAZIONE);
				ps.setString(1, infraz.getData());
				ps.setString(2, infraz.getTipo());
				ps.setInt(3, infraz.getImporto());
				ps.setString(4, infraz.getTargaf());
				
				int i = ps.executeUpdate();
				System.out.println("Infrazione aggiornata correttamente");
				if (i>0)
					return true;
				else return false;
				
			} catch (SQLException e) {
				System.out.println("Errore aggiornamento infrazione");
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean deleteInfrazione(Infrazione infraz) {
			PreparedStatement ps = null;			
			
			try {
				ps = conn.prepareStatement(DELETE_INFRAZIONE);
				ps.setString( 1, infraz.getTargaf() );
				ps.setInt(2, infraz.getId());
				
				int i = ps.executeUpdate();
				System.out.println("Infrazione annullata correttamente");
				if(i > 0) 
					return true;
					else return false;
				
			} catch (SQLException e) {
				System.out.println("Errore annullamento infrazione!");
				e.printStackTrace();
			}
			return false;					
	}
		public ArrayList<Infrazione> getAllInfrazioni() {
			
			ArrayList<Infrazione> listaInfrazioni = new ArrayList<Infrazione>();
			Statement st = null;
			ResultSet rs = null;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(SELECT_ALL_INFRAZIONI);
				
				while(rs.next()) {
					Infrazione infrazione = new Infrazione();
					infrazione.setId(rs.getInt("id"))
					.setTargaf(rs.getString("targaf"))
					.setData(rs.getString("data"))
					.setTipo(rs.getString("tipo"))
					.setImporto(rs.getInt("importo"));
					
					listaInfrazioni.add(infrazione);
					
				}
				System.out.println("Lista infrazioni recuperata con successo!");
			} catch (SQLException e) {
				System.out.println("Errore recupero lista infrazioni!");
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return listaInfrazioni;
		}		
		
}
