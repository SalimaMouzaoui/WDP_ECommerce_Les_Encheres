package wdp1;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class ChoixRechercheLocale extends javax.swing.JDialog{
	
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Button confirm;
	private int choice;
	int retour;
	JCheckBox tabu,recuit;
	private boolean choosen=false;
	public ChoixRechercheLocale(JFrame parent) {
		super(parent,"R\u00E9cuit Simul\u00E9 || Recherche Tabou ",true);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		getContentPane().setBackground(new Color(204, 204, 255));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		retour=0;
		recuit = new JCheckBox("R\u00E9cuit Simul\u00E9");
		recuit.setMnemonic('s');
		recuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(recuit.isSelected()|| tabu.isSelected()){
					confirm.setEnabled(true);
				setchoice(1);
				}
			}
		});
		buttonGroup.add(recuit);
		recuit.setBackground(new Color(204, 204, 255));
		springLayout.putConstraint(SpringLayout.NORTH, recuit, 83, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, recuit, 155, SpringLayout.WEST, getContentPane());
		getContentPane().add(recuit);
		
		tabu = new JCheckBox("Recherche Tabou");
		tabu.setMnemonic('t');
		tabu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(recuit.isSelected()== true || tabu.isSelected()== true){
					confirm.setEnabled(true);
					setchoice(2);
				}				
			}
		});
		tabu.setBackground(new Color(204, 204, 255));
		buttonGroup.add(tabu);
		springLayout.putConstraint(SpringLayout.NORTH, tabu, 25, SpringLayout.SOUTH, recuit);
		springLayout.putConstraint(SpringLayout.WEST, tabu, 154, SpringLayout.WEST, getContentPane());
		getContentPane().add(tabu);
		
		JLabel lblChooseExecutionType = new JLabel("Choisir Recherche Locale ");
		lblChooseExecutionType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.WEST, lblChooseExecutionType, 97, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblChooseExecutionType, -20, SpringLayout.NORTH, recuit);
		getContentPane().add(lblChooseExecutionType);
		
		confirm = new Button("confirmer");
		confirm.setActionCommand("confirm");
		confirm.setEnabled(false);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosen=true;
				setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, confirm, -38, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, confirm, -81, SpringLayout.EAST, getContentPane());
		getContentPane().add(confirm);
		
		Button button_1 = new Button("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retour=1;
				setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, confirm);
		springLayout.putConstraint(SpringLayout.EAST, button_1, -95, SpringLayout.WEST, confirm);
		getContentPane().add(button_1);
		setVisible(true);
	}
	
	protected void setchoice(int i) {
		// TODO Auto-generated method stub
		this.choice=i;
	}
	protected int getchoice() {
		// TODO Auto-generated method stub
		return this.choice;
	}
	protected boolean getchoosen() {
		// TODO Auto-generated method stub
		return this.choosen;
	}
}
