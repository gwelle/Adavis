package rentaco;

import java.awt.* ;
import java.awt.event.* ;

import javax.swing.* ;

/** Vue dédiée à la saisie des informations d'un nouveau client
 * 
 * @author xilim
 *
 */
public class VueNouveauClient extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleLocations modele ;
	
	private JTextField tfNom = new JTextField() ;
	private JTextField tfPrenom = new JTextField() ;
	private JTextField tfMobile = new JTextField() ;
	
	//Liste des boutons
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	//JLabel
	private JLabel lblNom = new JLabel("Nom :");
	private JLabel lblPrenom = new JLabel("Prenom : ");
	private JLabel lblMobile = new JLabel("Mobile :");
	
	
	
	/** Créer la vue de saisie d'un nouveau client
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueNouveauClient(ModeleLocations modele, Controleur controleur) {
		super();
		System.out.println("VueNouveauClient::VueNouveauClient()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		
		this.bEnregistrer.addActionListener(this) ;
		this.bAnnuler.addActionListener(this) ;
		Box boxPrincipal = Box.createVerticalBox() ;
		
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxNom = Box.createHorizontalBox() ;
		Box boxPrenom = Box.createHorizontalBox() ;
		Box boxMobile = Box.createHorizontalBox() ;
		Box boxBoutons = Box.createHorizontalBox() ;
		
		boxEtiquette.add(new JLabel("Enregister un nouveau client :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		boxNom.add(lblNom);
		boxNom.add(tfNom);
		
		boxPrenom.add(lblPrenom);
		boxPrenom.add(tfPrenom);
		
		boxMobile.add(lblMobile);
		boxMobile.add(tfMobile);
		
		boxBoutons.add(bEnregistrer) ;
		boxBoutons.add(bAnnuler) ;		
		
		boxPrincipal.add(boxEtiquette);
		boxPrincipal.add(boxNom);
		boxPrincipal.add(boxPrenom);
		boxPrincipal.add(boxMobile);
		boxPrincipal.add(boxBoutons);
		
		this.add(boxPrincipal) ;
	}
	
	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'action de l'utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		System.out.println("VueNouveauClient::actionPerformed()") ;
		Object sourceEvt = evenement.getSource() ;
		if(sourceEvt == this.bEnregistrer){
			this.controleur.enregistrerClient(tfNom.getText(), tfPrenom.getText(), tfMobile.getText());
		}
		if(sourceEvt == this.bAnnuler){
			this.controleur.annulerEnregistrerClient();
		}
	}
	
	public void actualiser(){
		System.out.println("VueNouveauClient::actualiser()") ;
		this.tfNom.setText("");
		this.tfPrenom.setText("");
		this.tfMobile.setText("");
	}
	
}
