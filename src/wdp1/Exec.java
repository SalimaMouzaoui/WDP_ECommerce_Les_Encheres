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

public class Exec extends JDialog{
		
		JPanel panel1 = new JPanel();
		JLabel lblPrix;
		JButton btnAccepter;
		String answer=new String("");
		JRadioButton rdbtnNewRadioButton_1, rdbtnNewRadioButton;
				
		    void button_Clicked(java.awt.event.ActionEvent event) 
		    {
		        answer="yes";  
	            dispose();
	        }
			
			public Exec (Frame parent, boolean modal) {

			    super(parent, modal);
	     		panel1.setLayout(null);
		        panel1.setSize(360, 220) ;
		        panel1.setBackground(SystemColor.control);
		        getContentPane().add(panel1);
		        
		        lblPrix = new JLabel("Ex\u00E9cution en Cours");
		        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		        lblPrix.setForeground(Color.BLACK);
		        lblPrix.setBackground(SystemColor.control);
		        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
		        lblPrix.setBounds(10, 23, 316, 40);
		        panel1.add(lblPrix);
		        
		        btnAccepter = new JButton("Ok");
		        btnAccepter.setToolTipText("Alt + O");
		        btnAccepter.setMnemonic('O');
		        btnAccepter.setBackground(UIManager.getColor("Button.background"));
		        btnAccepter.setForeground(Color.BLACK);
		        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
		        btnAccepter.setBounds(107, 130, 111, 33);
		        panel1.add(btnAccepter);
		        
		        JLabel lblVeuillezChoisirLa = new JLabel("Veuillez patienter");
		        lblVeuillezChoisirLa.setHorizontalAlignment(SwingConstants.CENTER);
		        lblVeuillezChoisirLa.setForeground(Color.BLACK);
		        lblVeuillezChoisirLa.setFont(new Font("Constantia", Font.PLAIN, 18));
		        lblVeuillezChoisirLa.setBackground(SystemColor.menu);
		        lblVeuillezChoisirLa.setBounds(10, 62, 316, 40);
		        panel1.add(lblVeuillezChoisirLa);
		        
		        JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon("photo/2.jpg"));
				lblNewLabel_4.setBounds(0, 0, 336, 215);
				panel1.add(lblNewLabel_4);
		       	        
				setSize(352,253);
				setTitle("Ex\u00E9cution en cours");	
				this.addWindowListener(new windowEvents());
				SymAction lSymAction = new SymAction();
				btnAccepter.addActionListener(lSymAction);
			}
			
			class windowEvents extends java.awt.event.WindowAdapter {
		        public void windowClosing(java.awt.event.WindowEvent event) {
		               dispose();
		        }
		    }
			class SymAction implements java.awt.event.ActionListener
			{
				public void actionPerformed(java.awt.event.ActionEvent event)
				{
					Object object = event.getSource();
					if (object == btnAccepter)
						button_Clicked(event);
	            }
		    }
		    
		    public String getAnswer()
		    {
		    	return answer;
		    }
		    
}