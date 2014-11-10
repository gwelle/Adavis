package rentaco;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/** Vue dédiée à la saisie des informations d'une nouvelle location
 * 
 * @author xilim
 *
 */
public class VueNouvelleLocation extends JPanel implements ActionListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleLocations modele ;
	
	private JComboBox cbClients = new JComboBox() ;
	private JComboBox cbVehicules = new JComboBox() ;
	
	private JTextField tfDateDepart = new JTextField(10) ;
	
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	private JLabel lblClient = new JLabel("Clients : ");
	private JLabel lblDateDepart = new JLabel("Date de départ : ");
	private JLabel lblVehicules = new JLabel("Véhicule : ");
	

	
	
	/** Créer la vue de saisie d'une nouvelle location
	 * 
	 * @param modele Le modele
	 * @param controleur Le contrôleur
	 */
	public VueNouvelleLocation(ModeleLocations modele, Controleur controleur) {
		super();
		System.out.println("VueNouvelleLocation::VueNouvelleLocation()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		
		this.tfDateDepart.getDocument().addDocumentListener(this) ;
		
		this.bEnregistrer.setEnabled(false) ;
		this.bEnregistrer.addActionListener(this) ;
		
		this.bAnnuler.addActionListener(this) ;
		
		for(Client client : this.modele.getClients()){
			this.cbClients.addItem(client.getNom() + " " + client.getPrenom() + " (" + client.getNumero() + ")") ;
		}
		
		for(Vehicule vehicule : this.modele. getVehicules()){
			this.cbVehicules.addItem(vehicule.getImmatriculation() /*+ " " + vehicule.getPrenom() + " (" + vehicule.getNumero() + ")"*/) ;
		}
		
		Box boxPrincipal = Box.createVerticalBox() ;
		
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxClient= Box.createHorizontalBox() ;
		Box boxDateDepart = Box.createHorizontalBox() ;
		Box boxVehicules = Box.createHorizontalBox() ;
		Box boxBoutons = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("Enregister une nouvelle location:")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		boxClient.add(lblClient);
		boxClient.add(cbClients);
		
		boxDateDepart.add(lblDateDepart);
		boxDateDepart.add(tfDateDepart);
		
		boxVehicules.add(lblVehicules);
		boxVehicules.add(cbVehicules);
		
		boxBoutons.add(bEnregistrer) ;
		boxBoutons.add(bAnnuler) ;		
		
		boxPrincipal.add(boxEtiquette);
		boxPrincipal.add(boxClient);
		boxPrincipal.add(boxDateDepart);
		boxPrincipal.add(boxVehicules);
		boxPrincipal.add(boxBoutons);
		
		this.add(boxPrincipal) ;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println("VueNouvelleLocation::actionPerformed()") ;
		Object sourceEvt = evt.getSource() ;
		if(sourceEvt == this.bEnregistrer){
			//this.controleur.enregistrerLocation(name, flags, null);
		}
		else if(sourceEvt == this.bAnnuler) {
			
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent evt) {
		System.out.println("VueNouvelleLocation::changedUpdate()") ;
		this.repercuterSaisieDate() ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent evt) {
		System.out.println("VueNouvelleLocation::insertUpdate()") ;
		this.repercuterSaisieDate() ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent evt) {
		System.out.println("VueNouvelleLocation::actionPerformed()") ;
		this.repercuterSaisieDate() ;
	}
	
	/** Modifier l'état du bouton "Valider" en fonction de la valeur saisie dans le champ associé à la date de départ
	 * 
	 */
	private void repercuterSaisieDate(){
		System.out.println("VueNouvelleLocation::repercuterSaisieDate()") ;
		// A compléter
		//
		// Si la saisie représente une date :
		//   - Activer le bouton "Valider"
		//
		// Si la saisie ne représente par une date :
		//   - Désactiver le bouton "Valider"
		
	}
	
		/*public void actualiser(){
		System.out.println("VueNouveauClient::actualiser()") ;
		this.tfNom.setText("");
		this.tfPrenom.setText("");
		this.tfMobile.setText("");*/
	}
