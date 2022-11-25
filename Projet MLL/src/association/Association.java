package association;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
  public InterGestionEvenements gestionEvent = null;
  public InterGestionMembres gestionMember = null;
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
    return this.gestionnaireMembre();
  }
  /**
   * Sauvegarde des données fournies dans un fichier dont le nom est fourni 
   * en paramètre de la méthode.
   */
  
  @Override
  public void sauvegarderDonnees(String nomFichier) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
      writer.write("placeholder du truc à écrire");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  /**
   * Charge des données fournies dans un fichier dont le nom est fourni 
   * en paramètre de la méthode.
   */
  
  @Override
  public void chargerDonnees(String nomFichier)  {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
      System.out.println(reader.readLine());
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
