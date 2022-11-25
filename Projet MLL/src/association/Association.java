package association;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Gestion g�n�rales de l'association.
 * 
 *
 * @author S�bastien le Lez
 */
public class Association implements InterGestionAssociation {
  
  /**
 * Appek aux interface de gestion des membres et des �venement de l'association..
 */
  public InterGestionEvenements gestionEvent = null;
  public InterGestionMembres gestionMember = null;
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
   * @return l'instance du gestionnaire d'�v�nement
   */
  
  @Override
  public InterGestionMembres gestionnaireMembre() {
    if (this.gestionMember == null) {
      this.gestionMember = new GestionMembre();
    }
    return this.gestionnaireMembre();
  }
  
  @Override
  public void sauvegarderDonnees(String nomFichier) throws IOException {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
      writer.write("placeholder du truc � �crire");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  
  @Override
  public void chargerDonnees(String nomFichier) throws IOException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
      System.out.println(reader.readLine());
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
