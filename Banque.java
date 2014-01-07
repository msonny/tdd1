import java.io.*;
import java.util.*;

/**
 * Classe Banque 
 * @author Roland Garnier
 * @version 0.99
 * utilise la class Compte define plus bas
 */

public class Banque implements Serializable{
   
	
	
	ArrayList<Compte> lesComptes; // visible dans le package
    int nb;//le nombre qui permettra la generation automatique des numeros
           // de comptes ; il est visible dans le package
  
	
	/** 
	 * Constructeur de la class Banque
	 */
    
    Banque(){
	lesComptes=new ArrayList<Compte>();
	nb=0;
    }

	
    /**
     *  ajout d'un compte a la banque
     * @param c 
     */
	
    public void  ajouter(Compte c){
	lesComptes.add(c);
    }

    /**
     * observateur retourne le compte ayant pour numero numComp
     * @param numComp
     * @return 
     */
	
	Compte getCompte(int numComp){
	int i;
	for ( i=0; i<lesComptes.size();i++){
	    if (lesComptes.get(i).getNumComp()==numComp) break;
	}
	if(i==lesComptes.size()) return null;
	return lesComptes.get(i);
    }
	
    public void enlever(int numComp){
	int i;
	for ( i=0; i<lesComptes.size();i++){
	    if (lesComptes.get(i).getNumComp()==numComp) break;
	}
	if(i==lesComptes.size()) return;
	lesComptes.remove(i);
    }
	
    /**
     * saisie d'un compte de la banque
     * @return
     */
	
	/*public  Compte  saisir(String s1, int s2){
	double sold;
	String id;
	Scanner entree= new Scanner(System.in);*/
	/*try{ 
	    System.out.println("idendifiant :");
	    id=entree.next();
	    System.out.println("solde :");
	    sold=entree.nextDouble();
	    return  new Compte(s1,s2,this);
	}
	catch(Exception e){
	    //System.err.println("Saisie invalide : recommencer");
	    return  null;
	}
    }*/
	
    /**
     *  observateur de la liste des comptes de la banque
     * @return
     */
	
	public ArrayList<Compte> getlesComptes(){
	return lesComptes;
    }
	
	
	/**
	 * affichage d'un compte de numero numComp
	 * @param numComp
	 */
	
    public void afficher(int numComp){
	int i;
	for ( i=0; i<lesComptes.size();i++){
	    if (lesComptes.get(i).getNumComp()==numComp) break;
	}
   
	if(i==lesComptes.size()) {
	    System.err.println("Compte inexistant");
	    return;
	}
	lesComptes.get(i).afficher();
    }
    
    /**
     * surcharge de la methode toString
     * @eturn
     */
	
	public String toString(){
	String s="";
	int i;
	for ( i=0; i<lesComptes.size();i++){
	    s+=lesComptes.get(i)+"\n";
	}
	return s;
    }
	
	
	/**
	 *  affichage de tous les comptes de la banque
	 */
    public void afficherLesComptes(){
	System.out.print(this);
    }
	 
	/**
	 * sauvegarde de la banque utilisant la serialisation
	 * @param fichier
	 */
	
	public void sauver(String fichier){
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		}
		catch (IOException e){
			System.err.println(e);
		}

		finally{
			try{
				fos.close();
			}
			catch (Exception e){
				System.err.println(e);
			}
		}
	}
					   

	/**
	 * restauration d'una banque a partir d'un fichier cree par la methode sauver
	 * @param fichier
	 * @return
	 */
	
	public static Banque charger(String fichier){
		FileInputStream fis=null;
		Banque b=null;

		try{
			fis= new FileInputStream(fichier);
			ObjectInputStream ois= new ObjectInputStream(fis);
			b= (Banque)ois.readObject();
		}
		catch(ClassNotFoundException e){
			System.err.println(e);
		}
		catch(IOException e){
			System.err.println(e);
		}
		finally{
			try{
				fis.close();
				return b;
			}
			catch (final Exception e){
				System.err.println(e);
				return null;
			}
		}
		
    }
					   
	/**
	 * sauvegarde de la banque en mode texte
	 * @param fichier
	 * l'interet de ce mode est que l'on peut editer le fichier de sauvegarde et eventuellement 
	 * le modifier
	*/
	public void sauverTxt(String fichier){
		PrintWriter ecrivain=null;
		try{
			ecrivain = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));

			ecrivain.println(nb);
			for(int i=0;i < getlesComptes().size();i++){
				Compte c=getlesComptes().get(i);
				ecrivain.println(c.getNumComp()+" "+c.getId()+" "+c.getSolde());
			}
		}
		catch(FileNotFoundException e){
			System.err.println(e);
		}
		catch(IOException e){
			System.err.println(e);
		}
		finally{
			try{
				ecrivain.close();
			}
			catch (Exception e){
				System.err.println(e);
			}
		}

	}
										  

	
/**
 *  restauration d'une banque a partir d'un fichier cree par la methode sauverTxt
 *ou tape dans un editeur de texte et respectant la forme suivante
 *premiere ligne : l'attribut nb de la banque
 *seconde ligne et suivante : les attributs de chaque compte de la banque
 *exemple
 *4
 *1 garnier 1000.0
 *2 dupontel 500.0	
 *4 duval	1200.0	
 *nb dans cet exemple le compte numero 3 a certainement ete supprime dans une precedente operation	
*/
	
	public static Banque chargerTxt(String fichier){
	Scanner sc=null;	
	Banque b=null;
		
		try{
			b=new Banque();
			sc= new Scanner(new File(fichier)).useLocale(Locale.US);
			b.nb=sc.nextInt();
			while(sc.hasNext()){
				int num=sc.nextInt();
				String nom=sc.next();
				int sold=(int) sc.nextDouble();
				sc.nextLine();
				Compte c=new Compte(num,nom,sold);
				b.getlesComptes().add(c);
			}
		}
		catch(FileNotFoundException e){
			System.err.println(e);
			return null;
		}
		finally{
			sc.close();
			return b;
		}
    }													   
					   
					   
	static public void main(String []args){
		Banque b=new Banque();
		for(int i=0;i<3;i++){
		//b.ajouter(b.saisir());
		}
		
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();
		System.out.println("On sauve  la Banque  en mode serialisation dans banque.sav:");
		b.sauver("banque.sav");
		System.out.println("On sauve  la Banque  en mode texte dans banque.txt:");
		b.sauverTxt("banque.txt");	
		System.out.println("On detruit la banque");
		b=new Banque();
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();
		System.out.println("On restaure la banque à partir du fichier banque.sauv :");
		b=Banque.charger("banque.sav");
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();		
		System.out.println("On detruit a nouveau la banque");
		b=new Banque();
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();
		System.out.println("On restaure la banque à partir du fichier banque.txt :");
		b=Banque.chargerTxt("banque.txt");
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();		
		System.out.println("On supprime lde compte numero 2");
		b.enlever(2);
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();
		System.out.println("On credite le compte numero 3 de 1000");
		b.getCompte(3).crediter(1000);
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();					
		System.out.println("On debite le compte numero 1 de 1000");
		b.getCompte(1).debiter(1000);
		System.out.println("Etat de la Banque :");
		b.afficherLesComptes();	
		
		
    }
  
}

