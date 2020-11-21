package wdp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Message5 extends JDialog{
	
	JPanel panel1 = new JPanel();
	JLabel lblPrix;
	JButton btnAccepter;
	String answer=new String("");
	JRadioButton rdbtnNewRadioButton_1, rdbtnNewRadioButton;
	private JLabel lblNomDeBenchmark;
	private JLabel label;
	private JLabel lblMthodeApplique;
	private JLabel label_2;
	private JLabel lblNombreDoffres;
	private JLabel label_9;
	private JLabel lblNombreDobjets;
	private JLabel label_11;
			
	    void button_Clicked(java.awt.event.ActionEvent event) 
	    {
	        answer="yes";  
            dispose();
        }
		
		public Message5 (Frame parent, boolean modal) {

		    super(parent, modal);
     		panel1.setLayout(null);
	        panel1.setSize(360, 220) ;
	        panel1.setBackground(SystemColor.control);
	        getContentPane().add(panel1);
	        
	        lblPrix = new JLabel("Voici les informations concernant");
	        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPrix.setForeground(Color.BLACK);
	        lblPrix.setBackground(SystemColor.control);
	        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPrix.setBounds(10, 11, 316, 40);
	        panel1.add(lblPrix);
	        
	        btnAccepter = new JButton("Ok");
	        btnAccepter.setToolTipText("Alt + O");
	        btnAccepter.setMnemonic('O');
	        btnAccepter.setBackground(UIManager.getColor("Button.background"));
	        btnAccepter.setForeground(Color.BLACK);
	        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnAccepter.setBounds(106, 244, 111, 33);
	        panel1.add(btnAccepter);
	        
	        JLabel lblVeuillezChoisirLa = new JLabel(" cette ench\u00E8re");
	        lblVeuillezChoisirLa.setHorizontalAlignment(SwingConstants.CENTER);
	        lblVeuillezChoisirLa.setForeground(Color.BLACK);
	        lblVeuillezChoisirLa.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblVeuillezChoisirLa.setBackground(SystemColor.menu);
	        lblVeuillezChoisirLa.setBounds(10, 48, 316, 40);
	        panel1.add(lblVeuillezChoisirLa);
	        
	        lblNomDeBenchmark = new JLabel("Nom de Benchmark : ");
	        lblNomDeBenchmark.setForeground(Color.BLACK);
	        lblNomDeBenchmark.setBounds(20, 99, 131, 23);
	        panel1.add(lblNomDeBenchmark);
	        
	        label = new JLabel("");
	        label.setForeground(Color.BLACK);
	        label.setBounds(175, 99, 151, 23);
	        panel1.add(label);
	        
	        lblMthodeApplique = new JLabel("   M\u00E9thode Appliqu\u00E9e : ");
	        lblMthodeApplique.setForeground(Color.BLACK);
	        lblMthodeApplique.setBounds(10, 133, 141, 23);
	        panel1.add(lblMthodeApplique);
	        
	        label_2 = new JLabel("");
	        label_2.setForeground(Color.BLACK);
	        label_2.setBounds(175, 133, 151, 23);
	        panel1.add(label_2);
	        
	        lblNombreDoffres = new JLabel("Nombre d'offres : ");
	        lblNombreDoffres.setForeground(Color.BLACK);
	        lblNombreDoffres.setBounds(20, 164, 131, 23);
	        panel1.add(lblNombreDoffres);
			
	        label_9 = new JLabel("");
	        label_9.setForeground(Color.BLACK);
	        label_9.setBounds(175, 164, 151, 23);
	        panel1.add(label_9);
	        
	        lblNombreDobjets = new JLabel("Nombre d'objets : ");
	        lblNombreDobjets.setForeground(Color.BLACK);
	        lblNombreDobjets.setBounds(20, 198, 131, 23);
	        panel1.add(lblNombreDobjets);
	        
	        label_11 = new JLabel("");
	        label_11.setForeground(Color.BLACK);
	        label_11.setBounds(175, 198, 151, 23);
	        panel1.add(label_11);
	       	        
	        JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("photo/2Bis.jpg"));
			lblNewLabel_4.setBounds(0, 0, 336, 291);
			panel1.add(lblNewLabel_4);
			
			setSize(352,329);
			setTitle("Informations sur l'ench\u00E8re");	
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
	    
	    public void setNomBenchmark(String msg)
	    {
	    	label.setText(msg);
	    }
	    public void setNomMethode(String msg)
	    {
	    	label_2.setText(msg);
	    }
	    public void setNbOffres(String msg)
	    {
	    	label_9.setText(msg);
	    }
	    public void setNbObjets(String msg)
	    {
	    	label_11.setText(msg);
	    }
	}
