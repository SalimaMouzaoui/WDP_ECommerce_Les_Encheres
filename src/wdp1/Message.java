package wdp1;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Message extends JDialog{
	
	JPanel panel1 = new JPanel();
	JLabel lblPrix;
	JButton btnAccepter;
	JButton btnRefuser;
	String answer=new String("");
	String nomFile;
	String pathFile;
	
	    void button_Clicked(java.awt.event.ActionEvent event) 
	    {
	    	DialogFichier f = new DialogFichier();
	    	nomFile = f.nomFile;
	    	pathFile = f.pathFile;
	        answer="yes";  
            dispose();
        }
	    
	    void button1_Clicked(java.awt.event.ActionEvent event) 
	    {
	    	answer="no";    
            dispose();
        }
		
		public Message (Frame parent, boolean modal) {

		    super(parent, modal);
     		panel1.setLayout(null);
	        panel1.setSize(360, 220) ;
	        panel1.setBackground(SystemColor.control);
	        getContentPane().add(panel1);
	        
	        lblPrix = new JLabel("Veuillez choisir un Benchmark SVP");
	        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPrix.setForeground(Color.BLACK);
	        lblPrix.setBackground(SystemColor.control);
	        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPrix.setBounds(10, 59, 316, 40);
	        panel1.add(lblPrix);
	        
	        btnAccepter = new JButton("Ok");
	        btnAccepter.setToolTipText("Alt + O");
	        btnAccepter.setMnemonic('O');
	        btnAccepter.setBackground(UIManager.getColor("Button.background"));
	        btnAccepter.setForeground(Color.BLACK);
	        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnAccepter.setBounds(38, 138, 111, 33);
	        panel1.add(btnAccepter);
	        
	        btnRefuser = new JButton("Annuler");
	        btnRefuser.setToolTipText("Alt + A");
	        btnRefuser.setMnemonic('A');
	        btnRefuser.setForeground(Color.BLACK);
	        btnRefuser.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnRefuser.setBounds(205, 138, 103, 33);
	        panel1.add(btnRefuser);
	       	        
	        JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("photo/2.jpg"));
			lblNewLabel_4.setBounds(0, 0, 336, 229);
			panel1.add(lblNewLabel_4);
			
			setSize(352,267);
			setTitle("Choix de Benchmark");	
			this.addWindowListener(new windowEvents());
			SymAction lSymAction = new SymAction();
			btnAccepter.addActionListener(lSymAction);
			btnRefuser.addActionListener(lSymAction);
		}
		
		class SymAction implements java.awt.event.ActionListener
		{
			public void actionPerformed(java.awt.event.ActionEvent event)
			{
				Object object = event.getSource();
				if (object == btnAccepter)
					button_Clicked(event);
				if (object == btnRefuser)
					button1_Clicked(event);
            }
	    }
		
		class windowEvents extends java.awt.event.WindowAdapter {
	        public void windowClosing(java.awt.event.WindowEvent event) {
	               dispose();
	        }
	    }		
	    
	    public String getAnswer()
	    {
	    	return answer;
	    }
	    
	    public String getNomFile()
	    {
	    	return nomFile;
	    }
	    public String getPathFile()
	    {
	    	return pathFile;
	    }
	}
