/**
 * Implémentation de l'interface evenement.
 *
 * @author adrien.failler;
 */

package association;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * Class Evenement.
*/

public class Evenement implements java.io.Serializable {
  
  /**
  *  identifiant de version serialVersionUIDuniversel pour une Serializableclasse. 
  *  La désérialisation utilise ce nombre pour s'assurer qu'une classe chargée 
  *  correspond exactement à un objet sérialisé.
  *  Si aucune correspondance n'est trouvée, un InvalidClassExceptionest lancé.
 */
  private static final long serialVersionUID = 1L;

  private String nom;

  private String lieu;

  private LocalDateTime date;

  private int duree;

  private int nbParticipantsMax;

  private Set<InterMembre> participants;
  
  
  

  /**
 * Constructeur.
 *
 * @param nom le nom de l'evenement
 * @param lieu le lieu de l'evenement
 * @param date la date de l'evenement
 * @param duree la duree de l'evenement
 * @param nbParticipantsMax le nombre maximum de participant de l'evenement
 * @param participants un participants de l'evenement
 */
  
  public Evenement(String nom, String lieu, LocalDateTime date, int duree, int nbParticipantsMax,
      Set<InterMembre> participants) {
    super();
    this.nom = nom;
    this.lieu = lieu;
    this.date = date;
    this.duree = duree;
    this.nbParticipantsMax = nbParticipantsMax;
    this.participants = participants;
  }  
  /**
 * Renvoie le nom de l'evenement.
 *
 * @return le nom de l'evenement.
 */

  public String getNom() {
    return nom;
  }

  /**
 * modifie le nom de l'evenement.
 *
 * @param nom le nouveau nom.
 */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
 * Renvoie le lieu de l'evenement.
 *
 * @return le lieu de l'evenement.
 */
  public String getLieu() {
    return lieu;
  }
  /**
 * modifie le lieu de l'evenement.
 *
 * @param lieu le nouveau lieu.
 */

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }
  /**
 * Renvoie la date de l'evenement.
 *
 * @return la date de l'evenement.
 */
  
  public LocalDateTime getDate() {
    return date;
  }
  /**
 * modifie la date de l'evenement.
 *
 * @param date la nouvelle date.
 */
  
  public void setDate(LocalDateTime date) {
    this.date = date;
  }
  /**
 * Renvoie la duree de l'evenement.
 *
 * @return la duree de l'evenement.
 */
  
  public int getDuree() {
    return duree;
  }
  /**
 * modifie la duree de l'evenement.
 *
 * @param duree la nouvelle duree.
 */
  
  public void setDuree(int duree) {
    this.duree = duree;
  }
  /**
 * Renvoie le nombre de participants maximum de l'evenement.
 *
 * @return nbParticipantsMax de l'evenement.
 */
  
  public int getNbParticipantsMax() {
    return nbParticipantsMax;
  }
  /**
 * modifie le nombre de particpant maximum de l'evenement.
 *
 * @param nbParticipantsMax le nouveau NbParticipantsMax.
 */
  
  public void setNbParticipantsMax(int nbParticipantsMax) {
    this.nbParticipantsMax = nbParticipantsMax;
  }
  /**
 * Renvoie un participant de l'evenement.
 *
 * @return participants de l'evenement.
 */
  
  public Set<InterMembre> getParticipants() {
    return participants;
  }
  /**
 * modifie un participant de l'evenement.
 *
 * @param participants le nouveau participants.
 */
  
  public void setParticipants(Set<InterMembre> participants) {
    this.participants = participants;
  }





  @Override
public int hashCode() {
    return Objects.hash(date, duree, lieu, nbParticipantsMax, nom, participants);
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
    Evenement other = (Evenement) obj;
    return Objects.equals(date, other.date) && duree == other.duree 
        && Objects.equals(lieu, other.lieu)
        && nbParticipantsMax == other.nbParticipantsMax && Objects.equals(nom, other.nom);
        
  }




  /**
 * renvoie les elements de l'evenement.
 * 
 *
 * @return une chaine de caractère contenant toutes les données d'un evenement.
 */

  @Override

  public String toString() {
    return "Evenement [nom=" + nom + ", lieu=" + lieu + ", date=" + date 
        + ", duree=" + duree + ", nbParticipantsMax="
        + nbParticipantsMax + ", participants=" + participants + "]";
  }





  // A implémenter : retourne vrai si deux événements ne se chevauchent pas
  // dans le même lieu en même temps
  /**
 * function public pasDeChevauchementLieu.
 *
 * @param evt non null
 * @return true or false
 */
  public boolean pasDeChevauchementLieu(Evenement evt) {
    if ((this.lieu != evt.lieu) && (this.date != evt.date)) {
      return true;
    } else { 
      return false;
    }

  }
  // A implémenter : retourne vrai si deux événements ne se chevauchent pas
  // dans le temps (indépendamment du lieu).
  
  /**
 * function public pasDeChevauchementLieu.
 *
 * @param evt non null
 * @return true or false
 */
 
  public boolean pasDeChevauchementTemps(Evenement evt) {
    if (this.date.isBefore(evt.date) & this.date.plusHours(this.duree).isAfter(evt.date)) { 
      return false; 
    } else if (evt.date.isBefore(this.date) & evt.date.plusHours(evt.duree).isAfter(this.date)) {
      return false;
    } else {
      return true;
    }
    
  }

  // A compléter :
  //
  // - génération automatique des getters, setters, constructeurs,
  // des méthodes hashCode, toString et equals.
  
  // Modifiez manuellement le code généré au besoin. Rajoutez notamment
  // les méthodes de gestion des participants à l'événement.
  //
  // - Rajoutez un/des constructeurs permettant de construire plus facilement
  // un événement sans avoir besoin de passer un paramètre de type LocalDateTime
  //
  // - Ecrivez la JavaDoc complète de la classe
}
