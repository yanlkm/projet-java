package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import association.Evenement;
import association.GestionEvenements;
import association.InterMembre;
import association.Membre;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  //private Evenement e2;
  //private Evenement e3;
  //private Evenement e4;
  
  
  /**
   * Instancie une gestion d'Evenements avec une liste d'evenements vide.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @BeforeEach
  void setUp() throws Exception {
    gestE = new GestionEvenements();
    
    Month mois = Month.valueOf("JULY");
    Set<InterMembre> participants = new HashSet<InterMembre>();
    LocalDateTime date1 = LocalDateTime.of(2023, mois, 12, 20, 30, 00, 000);
    //LocalDateTime date2 = LocalDateTime.of(2023, mois, 4, 14, 15, 0, 0);
    e1 = new Evenement("Présentation", "Landivisiau", date1, 300, 100, participants);
    //Evenement e2 = new Evenement("Concours", "Brest", date2, 500, 50, participants);
    //Evenement e3 = new Evenement("Salon", "Landivisiau", date1, 300, 100, participants);
    //Evenement e4 = new Evenement("Projection", "Landerneau", date2, 200, 20, participants);
    
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
    
    Month mois = Month.valueOf("JULY");

    Evenement e = 
        gestE.creerEvenement("Présentation", "Landivisiau", 12, mois, 2023, 20, 30, 300, 100);
    assertEquals(e1, e);
    List<Evenement> l = new ArrayList<Evenement>();
    l.add(e1);
    assertEquals(l, gestE.getListeEvenement());
    Evenement rate = 
        gestE.creerEvenement("Présentation", "Landivisiau", 12, mois, 2023, 20, 30, 300, 100);
    l.add(rate);
    assertTrue(gestE.getListeEvenement().size() == 1);
  }
  
  
  /**
   * Vérifie que l'on peut supprimer un évenement à la liste des évenements.
    */
  @Test
  void testSupprimerEvenement() {
      
    gestE.supprimerEvenement(e1);
    assertTrue(gestE.getListeEvenement().size() == 0);
  }
    
  
  /**
   * Vérifie que la fonction ensembleEvenements fonctionne.
   */
  @Test
  void testEnsembleEvenement() {
    Month mois = Month.valueOf("JUNE");
    
    //Evenement e = gestE.creerEvenement("Concours", "Brest", 5, mois, 2023, 16, 54, 800, 50);
    //Evenement le = gestE.creerEvenement("Concours", "Brest", 5, mois, 2024, 16, 54, 800, 50);
    //Evenement evt = 
    gestE.creerEvenement("Spectacle", "Saint-Sauveur", 6, mois, 2021, 16, 54, 800, 50);
    
    assertTrue(gestE.ensembleEvenements().size() == 3);
  }
  
  
  /**
   * Vérifie que la fonction ensembleEvenementsAvenir fonctionne.
     */
  @Test
  void testEnsembleEvenementAvenir() {
    Month mois = Month.valueOf("JUNE");
    
    //Evenement e = gestE.creerEvenement("Concours", "Brest", 5, mois, 2023, 16, 54, 800, 50);
    //Evenement le = gestE.creerEvenement("Concours", "Brest", 5, mois, 2024, 16, 54, 800, 50);
    //Evenement evt = 
    gestE.creerEvenement("Spectacle", "Saint-Sauveur", 6, mois, 2021, 16, 54, 800, 50);
    assertTrue(gestE.ensembleEvenementAvenir().size() == 2);    
  }
  
  
  /**
   * Vérifie que la fonction inscriptionEvenement fonctionne.
     */
  @Test
  void testInscriptionEvenement() {
    Membre m = new Membre("Charlotte", "Menou", "Landivisiau", 21); 
    Membre m2 = new Membre("Gael", "Menou", "Landivisiau", 18);
    gestE.inscriptionEvenement(e1, m);
    gestE.inscriptionEvenement(e1, m2);
    
    assertTrue(e1.getParticipants().size() == 2);
    assertTrue(m.ensembleEvenements().size() == 1);
  }
  
  /**
   * Vérifie que la fonction annulerEvenement fonctionne.
      */
  @Test
  void testAnnulerEvenement() {
    Membre m = new Membre("Charlotte", "Menou", "Landivisiau", 21); 
    Membre m2 = new Membre("Gael", "Menou", "Landivisiau", 18);
    
    gestE.annulerEvenement(e1, m);
    gestE.annulerEvenement(e1, m2);
    
    assertTrue(e1.getParticipants().size() == 0);
    assertTrue(m.ensembleEvenements().size() == 0);
  }
  

  
 
}
