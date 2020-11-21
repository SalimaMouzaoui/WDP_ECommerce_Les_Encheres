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

public class Message6 extends JDialog{
	
	JPanel panel1 = new JPanel();
	JLabel lblPrix;
	JButton btnAccepter;
	String answer=new String("");
	JRadioButton rdbtnNewRadioButton_1, rdbtnNewRadioButton;
	private JLabel lblNomDeBenchmark;
	private JLabel label;
	private JLabel lblMthodeApplique;
	private JLabel label_2;
	private JLabel lblParamtresEmpiriques;
	private JLabel lblNombreDitrations;
	private JLabel lblWp;
	private JLabel label_6;
	private JLabel label_7;
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
		
		public Message6 (Frame parent, boolean modal) {

		    super(parent, modal);
     		panel1.setLayout(null);
	        panel1.setSize(360, 220) ;
	        panel1.setBackground(SystemColor.control);
	        getContentPane().add(panel1);
	        
	        lblPrix = new JLabel("Fin d'ex\u00E9cution");
	        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPrix.setForeground(Color.BLACK);
	        lblPrix.setBackground(SystemColor.control);
	        lblPrix.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPrix.setBounds(10, 11, 316, 40);
	        panel1.add(lblPrix);
	        
	        btnAccepter = new JButton("Ok");
	        btnAccepter.setToolTipText("Alt + O");
	        btnAccepter.setMnemonic('O');
	        btnAccepter.setVisible(true);
	        btnAccepter.setBackground(UIManager.getColor("Button.background"));
	        btnAccepter.setForeground(Color.BLACK);
	        btnAccepter.setFont(new Font("Constantia", Font.PLAIN, 16));
	        btnAccepter.setBounds(112, 413, 111, 33);
	        panel1.add(btnAccepter);
	        
	        lblNomDeBenchmark = new JLabel("Nom de Benchmark : ");
	        lblNomDeBenchmark.setForeground(Color.BLACK);
	        lblNomDeBenchmark.setBounds(20, 62, 145, 23);
	        panel1.add(lblNomDeBenchmark);
	        
	        label = new JLabel("");
	        label.setForeground(Color.BLACK);
	        label.setBounds(175, 62, 151, 23);
	        panel1.add(label);
	        
	        lblMthodeApplique = new JLabel("   M\u00E9thode Appliqu\u00E9e : ");
	        lblMthodeApplique.setForeground(Color.BLACK);
	        lblMthodeApplique.setBounds(10, 96, 141, 23);
	        panel1.add(lblMthodeApplique);
	        
	        label_2 = new JLabel("");
	        label_2.setForeground(Color.BLACK);
	        label_2.setBounds(175, 96, 151, 23);
	        panel1.add(label_2);
	        
	        lblParamtresEmpiriques = new JLabel("Param\u00E8tres empiriques : ");
	        lblParamtresEmpiriques.setForeground(Color.BLACK);
	        lblParamtresEmpiriques.setBounds(20, 130, 146, 23);
	        panel1.add(lblParamtresEmpiriques);
			
	        lblNombreDitrations = new JLabel("Nombre d'it\u00E9rations : ");
	        lblNombreDitrations.setForeground(Color.BLACK);
	        lblNombreDitrations.setBounds(82, 164, 128, 23);
	        panel1.add(lblNombreDitrations);
	        
	        lblWp = new JLabel("Walk Probability : ");
	        lblWp.setForeground(Color.BLACK);
	        lblWp.setBounds(82, 194, 128, 23);
	        panel1.add(lblWp);
	        
	        label_6 = new JLabel("");
	        label_6.setForeground(Color.BLACK);
	        label_6.setBounds(215, 164, 111, 23);
	        panel1.add(label_6);
	        
	        label_7 = new JLabel("");
	        label_7.setForeground(Color.BLACK);
	        label_7.setBounds(215, 198, 111, 23);
	        panel1.add(label_7);
	        
	        lblNombreDoffres = new JLabel("Nombre d'offres : ");
	        lblNombreDoffres.setForeground(Color.BLACK);
	        lblNombreDoffres.setBounds(20, 228, 131, 23);
	        panel1.add(lblNombreDoffres);
	        
	        label_9 = new JLabel("");
	        label_9.setForeground(Color.BLACK);
	        label_9.setBounds(175, 228, 151, 23);
	        panel1.add(label_9);
	        
	        lblNombreDobjets = new JLabel("Nombre d'objets : ");
	        lblNombreDobjets.setForeground(Color.BLACK);
	        lblNombreDobjets.setBounds(20, 256, 131, 23);
	        panel1.add(lblNombreDobjets);
	        
	        label_11 = new JLabel("");
	        label_11.setForeground(Color.BLACK);
	        label_11.setBounds(175, 256, 151, 23);
	        panel1.add(label_11);
	        
	        lblGain = new JLabel("Gain du Vendeur : ");
	        lblGain.setForeground(Color.BLACK);
	        lblGain.setBounds(20, 323, 131, 23);
	        panel1.add(lblGain);
	        
	        label_3 = new JLabel("");
	        label_3.setForeground(Color.BLACK);
	        label_3.setBounds(161, 323, 165, 23);
	        panel1.add(label_3);
	        
	        lblOffresGagnante = new JLabel("Offres Gagnantes : ");
	        lblOffresGagnante.setForeground(Color.BLACK);
	        lblOffresGagnante.setBounds(20, 357, 131, 23);
	        panel1.add(lblOffresGagnante);
	        
	        label_4 = new JLabel("");
	        label_4.setForeground(Color.BLACK);
	        label_4.setBounds(161, 357, 165, 23);
	        panel1.add(label_4);
	        
	        lblTempsDexcution = new JLabel("Temps d'ex\u00E9cution : ");
	        lblTempsDexcution.setForeground(Color.BLACK);
	        lblTempsDexcution.setBounds(20, 289, 131, 23);
	        panel1.add(lblTempsDexcution);
	        
	        label_5 = new JLabel("");
	        label_5.setForeground(Color.BLACK);
	        label_5.setBounds(161, 289, 165, 23);
	        panel1.add(label_5);
	       	        
	        JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("photo/2Bis.jpg"));
			lblNewLabel_4.setBounds(0, 0, 336, 456);
			panel1.add(lblNewLabel_4);
			
			setSize(352,494);
			setTitle("Fin d'ex\u00E9cution");	
			dispose();
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
	    public void setNbInterations(String msg)
	    {
	    	label_6.setText(msg);
	    }
	    public void setWlakProbabability(String msg)
	    {
	    	label_7.setText(msg);
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
