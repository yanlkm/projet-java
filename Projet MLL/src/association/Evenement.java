/**
 * Impl�mentation de l'interface evenement.
 *
 * @author adrien.failler;
 */

package association;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * Class Evenement qui permet une gestion crud pour des evenements.
*/

public class Evenement implements java.io.Serializable {
  
  private String nom;

  private String lieu;

  private LocalDateTime date;

  private int duree;

  private int nbParticipantsMax;

  private Set<InterMembre> participants;
  
  
  

  /**
 * Cr�e un evenement avec toutes ses informations.
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
        && nbParticipantsMax == other.nbParticipantsMax && Objects.equals(nom, other.nom)
        && Objects.equals(participants, other.participants);
  }




  /**
 * renvoie les elements de l'evenement.
 * 
 *
 * @return une chaine de caract�re contenant toutes les donn�es d'un evenement.
 */

  @Override

  public String toString() {
    return "Evenement [nom=" + nom + ", lieu=" + lieu + ", date=" + date 
        + ", duree=" + duree + ", nbParticipantsMax="
        + nbParticipantsMax + ", participants=" + participants + "]";
  }





  // A impl�menter : retourne vrai si deux �v�nements ne se chevauchent pas
  // dans le m�me lieu en m�me temps
  /**
 * function public pasDeChevauchementLieu.
 *
 * @param evt not null
 * @return true
 */
  public boolean pasDeChevauchementLieu(Evenement evt) {
    if ((this.lieu != evt.lieu) && (this.date != evt.date)) {
      return true;
    } else { 
      return false;
    }

  }
  // A impl�menter : retourne vrai si deux �v�nements ne se chevauchent pas
  // dans le temps (ind�pendamment du lieu)
  
  /**
 * function public pasDeChevauchemenTemps.
 *
 * @param evt not null
 * @return true
 */
  public boolean pasDeChevauchementTemps(Evenement evt) {
    if ((this.duree != evt.duree)) {
      return true;
    } else {
      return false;
    }
  }

  // A compl�ter :
  //
  // - g�n�ration automatique des getters, setters, constructeurs,
  // des m�thodes hashCode, toString et equals.
  
  // Modifiez manuellement le code g�n�r� au besoin. Rajoutez notamment
  // les m�thodes de gestion des participants � l'�v�nement.
  //
  // - Rajoutez un/des constructeurs permettant de construire plus facilement
  // un �v�nement sans avoir besoin de passer un param�tre de type LocalDateTime
  //
  // - Ecrivez la JavaDoc compl�te de la classe
}
