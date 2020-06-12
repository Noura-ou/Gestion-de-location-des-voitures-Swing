package Gestion_Loc_Git;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import Gestion_Loc_Git.JAgence;

public class Acceuil extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JPanel mypanel = new JPanel();
	public Acceuil() {
		super("Agence de location des voitures Nisrine & NOURA ");

		Image icon =Toolkit.getDefaultToolkit().getImage("C:\\Users\\NOURA\\gesrg\\i2.jpg");
		setIconImage (icon);
		
		jButton1  = new JButton("   START   ");
	    jButton1.setBackground(new Color(154, 131, 155));
        jButton1.setFont(new Font("Arial", 8, 35)); 
	    jButton1.setForeground(new Color(255,255, 255));
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        jButton1.setHorizontalTextPosition(SwingConstants.LEFT);
        
        jButton1.addActionListener(this);
        
        mypanel.add(jButton1);
        add(mypanel,BorderLayout.SOUTH);
        
 		// Image De l'acceuil :
		try {
           
            this.getContentPane().add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\NOURA\\gesrg\\im1.jpeg")))),BorderLayout.CENTER);
            //      Graphics.drawImage(background,0,0,this.getWidth() , this.getHeight(), this);
            
        } catch (IOException e) {
            e.printStackTrace();
           
            
        } 
		
     
        setSize(800,600);
    	setVisible(true);
    	setLocationRelativeTo(null);
    	setResizable(false);
	}

	public static void main(String[] args) {
		Acceuil a = new Acceuil();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new JAgence();
	}

}









