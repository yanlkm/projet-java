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
  
  /**
   * Constructeur de la classe Membre.
   *
   * @param nom du membre
   * @param prenom du membre
   * @param adresse du membre
   * @param age
   *
   */
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
    GestionEvenements listAllEvent = new GestionEvenements();
    List<Evenement> listTemp = new ArrayList<Evenement>();
    
    List<Evenement> listGestionEvent = new ArrayList<Evenement>();
    listGestionEvent = listAllEvent.getListeEvenement();
    
    for (int i = 0; i < listGestionEvent.size(); i++) {
      if (listGestionEvent.get(i).getParticipants().contains(this)) {
        listTemp.add(listGestionEvent.get(i));
      }
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
    GestionEvenements listAllEvent = new GestionEvenements();
    List<Evenement> listTemp = new ArrayList<Evenement>();
    
    List<Evenement> listGestionEvent = new ArrayList<Evenement>();
    listGestionEvent = listAllEvent.ensembleEvenementAvenir();
    
    for (int i = 0; i < listGestionEvent.size(); i++) {
      if (listGestionEvent.get(i).getParticipants().contains(this)) {
        listTemp.add(listGestionEvent.get(i));
      }
    }
    
    return listTemp;
  }
  
  @Override
  public String toString() {
    return "Membre [info=" + info + ", nom=" + nom + ", prenom=" + prenom
        + ", adresse=" + adresse + ", age=" + age + "]";
  }

  /**
   * Définit les informations personnelles du membre.
   *
   * @param info les informations personnelles du membre
   */
  @Override
  public void definirInformationPersonnnelle(InformationPersonnelle info) {
    info = new InformationPersonnelle(this.nom, this.prenom, this.adresse,
        this.age);
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

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
}
