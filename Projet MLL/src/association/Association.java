package association;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * implémentation de l'interface association.
 *
 *@author sebastien.lelez
 *
 */
public class Association implements InterGestionAssociation {
  

  public InterGestionEvenements gestionEvent = null;
  public InterGestionMembres gestionMember = null;
  
  @Override
  public InterGestionEvenements gestionnaireEvenements() {
    if (this.gestionEvent == null) {
      this.gestionEvent = new GestionEvenements();   
    }
    return this.gestionEvent; 
  }
  
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
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      writer.write("placeholder du truc à écrire");
      writer.close();
    } catch (IOException e) {
      e.getStackTrace();
    }
    
    
  }
  
  @Override
  public void chargerDonnees(String nomFichier) throws IOException {
    // TODO Auto-generated method stub
    
  }
  
}
