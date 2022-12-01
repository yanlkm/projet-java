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
