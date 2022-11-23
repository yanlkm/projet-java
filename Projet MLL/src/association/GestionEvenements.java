package association;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *Classe GestionEvenements qui g�re la liste d'evennements d'une association.

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
   * Cr�e un nouvel �v�nement. Plusieurs v�rifications sont effectu�es : que les
   * dates et heures sont coh�rentes et qu'il n'y a pas un chevauchement sur la
   * m�me p�riode avec un autre �v�nement dans le m�me lieu.
   *
   * @param nom le nom de l'�v�nement
   * @param lieu le lieu
   * @param jour le jour dans le mois (nombre de 0 � 31)
   * @param mois le mois dans l'ann�e
   * @param annee l'ann�e
   * @param heure l'heure de la journ�e (nombre entre 0 et 23)
   * @param minutes les minutes de l'heure (nombre entre 0 et 59)
   * @param duree la dur�e (en minute)
   * @param nbParticipants le nombre maximum de participants (0 signifie un
   *        nombre quelconque)
   * @return l'�v�nement cr�� ou <code>null</code> en cas de probl�me
   *         (param�tres non valides)
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
   * Supprime un �v�nement. Les membres qui �taient inscrits sont
   * automatiquement d�sinscrits de l'�v�nement supprim�. Si l'�v�nement
   * n'existait pas, la m�thode ne fait rien.
   *
   * @param evt l'�v�nement � supprimer.
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
   * Renvoie l'ensemble des �v�nements de l'association.
   *
   * @return l'ensemble des �v�nements
   */
  @Override
  public List<Evenement> ensembleEvenements() {
    return this.listeEvenements;
  }

  
  
  /**
   * Renvoie l'ensemble des �v�nements � venir de l'association.
   *
   * @return l'ensemble des �v�nements � venir
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
   * Un membre est incrit � un �v�nement.
   *
   * @param evt l'�v�nement auquel s'inscrire
   * @param mbr le membre qui s'inscrit
   * @return <code>true</code> s'il n'y a pas eu de probl�me, <code>false</code>
   *         si l'�v�nement est en conflit de calendrier avec un �v�nement
   *         auquel est d�j� inscrit le membre ou si le nombre de participants
   *         maximum est d�j� atteint
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
   * D�sincrit un membre d'un �v�nement.
   *
   * @param evt l'�v�nement auquel se d�sinscrire
   * @param mbr le membre qui se d�sincrit
   * @return si le membre �tait bien inscrit � l'�v�nement, renvoie
   *         <code>true</code> pour pr�ciser que l'annulation est effective,
   *         sinon <code>false</code> si le membre n'�tait pas inscrit �
   *         l'�v�nement
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
