package association;

import java.io.IOError;
import java.io.IOException;
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
