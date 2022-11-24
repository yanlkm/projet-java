package association;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *Classe GestionEvenements qui gère la liste d'evennements d'une association.

 * @author charlotte.menou
 *
 */
public class GestionEvenements implements InterGestionEvenements  {
  
  
  public List<Evenement> listeEvenements;
  
 
  /**
   * Constructeur de la classe 'GestionEvenements' qui initialise la liste d'evenements
   * avec une liste vide.
   */
  public GestionEvenements() {
    this.listeEvenements = new ArrayList<Evenement>();
  }
  
  
  /**
   * Getter de la classe 'GestionEvenements'.

   * @return listeEvenements
   */
  public List<Evenement> getListeEvenement() {
    return listeEvenements;
  }


  /**
  * Setter de la classe 'GestionEvenements'.

  * @param listeEvenements
  * 
  */
  public void setListeEvenement(List<Evenement> listeEvenements) {
    this.listeEvenements = listeEvenements;
  }



  /**
   * Crée un nouvel événement. Plusieurs vérifications sont effectuées : que les
   * dates et heures sont cohérentes et qu'il n'y a pas un chevauchement sur la
   * même période avec un autre événement dans le même lieu.
   *
   * @param nom le nom de l'événement
   * @param lieu le lieu
   * @param jour le jour dans le mois (nombre de 0 à 31)
   * @param mois le mois dans l'année
   * @param annee l'année
   * @param heure l'heure de la journée (nombre entre 0 et 23)
   * @param minutes les minutes de l'heure (nombre entre 0 et 59)
   * @param duree la durée (en minute)
   * @param nbParticipants le nombre maximum de participants (0 signifie un
   *        nombre quelconque)
   * @return l'événement créé ou <code>null</code> en cas de problème
   *         (paramètres non valides)
   */
  public Evenement creerEvenement(String nom, String lieu, int jour, Month mois,
      int annee, int heure, int minutes, int duree, int nbParticipants) {
    
    if (jour < 0 || jour > 31 || heure < 0 || heure > 23 || minutes < 0 || minutes > 59) {
      return null;
    }
    
    int minutesduree = minutes + duree;
    LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minutes, 0, 0);
    LocalDateTime dduree = LocalDateTime.of(annee, mois, jour, heure, minutesduree, 0, 0);
    
    
    for (Evenement e : this.listeEvenements) {
      if (e.getLieu() == lieu && e.getDate().isAfter(d) && e.getDate().isBefore(dduree)) {
        return null;
      }
    }
    
    Evenement e = new Evenement(nom, lieu, d, duree, nbParticipants, null);
    this.listeEvenements.add(e);
    return  e;
  }


  /**
   * Supprime un événement. Les membres qui étaient inscrits sont
   * automatiquement désinscrits de l'événement supprimé. Si l'événement
   * n'existait pas, la méthode ne fait rien.
   *
   * @param evt l'événement à supprimer.
   */
  @Override
  public void supprimerEvenement(Evenement evt) {
    for (Evenement e : this.listeEvenements) {
      if (e == evt) {
        for (InterMembre m : e.getParticipants()) {
          e.getParticipants().remove(m);
        }
        this.listeEvenements.remove(e);
      }
    } 
  }
  
  
  
  /**
   * Renvoie l'ensemble des événements de l'association.
   *
   * @return l'ensemble des événements
   */
  @Override
  public List<Evenement> ensembleEvenements() {
    return this.listeEvenements;
  }

  
  
  /**
   * Renvoie l'ensemble des événements à venir de l'association.
   *
   * @return l'ensemble des événements à venir
   */
  @Override
  public List<Evenement> ensembleEvenementAvenir() {
    List<Evenement> avenir = new ArrayList<Evenement>();
    LocalDateTime aujourdhui = LocalDateTime.now();
    for (Evenement e : this.listeEvenements) {
      if (e.getDate().isAfter(aujourdhui)) {
        avenir.add(e);
      }
    }
    return avenir;
  }
  

  
  /**
   * Un membre est incrit à un événement.
   *
   * @param evt l'événement auquel s'inscrire
   * @param mbr le membre qui s'inscrit
   * @return <code>true</code> s'il n'y a pas eu de problème, <code>false</code>
   *         si l'événement est en conflit de calendrier avec un événement
   *         auquel est déjà inscrit le membre ou si le nombre de participants
   *         maximum est déjà atteint
   */
  @Override
  public boolean inscriptionEvenement(Evenement evt, InterMembre mbr) {
    if (evt.getNbParticipantsMax() == evt.getParticipants().size()) {
      return false;
    }
    for (Evenement e : mbr.ensembleEvenements()) {
      if (evt.getDate() == e.getDate()) {
        return false;
      }
    }
    evt.getParticipants().add(mbr);
    return true;
  }

  
  
  /**
   * Désincrit un membre d'un événement.
   *
   * @param evt l'événement auquel se désinscrire
   * @param mbr le membre qui se désincrit
   * @return si le membre était bien inscrit à l'événement, renvoie
   *         <code>true</code> pour préciser que l'annulation est effective,
   *         sinon <code>false</code> si le membre n'était pas inscrit à
   *         l'événement
   */
  @Override
  public boolean annulerEvenement(Evenement evt, InterMembre mbr) {
    for (Evenement e : mbr.ensembleEvenements()) {
      if (evt == e) {
        evt.getParticipants().remove(mbr);
        return true;
      }
    }
    return false;
  }

}
