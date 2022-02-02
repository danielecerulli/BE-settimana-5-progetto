package it.corso_epicode.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL = "jdbc:postgresql://localhost:5432/multedb"; //cambia nome db
	public static final String USER = "postgres";
	public static final String PASS = "danielec13";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println( "*** Connessione al DB postgreSQL riuscita! ***" + "\n" + conn );
		}
		catch(SQLException ex) {
			System.out.println( "*** Connessione al DB postgreSQL non riuscita! ***");
		}
		return conn;
	}

}