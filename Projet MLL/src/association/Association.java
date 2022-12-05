package association;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Gestion g�n�rales de l'association.
 * 
 *
 * @author S�bastien le Lez
 */
public class Association implements InterGestionAssociation {
  
  /**
 * Appel aux interface de gestion des membres et des �venement de l'association..
 */
  private InterGestionEvenements gestionEvent = null;
  private InterGestionMembres gestionMember = null;
  /**
   * Cr�ation, si non-existant, d'une instance du gestionnaire d'�v�nement.
   *
   * @return l'instance du gestionnaire d'�v�nement
   */
  
  @Override
  public InterGestionEvenements gestionnaireEvenements() {
    if (this.gestionEvent == null) {
      this.gestionEvent = new GestionEvenements();   
    }
    return this.gestionEvent; 
  }
  /**
   * Cr�ation, si non-existant, d'une instance du gestionnaire de membre.
   *
   * @return l'instance du gestionnaire de membre
   */
  
  @Override
  public InterGestionMembres gestionnaireMembre() {
    if (this.gestionMember == null) {
      this.gestionMember = new GestionMembre();
    }
    return this.gestionMember;
  }
  /**
   * Sauvegarde des donn�es fournies(ensemble des membres et �v�nements) dans un fichier 
   * dont le nom est fourni en param�tre de la m�thode.
   */
  
 
  public void sauvegarderDonnees(String nomFichier) throws IOException {
    FileOutputStream fos = new FileOutputStream(nomFichier);
    ObjectOutputStream oos = new ObjectOutputStream(fos);    
    oos.writeObject(this.gestionMember);
    oos.writeObject(this.gestionEvent);
    oos.close();
  }
  
  
  

  /**
   * Charge des donn�es fournies dans un fichier dont le nom est fourni 
   * en param�tre de la m�thode.
   */
  
  @Override
  public void chargerDonnees(String nomFichier) throws IOException  {
    FileInputStream fis = new FileInputStream(nomFichier);
    ObjectInputStream ois = new ObjectInputStream(fis);    
    try {
      this.gestionMember = (InterGestionMembres) ois.readObject();
    } catch (ClassNotFoundException e1) {     
      e1.printStackTrace();
    } 
    try {
      this.gestionEvent = (InterGestionEvenements) ois.readObject();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } 
    ois.close();
    
    

  }
  
}
