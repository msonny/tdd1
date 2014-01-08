import java.io.*;
import java.util.*;
import java.nio.charset.Charset;

/**
 * Classe Banque 
 * utilise la class Compte define plus bas
 */

public class Banque implements Serializable{
   
	
	Charset charset = Charset.forName("UTF-8");
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
     * verifie aussi s'il n'y a pas deux fois le meme numero de compte
     */
	
    public String  ajouter(Compte c){
		 for (int i = 0; i < lesComptes.size(); i++) {
				if (!lesComptes.isEmpty() && lesComptes.get(i).getNumComp()==c.getNumComp()) {
					return "Echec !! compte existe deja";
				}
			}
	lesComptes.add(c);
	return "OK";
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
	
    /**
     * suppression d'un compte de la banque
     *
     */
	
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
	 * restauration d'une banque a partir d'un fichier cree par la methode sauver
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
}

