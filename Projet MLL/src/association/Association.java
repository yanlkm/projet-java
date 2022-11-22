package association;

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
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void chargerDonnees(String nomFichier) throws IOException {
    // TODO Auto-generated method stub
    
  }
  
}
