import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Saisir extends JFrame implements ActionListener{
	private JPanel p = new JPanel();
	private JLabel l1 = new JLabel("NumPilote");
	private JTextField tf1 = new JTextField("");
	private JLabel l2 = new JLabel("NomPilote");
	private JTextField tf2 = new JTextField("");
	private JLabel l3 = new JLabel("PrenomPilote");
	private JTextField tf3 = new JTextField("");
	private JButton b1 = new JButton("Enregistrer");
	
	public Saisir(){
		this.setTitle("Saisir un pilote");
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(4, 2));
		this.getContentPane().add(p);
		
		tf1.setPreferredSize(new Dimension(100, 30));
		tf2.setPreferredSize(new Dimension(100, 30));
		tf3.setPreferredSize(new Dimension(100, 30));
		p.add(l1);
		p.add(tf1);
		p.add(l2);
		p.add(tf2);
		p.add(l3);
		p.add(tf3);
		p.add(b1);
		b1.addActionListener(this);
		this.pack();
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		Connection c = null; 
		try { 
		       Class.forName ("org.postgresql.Driver") ; 
		       c = DriverManager.getConnection ("jdbc:postgresql:bdolenoir",
		    		   							"olenoir","olenoir"); 
		       Statement st = c.createStatement ();
		       st.executeUpdate("INSERT INTO Pilotes (numpilote, nompilote, prenompilote)" +
		       					"VALUES ("+tf1.getText()+",'"+tf2.getText()+"','"+tf3.getText()+"');");
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
