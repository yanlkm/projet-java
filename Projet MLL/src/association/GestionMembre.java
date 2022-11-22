package association;

import java.util.HashSet;
import java.util.Set;

/**
*Definition d'une classe implémentant l'interface IntergestionMembre qui permet de gerer
* un membre dans une association.

 * @author yanmarcelferel.l

 *
 */
public class GestionMembre implements InterGestionMembres {

  private Set<InterMembre> membres;
  private InterMembre president;
 
  /** 
   * commentaire javadoc a venir.
   */

  public GestionMembre() {
   
    this.membres = new HashSet<InterMembre>();

   
  }

  /** 
   * commentaire javadoc a venir.
   */
   
  public boolean ajouterMembre(InterMembre membre) {
    // TODO Auto-generated method stub
    
    if (!(this.membres.contains(membre))) {
      this.membres.add(membre);
      return true;
    }
    return false;
  }

  public InterMembre getPresident() {
    return president;
  }

  public void setPresident(InterMembre president) {
    this.president = president;
  }
 

  public Set<InterMembre> getMembres() {
    return membres;
  }

  public void setMembres(Set<InterMembre> membres) {
    this.membres = membres;
  }

  /** 
   * commentaire javadoc a venir.
   */

  public boolean supprimerMembre(InterMembre membre) {
    // TODO Auto-generated method stub
    if (this.membres.contains(membre)) {
      this.membres.remove(membre);
      return true;
    }
    return false;
  }

  /** 
   * commentaire javadoc a venir.
   */

  public boolean designerPresident(InterMembre membre) {
    // TODO Auto-generated method stub
    if (this.membres.contains(membre)) {
      this.president = membre;
      return true;
    
    
    }
    return false;
  }

  /** 
   * commentaire javadoc a venir.
   */

  public Set<InterMembre> ensembleMembres() {
    // TODO Auto-generated method stub
    
    return null;
  }

  /** 
   * commentaire javadoc a venir.
   */
 
  public InterMembre president() {
    // TODO Auto-generated method stub
    
    return null;
  }	

}
