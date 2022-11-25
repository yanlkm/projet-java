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
   * Une information basique : prénom et nom.
   */
  private Membre membreTest;  
  /**
   * Instancie un membre basique pour les tests.
   *
   * @throws Exception ne peut pas être levée ici
   */
  
  @BeforeEach
  void setUp() throws Exception {
    membreTest = new Membre("Skywalker", "Luke", "UBO", 23);
  }
  
  /**
   * Ne fait rien après les tests : à modifier au besoin.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  /**
   * Vérifie que l'on peut positionner un age de 25 ans.
   */
  @Test
  void testAge25Basique() {
    membreTest.setAge(25);
    assertEquals(membreTest.getAge(), 25);
  }
  
  /**
   * Vérifie qu'on ne peut pas positionner un age négatif sur une information
   * basique.
   */
  @Test
  void testAgeNegatifBasique() {
    membreTest.setAge(-20);
    assertTrue(membreTest.getAge() != -20);
  }

  
  /**
   * Vérifie qu'une adresse n'est pas null quand on crée une information
   * personnelle.
   */
  @Test
  void testAdresseNonNull() {
    assertTrue(membreTest.getAdresse() != null);
  }
    
  /**
   * Vérifie que les paramètres des constructeurs sont correctement gérés.
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
