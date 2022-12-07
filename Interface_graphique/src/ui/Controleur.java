package ui;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

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
	  try {
		  String s = listeMembres.getSelectionModel().getSelectedItem();
		  listeMembres.getItems().clear();
		  
		  String[] words = s.split(" ");
		  entreePrenomMembre.setText(words[0]);
		  entreeNomMembre.setText(words[1]);
		  entreAdresseMembre.setText(words[7]);
		  entreAgeMembre.setText(words[4]);
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonAfficherParticipantsEvt(ActionEvent event) {//////////////////////////////////////////////////////////////////////
    
  }
  
  @FXML
  void actionBoutonAfficherTousMembresMembre(ActionEvent event) {
	  Iterator<InterMembre> itValue = gestM.getMembres().iterator();
	  listeMembres.getItems().clear();
	  while(itValue.hasNext()) {
		  InterMembre value = (InterMembre) itValue.next();
		  labelListeAfficheeMembre.setText("tous les membres de l'association.");
		  listeMembres.getItems().add(value.getInformationPersonnelle().toString());  
	  }
	  if(gestM.getMembres().isEmpty()) {
		  labelListeAfficheeMembre.setText("Cette association n'a pas de membres !");
	  }
  }
  
  @FXML
  void actionBoutonEvenementSelectionneEvt(ActionEvent event) {
	  try {
		  String s = listeEvenements.getSelectionModel().getSelectedItem();
		  listeEvenements.getItems().clear();
		  
		  String[] words = s.split(" ");
		  entreeNomEvt.setText(words[0]);
		  entreeLieuEvt.setText(words[1]);
		  String[] date = words[2].split("T");
		  entreeDateEvt.setText(date[0]);
		  entreeHeureEvt.setText(date[1]);
		  entreeDureeEvt.setText(words[3]);
		  entreeMaxParticipantsEvt.setText(words[4]);
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonEvenementsFutursAssociation(ActionEvent event) {
	  Iterator<Evenement> itValue = gestE.ensembleEvenementAvenir().iterator();
	  listeEvenements.getItems().clear();
	  while(itValue.hasNext()) {
		  Evenement value = itValue.next();
		  labelListeAfficheeEvt.setText("tous les evenements futurs de l'association.");
		  listeEvenements.getItems().add(value.toString());  
	  }
	  if(gestE.getListeEvenement().isEmpty()) {
		  labelListeAfficheeMembre.setText("Cette association n'a pas d'evenements futurs !");
	  }
  }
  
  @FXML
  void actionBoutonEvenementsFutursMembre(ActionEvent event) {/////////////////////////////////////////////////////////////////////////////////////
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
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonEvenementsMembreMembre(ActionEvent event) {////////////////////////////////////////////////////////////////////////////////////////////////
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
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);

	  }
  }
  
  @FXML
  void actionBoutonIDesiscrireMembreEvenement(ActionEvent event) {/////////////////////////////////////////////////////////////////////
    
  }
  
  @FXML
  void actionBoutonInscrireMembreEvenement(ActionEvent event) {///////////////////////////////////////////////////////////
	  try {
		  //récupération de l'évennement
		  String s = listeEvenements.getSelectionModel().getSelectedItem();
		  listeEvenements.getItems().clear();
		  
		  String[] words = s.split(" ");
		  String nom = words[0];
		  String lieu = words[1];
		  String[] date = words[2].split("T");
		  String thedate = date[0];
		  String heure1 = date[1];
		  String duree = words[3];
		  String max = words[4];
		  
		  String[] words_date = thedate.split("-");
		  String[] words_heure = heure1.split(":");
		  int annee = Integer.parseInt(words_date[0]);
		  int mois = Integer.parseInt(words_date[1]);
		  int jour = Integer.parseInt(words_date[2]);
		  int heure = Integer.parseInt(words_heure[0]);
		  int minute = Integer.parseInt(words_heure[1]);
		  int dure = Integer.parseInt(duree);
		  int part_max = Integer.parseInt(max);
		  
		  LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minute, 0, 000);
		  Set<InterMembre> participants = new HashSet<InterMembre>();
		  
		  Evenement evt = new Evenement(nom, lieu, d, dure, part_max, participants);
		  
		  //récupération du membre
		  String s2 = listeMembres.getSelectionModel().getSelectedItem();
		  listeMembres.getItems().clear();
		  
		  String[] words2 = s2.split(" ");
		  String prenom = words[0];
		  String nom2 = words[1];
		  String adresse = words[7];
		  int age = Integer.parseInt(words[4]);
		  
		  Membre membre = new Membre(nom2, prenom, adresse, age);
		  
		  gestE.inscriptionEvenement(evt, membre);
		  
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauEvt(event);
	  }
		  
	  
	  
  }
  
  @FXML
  void actionBoutonNouveauEvt(ActionEvent event) {
	  entreeDateEvt.clear();
	  entreeDureeEvt.clear();
	  entreeHeureEvt.clear();
	  entreeLieuEvt.clear();
	  entreeNomEvt.clear();
	  entreeMaxParticipantsEvt.clear();
  }
  
  @FXML
  void actionBoutonNouveauMembre(ActionEvent event) {
	  entreAdresseMembre.clear();
	  entreAgeMembre.clear();
	  entreeNomMembre.clear();
	  entreePrenomMembre.clear();
  }
  
  @FXML
  void actionBoutonSupprimerEvt(ActionEvent event) {///////////////////////////////////////////////////////////////////////////////
	  try {
		  String date = entreeDateEvt.getText();
		  String duree = entreeDureeEvt.getText();
		  String nom = entreeNomEvt.getText();
		  String horaire = entreeHeureEvt.getText();
		  String lieu = entreeLieuEvt.getText();
		  String max = entreeMaxParticipantsEvt.getText();
		  
		  String[] words_date = date.split("-");
		  String[] words_heure = horaire.split(":");
		  int annee = Integer.parseInt(words_date[2]);
		  int mois = Integer.parseInt(words_date[1]);
		  int jour = Integer.parseInt(words_date[0]);
		  int heure = Integer.parseInt(words_heure[0]);
		  int minute = Integer.parseInt(words_heure[1]);
		  int dure = Integer.parseInt(duree);
		  int part_max = Integer.parseInt(max);
		  
		  LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minute, 0, 000);
		  Set<InterMembre> participants = new HashSet<InterMembre>();
		  
		  Evenement evt = new Evenement(nom, lieu, d, dure, part_max, participants);

		  gestE.supprimerEvenement(evt);
		  System.out.println(gestE);
		  
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauEvt(event);
	  }
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
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauMembre(event);
	  }
	  
  }
  
  @FXML
  void actionBoutonTousEvenementsAssociationEvt(ActionEvent event) {
	  Iterator<Evenement> itValue = gestE.getListeEvenement().iterator();
	  listeEvenements.getItems().clear();
	  while(itValue.hasNext()) {
		  Evenement value = itValue.next();
		  labelListeAfficheeEvt.setText("tous les evenements de l'association.");
		  listeEvenements.getItems().add(value.toString());  
	  }
	  if(gestE.getListeEvenement().isEmpty()) {
		  labelListeAfficheeMembre.setText("Cette association n'a pas d'evenements !");
	  }
  }
  
  @FXML
  void actionBoutonValiderEvt(ActionEvent event) {
	  try {
		  String date = entreeDateEvt.getText();
		  String duree = entreeDureeEvt.getText();
		  String nom = entreeNomEvt.getText();
		  String horaire = entreeHeureEvt.getText();
		  String lieu = entreeLieuEvt.getText();
		  String max = entreeMaxParticipantsEvt.getText();
		  
		  String[] words_date = date.split("-");
		  String[] words_heure = horaire.split(":");
		  int annee = Integer.parseInt(words_date[0]);
		  int mois = Integer.parseInt(words_date[1]);
		  int jour = Integer.parseInt(words_date[2]);
		  int heure = Integer.parseInt(words_heure[0]);
		  int minute = Integer.parseInt(words_heure[1]);
		  int dure = Integer.parseInt(duree);
		  int part_max = Integer.parseInt(max);
		  
		  LocalDateTime d = LocalDateTime.of(annee, mois, jour, heure, minute, 0, 000);
		  Set<InterMembre> participants = new HashSet<InterMembre>();
		  
		  Evenement evt = new Evenement(nom, lieu, d, dure, part_max, participants);
		  
		  Evenement b = null;
		  b = gestE.verifier(evt);
		  
		  if(b != null ) {
			  gestE.supprimerEvenement(b);
			  gestE.getListeEvenement().add(evt);
			  
			  System.out.println(gestE);
			  
		  }else {
			  gestE.getListeEvenement().add(evt);
			  System.out.println(gestE);
		  }
		  
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauEvt(event);
	  }
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
			  
			  System.out.println(gestM);
			  
		  }else {
			  gestM.ajouterMembre(membre);
			  System.out.println(gestM);
			  
		  }  	
	  }catch(Exception e) {
		  System.out.println("problème !!!!!!!!!!!!!!!!");
		  System.out.println(e);
		  e.printStackTrace();
		  actionBoutonNouveauMembre(event);
	  }
  }
  
  
  @FXML
  void actionMenuApropos(ActionEvent event) {
	message.setText("Bonjour, bienvenue sur la première version l'appliction de la team Zmenouch.\n Dans cette application, on gère des associations, des évènements, des membres.");
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
