package association;

import java.io.IOError;
import java.io.IOException;
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
    this.listeEvenements = new ArrayList<>();;  
  }
  
  /**
   * Getter de la classe GestionEvenements.

   * @return listeEvenements
   */
  public List<Evenement> getListeEvenement() {
    return listeEvenements;
  }


  /**
  * Setter de la classe GestionEvenements.

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
    
    Evenement e = new Evenement();
    
    try {
      LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minutes, 0, 0);
    } catch (OutOfMemoryError e1) {
      throw new IOError(e1);
    }
    
    if(listeEvenements.(d)) {
      coucou
    }
    return e;
  }

  
  @Override
  public void supprimerEvenement(Evenement evt) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Evenement> ensembleEvenements() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Evenement> ensembleEvenementAvenir() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean inscriptionEvenement(Evenement evt, InterMembre mbr) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean annulerEvenement(Evenement evt, InterMembre mbr) {
    // TODO Auto-generated method stub
    return false;
  }



}
