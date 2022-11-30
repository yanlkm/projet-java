package association;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Définit la classe Membre.java.
 *
 * @author Glenn LOUIS
 */
public class Membre implements InterMembre {
  private InformationPersonnelle info;
  private List<Evenement> ListMesEvenements;
  
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
    if (age > 0) {
      this.info = new InformationPersonnelle(nom, prenom, adresse, age);
    }else {
      this.info = new InformationPersonnelle(nom, prenom, adresse, 0);
    }    
    this.ListMesEvenements = new ArrayList<Evenement>();
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
    
    for (int i = 0; i < this.ListMesEvenements.size(); i++) {
      if (ListMesEvenements.get(i).getParticipants().contains(this)) {
        listTemp.add(ListMesEvenements.get(i));
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
  
  /**
   * Définit les informations personnelles du membre.
   *
   * @param info les informations personnelles du membre
   */
  @Override
  public void definirInformationPersonnnelle(InformationPersonnelle info) {
    
  }
  
  /**
   * Renvoie les informations personnelles du membre.
   *
   * @return l'objet contenant les informations personnelles du membre ou >null
   *         si elles (nom, prenom) n'ont pas été définies
   */
  @Override
  public InformationPersonnelle getInformationPersonnelle() {
    return this.info;
  
  }
  
  public InformationPersonnelle getInfo() {
    return info;
  }

  public void setInfo(InformationPersonnelle info) {
    this.info = info;
  }

  public List<Evenement> getListMesEvenements() {
    return ListMesEvenements;
  }

  public void setListMesEvenements(List<Evenement> listMesEvenements) {
    ListMesEvenements = listMesEvenements;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
      
    if (obj == null) {
      return false;
    }
      
    if (getClass() != obj.getClass()) {
      return false;
    }
      
    Membre other = (Membre) obj;
    return true;
  }
  
  
}
