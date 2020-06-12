
package Gestion_Loc_Git;

import location.Voiture;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Gestion_Loc_Git.JLocation;

public class JVoiture extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();

	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;
	
	JFrame f;
	JFrame l;
	private JPanel mPanelVoitureForm;
	public static JTextField mTxtVoitureMatricule = new JTextField("",30),
			   mTxtVoitureType= new JTextField("",30),
			   mTxtVoitureMarque = new JTextField("",30),
			  mTxtVoiturePrix = new JTextField("",30),
	         mTxtVoitureLouee = new JTextField("",30);
	
	private JLabel  matricule= new JLabel("Matricule"),
			type = new JLabel("Type Voiture"),
	        marque = new JLabel("Marque"),
		    prix= new JLabel("Prix Voiture"),
		    voitureLouee = new JLabel("Voiture Louée ? (OUI/NON)");
	
	private JPanel mPanelVoitureMilieu = new JPanel();
	
	private JTable mTableLivre = new JTable();
	
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel,mBCalculGarantie ;

	private JPanel Test = new JPanel();
	
	private DefaultTableModel mTableLivreModel = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	public JVoiture(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(255, 160, 122));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setText("  Espace de Gestion des Voitures ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\NOURA\\gesrg\\i2.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jIcon.setIcon(imageIcon); 
        
        mPanelEntete.add(jLabelEntete);
        mPanelEntete.add(jIcon);
        
        
        //MILIEU :
        mPanelVoitureForm = new JPanel();
       
        
        mPanelVoitureForm.setLayout(new GridLayout(5,2));
        
        
        matricule.setFont(new Font("Yu Mincho Light", 1, 13));
        matricule.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(matricule);
        mPanelVoitureForm.add(mTxtVoitureMatricule);
        marque.setFont(new Font("Yu Mincho Light", 1, 13)); 
        marque.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(marque);
        mPanelVoitureForm.add(mTxtVoitureMarque);
        type.setFont(new Font("Yu Mincho Light", 1, 13)); 
        type.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(type);
        mPanelVoitureForm.add(mTxtVoitureType);
		prix.setFont(new Font("Yu Mincho Light", 1, 13)); 
		prix.setForeground(new Color(71, 74, 74));
		mPanelVoitureForm.add(prix);
		mPanelVoitureForm.add(mTxtVoiturePrix);
		voitureLouee.setFont(new Font("Yu Mincho Light", 1, 13)); 
		voitureLouee.setForeground(new Color(71, 74, 74));
		mPanelVoitureForm.add(voitureLouee);
		mPanelVoitureForm.add(mTxtVoitureLouee);
		//mPanelVoitureForm.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setLayout(new BorderLayout());
		Test.setLayout(new FlowLayout());
		Test.add(mPanelVoitureForm);
		//Test.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setBackground(new Color(179, 204, 204));
		mPanelVoitureMilieu.add(Test,BorderLayout.NORTH);
		
		this.add(mPanelVoitureMilieu, BorderLayout.CENTER);
		
        /// FOOTER :
		mPanelFooter = new JPanel();
		mPanelFooter.setLayout(new FlowLayout());
		 
        mBtnLivreAdd = new JButton("Nouvelle Voiture");
        mBtnLivreEdit = new JButton("Modifier");
        mBtnLivreDel= new JButton("Supprimer");
        mBCalculGarantie= new JButton("Calcul Garantie d'une Voiture");
        
        mPanelFooter.add(mBtnLivreAdd);
        mPanelFooter.add(mBtnLivreEdit);
        mPanelFooter.add(mBtnLivreDel);
        mPanelFooter.add(mBCalculGarantie);
        
        mPanelFooter.setBackground(new Color(255,200,250));
        mPanelVoitureMilieu.add(mPanelFooter,BorderLayout.SOUTH);
        this.add(mPanelEntete, BorderLayout.NORTH);
       
        mTableLivre.setModel(mTableLivreModel);
        mTableLivreModel.addColumn("Matricule");
     		mTableLivreModel.addColumn("Marque");
     		mTableLivreModel.addColumn("Type Voiture");
     		mTableLivreModel.addColumn("Prix Voiture");
     		mTableLivreModel.addColumn("Voiture Louée ?");
      
      
	    mTableLivre.setBackground(new Color(255,255,220));
	    
        JScrollPane  mPanelVoitureTable;
        mPanelVoitureTable= new JScrollPane(mTableLivre);
        mPanelVoitureMilieu.add(mPanelVoitureTable,BorderLayout.CENTER);
        mPanelVoitureTable.setPreferredSize(new Dimension(200, 600));
        mPanelVoitureTable.setBorder(BorderFactory.createTitledBorder(" Tableau des Voitures "));
        mPanelVoitureTable.setBackground(new Color(255,200,0));
   
		  
		
		
		mTableLivre.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableLivre.getSelectedRow() > -1) 
				{
					JVoiture.mTxtVoitureMarque.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 1).toString());
					JVoiture.mTxtVoitureMatricule.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 0).toString());
					JVoiture.mTxtVoitureType.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 2).toString());
					JVoiture.mTxtVoiturePrix.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 3).toString());
					JVoiture.mTxtVoitureLouee.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 4).toString());
				
					mBtnLivreAdd.setEnabled(true);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					
				}
			}
		});
		
		JLocation.ListVoiture.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (JLocation.ListVoiture.getSelectedRow() > -1) 
				{
					JVoiture.mTxtVoitureMarque.setText(JLocation.ListVoiture.getValueAt(JLocation.ListVoiture.getSelectedRow(), 1).toString());
					JVoiture.mTxtVoitureMatricule.setText(JLocation.ListVoiture.getValueAt(JLocation.ListVoiture.getSelectedRow(), 0).toString());
					JVoiture.mTxtVoitureType.setText(JLocation.ListVoiture.getValueAt(JLocation.ListVoiture.getSelectedRow(), 2).toString());
					JVoiture.mTxtVoiturePrix.setText(JLocation.ListVoiture.getValueAt(JLocation.ListVoiture.getSelectedRow(), 3).toString());
					JVoiture.mTxtVoitureLouee.setText(JLocation.ListVoiture.getValueAt(JLocation.ListVoiture.getSelectedRow(), 4).toString());	
					
				}
			}
		});
	
		//DEBUT
		
		setFormEnable(false);
		mBtnLivreEdit.setEnabled(true);
		mBtnLivreDel.setEnabled(true);
		
		
		// Listner Button ajouter 
		mBtnLivreAdd.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{		
				if(mBtnLivreAdd.getText().equals("Nouvelle Voiture"))
				{
					mTableLivre.setEnabled(false);
					mTableLivre.getSelectionModel().clearSelection();
					mBtnLivreAdd.setText("Ajouter");
					resetForm();
					setFormEnable(true);
					
					
				}
				else
				{
					 mTableLivreModel.addRow(new Object[]{
							 JVoiture.mTxtVoitureMatricule.getText().toString(),
							 JVoiture.mTxtVoitureMarque.getText().toString(),
							 JVoiture.mTxtVoitureType.getText().toString(),
							 JVoiture.mTxtVoiturePrix.getText().toString(),
							 JVoiture.mTxtVoitureLouee.getText().toString()
								});
					 
					 JLocation.mTableVoitureModel.addRow(new Object[]{
							 JVoiture.mTxtVoitureMatricule.getText().toString(),
							 JVoiture.mTxtVoitureMarque.getText().toString(),
							 JVoiture.mTxtVoitureType.getText().toString(),
							 JVoiture.mTxtVoiturePrix.getText().toString(),
							 JVoiture.mTxtVoitureLouee.getText().toString()
								});
					 
					 
				
					mBtnLivreAdd.setText("Nouvelle Voiture");
					resetForm();
					setFormEnable(false);
					mTableLivre.setEnabled(true);
					
				}
			}
		});
	
		// Listner Button Calcul Garantie
		mBCalculGarantie.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{      f=new JFrame();   
		    String type=JOptionPane.showInputDialog(f,"Entrez le type de la Voiture...");
		    l=new JFrame();
		    String prix =JOptionPane.showInputDialog(l,"Entrez le prix de la Voiture..."); 
		    double garantie;
		   int prx = Integer.parseInt( prix );
		  garantie = Voiture.calculGarantie(type, prx);
		    JOptionPane.showMessageDialog( null, "la garantie de cette voiture de type "+" " + type + " " + " est de " + " "+ garantie,
		            "Calcul Garantie ", JOptionPane.PLAIN_MESSAGE );
			}
		});
		
		// Listner Button Modifier
		mBtnLivreEdit.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				if(mBtnLivreEdit.getText().equals("Modifier"))
				{
					mBtnLivreEdit.setText("Confirmer");
					setFormEnable(true);
					
				}
				else
				{
					mBtnLivreEdit.setText("Modifier");
					mTableLivre.setEnabled(true);
					if (mTableLivre.getSelectedRow() > -1) 
					{
						mTableLivre.setValueAt(mTxtVoitureMarque.getText().toString() ,mTableLivre.getSelectedRow(), 0);
						mTableLivre.setValueAt(mTxtVoitureMatricule.getText().toString()  ,mTableLivre.getSelectedRow(), 1);
						mTableLivre.setValueAt(mTxtVoitureType.getText().toString() ,mTableLivre.getSelectedRow(), 2);
						mTableLivre.setValueAt(mTxtVoiturePrix.getText().toString()  ,mTableLivre.getSelectedRow(), 3);					
						mTableLivre.setValueAt(mTxtVoitureLouee.getText().toString()  ,mTableLivre.getSelectedRow(), 4);	
						
					mBtnLivreAdd.setEnabled(true);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					setFormEnable(false);
					resetForm();
					
				}
			}
			}
		});
	//	 Listner Button supprimer 
		mBtnLivreDel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mTableLivre.getSelectedRow() > -1) 
				{
					if(JOptionPane.showConfirmDialog(
							mFram,
							"Voulez vous vraiment supprimer cette Voiture ?",
							"Confirmez",
							JOptionPane.YES_NO_CANCEL_OPTION
						)==0
						)
				{
				
						mTableLivreModel.removeRow(mTableLivre.getSelectedRow());
						JLocation.mTableVoitureModel.removeRow(mTableLivre.getSelectedRow());
						resetForm();
					}
				}
				
			}
		});
		
		
		
	}
	private void resetForm()
	{
		mTxtVoitureMarque.setText("");
		mTxtVoitureMatricule.setText("");
		mTxtVoitureType.setText("");
		mTxtVoiturePrix.setText("");
		mTxtVoitureLouee.setText("");
	}
	
	private void setFormEnable(Boolean b)
	{
		mTxtVoitureMarque.setEnabled(b);
		mTxtVoitureMatricule.setEnabled(b);
		mTxtVoitureType.setEnabled(b);
		mTxtVoiturePrix.setEnabled(b);
		mTxtVoitureLouee.setEnabled(b);
       }
	
}
