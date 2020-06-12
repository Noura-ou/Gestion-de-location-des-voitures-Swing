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


public class JDocument extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();

	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;
	
	private JPanel mPanelVoitureForm;
	private JTextField mTxtnumeroclient = new JTextField("",30),
			   mTxtcin= new JTextField("",30),
			   mTxtpermis = new JTextField("",30),
			   mTxtjust = new JTextField("",30);
	        
	
	private JLabel  numClient= new JLabel("Numéro Client"),
			cin = new JLabel("CIN "),
	        permis = new JLabel("Permis de conduire "),
		    just = new JLabel("Justificatif de domicile (Attribué ou NON ) ?");
		    
	private JPanel mPanelVoitureMilieu = new JPanel();
	
	private JTable mTableLivre = new JTable();
	
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel ;

	private JPanel Test = new JPanel();
	
	private DefaultTableModel mTableLivreModel = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	public JDocument(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(255, 160, 122));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setText("  Espace de Gestion des Documents ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\NOURA\\gesrg\\i2.jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jIcon.setIcon(imageIcon); 
        
        mPanelEntete.add(jLabelEntete);
        mPanelEntete.add(jIcon);
        
        
        //MILIEU :
        mPanelVoitureForm = new JPanel();
      
        
        mPanelVoitureForm.setLayout(new GridLayout(5,2));
        
        
        numClient.setFont(new Font("Yu Mincho Light", 1, 13));
        numClient.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(numClient);
        mPanelVoitureForm.add(mTxtnumeroclient);
        cin.setFont(new Font("Yu Mincho Light", 1, 13)); 
        cin.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(cin);
        mPanelVoitureForm.add(mTxtcin);
        permis.setFont(new Font("Yu Mincho Light", 1, 13)); 
        permis.setForeground(new Color(71, 74, 74));
        mPanelVoitureForm.add(permis);
        mPanelVoitureForm.add(mTxtpermis);
		just.setFont(new Font("Yu Mincho Light", 1, 13)); 
		just.setForeground(new Color(71, 74, 74));
		mPanelVoitureForm.add(just);
		mPanelVoitureForm.add(mTxtjust);
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
		 
        mBtnLivreAdd = new JButton("Nouveau Client");
        mBtnLivreEdit = new JButton("Modifier");
        mBtnLivreDel= new JButton("Supprimer");
       
        
        mPanelFooter.add(mBtnLivreAdd);
        mPanelFooter.add(mBtnLivreEdit);
        mPanelFooter.add(mBtnLivreDel);
      
        
        mPanelFooter.setBackground(new Color(250,175,175));
        mPanelVoitureMilieu.add(mPanelFooter,BorderLayout.SOUTH);
        this.add(mPanelEntete, BorderLayout.NORTH);
       
        mTableLivre.setModel(mTableLivreModel);
        mTableLivreModel.addColumn("Numéro Client");
     	mTableLivreModel.addColumn("CIN du client");
     	mTableLivreModel.addColumn("Permis de conduire");
     	mTableLivreModel.addColumn("Justificatif de domicile");
     		
	    mTableLivre.setBackground(new Color(255,255,255));
	    
        JScrollPane  mPanelVoitureTable;
        mPanelVoitureTable= new JScrollPane(mTableLivre);
        mPanelVoitureMilieu.add(mPanelVoitureTable,BorderLayout.CENTER);
        mPanelVoitureTable.setPreferredSize(new Dimension(200, 600));
        mPanelVoitureTable.setBorder(BorderFactory.createTitledBorder(" Tableau des Documents "));
        mPanelVoitureTable.setBackground(new Color(255,200,0));
   	
	
		
		mTableLivre.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableLivre.getSelectedRow() > -1) 
				{
					mTxtnumeroclient.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 1).toString());
					mTxtcin.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 0).toString());
					mTxtpermis.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 2).toString());
					mTxtjust.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 3).toString());
					mBtnLivreAdd.setEnabled(true);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					
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
				if(mBtnLivreAdd.getText().equals("Nouveau Client"))
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
								mTxtnumeroclient.getText().toString(),
								mTxtcin.getText().toString(),
								mTxtpermis.getText().toString(),
								mTxtjust.getText().toString(),
								});
				
					mBtnLivreAdd.setText("Nouveau Client");
					resetForm();
					setFormEnable(false);
					mTableLivre.setEnabled(true);
					
				}
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
						mTableLivre.setValueAt(mTxtnumeroclient.getText().toString() ,mTableLivre.getSelectedRow(), 0);
						mTableLivre.setValueAt(mTxtcin.getText().toString()  ,mTableLivre.getSelectedRow(), 1);
						mTableLivre.setValueAt(mTxtpermis.getText().toString() ,mTableLivre.getSelectedRow(), 2);
						mTableLivre.setValueAt(mTxtjust.getText().toString()  ,mTableLivre.getSelectedRow(), 3);					
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
						resetForm();
					}
				}
				
			}
		});
		
		
		
	}
	private void resetForm()
	{
		mTxtnumeroclient.setText("");
		mTxtcin.setText("");
		mTxtpermis.setText("");
		mTxtjust.setText("");
	}
	
	private void setFormEnable(Boolean b)
	{
		mTxtnumeroclient.setEnabled(b);
		mTxtcin.setEnabled(b);
		mTxtpermis.setEnabled(b);
		mTxtjust.setEnabled(b);
       }
	
}
