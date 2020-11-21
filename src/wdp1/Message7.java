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

public class Message7 extends JDialog{
	
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
	private JLabel lblParamtreLamda;
	private JLabel label_8;
			
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
		
		public Message7 (Frame parent, boolean modal) {

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
	        btnAccepter.setBounds(111, 391, 111, 33);
	        panel1.add(btnAccepter);
	       			
	        lblNomDeBenchmark = new JLabel("Nom de Benchmark : ");
	        lblNomDeBenchmark.setForeground(Color.BLACK);
	        lblNomDeBenchmark.setBounds(20, 51, 145, 23);
	        panel1.add(lblNomDeBenchmark);
	        
	        label = new JLabel("");
	        label.setForeground(Color.BLACK);
	        label.setBounds(175, 51, 151, 23);
	        panel1.add(label);
	        
	        lblMthodeApplique = new JLabel("   M\u00E9thode Appliqu\u00E9e : ");
	        lblMthodeApplique.setForeground(Color.BLACK);
	        lblMthodeApplique.setBounds(10, 83, 141, 23);
	        panel1.add(lblMthodeApplique);
	        
	        label_2 = new JLabel("");
	        label_2.setForeground(Color.BLACK);
	        label_2.setBounds(175, 83, 151, 23);
	        panel1.add(label_2);
	        
	        lblParamtresEmpiriques = new JLabel("   Param\u00E8tres empiriques : ");
	        lblParamtresEmpiriques.setForeground(Color.BLACK);
	        lblParamtresEmpiriques.setBounds(10, 106, 156, 23);
	        panel1.add(lblParamtresEmpiriques);
	        
	        lblNombreDitrations = new JLabel("Nombre d'it\u00E9rations : ");
	        lblNombreDitrations.setForeground(Color.BLACK);
	        lblNombreDitrations.setBounds(80, 140, 130, 23);
	        panel1.add(lblNombreDitrations);
	        
	        lblWp = new JLabel("Param\u00E8tre P : ");
	        lblWp.setForeground(Color.BLACK);
	        lblWp.setBounds(80, 174, 130, 23);
	        panel1.add(lblWp);
	        
	        label_6 = new JLabel("");
	        label_6.setForeground(Color.BLACK);
	        label_6.setBounds(220, 140, 111, 23);
	        panel1.add(label_6);
	        
	        label_7 = new JLabel("");
	        label_7.setForeground(Color.BLACK);
	        label_7.setBounds(220, 170, 111, 23);
	        panel1.add(label_7);
	        
	        lblNombreDoffres = new JLabel("Nombre d'offres : ");
	        lblNombreDoffres.setForeground(Color.BLACK);
	        lblNombreDoffres.setBounds(20, 242, 131, 23);
	        panel1.add(lblNombreDoffres);
	        
	        label_9 = new JLabel("");
	        label_9.setForeground(Color.BLACK);
	        label_9.setBounds(175, 242, 151, 23);
	        panel1.add(label_9);
	        
	        lblNombreDobjets = new JLabel("Nombre d'objets : ");
	        lblNombreDobjets.setForeground(Color.BLACK);
	        lblNombreDobjets.setBounds(20, 264, 131, 23);
	        panel1.add(lblNombreDobjets);
	        
	        label_11 = new JLabel("");
	        label_11.setForeground(Color.BLACK);
	        label_11.setBounds(175, 264, 151, 23);
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
	        label_5.setBounds(175, 289, 151, 23);
	        panel1.add(label_5);
	        
	        lblParamtreLamda = new JLabel("Param\u00E8tre Lamda : ");
	        lblParamtreLamda.setForeground(Color.BLACK);
	        lblParamtreLamda.setBounds(80, 208, 130, 23);
	        panel1.add(lblParamtreLamda);
	        
	        label_8 = new JLabel("");
	        label_8.setForeground(Color.BLACK);
	        label_8.setBounds(215, 208, 111, 23);
	        panel1.add(label_8);
	        
	        JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon("photo/2Bis.jpg"));
			lblNewLabel_4.setBounds(0, 0, 336, 445);
			panel1.add(lblNewLabel_4);
			
	        setSize(352,483);
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
	    public void setNbInterations(String msg)
	    {
	    	label_6.setText(msg);
	    }
	    public void setParameterP(String msg)
	    {
	    	label_7.setText(msg);
	    }
	    public void setParameterLamda(String msg)
	    {
	    	label_8.setText(msg);
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
