package association;

import java.util.HashSet;
import java.util.Iterator;
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
    if (this.membres.contains(membre))  {

      this.president = membre;
      return true;

    }
    return false;
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

  public Set<InterMembre> ensembleMembres() {
    // TODO Auto-generated method stub
    
    return this.membres;
  }

  /** 
   * commentaire javadoc a venir.
   */
 
  public InterMembre president() {
    // TODO Auto-generated method stub
    
    return this.president;
  }

  /** 
   * commentaire javadoc a venir.
   */

  public String toString() {
    String n = "";
    Iterator<InterMembre> l = this.membres.iterator();
    while (!l.hasNext()) {

      InterMembre e = (InterMembre) l;
      if (e == this.president) {
        n += "président : ";
      }
      n += e.toString();
      l.next();
    }
    return n;
  }


}
