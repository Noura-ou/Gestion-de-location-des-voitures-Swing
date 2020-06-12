package Gestion_Loc_Git;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class JClient extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();
    JFrame l;
	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;
	private JPanel mPanelVoitureForm;
	public static JTextField mTxtVoiturePrix = new JTextField("",25);
	public static JTextField mTxtVoitureModele= new JTextField("",25),
			   mTxtVoitureDatePrdct = new JTextField("",25),
					   mTxtVoitureMarque = new JTextField("",25);
	
	JLabel marque = new JLabel("Nom"),
		   modele= new JLabel("Prénom"),
		   prod= new JLabel("Num client"),
		   prix= new JLabel("Type Client ? (professionnel/Normal)");
	
	private JPanel mPanelVoitureMilieu = new JPanel();
	
	private JPanel mPanelVoitureTable = new JPanel();
	
	public static JTable mTableLivre = new JTable();
	
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel ;

	private JPanel Test = new JPanel();

	
	
	private DefaultTableModel mTableLivreModel = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	public JClient(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(0, 188, 9));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setForeground(new Color(255, 255, 255));
        jLabelEntete.setText("  Espace de Gestion des Clients ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\NOURA\\gesrg\\i2.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jIcon.setIcon(imageIcon); 
        
        mPanelEntete.add(jLabelEntete);
        mPanelEntete.add(jIcon);
		
        
      //MILIEU :
        mPanelVoitureForm = new JPanel();

        
        mPanelVoitureForm.setLayout(new GridLayout(5,2));
        
        marque.setFont(new Font("Yu Mincho Light", 1, 13));
        marque.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(marque);
        mPanelVoitureForm.add(mTxtVoitureMarque);
        modele.setFont(new Font("Yu Mincho Light", 1, 13)); 
        modele.setForeground(new Color(71, 74, 74));
        
        mPanelVoitureForm.add(modele);
        mTxtVoitureModele.setPreferredSize(new Dimension(20, 5));
        mPanelVoitureForm.add(mTxtVoitureModele);
        prod.setFont(new Font("Yu Mincho Light", 1, 13)); 
        prod.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(prod);
        mPanelVoitureForm.add(mTxtVoitureDatePrdct);
		prix.setFont(new Font("Yu Mincho Light", 1, 13)); 
		prix.setForeground(new Color(71, 74, 74));
		mPanelVoitureForm.add(prix);
		mPanelVoitureForm.add(mTxtVoiturePrix);
		//mPanelVoitureForm.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setLayout(new BorderLayout());
		Test.setLayout(new FlowLayout());
		Test.add(mPanelVoitureForm);
		//Test.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setBackground(new Color(179, 204, 204));
		mPanelVoitureMilieu.add(Test,BorderLayout.NORTH);
		
		this.add(mPanelVoitureMilieu, BorderLayout.CENTER);
		 /// FOOTER :
		/// FOOTER :
				mPanelFooter = new JPanel();
				mPanelFooter.setLayout(new FlowLayout());
				 
				 
		        mBtnLivreAdd = new JButton("Nouveau client");
		        mBtnLivreEdit = new JButton("Modifier");
		        mBtnLivreDel= new JButton("Supprimer");
		
			
		        mPanelFooter.add(mBtnLivreAdd);
		        mPanelFooter.add(mBtnLivreEdit);
		        mPanelFooter.add(mBtnLivreDel);
		
		      
		        
		        mPanelFooter.setBackground(new Color(251,127,127));
		        mPanelVoitureMilieu.add(mPanelFooter,BorderLayout.SOUTH);
		        this.add(mPanelEntete, BorderLayout.NORTH);
		        
		        mPanelVoitureTable.setBackground(new Color(254,156,156));
		        mPanelVoitureTable.setLayout(new FlowLayout());
		        mPanelVoitureTable.add(new JScrollPane(mTableLivre));
		        mPanelVoitureMilieu.add(mPanelVoitureTable,BorderLayout.CENTER);
		        
		        mTableLivre.setModel(mTableLivreModel);
		        mTableLivreModel.addColumn("Nom ");
				mTableLivreModel.addColumn("Prénom");
				mTableLivreModel.addColumn("Num client");
				mTableLivreModel.addColumn("Type Client");
				
				mTableLivre.setBackground(new Color(255,255,220));
				 
				  
		        JScrollPane  mPanelVoitureTable;
		        mPanelVoitureTable= new JScrollPane(mTableLivre);
		        mPanelVoitureMilieu.add(mPanelVoitureTable,BorderLayout.CENTER);
		        mPanelVoitureTable.setPreferredSize(new Dimension(200, 600));
		        mPanelVoitureTable.setBorder(BorderFactory.createTitledBorder("Tableau des clients"));
		        mPanelVoitureTable.setBackground(new Color(95,158,160));
		   
		
		mTableLivre.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableLivre.getSelectedRow() > -1) 
				{
					JClient.mTxtVoitureMarque.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 0).toString());
					JClient.mTxtVoitureModele.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 1).toString());
					JClient.mTxtVoitureDatePrdct.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 2).toString());
					JClient.mTxtVoiturePrix.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 3).toString());
					
					 
					mBtnLivreAdd.setEnabled(true);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					
				}
			}
		});
		
		JLocation.ListClient.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (JLocation.ListClient.getSelectedRow() > -1) 
				{
				
					JClient.mTxtVoitureMarque.setText(JLocation.ListClient.getValueAt(JLocation.ListClient.getSelectedRow(), 0).toString());
					JClient.mTxtVoitureModele.setText(JLocation.ListClient.getValueAt(JLocation.ListClient.getSelectedRow(), 1).toString());
					JClient.mTxtVoitureDatePrdct.setText(JLocation.ListClient.getValueAt(JLocation.ListClient.getSelectedRow(), 2).toString());
					JClient.mTxtVoiturePrix.setText(JLocation.ListClient.getValueAt(JLocation.ListClient.getSelectedRow(), 3).toString());
					setFormEnable(true);
				}
			}
		});
		
		
		//DEBUT
		
		setFormEnable(false);
		mBtnLivreEdit.setEnabled(true);
		mBtnLivreDel.setEnabled(true);
		
		
		/* Listner Button ajouter */
		mBtnLivreAdd.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{		
				if(mBtnLivreAdd.getText().equals("Nouveau client"))
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
							 JClient.mTxtVoitureMarque.getText().toString(),
							 JClient.mTxtVoitureModele.getText().toString(),
							 JClient.mTxtVoitureDatePrdct.getText().toString(),
							 JClient.mTxtVoiturePrix.getText().toString()});
					 
					 JLocation.mTableClientModel.addRow(new Object[]{
							 JClient.mTxtVoitureMarque.getText().toString(),
							 JClient.mTxtVoitureModele.getText().toString(),
							 JClient.mTxtVoitureDatePrdct.getText().toString(),
							 JClient.mTxtVoiturePrix.getText().toString()});
					 
				
					mBtnLivreAdd.setText("Nouveau client");
					resetForm();
					setFormEnable(false);
					mTableLivre.setEnabled(true);
					
					
				}
			}
		});
		
		
		/* Listner Button Modifier*/
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
						mTableLivre.setValueAt(mTxtVoitureDatePrdct.getText().toString()  ,mTableLivre.getSelectedRow(), 1);
						mTableLivre.setValueAt( mTxtVoitureModele.getText().toString() ,mTableLivre.getSelectedRow(), 2);
						mTableLivre.setValueAt(mTxtVoiturePrix.getText().toString()  ,mTableLivre.getSelectedRow(), 3);					
			
					mBtnLivreAdd.setEnabled(true);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					setFormEnable(false);
					resetForm();
					
				}
			}
			}
		});
		/* Listner Button supprimer */
		mBtnLivreDel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mTableLivre.getSelectedRow() > -1) 
				{
					if(JOptionPane.showConfirmDialog(
							mFram,
							"Voulez vous vraiment supprimer ce client ?",
							"Confirmez",
							JOptionPane.OK_CANCEL_OPTION
						)==0
						)
					{
					//	/mAgence.retirerLivre(mTableLivre.getSelectedRow());/
						mTableLivreModel.removeRow(mTableLivre.getSelectedRow());
					JLocation.mTableClientModel.removeRow(mTableLivre.getSelectedRow());
						resetForm();
					}
				}
				
			}
		});
		
		
		
	}
	//Retourne le nombre de lignes
    public int getRowCount() {
      return mTableLivre.getComponentCount();
    }
	private void resetForm()
	{
		mTxtVoitureMarque.setText("");
		mTxtVoitureDatePrdct.setText("");
		mTxtVoitureModele.setText("");
		mTxtVoiturePrix.setText("");
	}
	
	private void setFormEnable(Boolean b)
	{
		mTxtVoitureMarque.setEnabled(b);
		mTxtVoitureDatePrdct.setEnabled(b);
		mTxtVoitureModele.setEnabled(b);
		mTxtVoiturePrix.setEnabled(b);
       }
	

}
