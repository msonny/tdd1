import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfaceBanque extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3162943452301723219L;
	Banque b;
	JFrame frame;
	JButton buttonIncr;
	JButton buttonSup;
	JButton buttonList, buttonCrediter, buttonDebiter, buttonFermer, buttonAfficher, buttonSauver, buttonCharger;
	JLabel label;
	JTextField iden,iden1,nom,solde;
	JTextField iden2 = new JTextField("iden");
	JTextField iden3 = new JTextField("somme");
	JTextField iden4 = new JTextField("iden");
	JTextField iden5 = new JTextField("somme");
	JTextField iden6 = new JTextField("iden");
	JLabel id = new JLabel("iden");
	JLabel n = new JLabel("nom");
	JLabel s = new JLabel("solde");
	JPanel pane;
	JPanel pane1;
	JPanel onglet5 = new JPanel();
	JLabel save=new JLabel();
	JLabel load=new JLabel();

	public InterfaceBanque() {
		b = new Banque();
	}
	@SuppressWarnings("deprecation")
	public void go(){
		frame = new JFrame("Ajout compte");
		buttonIncr = new JButton("Ajouter");
		label = new JLabel("un petit texte");
		iden= new JTextField("identifiant");
		nom= new JTextField("detenteur");
		solde= new JTextField("solde");
		pane = new JPanel(new GridLayout());
		pane1 = new JPanel(new GridLayout());
		pane.add(buttonIncr,BorderLayout.EAST);
		buttonIncr.addActionListener(this);

		pane1.add(iden);
		pane1.add(nom);
		pane1.add(solde);
		frame.getContentPane().add(pane, BorderLayout.SOUTH);
		frame.getContentPane().add(pane1, BorderLayout.NORTH);
		frame.setSize(400, 100);
		frame.setLocation(100, 100);
		frame.show();
	}		
	public void onglet(){
		JFrame f = new JFrame("Ma Banque");
		f.setSize(520, 250);
		JPanel pannel = new JPanel();

		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		JPanel onglet1 = new JPanel();
		iden= new JTextField("identifiant");
		nom= new JTextField("detenteur");
		solde= new JTextField("solde");
		buttonIncr = new JButton("Ajouter");
		onglet1.add(iden);
		onglet1.add(nom);
		onglet1.add(solde);
		onglet1.add(buttonIncr);
		buttonIncr.addActionListener(this);

		onglet1.setPreferredSize(new Dimension(400, 180));
		onglets.addTab("Ajouter compte", onglet1);
		/**********************************supprimer************************************************/
		JPanel onglet2 = new JPanel();
		JLabel titreOnglet2 = new JLabel("Saisir identifiant :");
		iden1= new JTextField(3);
		buttonSup = new JButton("Supprimer");
		onglet2.add(titreOnglet2);
		onglet2.add(iden1);
		onglet2.add(buttonSup);
		buttonSup.addActionListener(this);
		onglet2.setPreferredSize(new Dimension(400, 180));
		onglets.addTab("Suppimer compte", onglet2);
		/*********************************************liste des comptes ****************************************************/
		JPanel onglet3 = new JPanel();
		//JLabel titreOnglet4 = new JLabel("compte");
		id = new JLabel("");
		id.setVisible(false);

		//s = new JLabel("solde");
		buttonList = new JButton("Lister les comptes crees");
		//onglet3.add(titreOnglet4);

		onglet3.add(id);

		//onglet3.add(s);
		onglet3.add(buttonList);
		buttonList.addActionListener(this);
		onglet3.setPreferredSize(new Dimension(400, 180));
		onglets.addTab("Liste comptes", onglet3);

		/*******************************************************************************************************************/
		JPanel onglet4 = new JPanel();
		//JLabel titreOnglet4 = new JLabel("compte");
		JTextField iden2 = new JTextField("iden");
		JTextField iden3 = new JTextField("somme");
		JTextField iden4 = new JTextField("iden");
		JTextField iden5 = new JTextField("somme");
		JTextField iden6 = new JTextField("iden");
		JTextField iden7 = new JTextField("iden");
		buttonCrediter = new JButton("Crediter");
		buttonDebiter = new JButton("Debiter");
		buttonFermer = new JButton("Fermer");
		buttonAfficher = new JButton("Afficher les opérations");
		//onglet3.add(titreOnglet4);

		onglet4.add(iden2);
		onglet4.add(iden3);
		onglet4.add(buttonCrediter);
		onglet4.add(iden4);
		onglet4.add(iden5);
		onglet4.add(buttonDebiter);
		onglet4.add(iden6);
		onglet4.add(buttonFermer);
		onglet4.add(iden7);
		onglet4.add(buttonAfficher);
		buttonCrediter.addActionListener(this);
		buttonDebiter.addActionListener(this);
		buttonFermer.addActionListener(this);
		buttonAfficher.addActionListener(this);
		onglet4.setPreferredSize(new Dimension(400, 180));
		onglets.addTab("Operations comptes", onglet4);

		/*******************************************************************************************************************/
		
		buttonSauver = new JButton("Sauvegarder les comptes crees");
		buttonCharger = new JButton("Charger les comptes depuis une sauvegarde");

		onglet5.add(buttonSauver);
		onglet5.add(buttonCharger);
		buttonSauver.addActionListener(this);
		buttonCharger.addActionListener(this);
		onglet5.setPreferredSize(new Dimension(400, 180));
		onglets.addTab("Sauver/charger comptes", onglet5);

		/*******************************************************************************************************************/
		
		onglets.setOpaque(true);
		pannel.add(onglets);
		f.getContentPane().add(pannel);
		f.setVisible(true);
		save.setText("Sauvegarde effectuee : ./sauvegarde.txt");
		save.setVisible(false);
		onglet5.add(save);
		load.setText("Comptes chargés.");
		load.setVisible(false);
		onglet5.add(load);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();

		if  (source==buttonIncr){
			System.out.println("ajout !");
			Compte c1 = new Compte(Integer.parseInt(iden.getText()), nom.getText(), Integer.parseInt(solde.getText()));
			b.ajouter(c1);
			//b.ajouter(b.saisir(nom.getText(), Integer.parseInt(solde.getText())));	
			b.afficherLesComptes();
		}
		else if  (source==buttonSup){
			System.out.println("supr");

			b.supprimerComptes(Integer.parseInt(iden1.getText()));	
			b.afficherLesComptes();
		}
		else if  (source==buttonList){
			id.setText("<html>");
			for (int i = 0; i < b.getlesComptes().size(); i++) {
				Compte maValeur = b.getlesComptes().get(i);
				//JLabel titreOnglet3 = new JLabel("compte "+i);
				if (id.getText() != null)
					id.setText(id.getText()+"<br />"+maValeur);
				//n.setText(""+b.getlesComptes().get(i).getNumComp());
				//s.setText(""+b.getlesComptes().get(i).getSolde());
			}
			id.setText(id.getText()+"</html>");
			id.setVisible(true);
		}
		else if (source==buttonCrediter){
			b.getCompte(Integer.parseInt(iden2.getText())).crediter(Integer.parseInt(iden3.getText()));
		}
		else if (source==buttonDebiter){
			b.getCompte(Integer.parseInt(iden4.getText())).debiter(Integer.parseInt(iden5.getText()));
		}
		else if (source==buttonFermer){
			b.getCompte(Integer.parseInt(iden4.getText())).fermer();
		}
		else if (source==buttonAfficher){
			
		}
		else if (source==buttonSauver){
			b.sauverTxt("sauvegarde.txt");
			save.setVisible(true);
		}
		else if (source==buttonCharger){
			b=Banque.chargerTxt("sauvegarde.txt");
			load.setVisible(true);
		}
		}
	
	public static void main(String[] args) {
		
		InterfaceBanque inter = new InterfaceBanque();
		//inter.go();
		inter.onglet();
		/*Comptes c1 = new Comptes(0, "niass", 4000);
		Comptes c2 = new Comptes(1,"baye",1000);
		Banque b = new Banque();
		b.ajouterComptes(c1);
		b.ajouterComptes(c2);
	    b.crediter(c1,200.00);	
		b.debiter(c2,100);
		
        b.afficherInfoComptes();
        b.supprimerComptes(c2);
        b.afficherInfoComptes();*/
	}

	}

