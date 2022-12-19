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
   *Le constructeur qui instancie la liste des membres .
   * 
   * 
   *  
   */

  public GestionMembre() {
   
    this.membres = new HashSet<InterMembre>();

   
  }

  /**
   *L'insertion d'un président .
   * 

   * @param president est le membre qui aura le rôle d'un président.
   * 
   *  
   */
 
  public void setPresident(InterMembre president) {
    if (!(this.membres.contains(president))) {
      this.membres.add(president);
    }
    this.president = president;
  }

  /** 
   *Retourne le président.
   *
   * @return le membre président.
   */

  public InterMembre getPresident() {
    return president;
  }


  /**
   *L'insertion d'une liste de membres.
   * 

   * @param membres est une liste de membres avec laquelle on veut faire une insertion.
   * 
   *  
   */

  public void setMembres(Set<InterMembre> membres) {
    this.membres = membres;
  }
  
  /** 
   *Retourne la liste des membres.
   *
   * @return la liste des membres
   */

  public Set<InterMembre> getMembres() {
    return membres;
  }
 
  /** 
   *Ajoute un membre .
   *
   * @return si le membre est ajouté a la liste des membres
   *         <code>true</code> pour le supprimer,
   *         sinon <code>false</code> ne fait rien si le membre était déjà inscrit à
   *         la liste des membres. 
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
   *Supprime un membre s'il existe .
   *
   * @return si le membre appartient a la liste des membres
   *         <code>true</code> pour le supprimer,
   *         sinon <code>false</code> ne fait rien si le membre n'était pas inscrit à
   *         la liste des membres. 
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
   * Désigne un président en si le membre existe dans la liste des mmebres.
   *
   * @param membre est un membre avec lequel on veut faire une verification.
   *
   * @return si le membre appartient a la liste des membres
   *         <code>true</code> pour le designer en tant que president,
   *         sinon <code>false</code> si le membre n'était pas inscrit à
   *         la liste des membres.
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
   *  Verifie qu'un membre appartient à une liste d'evenements.
   *
   * @param membre est un membre avec lequel on veut faire une verification.
   *
   * @return null si le membre n'existe pas dans la liste
   *        sinon renvoie le membre.
   */
  public Membre verifier(Membre membre) {

 
    Iterator<InterMembre> itValue = this.membres.iterator();
    while (itValue.hasNext()) {
      Membre value = (Membre) itValue.next();
      if (value.getInformationPersonnelle().getNom()
          .equals(membre.getInformationPersonnelle().getNom())
          && value.getInformationPersonnelle().getPrenom()
          .equals(membre.getInformationPersonnelle().getPrenom())) {
        return (Membre) value;
      }
    }
    return null;
  }




  /** 
   *Retourne l'ensemble des membres.
   *
   * @return est la liste des membres 
   */

  public Set<InterMembre> ensembleMembres() {
    // TODO Auto-generated method stub
    
    return this.membres;
  }

  /** 
   *Retourne le president des membres.
   *
   * @return est le membre qui a le role de president
   */
 
  public InterMembre president() {
    // TODO Auto-generated method stub
    
    return this.president;
  }

  

  /** 
   *verifie l'egalite entre deux membres.
   *
   * @return si il y a egalité entre l'objet (supposémment membre)
   *         <code>true</code> ,
   *         sinon <code>false</code> si les membres n'étaient pas égaux
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
   *Affiche la liste des membres.
   *
   * @return est la chaine de caracteres qui affiche des membres qui a le role de president
   */

  public String toString() {
    String retour = "Liste des membres :\n";
    for (InterMembre m : this. membres) {
      retour = retour + m.getInformationPersonnelle().toString() + "\n";
    }
    return retour;
  }


}
