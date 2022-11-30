package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import association.GestionMembre;
import association.InterMembre;
import association.Membre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
*Definition d'une classe impl�mentant l'interface IntergestionMembre qui permet de gerer
* un membre dans une association.

 * @author yanmarcelferel.l

 *
 */ET LAAAAAA
public class TestGestionMembre {

  

  private GestionMembre gerer;
  
  /**
   * Instancie une information basique et une compl�te pour les tests.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */ 
  @BeforeEach
  void setUp() throws Exception {
    gerer = new GestionMembre();
    
  }
  
  /**
   * Ne fait rien apr�s les tests : � modifier au besoin.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * V�rifie qu'on peut avoir une liste de membres � un �venement  qui est vide.
   */
  
  @Test
  void testvidelistemembres() {
    Set<InterMembre> test1 = new HashSet<InterMembre>();
 
    gerer.setMembres(test1);
  
    assertEquals(gerer.getMembres(), test1);
  }
  
  /**
   * V�rifie qu'on ne peut pas positionner un age n�gatif sur une information
   * basique.
   */ 

  @Test
  void testajoutunmembre() {
    Set<InterMembre> test2 = gerer.getMembres();
    InterMembre type1 =  new Membre("prout", "Luke", "UBA", 26);
    gerer.ajouterMembre(type1);

    assertEquals(gerer.getMembres(), test2);
  }
  
  /**
   * V�rifie qu'on ne peut pas positionner un age n�gatif sur une information
   * compl�te.
   */
  @Test
  void testsupprimermembre() {

    Set<InterMembre> test2 = gerer.getMembres();
    InterMembre type1 =  new Membre("Skywalker", "Luke", "UBO", 23);
    gerer.ajouterMembre(type1);
    gerer.supprimerMembre(type1);
   
    assertEquals(gerer.getMembres(), test2);
  }
 
  @Test
  void testrenvoiliste() {

    Set<InterMembre> test2 = new HashSet<InterMembre>();
    InterMembre type1 =  new Membre("Skywalker", "Luke", "UBO", 23);
    InterMembre type2 =  new Membre("Sar", "Lucie", "UBO", 24);
    InterMembre type3 =  new Membre("Kywa", "Aminata", "UBO", 29);
    test2.add(type1);
    test2.add(type2);
    test2.add(type3);
    gerer.ajouterMembre(type1);
    gerer.ajouterMembre(type2);   
    gerer.ajouterMembre(type3);

    
    assertEquals(gerer.ensembleMembres(), test2);
  }
  
 
  @Test
  void testverifierpresident() {

    InterMembre type1 =  new Membre("Skywalker", "Luke", "UBO", 23);
    InterMembre type2 =  new Membre("Sar", "Lucie", "UBO", 24);
    gerer.ajouterMembre(type1);
    gerer.ajouterMembre(type2);
    gerer.setPresident(type2);
    assertEquals(gerer.president(), type2);
  }

  @Test
  void testverifierpaspresident() {

    InterMembre type1 =  new Membre("Skywalker", "Luke", "UBO", 23);
    InterMembre type2 =  new Membre("Sar", "Lucie", "UBO", 24);
    gerer.ajouterMembre(type1);
    
    gerer.setPresident(type1);
    assertTrue(gerer.president() != type2);
  }
  

  /*  @Test
  void testequal() {

    InterMembre type1 =  new Membre("Sar", "Lucie", "UBO", 24);
    InterMembre type2 =  new Membre("Sar", "Lucie", "UBO", 24);
    gerer.ajouterMembre(type1);
    assertTrue(gerer.equals(type2));
  }*/

  /**
   * V�rifie qu'une adresse n'est pas null quand on cr�e une information
   * personnelle.
   
  @Test
  void testAdresseNonNull() {
    assertTrue(infoBasique.getAdresse() != null);
    assertTrue(infoComplete.getAdresse() != null);
  }
  
  /**
   * V�rifie qu'on ne peut pas positionner une adresse null sur une information
   * existante.
   
  @Test
  void testSetterAdresseNull() {
    infoComplete.setAdresse(null);
    assertTrue(infoComplete.getAdresse() != null);
  }
  
  /**
   * V�rifie que les param�tres des constructeurs sont correctement g�r�s.
  
  @Test
  void testConstructeur() {
    InformationPersonnelle inf =
        new InformationPersonnelle("Vador", "Dark", null, -30);
    assertEquals(inf.getNom(), "Vador");
    assertEquals(inf.getPrenom(), "Dark");
    assertTrue(inf.getAdresse() != null);
    assertTrue(inf.getAge() >= 0);
  }

public GestionMembre getGerer() {
	return gerer;
}

public void setGerer(GestionMembre gerer) {
	this.gerer = gerer;
}*/
  
}
