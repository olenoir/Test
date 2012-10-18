import java.sql.*;

public class Test {

	public static void main(String[] args) {
		//Saisir s = new Saisir();
		
		
		Connection c = null; 
		try { 
		       Class.forName ("org.postgresql.Driver") ; 
		       c = DriverManager.getConnection ("jdbc:postgresql:bdolenoir",
		    		   							"olenoir","olenoir"); 
		       Statement st = c.createStatement ();
		       ResultSet  rs = st.executeQuery ("SELECT * FROM Pilotes");
		       int taille = rs.getFetchSize();
		       Afficher a = new Afficher(taille, rs);
		       rs.close() ;
		       c.close ();
		} 
		catch (ClassNotFoundException erreur) {
		       System.out.println ("Driver non chargé !" + erreur); 
		} 
		catch (SQLException erreur) { 
			   System.out.println("Erreur SQL ! " + erreur);
		}
		
		
	}

}
