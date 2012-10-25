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
		       
		       ResultSet rs2 = st.executeQuery("SELECT count(numPilote) FROM Pilotes");
		       rs2.next();
		       int t = rs2.getInt(1);
		       rs2.close();
		       ResultSet rs = st.executeQuery ("SELECT * FROM Pilotes");
		       Afficher a = new Afficher(t, rs);
		       rs.close();
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
