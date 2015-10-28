import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class AddPTNO extends JFrame {

	
	private JPanel contentPane;
	private static JTextField PartNumberTxtField;
	String[] AreaArray = new String[] {"CHOOSE / ESCOJA","MOL1", "MOL2"};
	
	
	/**
	 * Copyright [2015] [Gustavo Bravo]
	 */
	public AddPTNO() {
		
		Image img1 = new ImageIcon (this.getClass().getResource("GE_Icon_Original.png")).getImage();
		setIconImage(img1);
		
		setResizable(false);					
		
		setTitle("Part Number Adder");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblAddPartNumberTitle = new JLabel("Add Part Number / A\u00F1adir N\u00FAmero de Pieza:");
		lblAddPartNumberTitle.setForeground(Color.WHITE);
		lblAddPartNumberTitle.setFont(new Font("GE Inspira Pitch", Font.BOLD, 16));
		lblAddPartNumberTitle.setBounds(84, 11, 345, 29);
		contentPane.add(lblAddPartNumberTitle);
		
		JLabel lblNewPartNumber = new JLabel("New Part Number / Numero de Pieza Nuevo:");
		lblNewPartNumber.setForeground(Color.WHITE);
		lblNewPartNumber.setFont(new Font("GE Inspira Pitch", Font.BOLD, 12));
		lblNewPartNumber.setBounds(10, 63, 255, 19);
		contentPane.add(lblNewPartNumber);
		
		setPartNumberTxtField(new JTextField());
		getPartNumberTxtField().setFont(new Font("GE Inspira Pitch", Font.PLAIN, 11));
		getPartNumberTxtField().setBounds(300, 63, 173, 20);
		contentPane.add(getPartNumberTxtField());
		getPartNumberTxtField().setColumns(10);
		
		JLabel lblAreaOfMolding = new JLabel("Area Of Molding /  Area de Moldeo:");
		lblAreaOfMolding.setForeground(Color.WHITE);
		lblAreaOfMolding.setFont(new Font("GE Inspira Pitch", Font.BOLD, 12));
		lblAreaOfMolding.setBounds(10, 107, 224, 19);
		contentPane.add(lblAreaOfMolding);
		/*
		JComboBox comboBoxArea = new JComboBox();
		comboBoxArea.setBounds(300, 105, 173, 22);
		contentPane.add(comboBoxArea); */
		
		JComboBox<String> comboBoxArea = new JComboBox<String>(AreaArray);
		comboBoxArea.setBounds(300, 105, 173, 22);
		contentPane.add(comboBoxArea);
		
				
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(382, 173, 91, 23);
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (!((String) comboBoxArea.getSelectedItem()).equals(AreaArray[0]) & !(getPartNumberTxtField().getText()).equals("") & !(getPartNumberTxtField().getText()).equals(null))
				{
				FileHandler.PTNOWriter(getPartNumberTxtField().getText(), (String) comboBoxArea.getSelectedItem());
				getPartNumberTxtField().setText(null);
				comboBoxArea.setSelectedIndex(0);
				//JOptionPane.showMessageDialog(null,"The program will now close, please restart. / El programa se cerrara favor de abrirlo de nuevo.");			
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Choose area of molding. / Escoga area de moldeo.");
				}
				
			}
			
		});
		
		contentPane.add(btnSubmit);
		Image img = new ImageIcon (this.getClass().getResource("ge_scrap_bg.jpg")).getImage();
		JLabel lblAPNBackgorund = new JLabel("");
		lblAPNBackgorund.setForeground(SystemColor.WHITE);
		lblAPNBackgorund.setIcon(new ImageIcon(img));
		lblAPNBackgorund.setBounds(0, 0, 704, 387);
		lblAPNBackgorund.setBounds(0, 0, 491, 204);
		
		contentPane.add(lblAPNBackgorund);
		
		
	}
	
	public static JTextField getPartNumberTxtField() {
		return PartNumberTxtField;
	}

	public static void setPartNumberTxtField(JTextField partNumberTxtField) {
		PartNumberTxtField = partNumberTxtField;
	}
	
	
}
