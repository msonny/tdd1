import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * classe InterfaceBanque
 * interface graphique pour comptes bancaires
 * @author Etienne Bilal Sonny
 */

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
	JTextField iden,iden1,iden2, iden3, iden4, iden5, iden6, nom,solde;
	JLabel id = new JLabel("iden");
	JLabel n = new JLabel("nom");
	JLabel s = new JLabel("solde");
	JPanel pane;
	JPanel pane1;
	JPanel onglet5 = new JPanel();
	JPanel onglet4 = new JPanel();
	JLabel save=new JLabel();
	JLabel load=new JLabel();
	JLabel credit=new JLabel();
	JLabel debit=new JLabel();
	JTextArea affiche = new JTextArea();
	JScrollPane scrollPane = new JScrollPane (affiche);
	/** 
	 * gestion du font et police utilise 
	 * */
	Font police = new Font("Arial", Font.BOLD, 12);

	/**
	 * constructeur de InterfaceBanque
	 */
	
	public InterfaceBanque() {
		b = new Banque();
	}
	
	/**
	 * methode qui initialise tous les composants de la fenetre
	 */
	
	public void onglet(){
		final JFrame f = new JFrame("Ma Banque");
		f.setSize(520, 550);
		JPanel pannel = new JPanel();
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 
	    f.addWindowListener(new WindowAdapter(){
	             public void windowClosing(WindowEvent e){
	         		File MyFile = new File("evenement.txt");
	        		MyFile.delete(); 
	                f.dispose();   
	             }
	    });
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		/**********************************Utilisation de JTextField et JButton pour ajouter ou creer un compte ************************************************/
		JPanel onglet1 = new JPanel();
		iden= new JTextField("numero");
		iden.setFont(police);
		iden.setPreferredSize(new Dimension(70, 26));
		nom= new JTextField("detenteur");
		nom.setFont(police);
		nom.setPreferredSize(new Dimension(70, 26));
		solde= new JTextField("solde");
		solde.setFont(police);
		solde.setPreferredSize(new Dimension(70, 26));
		buttonIncr = new JButton("Ajouter");
		onglet1.add(iden);
		onglet1.add(nom);
		onglet1.add(solde);
		onglet1.add(buttonIncr);
		buttonIncr.addActionListener(this);

		onglet1.setPreferredSize(new Dimension(400, 380));
		onglets.addTab("Ajouter compte", onglet1);
		/**********************************supprimer un compte deja existant************************************************/
		JPanel onglet2 = new JPanel();
		JLabel titreOnglet2 = new JLabel("Saisir identifiant :");
		iden1= new JTextField(3);
		iden1.setFont(police);
		iden1.setPreferredSize(new Dimension(50, 26));
		buttonSup = new JButton("Supprimer");
		onglet2.add(titreOnglet2);
		onglet2.add(iden1);
		onglet2.add(buttonSup);
		buttonSup.addActionListener(this);
		onglet2.setPreferredSize(new Dimension(400, 380));
		onglets.addTab("Suppimer compte", onglet2);
		/*********************************************lister tous les comptes deja existant****************************************************/
		JPanel onglet3 = new JPanel();
		id = new JLabel("");
		id.setVisible(false);

		buttonList = new JButton("Lister les comptes crees");

		onglet3.add(id);

		onglet3.add(buttonList);
		buttonList.addActionListener(this);
		onglet3.setPreferredSize(new Dimension(400, 380));
		onglets.addTab("Liste comptes", onglet3);

		/************************************************Operations sur les comptes********************************************************/
		JPanel onglet4 = new JPanel();
		iden2 = new JTextField("iden");
		iden2.setFont(police);
		iden2.setPreferredSize(new Dimension(130, 26));
		iden3 = new JTextField("somme");
		iden3.setFont(police);
		iden3.setPreferredSize(new Dimension(130, 26));
		iden4 = new JTextField("iden");
		iden4.setFont(police);
		iden4.setPreferredSize(new Dimension(130, 26));
		iden5 = new JTextField("somme");
		iden5.setFont(police);
		iden5.setPreferredSize(new Dimension(130, 26));
		iden6 = new JTextField("iden");
		iden6.setFont(police);
		iden6.setPreferredSize(new Dimension(130, 26));
		affiche = new JTextArea ("");
		affiche.setEditable(false);
		buttonCrediter = new JButton("Crediter");
		buttonDebiter = new JButton("Debiter");
		buttonFermer = new JButton("Fermer");
		buttonAfficher = new JButton("Afficher les operations");

		onglet4.add(iden2);
		onglet4.add(iden3);
		onglet4.add(buttonCrediter);
		onglet4.add(iden4);
		onglet4.add(iden5);
		onglet4.add(buttonDebiter);
		onglet4.add(iden6);
		onglet4.add(buttonFermer);
		onglet4.add(buttonAfficher);
		onglet4.add(affiche);
		buttonCrediter.addActionListener(this);
		buttonDebiter.addActionListener(this);
		buttonFermer.addActionListener(this);
		buttonAfficher.addActionListener(this);
		onglet4.setPreferredSize(new Dimension(400, 380));
		onglets.addTab("Operations comptes", onglet4);
		credit.setText("credit effectue");
		credit.setVisible(false);
		onglet4.add(credit);
		debit.setText("Debit effectue");
		debit.setVisible(false);
		onglet4.add(debit);

		/************************************************charger/sauver**************************************************/
		
		buttonSauver = new JButton("Sauvegarder les comptes crees");
		buttonCharger = new JButton("Charger les comptes depuis une sauvegarde");

		onglet5.add(buttonSauver);
		onglet5.add(buttonCharger);
		buttonSauver.addActionListener(this);
		buttonCharger.addActionListener(this);
		onglet5.setPreferredSize(new Dimension(400, 380));
		onglets.addTab("Sauver/charger comptes", onglet5);
		
		onglets.setOpaque(true);
		pannel.add(onglets);
		f.getContentPane().add(pannel);
		f.setVisible(true);
		save.setText("Sauvegarde effectuee : ./sauvegarde.txt");
		save.setVisible(false);
		onglet5.add(save);
		load.setText("Comptes charges.");
		load.setVisible(false);
		onglet5.add(load);
	}

	/**
	 * actions a effectuer lors de la pression d'un bouton
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();

		if  (source==buttonIncr){
			System.out.println("ajout !");
			Compte c1 = new Compte(Integer.parseInt(iden.getText()), nom.getText(), Integer.parseInt(solde.getText()));
			b.ajouter(c1);	
			b.afficherLesComptes();
		}
		else if  (source==buttonSup){
			System.out.println("supr");

			b.enlever(Integer.parseInt(iden1.getText()));
		}
		else if  (source==buttonList){
			id.setText("<html>");
			for (int i = 0; i < b.getlesComptes().size(); i++) {
				Compte maValeur = b.getlesComptes().get(i);
				if (id.getText() != null)
					id.setText(id.getText()+"<br />"+maValeur);
			}
			id.setText(id.getText()+"</html>");
			id.setVisible(true);
		}
		else if (source==buttonCrediter){
	
			b.getCompte(Integer.parseInt(iden2.getText())).crediter(Integer.parseInt(iden3.getText()));
			
			PrintWriter ecrivain=null;
			try{
				ecrivain = new PrintWriter(new BufferedWriter(new FileWriter("evenement.txt", true)));

				ecrivain.println("Credit du compte "+iden2.getText()+" de "+iden3.getText()+" €.");
			}
			catch(FileNotFoundException ex){
				System.err.println(ex);
			}
			catch(IOException ex){
				System.err.println(ex);
			}
			finally{
				try{
					ecrivain.close();
				}
				catch (Exception ex){
					System.err.println(ex);
				}
			}
			
		}
		else if (source==buttonDebiter){
			
			b.getCompte(Integer.parseInt(iden4.getText())).debiter(Integer.parseInt(iden5.getText()));
			
			PrintWriter ecrivain=null;
			try{
				ecrivain = new PrintWriter(new BufferedWriter(new FileWriter("evenement.txt", true)));

				ecrivain.println("Debit du compte "+iden4.getText()+" de "+iden5.getText()+" €.");
			}
			catch(FileNotFoundException ex){
				System.err.println(ex);
			}
			catch(IOException ex){
				System.err.println(ex);
			}
			finally{
				try{
					ecrivain.close();
				}
				catch (Exception ex){
					System.err.println(ex);
				}
			}
			
		}
		else if (source==buttonFermer){
			b.getCompte(Integer.parseInt(iden6.getText())).fermer();
			PrintWriter ecrivain=null;
			try{
				ecrivain = new PrintWriter(new BufferedWriter(new FileWriter("evenement.txt", true)));

				ecrivain.println("Compte" +iden6.getText()+ "ferme");
			}
			catch(FileNotFoundException ex){
				System.err.println(ex);
			}
			catch(IOException ex){
				System.err.println(ex);
			}
			finally{
				try{
					ecrivain.close();
				}
				catch (Exception ex){
					System.err.println(ex);
				}
			}
		}
		else if (source==buttonAfficher){
			/** 
			 * affichage des operations a partir de la lecture du fichier txt cree
			 * */
			Scanner sc=null;	
				try{
					/**
					 * si on a deja appuye sur ce bouton, il faut effacer l'ancien contenu de 
					 * l'affichage (sinon il y a duplication des informations)
					 * */
					if (affiche.getText()!=null){
						affiche.setText("");
					}
					sc= new Scanner(new File("evenement.txt")).useLocale(Locale.US);
					
					/** 
					 * gestion de l'affichage
					 * */
					scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

					while(sc.hasNext()){
						
						String nom=sc.nextLine();
						if (affiche.getText() != null)
							affiche.setText(affiche.getText()+nom+"\n");
						else
							affiche.setText(nom+"\n");
					}
					
				}
				catch(FileNotFoundException ex){
					System.err.println(ex);
				}
				finally{
					sc.close();
				}
				
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
	
	/**
	 * methode main qui lance l'interface
	 */
	
	public static void main(String[] args) {
		
		InterfaceBanque inter = new InterfaceBanque();
		inter.onglet();

	}

	}

