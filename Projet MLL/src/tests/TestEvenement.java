package tests;

import association.Evenement;
import association.InformationPersonnelle;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests JUnit de la classe {@link association.Evenement
 * EVENEMENT}.
 *
 * @author adrien.failler
 * @see association.Evenement
 */

class TestEvenement {
  
  /**
  * Une information compl�te : nom, lieu, date, duree,nbParicipantsMax,participants.
  */
  private Evenement infoComplete;
  
  /**
   * Instancie une information compl�te pour les tests.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */
  
  @BeforeEach
  void setUp() throws Exception {
    infoComplete =
        new Evenement("Vieille Charrues", "2022-06-06 15:00:00", "Carhaix", 10, 2000, "Didier");
  } 
  /**
   * Ne fait rien apr�s les tests : � modifier au besoin.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */
  
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * V�rifie que l'on peut modifier le nom de l'evenement.
   */
  
  @Test
  void testNomComplete() {
    infoComplete.setNom("panorama");
    assertEquals(infoComplete.getNom(), "panorama");
  }
  /**
   * V�rifie que l'on peut modifier le lieu de l'evenement.
   */
  
  @Test
  void testLieuComplete() {
    infoComplete.setLieu("Brest");
    assertEquals(infoComplete.getNom(), "Brest");
  }
  /**
   * V�rifie qu'on ne peut pas positionner un nombre de participant n�gatif sur une information
   * complete.
   */
  
  @Test
  void testNbParticipantsNegatifComplete() {
    infoComplete.setNbParticipantsMax(-20);
    assertTrue(infoComplete.getNbParticipantsMax() != -20);
  }
  
  /*/**
   * V�rifie qu'on ne peut pas positionner un nombre de participant n�gatif sur une information
   * complete.
   */
  /*
  @Test
  void testDateComplete() {
    infoComplete.SetDate(-20);
    assertTrue(infoComplete.getDate() != -20);
  }*/
  
  /**
   * V�rifie qu'on ne peut pas positionner une duree n�gatif sur une information
   * complete.
   */
  
  @Test
  void testDureeComplete() {
    infoComplete.setDuree(-20);
    assertTrue(infoComplete.getDuree() != -20);
  }
  /**
   * V�rifie qu'on ne peut pas positionner une Nom null sur une information
   * existante.
   */
  
  @Test
  void testSetterNomNull() {
    infoComplete.setNom(null);
    assertTrue(infoComplete.getNom() != null);
  }
  /**
   * V�rifie qu'on ne peut pas positionner une Lieu null sur une information
   * existante.
   */
  
  @Test
  void testSetterLieuNull() {
    infoComplete.setLieu(null);
    assertTrue(infoComplete.getLieu() != null);
  }
  /**
   * V�rifie qu'on ne peut pas positionner une Date null sur une information
   * existante.
   */
  
  @Test
  void testSetterDateNull() {
    infoComplete.setDate(null);
    assertTrue(infoComplete.getDate() != null);
  }
  
  /**
   * V�rifie qu'on ne peut pas positionner une Duree null sur une information
   * existante.
   */
   /*
  @Test
  void testSetterDureeNull() {
    infoComplete.setDuree(null);
    assertTrue(infoComplete.getDuree() != null);
  }
*/
   
  /**
    * V�rifie que les param�tres des constructeurs sont correctement g�r�s.
    */
  
  @Test
   void testConstructeur() {
    Evenement inf =
         new Evenement("Vieille Charrues", "Carhaix", "2022-06-06 15:00:00", 10, 2000, "Didier");
    assertEquals(inf.getNom(), "Vieille Charrues");
    assertEquals(inf.getLieu(), "Carhaix");
    assertEquals(inf.getDate(), "2022-06-06 15:00:00");
    assertEquals(inf.getDuree(), 10);
    assertEquals(inf.getNbParticipantsMax(), 2000);
    assertEquals(inf.getParticipants(), "didier");
     
    assertTrue(inf.getNom() != null);
    assertTrue(inf.getLieu() != null);
    assertTrue(inf.getDate() != null);
    assertTrue(inf.getNbParticipantsMax() >= 0);
    assertTrue(inf.getDuree() >= 0);
     
  }
   
  
  
}
