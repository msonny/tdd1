import javax.swing.*;
import java.awt.event.*; 
public class Interface extends JFrame {
 
	public Interface() {
 
	super("Gestion de Banque");
 
	WindowListener l = new WindowAdapter() {
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	};
 
	addWindowListener(l);
	
	JMenuItem mi = new JMenuItem("Display");
	JMenuItem mi1 = new JMenuItem("Manage");
	JMenuItem mi2 = new JMenuItem("Modify");
	JMenuItem mi3 = new JMenuItem("Save");
	//ImageIcon img = new ImageIcon("tips.gif");
	//JButton bouton = new JButton("Mon bouton",img); 
	JPanel panneau = new JPanel();
	panneau.add(mi);
	panneau.add(mi1);
	panneau.add(mi2);
	panneau.add(mi3);
	//panneau.add(bouton);
	setContentPane(panneau);
	setSize(500,400);
	
	//mi.setEnabled(true);
	
	setVisible(true);
	}
	
 
	public static void main(String [] args){
	//appel de la classe interface
	JFrame frame = new Interface();
	}
}
