package it.corso_epicode.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import it.corso_epicode.connection.ConnectionFactory;
import it.corso_epicode.dao.Auto;
import it.corso_epicode.dao.AutoDAO;
import it.corso_epicode.dao.Infrazione;
import it.corso_epicode.dao.InfrazioneDAO;

public class Main {

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();					
		
		//Inserisci istruzioni qui sotto
		InfrazioneDAO idao = new InfrazioneDAO(conn);
		AutoDAO adao = new AutoDAO(conn);
		
		//adao.mostraAutoEInfrazioni();
		
		//Auto a1 = new Auto("AB101CD", "Opel", "Corsa");
		//Auto a2 = new Auto("AB112CD", "Subaru", "Baracca");		
		//adao.insertAuto(a1);
		//adao.insertAuto(a2);
		//adao.deleteAuto(a1);
		
		//Auto a2m = new Auto("AB112CD", "Subaru", "SuperBaracca");
		//adao.updateAuto(a2m);
		
		//adao.mostraAutoEInfrazioni();
		//Infrazione infraz_a1m = new Infrazione("12/11/1999", "ECCESSO DI ZUCCHERI", 150, "AB112CD");
		//idao.insertInfrazione(infraz_a1m);
		//idao.updateInfrazione(infraz_a1m);
		//idao.deleteInfrazione(infraz_a1m);
		//adao.mostraAutoEInfrazioni();
		
		//ArrayList<Auto> listaAuto = adao.getAllAuto();
		//System.out.println(listaAuto.toString());
		
		
		/*ArrayList<Infrazione> listaInfrazioni = idao.getAllInfrazioni();
		for ( Infrazione infr : listaInfrazioni ) {
			System.out.println( "\n" + "ID multa: " + infr.getId() + " Tipo: " + infr.getTipo() + " in Data: " + " " + infr.getData() + " Targa veicolo multato = " + infr.getTargaf() 
			+ " " + infr.getImporto() + "€" + "\n");
		}*/
		
		//Auto aTargaAB123CD = adao.getAuto("AB123CD");
		//System.out.println(aTargaAB123CD.toString());
		
		
		/* Questo switch-case restituisce l'output desiderato ma da errore poiché 
		 chiudo lo scanner all'uscita dallo switch-case altrimenti lo scanner rimane aperto!!*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------");
		System.out.println("SCEGLI OPERAZIONE");
		String s_menu = "\n" + 
	    "1 - Inserisci dati auto nel DB" + "\n"         				// Show menu (all'interno di una funzione) -> richiamata dal ciclo while - rimane in attesa di un input
	   +"2 - Inserisci Dati infrazione nel DB" + "\n"					// l'input diventa anche val ritorno della f(x)
	   +"3 - Visualizza tutte le auto del DB" + "\n"					// quando val rit == val uscita torno al menu
	   +"4 - Cerca auto inserendo la targa" + "\n"						// esci = showmenu
	   +"5 - Visualizza dati Infrazioni e Auto da targa auto" + "\n"		
	   +"6 - Elimina infrazione" + "\n"
	   +"7 - Visualizza tutte le infrazioni registrate nel DB";
		System.out.println(s_menu);
		System.out.println("---------------------");
		 while (sc.hasNext()) {
             int select = 0;
             String query = "";
             if (sc.hasNextInt()) {
                 select = sc.nextInt();
             }
             switch (select) {
             
             case 1:
            	 System.out.println("INSERIMENTO NUOVA AUTO NEL DB");
            	 if (sc.nextLine() != null) {
            		 System.out.println("Inserisci Targa: ");
            		 String targa = sc.nextLine();
            		 System.out.println("Inserisci Marca: ");
            		 String marca = sc.nextLine();
            		 System.out.println("Inserisci modello: ");
            		 String modello = sc.nextLine();
            		 Auto a = new Auto(targa, marca, modello);
            		 System.out.println("Hai immesso i seguenti dati: " + targa + " " + marca + " " + modello);
            		 adao.insertAuto(a);           		 
            	 }
            	 try {
                     conn.close();
                     System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                 }catch (SQLException e) {
                     System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                 	e.printStackTrace();
                 }
            	 sc.close();
            	 break;
                
             case 2:
                 System.out.println("INSERIMENTO NUOVA INFRAZIONE NEL DB");
                 if ( sc.nextLine() != null ) {
                	 System.out.println("Inserisci la Data: ");
                	 String data = sc.nextLine();
                	 System.out.println("Inserisci il tipo di infrazione:");
                	 String tipo = sc.nextLine();
                	 System.out.println("Inserisci l'importo della sanzione (int) :");
                	 int importo = Integer.parseInt(sc.nextLine());
                	 System.out.println("Inserisci targa del trasgressore del CdS: ");
                	 String targaf = sc.nextLine();
                	 System.out.println("Hai immesso i seguenti dati: " + "Data - " + data + " tipo infr. CdS: " + tipo + " sanzione= " + importo + "€" + " targa del trasgressore -> " + targaf);
                	 Infrazione inf = new Infrazione( data, tipo, importo, targaf );                	 
                	 idao.insertInfrazione(inf);                	 
                 }
                 try {
                     conn.close();
                     System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                 }catch (SQLException e) {
                     System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                 	e.printStackTrace();
                 }
                 sc.close();
                 break;
             
             case 3:
                 System.out.println(" == REGISTRO AUTO DB Polizia Municipale == ");
                 ArrayList<Auto> listaAuto = adao.getAllAuto();
                 System.out.println(listaAuto.toString()); 
                 try {
                     conn.close();
                     System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                 }catch (SQLException e) {
                     System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                 	e.printStackTrace();
                 }
                 sc.close();
                 break;
             
             case 4: 
            	 if (sc.nextLine() != null) {
            		 System.out.println("Inserisci la targa ( Formato corretto = XX000XX ): ");
            		 query = sc.nextLine();	             	 
            			Auto a = adao.getAuto(query);
                			System.out.println(a.toString());
            	 }
            	 try {
                     conn.close();
                     System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                 }catch (SQLException e) {
                     System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                 	e.printStackTrace();
                 }
            	 sc.close();
                 break;
             
             case 5:
            	System.out.println("VISUALIZZATORE INFRAZIONI AUTO CON TARGA");
            	if (sc.nextLine() != null ) {
            		System.out.println("Inserisci la targa su cui effetturae la ricerca: ");
            		String targa = sc.nextLine();
            		adao.mostraAutoEInfrazioni(targa);
            	}
            	try {
                    conn.close();
                    System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                }catch (SQLException e) {
                    System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                	e.printStackTrace();
                }
            	 sc.close();
            	 break;
             
             case 6:
            	 System.out.println("ELIMINAZIONE INFRAZIONE DAL DB");
           if (sc.nextLine() != null) {
            	 System.out.println("Inserisci la targa a cui è associata l'infrazione da eliminare: ");
            	 String targaf = sc.nextLine();
            	 System.out.println("Inserire id sanzione(int): ");
            	 int id = Integer.parseInt(sc.nextLine());
            	 Infrazione infrDaElim = new Infrazione(id, targaf);
            	 System.out.println("Hai inserito la targa: " + "'" + targaf + "'" + "associata all'ID infrazione: " + id);
            	 idao.deleteInfrazione(infrDaElim);
             }
           try {
               conn.close();
               System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
           }catch (SQLException e) {
               System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
           	e.printStackTrace();
           }
           		 sc.close();
            	 break;
             
             // Questo ulteriore case mi serve per visualizzare la pkey "id" in modo da utilizzarla nel case: 6 "ELIMINA INFRAZIONE"
            	 //poiché può capitare che ad una targa siano associate più sanzioni e vogliamo cancellarne solo una!
             case 7:
            	 System.out.println(" ** LISTA INFRAZIONI PRESENTI NEL DB **");
            	 ArrayList<Infrazione> listaInfrazioni = idao.getAllInfrazioni();
                 System.out.println(listaInfrazioni.toString()); 
                 sc.close();
                 try {
                     conn.close();
                     System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
                 }catch (SQLException e) {
                     System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
                 	e.printStackTrace();
                 }
                 break;
             
             default:
                 System.out.println("premi i tasti da 1 a 7!");
             	
             }
           
		 }
		sc.close();
		
		try {
            conn.close();
            System.out.println("*** Connessione al DB postgreSQL chiusa correttamente! ***");
        }catch (SQLException e) {
            System.out.println("*** Si è verificato un problema durante la chiusura della connessione al DB postgreSQL! ***");
        	e.printStackTrace();
        }

	}

}
