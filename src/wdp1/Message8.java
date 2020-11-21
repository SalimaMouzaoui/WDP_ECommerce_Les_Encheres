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

public class Message8 extends JDialog{
	
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
	private JLabel lblGain;
	private JLabel label_3;
	private JLabel lblOffresGagnante;
	private JLabel label_4;
	private JLabel lblTempsDexcution;
	private JLabel label_5;
			
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
		
		public Message8 (Frame parent, boolean modal) {

		    super(parent, modal);
     		panel1.setLayout(null);
	        panel1.setSize(360, 220) ;
	        panel1.setBackground(SystemColor.control);
	        getContentPane().add(panel1);
	        
	        lblPrix = new JLabel("Fin d'ex\u00E9cution");
	        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPrix.setForeground(Color.BLACK);
	        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPrix.setBounds(10, 11, 316, 40);
	        panel1.add(lblPrix);
	        
	        btnAccepter = new JButton("Ok");
	        btnAccepter.setToolTipText("Alt + O");
	        btnAccepter.setMnemonic('O');
	        btnAccepter.setVisible(true);
	        btnAccepter.setForeground(Color.BLACK);
	        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnAccepter.setBounds(108, 317, 111, 33);
	        panel1.add(btnAccepter);
	        
	        lblNomDeBenchmark = new JLabel("Nom de Benchmark : ");
	        lblNomDeBenchmark.setForeground(Color.BLACK);
	        lblNomDeBenchmark.setBounds(40, 62, 138, 23);
	        panel1.add(lblNomDeBenchmark);
	      		
	        label = new JLabel("");
	        label.setForeground(Color.BLACK);
	        label.setBounds(198, 62, 166, 23);
	        panel1.add(label);
	        
	        lblMthodeApplique = new JLabel("M\u00E9thode Appliqu\u00E9e : ");
	        lblMthodeApplique.setForeground(Color.BLACK);
	        lblMthodeApplique.setBounds(40, 96, 138, 23);
	        panel1.add(lblMthodeApplique);
	        
	        label_2 = new JLabel("");
	        label_2.setForeground(Color.BLACK);
	        label_2.setBounds(198, 96, 166, 23);
	        panel1.add(label_2);
	        
	        lblNombreDoffres = new JLabel("Nombre d'offres : ");
	        lblNombreDoffres.setForeground(Color.BLACK);
	        lblNombreDoffres.setBounds(40, 130, 138, 23);
	        panel1.add(lblNombreDoffres);
	        
	        label_9 = new JLabel("");
	        label_9.setForeground(Color.BLACK);
	        label_9.setBounds(198, 130, 166, 23);
	        panel1.add(label_9);
	        
	        lblNombreDobjets = new JLabel("Nombre d'objets : ");
	        lblNombreDobjets.setForeground(Color.BLACK);
	        lblNombreDobjets.setBounds(40, 164, 138, 23);
	        panel1.add(lblNombreDobjets);
	        
	        label_11 = new JLabel("");
	        label_11.setForeground(Color.BLACK);
	        label_11.setBounds(198, 164, 166, 23);
	        panel1.add(label_11);
	        
	        lblGain = new JLabel("Gain du Vendeur : ");
	        lblGain.setForeground(Color.BLACK);
	        lblGain.setBounds(40, 232, 138, 23);
	        panel1.add(lblGain);
	        
	        label_3 = new JLabel("");
	        label_3.setForeground(Color.BLACK);
	        label_3.setBounds(198, 232, 166, 23);
	        panel1.add(label_3);
	        
	        lblOffresGagnante = new JLabel("Offres Gagnantes : ");
	        lblOffresGagnante.setForeground(Color.BLACK);
	        lblOffresGagnante.setBounds(40, 266, 138, 23);
	        panel1.add(lblOffresGagnante);
	        
	        label_4 = new JLabel("");
	        label_4.setForeground(Color.BLACK);
	        label_4.setBounds(161, 266, 203, 23);
	        panel1.add(label_4);
	        
	        lblTempsDexcution = new JLabel("Temps d'ex\u00E9cution : ");
	        lblTempsDexcution.setForeground(Color.BLACK);
	        lblTempsDexcution.setBounds(40, 198, 138, 23);
	        panel1.add(lblTempsDexcution);
	        
	        label_5 = new JLabel("");
	        label_5.setForeground(Color.BLACK);
	        label_5.setBounds(198, 198, 166, 23);
	        panel1.add(label_5);
	      
	        
	        JLabel lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setForeground(Color.BLACK);
			lblNewLabel_4.setIcon(new ImageIcon("photo/2Bis.jpg"));
			lblNewLabel_4.setBounds(0, 0, 374, 363);
			panel1.add(lblNewLabel_4);
			
			setSize(390,401);
			setTitle("Fin d'ex\u00E9cution");	
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
	    public void setTpsExec(String msg)
	    {
	    	label_5.setText(msg);
	    }
	    public void setGain(String msg)
	    {
	    	label_3.setText(msg);
	    }
	    public void setOffresGagn(String msg)
	    {
	    	label_4.setText(msg);
	    }
	}
