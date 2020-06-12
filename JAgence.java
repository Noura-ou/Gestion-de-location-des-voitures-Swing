package Gestion_Loc_Git;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class JAgence extends JFrame
{	
	private JLabel background;
	private JFrame mFram = new JFrame(" Agence ");
	private JTabbedPane mTabbledPane=new JTabbedPane();
	private JVoiture mPanelLivre = new JVoiture(mFram);
	private JClient mPanelClients = new JClient(mFram);
	private JLocation mPanelLoc = new JLocation(mFram);
	private JDocument mPanelDoc = new JDocument(mFram);
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	public JAgence()
	{
		
		super("  Agence NOURA & NISRINE ;) ");
// Image icone 
		Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\NOURA\\gesrg\\i2.jpg");
		setIconImage (icon);
	 
// L'ajout de Mes espaces  à mon JTabbedPane pour les afficher comme des onglets
		
		tabbedPane.addTab("Espace Voitures", mPanelLivre);
        tabbedPane.addTab("Espace Clients  ", mPanelClients);
        tabbedPane.addTab("Espace Locations", mPanelLoc);
        tabbedPane.addTab("Espace Documents Clients", mPanelDoc);
		
		setSize(1000, 725);
	
		add(tabbedPane);
		
		setVisible(true);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				if(JOptionPane.showConfirmDialog(
						mFram,"Voulez vous vraiment fermer l'application ?",
						"Fermer Agence",
						JOptionPane.OK_CANCEL_OPTION) == 0)
					System.exit(1);
			}
		});
	}
	private static JPanel makePanel(String text) {
        JPanel p = new JPanel();
        p.add(new Label(text));
        p.setLayout(new GridLayout(1, 1));
        return p;
    }

}
