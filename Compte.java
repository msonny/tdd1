
import java.io.*;
/**
* class Compte
*/

class Compte implements Serializable{
   
	private double solde;
	private String id;
	int numComp;


	/**
	 * constructeur de compte general
	 * @param num
	 * @param id
	 * @param solde
	 */
   Compte(int num, String id,int solde){
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
	 *
	 */
   public String toString(){
	return "num :"+numComp+" detenteur :"+id+" Solde :"+solde;
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
   
   /** 
	 * les operations sur un compte : fermer
	 * 
	 */
   void fermer(){
	   solde=0;
   }

}
