import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class InterfaceBanque extends JFrame implements ActionListener {
	JButton maj,quitter;
	JTextArea texte;
	JMenuBar menubar;
	JMenuItem mquitter,visuComptes, ajoutComptes, supprComptes, crediter, fermer, debiter, sauver, charger, afficheSolde, afficheTitulaire, afficheOperation;

	public InterfaceBanque(String name){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(name);
		setSize(400,500);
		setResizable(false);
		//maj = new JButton("MAJ");
		//quitter = new JButton("Quitter");
		Container cont = getContentPane();
		setLayout(new BorderLayout());
		JPanel entete = new JPanel();
		cont.add("North", entete);
		//entete.add(maj);
		//entete.add(quitter);
		texte = new JTextArea();
		cont.add("Center",texte);
		//texte.setText("La zone de texte");
		JLabel piedpage = new JLabel("Comptes Bancaires");
		cont.add("South",piedpage);

		menubar = new JMenuBar();
		JMenu m1 = new JMenu("Fichier");
		JMenu m2 = new JMenu("Gérer");
		JMenu m3 = new JMenu("Opérations");
		JMenu m4 = new JMenu("Visualiser");
		JMenu m5 = new JMenu("Quitter");
		
		menubar.add(m1);
		menubar.add(m2);
		menubar.add(m3);
		menubar.add(m4);
		menubar.add(m5);
		
		visuComptes = new JMenuItem("Visualiser Compte");
		ajoutComptes = new JMenuItem("Ajouter Compte");
		supprComptes = new JMenuItem("Supprimer Compte");
		crediter = new JMenuItem("Créditer");
		debiter = new JMenuItem("Débiter");
		fermer = new JMenuItem("Fermer");
		sauver = new JMenuItem("Sauver");
		charger = new JMenuItem("Charger");
		afficheSolde = new JMenuItem("Afficher solde compte");
		afficheTitulaire = new JMenuItem("Afficher titulaire compte");
		afficheOperation = new JMenuItem("Afficher opérations");
		mquitter = new JMenuItem("Quitter");
		
		m1.add(sauver);
		m1.add(charger);
		m1.add(mquitter);
		m2.add(visuComptes);
		m2.add(ajoutComptes);
		m2.add(supprComptes);
		m3.add(crediter);
		m3.add(debiter);
		m3.add(fermer);
		m4.add(afficheSolde);
		m4.add(afficheTitulaire);
		m4.add(afficheOperation);
		setJMenuBar(menubar);
		setVisible(true);
		
		visuComptes.addActionListener(new Visualiser(this));
		ajoutComptes.addActionListener(new ajouter(this));
		supprComptes.addActionListener(new supprimer(this));
		crediter.addActionListener(new Crediter(this));
		debiter.addActionListener(new Debiter(this));
		fermer.addActionListener(new Fermer(this));
		sauver.addActionListener(new Sauver(this));
		charger.addActionListener(new Charger(this));
		afficheSolde.addActionListener(new afficherSolde(this));
		afficheTitulaire.addActionListener(new afficherTitulaire(this));
		afficheOperation.addActionListener(new afficherOperation(this));
		mquitter.addActionListener(new Quitter(this));
	}

	public static void main(String[] args){
		new InterfaceBanque("Comptes Bancaires");
	}
	public void actionPerformed(ActionEvent e){
		if((e.getSource()==quitter)){
			dispose();
			System.exit(0);
		}
		if (e.getSource()==maj) {
			texte.setText(texte.getText().toUpperCase());
		}
	}
}
	
	
class Visualiser extends Banque implements ActionListener{//classe pour afficher les comptes (System.out, méthode ?)
	Banque b = new Banque();
	InterfaceBanque f;
	Visualiser(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		//texte.setText(b.afficherLesComptes());
	}
}
	
class ajouter extends Banque implements ActionListener{//ajouter un compte : ajouter(saisir());
	Banque b = new Banque();
	InterfaceBanque f;
	ajouter(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class supprimer extends Banque implements ActionListener{//supprimer un compte : enlever()
	Banque b = new Banque();
	InterfaceBanque f;
	supprimer(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class Crediter extends Banque implements ActionListener{//créditer : .getCompte(num).crediter()
	Banque b = new Banque();
	InterfaceBanque f;
	Crediter(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class Debiter extends Banque implements ActionListener{//débiter : .getCompte(num).debiter();
	Banque b = new Banque();
	InterfaceBanque f;
	Debiter(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class Fermer extends Banque implements ActionListener{//fermer compte : ??
	Banque b = new Banque();
	InterfaceBanque f;
	Fermer(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class Sauver extends Banque implements ActionListener{//sauver configuration
	Banque b = new Banque();
	InterfaceBanque f;
	Sauver(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}

class Charger extends Banque implements ActionListener{//charger configuration
	Banque b = new Banque();
	InterfaceBanque f;
	Charger(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class afficherSolde extends Banque implements ActionListener{//afficher solde compte X
	Banque b = new Banque();
	InterfaceBanque f;
	afficherSolde(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
class afficherTitulaire extends Banque implements ActionListener{//afficher id compte X
	Banque b = new Banque();
	InterfaceBanque f;
	afficherTitulaire(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}

class afficherOperation extends Banque implements ActionListener{//afficher opérations : supprimer/créditer/ajouter...
	Banque b = new Banque();
	InterfaceBanque f;
	afficherOperation(InterfaceBanque f){
		this.f=f;
	}
		
	public void actionPerformed(ActionEvent e){
		JTextArea texte = f.texte;
		//JMenuItem visuComptes = f.visuComptes;
		b.ajouter(b.saisir());
	}
}
	
	/*public void actionPerformed(ActionEvent e){
		JMenuItem sauver = f.sauver;
		JTextArea texte = f.texte;
		PrintWriter ecrivain=null;
		try{
			ecrivain = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
			ecrivain.println(texte.getText());
		}catch(FileNotFoundException ex){
			System.err.println(ex);
		}catch(IOException exe){
			System.err.println(exe);
		}
		finally{
			try{
				ecrivain.close();
			}catch(Exception exec){
				System.err.println(exec);
			}
		}
		}
}*/

class Quitter implements ActionListener{
	InterfaceBanque f;
	Quitter(InterfaceBanque f){
		this.f=f;
	}

	public void actionPerformed(ActionEvent e){
		f.dispose();
		System.exit(0);
	}
}
