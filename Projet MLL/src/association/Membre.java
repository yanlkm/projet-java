package association;

import java.util.ArrayList;
import java.util.List;

/**
 * Définit la classe Membre.java.
 *
 * @author Glenn LOUIS
 */
public class Membre implements InterMembre {
  private InformationPersonnelle info;
  private String nom;
  private String prenom;
  private String adresse;
  private int age;
 
  
  public Membre(String nom, String prenom, String adresse, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.age = age;
    this.definirInformationPersonnnelle(info);
    this.info = getInformationPersonnelle();
  }
  
  /**
   * La liste des événements auquel le membre est inscrit ou a participé.
   *
   * @return la liste des événements du membre
   */
  @Override
  public List<Evenement> ensembleEvenements() {
    List<Evenement> listTemp = new ArrayList<Evenement>();
    Evenement evt = new Evenement();
    Association asso = new Association();
    
    List<Evenement> listGestionEvent = new ArrayList<Evenement>();
    listGestionEvent = asso.gestionnaireEvenements();
    
    List<Evenement> listAllEvent = new ArrayList<Evenement>();
    listAllEvent = evt.ensembleEvenements();
    
    for(int i = 0; i < listAllEvent.size(); i++ ) {
      //if(listAllEvent[i].)
    }
      
    return listTemp;
  }
  
  /**
   * La liste des événements auquel le membre est inscrit et qui n'ont pas
   * encore eu lieu.
   *
   * @return la liste des événements à venir du memmbre
   */
  @Override
  public List<Evenement> ensembleEvenementsAvenir() {
    // TODO Auto-generated method stub
    return null;
  }
  
  /**
   * Définit les informations personnelles du membre.
   *
   * @param info les informations personnelles du membre
   */
  @Override
  public void definirInformationPersonnnelle(InformationPersonnelle info) {
    info = new InformationPersonnelle(this.nom, this.prenom, this.adresse, this.age);
  }
  
  /**
   * Renvoie les informations personnelles du membre.
   *
   * @return l'objet contenant les informations personnelles du membre ou >null
   *         si elles (nom, prenom) n'ont pas été définies
   */
  @Override
  public InformationPersonnelle getInformationPersonnelle() {
    if ((this.info.getNom() != null) && (this.info.getPrenom() != null)) {
      return this.info;
    } else {
      return null;
    }
  }
  
}
