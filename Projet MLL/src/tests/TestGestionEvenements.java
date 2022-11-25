package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import association.Evenement;
import association.GestionEvenements;
import association.Membre;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 * Tests JUnit de la classe {@link association.GestionEvenements
 * GestionEvenements}.
 *
 * @author Charlotte Menou
 * @see association.GestionEvenements
 */
class TestGestionEvenements {
  
  /**
   * Une instance de GestionEvenement.
   */
  private GestionEvenements gestE;
  
  private Evenement e1;
  private Evenement e2;
  private Evenement e3;
  private Evenement e4;
  
  
  /**
   * Instancie une gestion d'Evenements avec une liste d'evenements vide.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @BeforeEach
  void setUp() throws Exception {
    gestE = new GestionEvenements();
    
  }
  
  
  /**
   * Ne fait rien après les tests : à modifier au besoin.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  
  /**
   * Vérifie que l'on peut ajouter un évenement à la liste des évenements 
   * sans qu'il ne soit au même endroit qu'un autre évenement et en même temps.
   */
  @Test
  void testNouvelEvenement() {
    
    Month mois = Month.valueOf("July");
    
    //les évenements e1, e2, et e3 sont compatible mais pas e1, et e4.
    e1 = gestE.creerEvenement("Présentation", "Landivisiau", 13, mois, 2023, 12, 54, 200, 100);
    assertTrue(gestE.getListeEvenement().size() == 1);
    e2 = gestE.creerEvenement("Concours", "Brest", 5, mois, 2023, 16, 54, 800, 50);
    assertTrue(gestE.getListeEvenement().size() == 2);
    e3 = gestE.creerEvenement("Salon", "Saint-Sauveur", 22, mois, 2023, 8, 54, 500, 10);
    assertTrue(gestE.getListeEvenement().size() == 3);
    e4 = gestE.creerEvenement("Projection", "Brest", 5, mois, 2023, 16, 54, 200, 100); 
    assertTrue(gestE.getListeEvenement().size() == 3);
  }
  
 
  /**
   * Vérifie que l'on peut supprimer un évenement à la liste des évenements.
   */
  void testSupprimerEvenement() {
      
    gestE.supprimerEvenement(e1);
    assertTrue(gestE.getListeEvenement().size() == 2);
    gestE.supprimerEvenement(e2);
    assertTrue(gestE.getListeEvenement().size() == 1);
  }
    
  
  /**
   * Vérifie que la fonction ensembleEvenements fonctionne.
   */
  void testEnsembleEvenement() {
    Month mois = Month.valueOf("January");
    e2 = gestE.creerEvenement("Concours", "Brest", 5, mois, 2022, 16, 54, 800, 50);
    
    assertTrue(gestE.ensembleEvenements().size() == 2);
  }
  
  
  /**
   * Vérifie que la fonction ensembleEvenementsAvenir fonctionne.
   */
  void testEnsembleEvenementAvenir() {
    List<Evenement> gestAvenir = new ArrayList<Evenement>();
    gestAvenir = gestE.ensembleEvenementAvenir();
    
    assertTrue(gestAvenir.size() == 1);    
  }
  
  
  /**
   * Vérifie que la fonction inscriptionEvenement fonctionne.
   */
  void testInscriptionEvenement() {
    Membre m = new Membre("Charlotte", "Menou", "Landivisiau", 21); 
    Membre m2 = new Membre("Gael", "Menou", "Landivisiau", 18);
    gestE.inscriptionEvenement(e1, m);
    gestE.inscriptionEvenement(e1, m2);
    
    assertTrue(e1.getParticipants().size() == 2);
  }
  
  /**
   * Vérifie que la fonction annulerEvenement fonctionne.
   */
  void testAnnulerEvenement() {
    Membre m = new Membre("Charlotte", "Menou", "Landivisiau", 21); 
    Membre m2 = new Membre("Gael", "Menou", "Landivisiau", 18);
    
    gestE.annulerEvenement(e1, m);
    gestE.annulerEvenement(e1, m2);
    
    assertTrue(e1.getParticipants().size() == 0);
  }
  
  
  
 
}
