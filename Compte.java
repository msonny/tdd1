
import java.io.*;
/**
* class Compte
* @author roland garnier
*@version 0.99
*/

class Compte implements Serializable{
   
	private double solde;
   private String id;
   int numComp;

	/**
	 * constructeur de compte d'une banque donnee
	 * @param id
	 * @param solde
	 * @param banque
	 */
   
	public Compte(int idComptes, String nomDetenteur, double solde) {
		super();
		this.id = id;
		this.numComp = numComp;
		this.solde = solde;
	}

	/**
	 * constructeur de compte general
	 * @param num
	 * @param id
	 * @param solde
	 */
   Compte(int num,String id,int solde){
	this.solde=solde;
	this.id=id;
	numComp=num;
   }	

	/**  
	 * observateur du numero de compte
	 */
   int getNumComp(){
	return numComp;
   }

   /**  
	 * observateur de identifiant du compte
	 * 
	 */
   String getId(){
	return id;
   }

   /**  
	 * observateur du solde du compte
	 */
   double getSolde(){
	return solde;
   }
   
   /**  
	 * surcharge de la methode toString

	 */
   public String toString(){
	return "id :"+id+" numero :"+ numComp+" Solde :"+solde;
   }

	/**
	 * affichage d'un compte
	 */
   
   void afficher(){
	System.out.println(this);
   }
   
   
	/** 
	 * les operations sur un compte : credit
	 * @param c
	 */

   void crediter(int c){
	solde+=c;
   }
   
   /** 
	 * les operations sur un compte : debit
	 * @param c
	 */

   void debiter(int c){
	solde-=c;
   }
   
   void fermer(){
	   solde=0;
   }

}
