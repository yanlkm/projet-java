package tests;

import association.Evenement;
import association.InformationPersonnelle;
import association.InterMembre;
import association.Membre;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Tests JUnit de la classe {@link association.membre InformationPersonnelle}.
 *
 * @author LOUIS Glenn
 * @see association.Membre
 */
class TestMembre {
  
  private Membre m;  
  
  /**
   * Instancie une gestion d'Evenements avec une liste d'evenements vide.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @BeforeEach
  void setUp() throws Exception {
    
    m = new Membre("menou", "charlotte", "landi", 21);
    
    Month mois = Month.valueOf("JULY");
    Month mois2 = Month.valueOf("JANUARY");
    
    Set<InterMembre> participants = new HashSet<InterMembre>();
    LocalDateTime date1 = LocalDateTime.of(2023, mois2, 12, 20, 30, 00, 000);
    LocalDateTime date2 = LocalDateTime.of(2020, mois, 4, 14, 15, 0, 0);
    LocalDateTime date3 = LocalDateTime.of(2023, mois, 12, 20, 30, 00, 000);
    
    Evenement e1 = new Evenement("Présentation", "Landivisiau", date1, 300, 100, participants);
    Evenement e2 = new Evenement("Concours", "Brest", date2, 500, 50, participants);
    Evenement e3 = new Evenement("Salon", "Landivisiau", date3, 300, 100, participants);
   
    m.getListMesEvenements().add(e1);
    m.getListMesEvenements().add(e2);
    m.getListMesEvenements().add(e3);
  }
  
  /**
   * Ne fait rien après les tests : à modifier au besoin.
   *
   * @throws Exception ne peut pas être levée ici
   */
  @AfterEach
  void tearDown() throws Exception {}
  
  
  @Test
  void testEnsembleEvenementsAvenir() {
    
    //System.out.println(m.ensembleEvenementsAvenir());
    assertTrue(m.ensembleEvenementsAvenir().size() == 2);
    
  }
  
  @Test
  void testdefinirInformationPersonnnelle() {
    
    Membre m2 = new Membre("likeme", "yan", "", 0);
    InformationPersonnelle i = new InformationPersonnelle("likeme", "yan");
    
    m.definirInformationPersonnnelle(i);
    
    assertEquals(m.getInformationPersonnelle(), m2.getInformationPersonnelle());
    
  }
  
  @Test
  void testaddEvenement() {
    
    Month mois2 = Month.valueOf("JULY");
    Set<InterMembre> participants = new HashSet<InterMembre>();
    LocalDateTime date2 = LocalDateTime.of(2020, mois2, 4, 14, 15, 0, 0);
    
    Evenement e4 = new Evenement("Projection", "Landerneau", date2, 200, 20, participants);
    m.addEvenement(e4);
    
    assertTrue(m.getListMesEvenements().size() == 4);
    
  }
}
