package association;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Gestion générales de l'association.
 * 
 *
 * @author Sébastien le Lez
 */
public class Association implements InterGestionAssociation {
  
  /**
 * Appel aux interface de gestion des membres et des évenement de l'association..
 */
  private InterGestionEvenements gestionEvent = null;
  private InterGestionMembres gestionMember = null;
  /**
   * Création, si non-existant, d'une instance du gestionnaire d'évènement.
   *
   * @return l'instance du gestionnaire d'évènement
   */
  
  @Override
  public InterGestionEvenements gestionnaireEvenements() {
    if (this.gestionEvent == null) {
      this.gestionEvent = new GestionEvenements();   
    }
    return this.gestionEvent; 
  }
  /**
   * Création, si non-existant, d'une instance du gestionnaire de membre.
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
   * Sauvegarde des données fournies(ensemble des membres et évènements) dans un fichier 
   * dont le nom est fourni en paramètre de la méthode.
   */
  
 
  public void sauvegarderDonnees(String nomFichier) throws IOException {
    FileOutputStream fos = new FileOutputStream(nomFichier);
    ObjectOutputStream oos = new ObjectOutputStream(fos);    
    oos.writeObject(this.gestionMember);
    oos.writeObject(this.gestionEvent);
    oos.close();
  }
  
  
  

  /**
   * Charge des données fournies dans un fichier dont le nom est fourni 
   * en paramètre de la méthode.
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
