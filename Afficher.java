import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Afficher extends JFrame{
	
		private JPanel p = new JPanel();
		private int i = 0;
		
		public Afficher(int taille, ResultSet rs){
			this.setTitle("Afficher un pilote");
			this.setLocation(300,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			
			p.setBackground(Color.white);
			this.getContentPane().add(p);
			
			String  title[] = {"N°Pilote", "Nom", "Prenom"};
			Object[][]data = new Object[taille][3];
			JTable tableau = new JTable(data, title);
			try {
				while(rs.next()){
					data[i][0] = rs.getString(1);
					data[i][1] = rs.getString(2);
					data[i][2] = rs.getString(3);
					i++;
				}
			}
			catch (SQLException e) {
				System.out.println("Erreur SQL ! " + e);
			}
			i = 0;
		    this.getContentPane().add(new JScrollPane(tableau));
		    
			this.pack();
			this.setVisible(true);
		}
}
