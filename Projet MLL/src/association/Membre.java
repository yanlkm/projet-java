package association;

import java.time.LocalDateTime;
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
    } else {
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
    return ListMesEvenements;
  }
  
  /**
   * La liste des événements auquel le membre est inscrit et qui n'ont pas
   * encore eu lieu.
   *
   * @return la liste des événements à venir du memmbre
   */
  @Override
  public List<Evenement> ensembleEvenementsAvenir() {
    LocalDateTime dateToday = LocalDateTime.now();
    List<Evenement> ListMesEvenementsAvenir = new ArrayList<Evenement>();
    for (int i = 0; i < ListMesEvenements.size(); i++) {
      if (dateToday.isAfter(ListMesEvenements.get(i).getDate())) {
        ListMesEvenementsAvenir.add(ListMesEvenements.get(i));
      }
    }
    return ListMesEvenementsAvenir;
  }
  
  /**
   * Définit les informations personnelles du membre.
   *
   * @param info les informations personnelles du membre
   */
  @Override
  public void definirInformationPersonnnelle(InformationPersonnelle info) {
    this.info = info;
    
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
  
  
  
  @Override
  public int hashCode() {
    return Objects.hash(ListMesEvenements, info);
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
    return Objects.equals(ListMesEvenements, other.ListMesEvenements)
        && Objects.equals(info, other.info);
  }
  
  @Override
  public InformationPersonnelle getInfo() {
    return this.info;
  }
  
  @Override
  public void setInfo(InformationPersonnelle info) {
    
  }
  
  @Override
  public List<Evenement> getListMesEvenements() {
    return this.ListMesEvenements;
  }  
}
