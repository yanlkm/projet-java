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
*Definition d'une classe implémentant l'interface IntergestionMembre qui permet de gerer
* un membre dans une association.

 * @author yanmarcelferel.l

 *
 */
public class TestGestionMembre {

  /**
   * Une information complï¿½te : prï¿½nom, nom, adresse et age.
   */

  private GestionMembre gerer;
  
  /**
   * Instancie une information basique et une complï¿½te pour les tests.
   *
   * @throws Exception ne peut pas ï¿½tre levï¿½e ici
   */ 
  @BeforeEach
  void setUp() throws Exception {
    gerer = new GestionMembre();
    
  }
  
  /**
   * Ne fait rien aprï¿½s les tests : ï¿½ modifier au besoin.
   *
   * @throws Exception ne peut pas ï¿½tre levï¿½e ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * Vérifie qu'on peut avoir une liste de membres à un évenement  qui est vide.
   */
  
  @Test
  void testvidelistemembres() {
    Set<InterMembre> test1 = new HashSet<InterMembre>();
 
    gerer.setMembres(test1);
  
    assertEquals(gerer.getMembres(), test1);
  }
  
  /**
   * Vï¿½rifie qu'on ne peut pas positionner un age nï¿½gatif sur une information
   * basique.
   */

  @Test
  void testajoutunmembre() {
    Set<InterMembre> test2 = gerer.getMembres();
    InterMembre type1 =  new Membre("Skywalker", "Luke", "UBO", 23);
    gerer.ajouterMembre(type1);

    assertEquals(gerer.getMembres(), test2);
  }
  
  /**
   * Vï¿½rifie qu'on ne peut pas positionner un age nï¿½gatif sur une information
   * complï¿½te.
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
   * Vï¿½rifie qu'une adresse n'est pas null quand on crï¿½e une information
   * personnelle.
   
  @Test
  void testAdresseNonNull() {
    assertTrue(infoBasique.getAdresse() != null);
    assertTrue(infoComplete.getAdresse() != null);
  }
  
  /**
   * Vï¿½rifie qu'on ne peut pas positionner une adresse null sur une information
   * existante.
   
  @Test
  void testSetterAdresseNull() {
    infoComplete.setAdresse(null);
    assertTrue(infoComplete.getAdresse() != null);
  }
  
  /**
   * Vï¿½rifie que les paramï¿½tres des constructeurs sont correctement gï¿½rï¿½s.
  
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
