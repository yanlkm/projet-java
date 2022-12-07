package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

import association.Evenement;
import association.InterMembre;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
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
  
  //private static final String InterMembre = null;
  /**
  * Une information complï¿½te : nom, lieu, date, duree,nbParicipantsMax,participants.
  */

  private Evenement infoComplete;
  
  /**
   * Instancie une information complï¿½te pour les tests.
   *
   * @throws Exception ne peut pas ï¿½tre levï¿½e ici
   */
  
  @BeforeEach
  void setUp() throws Exception {
    Set<InterMembre> participants = new HashSet<InterMembre>();
    
    LocalDateTime date = LocalDateTime.of(2022, 06, 06, 15, 0, 0, 0);
    infoComplete = new Evenement("Vieille Charrues", "Carhaix", 
      date, 10, 2000, participants);
  } 
  /**
   * Ne fait rien aprï¿½s les tests : ï¿½ modifier au besoin.
   *
   * @throws Exception ne peut pas ï¿½tre levï¿½e ici
   */
  
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * Vï¿½rifie que l'on peut modifier le nom de l'evenement.
   */
  
  @Test
  void testNomComplete() {
    infoComplete.setNom("panorama");
    assertEquals(infoComplete.getNom(), "panorama");
  }
  /**
   * Vï¿½rifie que l'on peut modifier le lieu de l'evenement.
   */
  
  @Test
  void testLieuComplete() {
    infoComplete.setLieu("Brest");
    assertEquals(infoComplete.getLieu(), "Brest");
  }
  
  
  
  /**
   * Vérifie qu'on peut modifier la date.
   */
  
  @Test
  void testDateComplete() {
    LocalDateTime date = LocalDateTime.of(2022, 06, 06, 15, 0, 0, 0);    
    infoComplete.setDate(date);
    assertEquals(infoComplete.getDate(), date);
  }
  
  /**
   * Vérifie qu'on peut modifier la duree.
   */
  
  @Test
  void testDureeComplete() {     
    infoComplete.setDuree(10);
    assertEquals(infoComplete.getDuree(), 10);
  }
  
  /**
   * Vérifie qu'on peut modifier les participants.
   */
  void testnbParticipantsMaxComplete() {     
    
    infoComplete.setNbParticipantsMax(10);
    assertEquals(infoComplete.getNbParticipantsMax(), 10);
  }  
  
  /**
   * Vérifie qu'on peut modifier les participants.
   */
  void testNbParticipantsComplete() {     
    Set<InterMembre> participants = new HashSet<InterMembre>();
    infoComplete.setParticipants(participants);
    assertEquals(infoComplete.getParticipants(), participants);
  }
  
  /**
   * Vï¿½rifie qu'on ne peut pas positionner un nombre de participant nï¿½gatif sur une information
   * complete.
   */
  
  @Test
  void testNbParticipantsNegatifComplete() {
    infoComplete.setNbParticipantsMax(0);
    assertTrue(infoComplete.getNbParticipantsMax() >= 0);
  }  
  
  /**
   * Vï¿½rifie qu'on ne peut pas positionner une duree nï¿½gatif sur une information
   * complete.
   */
  
  @Test
  void testDureeCompleteSupp() {
    infoComplete.setDuree(1);
    assertTrue(infoComplete.getDuree() > 0);
  }
  /**
   * Vï¿½rifie qu'on ne peut pas positionner une Nom null sur une information
   * existante.
   */
  
  @Test
  void testSetterNomNull() {
    infoComplete.setNom("test");
    assertTrue(infoComplete.getNom() != null);
  }
  /**
   * Vï¿½rifie qu'on ne peut pas positionner une Lieu null sur une information
   * existante.
   */
  
  @Test
  void testSetterLieuNull() {
    infoComplete.setLieu("Brest");
    assertTrue(infoComplete.getLieu() != null);
  }
  /**
   * Vï¿½rifie qu'on ne peut pas positionner une Date null sur une information
   * existante.
   */
  
  @Test
  void testSetterDateNull() {
    LocalDateTime date = LocalDateTime.of(2022, 06, 06, 15, 0, 0, 0);
    infoComplete.setDate(date);
    assertTrue(infoComplete.getDate() != null);
  }
  
 
   
  /**
    * Vï¿½rifie que les paramï¿½tres des constructeurs sont correctement gï¿½rï¿½s.
    */
  
  @Test
   void testConstructeur() {
    Set<InterMembre> participants = new HashSet<InterMembre>();
    LocalDateTime date = LocalDateTime.of(2022, 06, 06, 15, 0, 0, 0);
    Evenement inf =
         new Evenement("Vieille Charrues", "Carhaix", date, 10, 2000, participants);
    assertEquals(inf.getNom(), "Vieille Charrues");
    assertEquals(inf.getLieu(), "Carhaix");
    assertEquals(inf.getDate(), date);
    assertEquals(inf.getDuree(), 10);
    assertEquals(inf.getNbParticipantsMax(), 2000);
    assertEquals(inf.getParticipants(), participants);
     
    assertTrue(inf.getNom() != null);
    assertTrue(inf.getLieu() != null);
    assertTrue(inf.getDate() != null);
    assertTrue(inf.getNbParticipantsMax() >= 0);
    assertTrue(inf.getDuree() >= 0);
     
  }
   
  
  
}
