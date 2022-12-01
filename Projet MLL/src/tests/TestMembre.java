package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import association.InformationPersonnelle;
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
  private InformationPersonnelle info;
  
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
