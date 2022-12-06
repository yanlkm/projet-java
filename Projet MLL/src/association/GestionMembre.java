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

  public void setPresident(InterMembre president) {
    this.president = president;
  }

  public InterMembre getPresident() {
    return president;
  }


  public void setMembres(Set<InterMembre> membres) {
    this.membres = membres;
  }
  
  public Set<InterMembre> getMembres() {
    return membres;
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

  
  /**
   * verifie que deux membres sont égaux.
   *
   * @return le membre si il est égal et null si il est différent
   */
  public Membre verifier(Membre membre) {
	  
	  InterMembre b = null;
	  
	  Iterator<InterMembre> itValue = this.membres.iterator();
	  
	  while(itValue.hasNext()) {
		 Membre value = (Membre) itValue.next();
		 if (value.getInformationPersonnelle().getNom().equals(membre.getInformationPersonnelle().getNom())
			        && value.getInformationPersonnelle().getPrenom().equals(membre.getInformationPersonnelle().getPrenom())) {
			      return (Membre) value;
		}
	  }
	  return null;
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

  
  public boolean equals(Object o) {
    boolean res = false;
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }

    if (!(o instanceof GestionMembre)) {
      return false;
    }
    InterMembre member = (InterMembre) o;
    Iterator<InterMembre> l = this.membres.iterator();
    l.next();
    while (!l.hasNext()) {

      if (member == l) {
        res = true;
      }
      
      l.next();
    }
    return res; 

  }

  /** 
   * commentaire javadoc a venir.
   */

  public String toString() {
	  String retour = "Liste des membres :\n";
	    for (InterMembre m : this. membres) {
	      retour = retour + m.getInformationPersonnelle().toString() + "\n";
	    }
	    return retour;
  }


}
