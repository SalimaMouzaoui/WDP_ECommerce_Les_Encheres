package wdp1;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ChoixBenchmark extends JDialog {
	public int param,paramChoice
	//,exit
	;
	JButton btnOk,btnAnnuler;
	public MouseEvent evt;
	private static final long serialVersionUID = 1L;

	public ChoixBenchmark(JFrame parent) {
		super(parent,"Choisir Benchmark ",true);
		setTitle("Choisir Benchmark");
		this.setSize(378, 295);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		getContentPane().setBackground(new Color(204, 204, 255));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -125, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -86, SpringLayout.EAST, getContentPane());
		panel.setBackground(new Color(155, 184, 223));
		panel.setPreferredSize(new Dimension(220, 60));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 42, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 56, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JRadioButton rdbtnChoixFichier = new JRadioButton("Choisir Benchmark");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnChoixFichier, 30, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnChoixFichier, 50, SpringLayout.WEST, panel);
		rdbtnChoixFichier.setMnemonic('b');
		rdbtnChoixFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnOk.setEnabled(true);
               setParam(1);
            }
        });
		
		rdbtnChoixFichier.setBackground(new Color(155, 184, 223));
		panel.add(rdbtnChoixFichier);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnChoixFichier);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 20, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 54, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -58, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(155, 184, 223));
		getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		btnOk = new JButton("OK");
		sl_panel_1.putConstraint(SpringLayout.EAST, btnOk, -26, SpringLayout.EAST, panel_1);
		btnOk.setMnemonic('o');
		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setparamChoice();
				close();
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setparamChoice();
				close();
			}
		});
		panel_1.add(btnOk);
		
		btnAnnuler = new JButton("Annuler");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnOk, 0, SpringLayout.NORTH, btnAnnuler);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnOk, 50, SpringLayout.EAST, btnAnnuler);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnOk, 0, SpringLayout.SOUTH, btnAnnuler);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnAnnuler, 12, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnAnnuler, 30, SpringLayout.WEST, panel_1);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//setEvt(e);
				close();
			}
		});
		panel_1.add(btnAnnuler);
		this.setVisible(true);
	}
	
	

	protected void setparamChoice() {
		paramChoice=param;
	}

	protected int getparamChoice() {
		return paramChoice;
	}

	protected void close() {
		this.setVisible(false);
	}


	protected void setParam(int i) {
		this.param=i;
		//System.out.println("i=param="+param);
	}

	
}
/*class AProposListener extends WindowAdapter{
	DialogFichier dialogue;
	public AProposListener(DialogFichier dialogue) {
	this.dialogue = dialogue;
	}
	public void windowClosing(WindowEvent e) {
	dialogue;
	}
}*/