package association;



import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *Classe GestionEvenements qui g?re la liste d'evennements d'une association.

 * @author charlotte.menou
 *
 */
public class GestionEvenements implements InterGestionEvenements  {
  
  
  private List<Evenement> listeEvenements;
  
 
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
    return this.listeEvenements;
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
  * M?thode toString de la classe 'GestionEvenements'.

  * @return affichage des ?vennements
  * 
  */
  @Override
  public String toString() {
    String retour = "Liste des ?v?nements :\n";
    for (Evenement e : this.listeEvenements) {
      retour = retour + e.toString() + "\n";
    }
    return retour;
  }
  

  /**
   * M?thode equals de la classe 'GestionEvenements'.

   * @return true si c'est ?gal et false si c'est diff?rents
   * 
   */
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
    GestionEvenements other = (GestionEvenements) obj;
    return Objects.equals(listeEvenements, other.listeEvenements);
  }


  /**
   * Cr?e un nouvel ?v?nement. Plusieurs v?rifications sont effectu?es : que les
   * dates et heures sont coh?rentes et qu'il n'y a pas un chevauchement sur la
   * m?me p?riode avec un autre ?v?nement dans le m?me lieu.
   *
   * @param nom le nom de l'?v?nement
   * @param lieu le lieu
   * @param jour le jour dans le mois (nombre de 0 ? 31)
   * @param mois le mois dans l'ann?e
   * @param annee l'ann?e
   * @param heure l'heure de la journ?e (nombre entre 0 et 23)
   * @param minutes les minutes de l'heure (nombre entre 0 et 59)
   * @param duree la dur?e (en minute)
   * @param nbParticipants le nombre maximum de participants (0 signifie un
   *        nombre quelconque)
   * @return l'?v?nement cr?? ou <code>null</code> en cas de probl?me
   *         (param?tres non valides)
   */
  public Evenement creerEvenement(String nom, String lieu, int jour, Month mois,
      int annee, int heure, int minutes, int duree, int nbParticipants) {
    
    try {
      LocalDateTime.of(annee, mois, jour, heure, minutes, 0, 000);  
    } catch (Exception e) {
      System.out.println(e);
      return null;   
    }

    LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minutes, 0, 000);  
    Set<InterMembre> participants = new HashSet<InterMembre>();
    Evenement e1 = new Evenement(nom, lieu, d, duree, nbParticipants, participants);
    
    for (Evenement e : this.listeEvenements) {
      if (!e.pasDeChevauchementLieu(e1) || !e.pasDeChevauchementTemps(e1)) {
        return null;
      }
       
    }
    this.listeEvenements.add(e1);
    return  e1;
   
  }


  /**
   * Supprime un ?v?nement. Les membres qui ?taient inscrits sont
   * automatiquement d?sinscrits de l'?v?nement supprim?. Si l'?v?nement
   * n'existait pas, la m?thode ne fait rien.
   *
   * @param evt l'?v?nement ? supprimer.
   */
  public void supprimerEvenement(Evenement evt) {
    if (this.listeEvenements.contains(evt)) {
      for (InterMembre m : evt.getParticipants()) {
        evt.getParticipants().remove(m);
      }
      this.listeEvenements.remove(evt);
    } 
  }
  
  
  
  /**
   * Renvoie l'ensemble des ?v?nements de l'association.
   *
   * @return l'ensemble des ?v?nements
   */
  public List<Evenement> ensembleEvenements() {
    return this.listeEvenements;
  }

  
  
  /**
   * Renvoie l'ensemble des ?v?nements ? venir de l'association.
   *
   * @return l'ensemble des ?v?nements ? venir
   */
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
   * D?sincrit un membre d'un ?v?nement.
   *
   * @param evt l'?v?nement auquel se d?sinscrire
   * @param mbr le membre qui se d?sincrit
   * @return si le membre ?tait bien inscrit ? l'?v?nement, renvoie
   *         <code>true</code> pour pr?ciser que l'annulation est effective,
   *         sinon <code>false</code> si le membre n'?tait pas inscrit ?
   *         l'?v?nement
   */
  public boolean annulerEvenement(Evenement evt, InterMembre mbr) {
    for (Evenement e : mbr.ensembleEvenements()) {
      if (evt.equals(e)) {
        evt.getParticipants().remove(mbr);
        mbr.getListMesEvenements().remove(evt);
        return true;
      }
    }
    return false;
  }
  
  
  /**
   * verifie que deux evenements sont ?gaux.
   *
   * @return le membre si il est ?gal et null si il est diff?rent
   */
  public Evenement verifier(Evenement evt) {
    Iterator<Evenement> itValue = this.listeEvenements.iterator();
    while (itValue.hasNext()) {
      Evenement value = (Evenement) itValue.next();
      if (value.getNom().equals(evt.getNom())) {
        return value;
      }
    }
    return null;
  }

  /**
  * Un membre est incrit ? un ?v?nement.
  *
  * @param evt l'?v?nement auquel s'inscrire
  * @param mbr le membre qui s'inscrit
  * @return <code>true</code> s'il n'y a pas eu de probl?me, <code>false</code>
  *         si l'?v?nement est en conflit de calendrier avec un ?v?nement
  *         auquel est d?j? inscrit le membre ou si le nombre de participants
  *         maximum est d?j? atteint
  */
  @Override
  public boolean inscriptionEvenement(Evenement evt, InterMembre mbr) {
    if (evt.getNbParticipantsMax() == evt.getParticipants().size()) {
      return false;
    }
    evt.addParticipant(mbr);
    mbr.addEvenement(evt);
    return true;
  }






}





