package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import association.Membre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests JUnit de la classe {@link association.membre InformationPersonnelle}.
 *
 * @author LOUIS Glenn
 * @see association.Membre
 */
class TestMembre {
  
  /**
   * Une information basique : pr�nom et nom.
   */
  private Membre membreTest;  
  /**
   * Instancie un membre basique pour les tests.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */
  
  @BeforeEach
  void setUp() throws Exception {
    membreTest = new Membre("Skywalker", "Luke", "UBO", 23);
  }
  
  /**
   * Ne fait rien apr�s les tests : � modifier au besoin.
   *
   * @throws Exception ne peut pas �tre lev�e ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * V�rifie que l'on peut positionner un age de 25 ans.
   */
  @Test
  void testAge25Basique() {
    membreTest.setAge(25);
    assertEquals(membreTest.getAge(), 25);
  }
  
  /**
   * V�rifie qu'on ne peut pas positionner un age n�gatif sur une information
   * basique.
   */
  @Test
  void testAgeNegatifBasique() {
    membreTest.setAge(-20);
    assertTrue(membreTest.getAge() != -20);
  }

  
  /**
   * V�rifie qu'une adresse n'est pas null quand on cr�e une information
   * personnelle.
   */
  @Test
  void testAdresseNonNull() {
    assertTrue(membreTest.getAdresse() != null);
  }
    
  /**
   * V�rifie que les param�tres des constructeurs sont correctement g�r�s.
   */
  @Test
  void testConstructeur() {
    Membre mem =
        new Membre("Vador", "Dark", null, -30);
    assertEquals(mem.getNom(), "Vador");
    assertEquals(mem.getPrenom(), "Dark");
    assertTrue(mem.getAdresse() != null);
    assertTrue(mem.getAge() >= 0);
  }
  
}
