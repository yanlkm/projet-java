package association;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * impl�mentation de l'interface association.
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
