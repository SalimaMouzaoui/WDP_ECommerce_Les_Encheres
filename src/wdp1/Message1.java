package wdp1;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Message1 extends JDialog{
	
	JPanel panel1 = new JPanel();
	JLabel lblPrix;
	JButton btnAccepter;
	JButton btnRefuser;
	String answer=new String("");
	JRadioButton rdbtnNewRadioButton_1, rdbtnNewRadioButton, radioButton;
	String nomMethod;
			
	    void button_Clicked(java.awt.event.ActionEvent event) 
	    {
	        answer="yes";  
            dispose();
        }
	    
	    void button1_Clicked(java.awt.event.ActionEvent event) 
	    {
	    	answer="no";    
            dispose();
        }
		
		public Message1 (Frame parent, boolean modal) {

		    super(parent, modal);
     		panel1.setLayout(null);
	        panel1.setSize(360, 220) ;
	        panel1.setBackground(SystemColor.control);
	        getContentPane().add(panel1);
	        
	        lblPrix = new JLabel("Veuillez choisir la m\u00E9thode ");
	        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPrix.setForeground(Color.BLACK);
	        lblPrix.setBackground(SystemColor.control);
	        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPrix.setBounds(10, 11, 316, 40);
	        panel1.add(lblPrix);
	        
	        btnAccepter = new JButton("Ok");
	        btnAccepter.setToolTipText("Alt + O");
	        btnAccepter.setMnemonic('O');
	        btnAccepter.setVisible(false);
	        btnAccepter.setBackground(UIManager.getColor("Button.background"));
	        btnAccepter.setForeground(Color.BLACK);
	        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnAccepter.setBounds(21, 187, 111, 33);
	        panel1.add(btnAccepter);
	        
	        btnRefuser = new JButton("Annuler");
	        btnRefuser.setToolTipText("Alt + A");
	        btnRefuser.setMnemonic('A');
	        btnRefuser.setForeground(Color.BLACK);
	        btnRefuser.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnRefuser.setBounds(198, 187, 103, 33);
	        panel1.add(btnRefuser);
	        
	        JLabel lblVeuillezChoisirLa = new JLabel("\u00E0 appliquer SVP");
	        lblVeuillezChoisirLa.setHorizontalAlignment(SwingConstants.CENTER);
	        lblVeuillezChoisirLa.setForeground(Color.BLACK);
	        lblVeuillezChoisirLa.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblVeuillezChoisirLa.setBackground(SystemColor.menu);
	        lblVeuillezChoisirLa.setBounds(10, 48, 316, 40);
	        panel1.add(lblVeuillezChoisirLa);
	        
	        rdbtnNewRadioButton = new JRadioButton("    M\u00E9thode naive");
	        rdbtnNewRadioButton.setForeground(Color.BLACK);
	        rdbtnNewRadioButton.setBounds(64, 95, 230, 23);
	        panel1.add(rdbtnNewRadioButton);
	        
	        			
	        rdbtnNewRadioButton_1 = new JRadioButton("    Recherche Tabou");
	        rdbtnNewRadioButton_1.setForeground(Color.BLACK);
	        rdbtnNewRadioButton_1.setBounds(64, 121, 214, 23);
	        panel1.add(rdbtnNewRadioButton_1);
	        
	        radioButton = new JRadioButton("    Recherche Locale Stochastique");
	        radioButton.setForeground(Color.BLACK);
	        radioButton.setBounds(64, 147, 230, 23);
	        panel1.add(radioButton);
	       	   
	        JLabel lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setForeground(Color.BLACK);
			lblNewLabel_4.setIcon(new ImageIcon("photo/2.jpg"));
			lblNewLabel_4.setBounds(0, 0, 336, 229);
			panel1.add(lblNewLabel_4);
			
			setSize(352,267);
			setTitle("Choix de m\u00E9thode");	
			this.addWindowListener(new windowEvents());
			SymAction2 lSymAction = new SymAction2();
			radioButton.addActionListener(lSymAction);
			rdbtnNewRadioButton.addActionListener(lSymAction);
			rdbtnNewRadioButton_1.addActionListener(lSymAction);
			SymAction lSymAct = new SymAction();
			btnAccepter.addActionListener(lSymAct);
			btnRefuser.addActionListener(lSymAct);
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
		
		class SymAction2 implements java.awt.event.ActionListener
		{
			public void actionPerformed(java.awt.event.ActionEvent event)
			{
				Object object = event.getSource();
				if (object == radioButton)
					nomMethod = "SLS";
				else if (object == rdbtnNewRadioButton_1)
					nomMethod = "TS";
				else if (object == rdbtnNewRadioButton)
					nomMethod = "NV";
				 if (object == rdbtnNewRadioButton || object == rdbtnNewRadioButton_1
						 || object == radioButton)
					 btnAccepter.setVisible(true);
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
	    
	    public String getNomMethod()
	    {
	    	return nomMethod;
	    }
	}
