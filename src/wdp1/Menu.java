package wdp1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;

import java.awt.Button;
import java.awt.Font;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Menu extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	
	String nom_fichier_image = "photo/1.jpg";

	Frame frame3=new Frame() ;
        
	public Menu() {
		super();
		setTitle("Probl\u00E8me de d\u00E9termination du Gagnant dans les ench\u00E8res combinatoires");
        setBounds(200, 200, 800, 600);
        setResizable(false);
        setLocation(250,50);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JPanel panneau = new JPanel()
        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon(nom_fichier_image);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
 
            }
        };
 
        //ajouter le panneau à la fenétre.
        getContentPane().add(panneau);
        
        JButton btnNewButton = new JButton("");
        ImageIcon iconInformation = new ImageIcon("photo/power-button.jpg",
				"Icon Information");
        
        btnNewButton = new JButton(iconInformation);
        btnNewButton.setToolTipText("Alt+l");
        btnNewButton.setMnemonic('l');
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		
        		try {
					lancer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        panneau.add(btnNewButton);
    }

	
	private void lancer() throws IOException {
		// TODO Auto-generated method stub

		traitement t = new traitement();
		Message msg = new Message(frame3, true);
        msg.setLocation(200,100);	
        Message1 msg1 = new Message1(frame3, true);
        msg1.setLocation(200,100);
        Message2 msg2 = new Message2(frame3, true);
        msg2.setLocation(200,100);
        Message6 msg6 = new Message6(frame3, true);
        msg6.setLocation(200,100);
        Message4 msg4 = new Message4(frame3, true);
        msg4.setLocation(200,100);
        Message5 msg5 = new Message5(frame3, true);
        msg5.setLocation(200,100);
        Message7 msg7 = new Message7(frame3, true);
        msg7.setLocation(200,100);
        Message8 msg8 = new Message8(frame3, true);
        msg8.setLocation(200,100);
        
        msg.show();
        String nomFile = msg.getNomFile();
        String pathFile = msg.getPathFile();
        
        if (msg.getAnswer().equals("yes"))  
        {
            msg1.show();	
        
        String nomMethod = msg1.getNomMethod();

        File fos = new File(nomFile+"_"+nomMethod+"_Result.txt");
        
        Execution exe = new Execution();
        exe.lectureFile(pathFile, t);

        String txt = new String();
               
        if (msg1.getAnswer().equals("yes")) 
        {
        	t.writeln(fos, " ****************************************************** ", nomFile);
        	if (nomMethod.equals("SLS"))
        	{
        		msg2.setNomBenchmark(nomFile);
            	msg2.setNomMethode("Recherche Locale Stochastique");
            	msg2.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	t.write(fos, "nombre d'offres = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbOffres()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg2.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	t.write(fos, "nombre d'objets = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbObjets()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg2.setNbInterations(txt.valueOf(t.getNbMaxIterationSLS()));
            	t.write(fos, "nombre Max d'Itérations = ", nomFile);
        		t.write(fos, String.valueOf(t.getNbMaxIterationSLS()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg2.setWlakProbabability(txt.valueOf(t.getWalkProbability()));
            	t.write(fos, "valeur de Walk Probability = ", nomFile);
        		t.write(fos, String.valueOf(t.getWalkProbability()), nomFile);
        		t.writeln(fos, "", nomFile);            	
            	msg2.show();
            	
        	}
        	else if (nomMethod.equals("TS"))
        	{
        		msg4.setNomBenchmark(nomFile);
            	msg4.setNomMethode("Recherche Taboue");
            	msg4.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	t.write(fos, "nombre d'offres = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbOffres()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg4.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	t.write(fos, "nombre d'objets = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbOffres()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg4.setNbInterations(txt.valueOf(t.getNbMaxIterationTS()));
            	t.write(fos, "nombre Max d'Itérations = ", nomFile);
        		t.write(fos, String.valueOf(t.getNbMaxIterationTS()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg4.setParameterP(txt.valueOf(t.getParameterP()));
            	t.write(fos, "valeur du paramètre P = ", nomFile);
        		t.write(fos, String.valueOf(t.getParameterP()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg4.setParameterLamda(txt.valueOf(t.getParameterLampda()));
            	t.write(fos, "valeur du paramètre lampda = ", nomFile);
        		t.write(fos, String.valueOf(t.getParameterLampda()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg4.show();
        	}
        	else if (nomMethod.equals("NV")){
        		msg5.setNomBenchmark(nomFile);
            	msg5.setNomMethode("Méthode Naive");
            	msg5.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	t.write(fos, "nombre d'offres = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbOffres()), nomFile);
        		t.writeln(fos, "", nomFile);
            	msg5.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	t.write(fos, "nombre d'objets = ", nomFile);
        		t.write(fos, String.valueOf(exe.getNbObjets()), nomFile);
        		t.writeln(fos, "", nomFile);
        		msg5.show();
        	}
        Exec exeD = new Exec(frame3, true);
        exeD.setLocation(200,100);
        exeD.show();
        exe.execute(nomMethod, t);
        
    	if (exeD.getAnswer().equals("yes"))
    	{
        String gain = txt.valueOf(exe.getGain());
        String offreGagn = exe.getOffreGagnates();
        String tpsExec = txt.valueOf(exe.getTempsExec() / 1000);
        
        if (msg2.getAnswer().equals("yes") || msg4.getAnswer().equals("yes") || msg5.getAnswer().equals("yes")) 
        {        	
        	if (nomMethod.equals("SLS"))
        	{
        		msg6.setNomBenchmark(nomFile);
            	msg6.setNomMethode("Recherche Locale Stochastique");
            	msg6.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	msg6.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	msg6.setNbInterations(txt.valueOf(t.getNbMaxIterationSLS()));
            	msg6.setWlakProbabability(txt.valueOf(t.getWalkProbability()));
            	msg6.setGain(gain);
            	msg6.setOffresGagn(offreGagn);
            	t.write(fos, "offres gagnantes = ", nomFile);
        		t.write(fos, offreGagn, nomFile);
        		t.writeln(fos, "", nomFile);
            	msg6.setTpsExec(tpsExec+ " secondes");
            	t.write(fos, "le temps d'exécution = ", nomFile);
        		t.write(fos, tpsExec+ " secondes", nomFile);
        		t.writeln(fos, "", nomFile);
            	t.write(fos, "le gain du vendeur = ", nomFile);
        		t.write(fos, gain, nomFile);
        		t.writeln(fos, "", nomFile);
            	msg6.show();
        	}
        	else if (nomMethod.equals("TS"))
        	{
        		msg7.setNomBenchmark(nomFile);
            	msg7.setNomMethode("Recherche Taboue");
            	msg7.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	msg7.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	msg7.setNbInterations(txt.valueOf(t.getNbMaxIterationTS()));
            	msg7.setParameterP(txt.valueOf(t.getParameterP()));
            	msg7.setParameterLamda(txt.valueOf(t.getParameterLampda()));
            	msg7.setGain(gain);
            	msg7.setOffresGagn(offreGagn);
            	t.write(fos, "offres gagnantes = ", nomFile);
        		t.write(fos, offreGagn, nomFile);
        		t.writeln(fos, "", nomFile);
            	msg7.setTpsExec(tpsExec+ " secondes");
            	t.write(fos, "le temps d'exécution = ", nomFile);
        		t.write(fos, tpsExec+ " secondes", nomFile);
        		t.writeln(fos, "", nomFile);
            	t.write(fos, "le gain du vendeur = ", nomFile);
        		t.write(fos, gain, nomFile);
        		t.writeln(fos, "", nomFile);
            	msg7.show();
        	}
        	else if (nomMethod.equals("NV")){
        		msg8.setNomBenchmark(nomFile);
            	msg8.setNomMethode("Méthode Naive");
            	msg8.setNbOffres(txt.valueOf(exe.getNbOffres()));
            	msg8.setNbObjets(txt.valueOf(exe.getNbObjets()));
            	msg8.setGain(gain);
            	msg8.setOffresGagn(offreGagn);
            	t.write(fos, "offres gagnantes = ", nomFile);
        		t.write(fos, offreGagn, nomFile);
        		t.writeln(fos, "", nomFile);
            	msg8.setTpsExec(tpsExec+ " secondes");
            	t.write(fos, "le temps d'exécution = ", nomFile);
        		t.write(fos, tpsExec+ " secondes", nomFile);
        		t.writeln(fos, "", nomFile);
            	t.write(fos, "le gain du vendeur = ", nomFile);
        		t.write(fos, gain, nomFile);
        		t.writeln(fos, "", nomFile);
        		msg8.show();
        	}
        } else setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	} else setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        } else setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        } else setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}   
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
