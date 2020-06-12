package Gestion_Loc_Git;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import Gestion_Loc_Git.JVoiture;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import Gestion_Loc_Git.JClient;

public class JLocation extends JPanel
{
	/**/
	private JTextField mTxtLivreAuteur = new JTextField("",20),
			   mTxtLivreTitre = new JTextField("",20),
			   mTxtLivrePrix = new JTextField("",20),
			   mTxtLivreAnnee = new JTextField("",20);
	
	private JPanel mPanelLivresForm = new JPanel();
	 private JLabel jLabel1= new JLabel();
	 private JLabel jLabel7= new JLabel();
	 private JLabel jLabel8= new JLabel();
	private JPanel mPanelEmpruntsButton = new JPanel();
	private JPanel mPanelEmpruntsimg = new JPanel();
	private JPanel mPanelEmpruntsTable = new JPanel();
	private JPanel mPanelEmpruntsTable2 = new JPanel();
	private JPanel mPanelEmpruntsTable3 = new JPanel();
	private JButton mBtnEmpruntAdd = new JButton("Ajouter Une Location"),
					mBtnEmpruntDel = new JButton("Rendre"),
					mBtnEmpruntAnu= new JButton("Annuler"),
					CalculMontant= new JButton("Calculer le montant de la location");
					;
	
	private JTable mTableEmprunt = new JTable();
	JLabel marque = new JLabel("Date début");
	JLabel model = new JLabel("Date fin");
	 // Labels
	JLabel PrixLoc = new JLabel("Prix De Location ");
	JLabel TypePayement = new JLabel("Type De Payement ");
	JLabel numLoc = new JLabel("le Numéro  de Location ");
	//
	public static JTextField mTxtVoitureM= new JTextField("",25);
	public static JTextField mTxtVoitureP= new JTextField("",25);
	
	
	// image 
	
	
	// Texts Fields
	public static JTextField mTxtPrixLoc= new JTextField("",25);
	public static JTextField mTxtTypePay= new JTextField("",25);
	public static JTextField mTxtNumLoc = new JTextField("",25);
	//
	public static JTable ListClient = new JTable();
	public static JTable ListVoiture = new JTable();
	private DefaultTableModel mTableEmpruntTitre = new DefaultTableModel() ;
	public static	 DefaultTableModel mTableClientModel = new DefaultTableModel();
	public static	 DefaultTableModel mTableVoitureModel = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	/**/
	public JLocation(JFrame mFram) {
		super();
	
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		mTableEmprunt.setBackground(new java.awt.Color(255, 189, 136));
		mPanelEmpruntsTable.setBackground(new java.awt.Color(249, 236, 242));
		mPanelEmpruntsimg.setBackground(new Color(252, 120, 15));
		mPanelEmpruntsTable2.setBackground(new java.awt.Color(255, 189, 136));
		mPanelEmpruntsButton.setBackground(new java.awt.Color(254, 161, 87));
		  mPanelEmpruntsTable3.setLayout(new GridLayout(5,2));
	        
		  numLoc.setFont(new Font("Yu Mincho Light", 1, 13)); 
		  numLoc.setForeground(new Color(71, 74, 74));
		  mPanelEmpruntsTable3.add(numLoc);
		  mPanelEmpruntsTable3.add(mTxtNumLoc);
	        marque.setFont(new Font("Yu Mincho Light", 1, 13));
	        marque.setForeground(new Color(71, 74, 74));
	        mPanelEmpruntsTable3.add(marque);
	        mPanelEmpruntsTable3.add(mTxtVoitureM);
	        model.setFont(new Font("Yu Mincho Light", 1, 13)); 
	        model.setForeground(new Color(71, 74, 74));
			mPanelEmpruntsTable3.add(model);
			mPanelEmpruntsTable3.add(mTxtVoitureP);
			PrixLoc.setFont(new Font("Yu Mincho Light", 1, 13)); 
			PrixLoc.setForeground(new Color(71, 74, 74));
				mPanelEmpruntsTable3.add(PrixLoc);
				mPanelEmpruntsTable3.add(mTxtPrixLoc);
				TypePayement.setFont(new Font("Yu Mincho Light", 1, 13)); 
				TypePayement.setForeground(new Color(71, 74, 74));
					mPanelEmpruntsTable3.add(TypePayement);
					mPanelEmpruntsTable3.add(mTxtTypePay);
		
		
		mTableEmprunt.setModel(mTableEmpruntTitre);
		mTableEmpruntTitre.addColumn("Date début");
		mTableEmpruntTitre.addColumn("Date fin");
		mTableEmpruntTitre.addColumn(" Numéro Client");
		mTableEmpruntTitre.addColumn(" Matricule");
		mTableEmpruntTitre.addColumn(" Numéro Location");
		mTableEmpruntTitre.addColumn(" prixDeLocation");
		mTableEmpruntTitre.addColumn("Type de paiement");
		 JScrollPane  mPanelVoitureTable;
	     mPanelVoitureTable= new JScrollPane(mTableEmprunt);
	        mPanelEmpruntsTable.add(mPanelVoitureTable,BorderLayout.CENTER);
	        mPanelEmpruntsTable.add(mPanelEmpruntsTable3,BorderLayout.NORTH);
	        mPanelVoitureTable.setPreferredSize(new Dimension(970, 390));
	        mPanelVoitureTable.setBorder(BorderFactory.createTitledBorder("Tableau des locations des clients"));
	        mPanelVoitureTable.setBackground(new Color(95,158,160));
	   

		/* Listner Jtable */
		mTableEmprunt.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableEmprunt.getSelectedRow() > -1) 
				{
					mBtnEmpruntAdd.setEnabled(false);
					mBtnEmpruntDel.setEnabled(true);
					mBtnEmpruntAnu.setEnabled(true);				
				}
			}
		});
		
	
		
		 jLabel7.setBackground(new Color(255, 255, 255));
		 jLabel7.setFont(new Font("Yu Mincho Light", 1, 25)); 
		 jLabel7.setForeground(new Color(255, 255, 255));
		 jLabel7.setText("  Espace de Gestion des Locations ");
	        
        mPanelEmpruntsimg.add(jLabel7);
        mPanelEmpruntsimg.add(jLabel8);
		
		
		mPanelLivresForm.setLayout(new GridLayout(8,1));
		mPanelLivresForm.add(new JLabel("Livre"));
		mPanelLivresForm.add(mTxtLivreAuteur);
		
		mPanelLivresForm.add(new JLabel("Prix"));
		mPanelLivresForm.add(mTxtLivrePrix);
		mPanelLivresForm.add(new JLabel("Annee"));
		mPanelLivresForm.add(mTxtLivreAnnee);
		
		
		
		mPanelEmpruntsButton.add(mBtnEmpruntAdd);
		mPanelEmpruntsButton.add(mBtnEmpruntDel);
		mPanelEmpruntsButton.add(mBtnEmpruntAnu);
		mPanelEmpruntsButton.add(CalculMontant);
		
		this.add(mPanelEmpruntsimg, BorderLayout.NORTH);
		this.add(mPanelEmpruntsTable, BorderLayout.CENTER);
		this.add(mPanelEmpruntsButton, BorderLayout.SOUTH);
		
		ListClient.setModel(mTableClientModel);
		mTableClientModel.addColumn("Nom ");
		mTableClientModel.addColumn("Prénom");
		mTableClientModel.addColumn("Num client");
		mTableClientModel.addColumn("Type Client");
		
		 
	      
	      
  		ListClient.setBackground(new Color(255,255,255));
	    
     JScrollPane  mPanelClientTable;
     mPanelClientTable= new JScrollPane(ListClient);
     mPanelClientTable.setPreferredSize(new Dimension(580, 600));
     mPanelClientTable.setBorder(BorderFactory.createTitledBorder(" Tableau des Clients "));
     mPanelClientTable.setBackground(new Color(255,200,0));
     
     JScrollPane  mPanelVoiturTable;
     mPanelVoiturTable= new JScrollPane(ListVoiture);
     mPanelVoiturTable.setPreferredSize(new Dimension(580, 600));
     mPanelVoiturTable.setBorder(BorderFactory.createTitledBorder(" Tableau des Voitures "));
     mPanelVoiturTable.setBackground(new Color(255,200,0));
     
     //pour le JTABLE Voitures
     
     ListVoiture.setModel(mTableVoitureModel);  
     mTableVoitureModel.addColumn("Matricule");
     mTableVoitureModel.addColumn("Marque");
     mTableVoitureModel.addColumn("Type Voiture");
     mTableVoitureModel.addColumn("Prix Voiture");
     mTableVoitureModel.addColumn("Voiture Louée ?");
		
    
     ListVoiture.setBackground(new Color(255,255,255));
	    
 

   
	//Buttons
	JButton mButtonAddAdd = new JButton("Ajouter Le Client");
	JButton mButtonAddAnu = new JButton("Annuler");

mButtonAddAdd.setEnabled(true);
mButtonAddAnu.setEnabled(true);
//setFormEnable(false) ;
		/* Listner Button ajouter */
		mBtnEmpruntAdd.addActionListener(new ActionListener() 
		{	
			@Override
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				//JDialog
				JDialog jd = new JDialog(mFram);
				jd.setTitle("Ajouter une Location");
				jd.setLayout(new BorderLayout());
				jd.setVisible(true);
				//Panel
				JPanel mPanelNorth = new JPanel();
				JPanel mPanelCentre = new JPanel();
				JPanel mPanelBtns = new JPanel();
				mPanelCentre.add(mPanelClientTable,BorderLayout.CENTER);

			    jLabel1.setBackground(new java.awt.Color(204, 204, 255));
		        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 14)); 
		        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
		        jLabel1.setText("  Liste  des Clients disponibles ");
			
		     
				setFormEnable(true) ;
				
		    	mPanelNorth.add(jLabel1);
		    	mPanelNorth.setBackground(new java.awt.Color(249, 236, 242));
		    	mPanelCentre.setBackground(new java.awt.Color(249, 236, 242));
		    	jd.getContentPane().add(mPanelNorth, BorderLayout.NORTH);
			    jd.getContentPane().add(mPanelCentre, BorderLayout.CENTER);
			    mPanelBtns.add(mButtonAddAdd);
		    	mPanelBtns.add(mButtonAddAdd);
				if(mBtnEmpruntAdd.getText().equals("Ajouter Une Location"))
				{
					ListClient.setEnabled(true);
					ListClient.getSelectionModel().clearSelection();
					ListVoiture.setEnabled(true);
					ListVoiture.getSelectionModel().clearSelection();
					mBtnEmpruntAdd.setText("Confirmer La Location");
				//	resetForm();
				//	setFormEnable(true);	
					
				
					mButtonAddAdd.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(mButtonAddAdd.getText().equals("Ajouter Le Client"))
							{
								ListClient.setEnabled(true);
								ListVoiture.setEnabled(true);
								mButtonAddAdd.setText("Ajouter La Voiture");
								
							mPanelCentre.remove(mPanelClientTable);
							mPanelCentre.repaint();
							mPanelCentre.revalidate();
							mPanelCentre.add(mPanelVoiturTable,BorderLayout.CENTER);
					        jLabel1.setText(" Liste  des Voitures disponibles ");
					    	mPanelCentre.repaint();
							mPanelCentre.revalidate();
							mPanelCentre.setVisible(true);
							jd.setVisible(true);
							mPanelVoiturTable.setEnabled(true);	
				          }
			     	else {   
			     		mPanelCentre.remove(mPanelVoiturTable);
						mPanelCentre.repaint();
						mPanelCentre.revalidate();
						mPanelCentre.add(mPanelClientTable,BorderLayout.CENTER);
				        jLabel1.setText("  Liste  des Clients disponibles ");
				    	mPanelCentre.repaint();
						mPanelCentre.revalidate();
						mPanelCentre.setVisible(true);
						mButtonAddAdd.setText("Ajouter Le Client");
						jd.setVisible(false);
						jd.dispose();
				}
						}	
					});
					}
				//// premiere if ..       et else =>..
						else {
				        
						if(ListClient.getSelectedRow() == -1 || ListVoiture.getSelectedRow() == -1 ) {   
							
							JOptionPane.showMessageDialog(jd, " Vous devez choisir un Client et une Voiture !!! ","Erreur Location",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
								mTableEmprunt.setEnabled(true);
								mTableEmpruntTitre.addRow(new Object[]{
										JLocation.mTxtVoitureM.getText().toString(),
							        	JLocation.mTxtVoitureP.getText().toString(),
							        	  JClient.mTxtVoitureDatePrdct.getText().toString(),
							        	  JVoiture.mTxtVoitureMatricule.getText().toString(),
							        	  mTxtNumLoc.getText().toString(),
							        	  mTxtPrixLoc.getText().toString(),
							        	  mTxtTypePay.getText().toString()
							        	  });
								jd.setVisible(false);
								jd.dispose();
							}
						mBtnEmpruntAdd.setText("Ajouter Une Location");
				//		resetForm();
				//		setFormEnable(false) ;
						
						jd.setVisible(false);
						jd.dispose();
						}
				
				mPanelBtns.add(mButtonAddAnu);
				mButtonAddAnu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						jd.setVisible(false);
						jd.dispose();
						
					}
				});
				jd.getContentPane().add(mPanelBtns, BorderLayout.SOUTH);
				//JDialg
				jd.setSize(600, 300);
				jd.setAlwaysOnTop(true);
				jd.setModal(true);
			
			}
		});
		mBtnEmpruntDel.setEnabled(false);
		mBtnEmpruntDel.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mTableEmprunt.getSelectedRow() > -1) 
				{
					if(JOptionPane.showConfirmDialog(
							mFram,
							"Voulez vous vraiment supprimer cette location ?",
							"Supprimer",
							JOptionPane.OK_CANCEL_OPTION
						)==0
						)
					{
						mTableEmpruntTitre.removeRow(mTableEmprunt.getSelectedRow());
					}
				}
				
			}
		});
		mBtnEmpruntAnu.setEnabled(false);
		
		CalculMontant.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{    
				
				String a =  JLocation.mTxtVoitureM.getText().toString();
				String b= JLocation.mTxtVoitureP.getText().toString();
				float c;
				float p;
		    	p=Float.valueOf(mTxtPrixLoc.getText().toString());
		    	c = location.Location.getDayCount(a, b);
		    	float r=c*p;
		    	String P=String.valueOf(r);
		        JOptionPane d = new JOptionPane();
		        d.showMessageDialog( null, " Le montant de la location numéro  "+mTxtNumLoc.getText().toString()+" est  :  " +P+" Dhs ",

	                     "Calcul montant",

	                     JOptionPane.INFORMATION_MESSAGE);
}
});
		
		
		/* Listner Button annuler */
		mBtnEmpruntAnu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mBtnEmpruntAdd.setEnabled(true);
				mBtnEmpruntAnu.setEnabled(false);
				mBtnEmpruntDel.setEnabled(false);
			}
		});
		
	}
	private void resetForm()
	{
		mTxtNumLoc.setText("");
		mTxtPrixLoc.setText("");
		mTxtTypePay.setText("");
		mTxtVoitureM.setText("");
		mTxtVoitureP.setText("");
	}
	
	private void setFormEnable(Boolean b)
	{
		mTxtNumLoc.setEnabled(b);
		mTxtPrixLoc.setEnabled(b);
		mTxtTypePay.setEnabled(b);
		mTxtVoitureM.setEnabled(b);
		mTxtVoitureP.setEnabled(b);
       }
	
}
