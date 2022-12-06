package ui;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import association.Association;
import association.Evenement;
import association.GestionEvenements;
import association.GestionMembre;
import association.InterMembre;
import association.Membre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controleur implements Initializable {
	
	private Association asso;
	private GestionEvenements gestE;
	private GestionMembre gestM;
  
  @FXML
  private TextField entreAdresseMembre;
  
  @FXML
  private TextField entreAgeMembre;
  
  @FXML
  private TextField entreeDateEvt;
  
  @FXML
  private TextField entreeDureeEvt;
  
  @FXML
  private TextField entreeHeureEvt;
  
  @FXML
  private TextField entreeLieuEvt;
  
  @FXML
  private TextField entreeMaxParticipantsEvt;
  
  @FXML
  private TextField entreeNomEvt;
  
  @FXML
  private TextField entreeNomMembre;
  
  @FXML
  private TextField entreePrenomMembre;
  
  @FXML
  private Label labelListeAfficheeEvt;
  
  @FXML
  private Label labelListeAfficheeMembre;
  
  @FXML
  private ListView<String> listeEvenements;
  
  @FXML
  private ListView<String> listeMembres;
  
  @FXML
  private TextArea message;
  
  @FXML
  private Font x1;
  
  @FXML
  private Color x2;
  
  @FXML
  void actionBoutonAfficherMembreSelectionneMembre(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonAfficherParticipantsEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonAfficherTousMembresMembre(ActionEvent event) {
	  Iterator<InterMembre> itValue = gestM.getMembres().iterator();
	  
	  while(itValue.hasNext()) {
		  InterMembre value = (InterMembre) itValue.next();
		  listeMembres.getItems().add(value.getInformationPersonnelle().toString());  
	  }
	  if(gestM.getMembres().isEmpty()) {
		  listeMembres.getItems().add("Cette association n'a pas de membres ! "); 
	  }
  }
  
  @FXML
  void actionBoutonEvenementSelectionneEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonEvenementsFutursAssociation(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonEvenementsFutursMembre(ActionEvent event) {
	  try {
		  int age = Integer.parseInt(entreAgeMembre.getText());
		  String adresse = entreAdresseMembre.getText();
		  String nom = entreeNomMembre.getText();
		  String prenom = entreePrenomMembre.getText();
		  
		  Membre membre = new Membre(nom, prenom, adresse, age);
		  
		  Membre b = null;
		  b = gestM.verifier(membre);
		  
		  if(b != null) {
			  Iterator<Evenement> itValue =  ((GestionEvenements) b.getListMesEvenements()).ensembleEvenementAvenir().iterator();
			  
			  while(itValue.hasNext()) {
				  Evenement value = (Evenement) itValue.next();
				  listeEvenements.getItems().add(value.toString());  
			  }
			  if(b.getListMesEvenements().isEmpty()) {
				  listeEvenements.getItems().add("Ce membre n'a pas d'argent.$$$"); 
			  }
		  }
	  }catch(Exception e) {
		  System.out.println("probl�me !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonEvenementsMembreMembre(ActionEvent event) {
	  try {
		  int age = Integer.parseInt(entreAgeMembre.getText());
		  String adresse = entreAdresseMembre.getText();
		  String nom = entreeNomMembre.getText();
		  String prenom = entreePrenomMembre.getText();
		  
		  Membre membre = new Membre(nom, prenom, adresse, age);
		  
		  Membre b = null;
		  b = gestM.verifier(membre);
		  
		  if(b != null) {
			  Iterator<Evenement> itValue = b.getListMesEvenements().iterator();
			  
			  while(itValue.hasNext()) {
				  Evenement value = (Evenement) itValue.next();
				  listeEvenements.getItems().add(value.toString());  
			  }
			  if(b.getListMesEvenements().isEmpty()) {
				  listeEvenements.getItems().add("Ce membre n'a pas d'argent.$$$"); 
			  }
		  }
	  }catch(Exception e) {
		  System.out.println("probl�me !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonIDesiscrireMembreEvenement(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonInscrireMembreEvenement(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonNouveauEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonNouveauMembre(ActionEvent event) {
	  entreAdresseMembre.clear();
	  entreAgeMembre.clear();
	  entreeNomMembre.clear();
	  entreePrenomMembre.clear();
  }
  
  @FXML
  void actionBoutonSupprimerEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonSupprimerMembre(ActionEvent event) {
	  try {
		  int age = Integer.parseInt(entreAgeMembre.getText());
		  String adresse = entreAdresseMembre.getText();
		  String nom = entreeNomMembre.getText();
		  String prenom = entreePrenomMembre.getText();
		  
		  Membre membre = new Membre(nom, prenom, adresse, age);
		  
		  gestM.supprimerMembre(membre);
		  System.out.println(gestM);
		  
	  }catch(Exception e) {
		  System.out.println("probl�me !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauMembre(event);
	  }
	  
  }
  
  @FXML
  void actionBoutonTousEvenementsAssociationEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonValiderEvt(ActionEvent event) {
    
  }
  
  @FXML
  void actionBoutonValiderMembre (ActionEvent event) throws Exception{
	  try {
		  int age = Integer.parseInt(entreAgeMembre.getText());
		  String adresse = entreAdresseMembre.getText();
		  String nom = entreeNomMembre.getText();
		  String prenom = entreePrenomMembre.getText();
		  
		  Membre membre = new Membre(nom, prenom, adresse, age);
		  
		  Membre b = null;
		  b = gestM.verifier(membre);
		  
		  if(b != null ) {
			  gestM.supprimerMembre(b);
			  gestM.ajouterMembre(membre);
			  labelListeAfficheeMembre.setText("prout !");
			  
			  System.out.println(gestM);
			  
		  }else {
			  gestM.ajouterMembre(membre);
			  System.out.println(gestM);
			  
		  }  	
	  }catch(Exception e) {
		  System.out.println("probl�me !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauMembre(event);
	  }
  }
  
  
  @FXML
  void actionMenuApropos(ActionEvent event) {
	message.setText("Bonjour, bienvenue sur la premi�re version l'appliction de la team Zmenouch.\n Dans cette application, on g�re des associations, des �v�nements, des membres.");
  }
  
  @FXML
  void actionMenuCharger(ActionEvent event) throws IOException {
    asso.chargerDonnees("test.txt");
  }
  
  @FXML
  void actionMenuNouveau(ActionEvent event) {
    gestE.getListeEvenement().clear();
    gestM.getMembres().clear();
  }
  
  @FXML
  void actionMenuQuitter(ActionEvent event) {
    System.exit(0);
  }
  
  @FXML
  void actionMenuSauvegarder(ActionEvent event) throws IOException {
    asso.sauvegarderDonnees("test.txt");
  }
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Initialisation de l'interface");
    asso = new Association();
    gestE = (GestionEvenements) asso.gestionnaireEvenements();
    gestM = (GestionMembre) asso.gestionnaireMembre();
  }
  
}
