import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;

/**
 * This class creates the GUI of the program.
 * @author Gustavo Bravo
 *
 */

/**
 * Copyright [2015] [Gustavo Bravo]
 */
public class ScrapGUI extends JFrame {

	
	private static final long serialVersionUID = 6036043929219636485L;
	public JPanel contentPane;
	public JTextField PTNO;
	public JTextField ID_Operator;
	public JTextField Date;
	public JTextField Qty;
	private static String VerNum = "V1.5.6";
	private static final String NONE = " NONE / NINGUNO ";
	
	private static ScrapGUI obj=null;
	
	
	public String sPTNO,sQty, sDefect,sID_Operator;
	int iShift;
	
	Integer[] shiftArray = new Integer[] {0,1,2,3};
	String[] defectArray = new String[] {NONE,"ASTILLADA", "MANCHADA","CONTAMINADA", "INCOMPLETA", "QUEMADA", "POROSA","RECHUPE","PARCHOS","PARTIDA","BURBUJA","RAYADA","BANDA PLATEADA","FALLO PRUEBA"};
	

	/**
	 * Create the frame of the NCM Program.
	 * 
	 */
	public ScrapGUI()  {
		
		//Set Frame Settings
		setTitle(" [SQL Server Database]");
		setResizable(false);					
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss a");		
		Calendar cal = Calendar.getInstance();
		String DATE = dateFormat.format(cal.getTime());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Non-Conforming Material");
		lblTitle1.setForeground(SystemColor.text);
		
		lblTitle1.setBounds(202, 36, 340, 32);
		contentPane.add(lblTitle1);
		
		JLabel lblPartNumber = new JLabel("Part Number/N\u00FAmero de Pieza:");
		lblPartNumber.setForeground(SystemColor.text);
		
		lblPartNumber.setBounds(25, 137, 190, 20);
		contentPane.add(lblPartNumber);
		
		JLabel lblIdOperator = new JLabel("ID Operator/ID Operador:");
		lblIdOperator.setForeground(SystemColor.text);
		
		lblIdOperator.setBounds(25, 183, 157, 20);
		contentPane.add(lblIdOperator);
		
		JLabel lblDate = new JLabel("Date/Fecha: (MM/DD/YYYY)");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDate.setBounds(365, 235, 154, 14);		
		//contentPane.add(lblDate);
		
		JLabel lblQty = new JLabel("Quantity/Cantidad:");
		lblQty.setForeground(SystemColor.text);
		
		lblQty.setBounds(397, 137, 118, 14);
		contentPane.add(lblQty);
		
		JLabel lblDefect = new JLabel("Defect/Defecto:");
		lblDefect.setForeground(SystemColor.text);
		
		lblDefect.setBounds(397, 186, 106, 14);
		contentPane.add(lblDefect);
		
		PTNO = new JTextField();
		PTNO.setBounds(225, 138, 145, 20);
		contentPane.add(PTNO);
		PTNO.setColumns(10);
		
		ID_Operator = new JTextField();
		ID_Operator.setBounds(225, 184, 145, 20);
		contentPane.add(ID_Operator);
		ID_Operator.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(518, 232, 84, 20);
		Date.setText(DATE);
		Date.setEditable(false);
		//contentPane.add(Date);
		Date.setColumns(10);
		
		Qty = new JTextField();
		Qty.setBounds(525, 137, 145, 20);
		contentPane.add(Qty);
		Qty.setColumns(10);
				
		JLabel lblTitle2 = new JLabel("Scrap Material Tag");
		lblTitle2.setForeground(SystemColor.text);
		
		//lblTitle2.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitle2.setBounds(280, 79, 158, 20);
		contentPane.add(lblTitle2);
		
		
		JLabel lblShift = new JLabel("Shift/Turno: ");
		lblShift.setForeground(SystemColor.text);
		
		lblShift.setBounds(25, 232, 84, 18);
		contentPane.add(lblShift);
		
		JLabel lblPlant = new JLabel("Powered by bravopr");
		lblPlant.setForeground(SystemColor.text);
		
		//lblVegaAltaPlant.setFont(new Font("Arial", Font.BOLD, 10));
		lblPlant.setBounds(15, 298, 167, 14);
		contentPane.add(lblPlant);
		
		/*
		JComboBox comboBoxShift = new JComboBox();
		comboBoxShift.setBounds(225, 228, 145, 22);
		contentPane.add(comboBoxShift);
		
		JComboBox comboBoxDefect = new JComboBox();
		comboBoxDefect.setBounds(525, 179, 145, 22);
		contentPane.add(comboBoxDefect); */
		
		JComboBox<Integer> comboBoxShift = new JComboBox<Integer>(shiftArray);
		comboBoxShift.setBounds(225, 228, 145, 22);
		contentPane.add(comboBoxShift);
		
		JComboBox<String> comboBoxDefect = new JComboBox<String>(defectArray);
		comboBoxDefect.setBounds(525, 179, 145, 22);
		contentPane.add(comboBoxDefect);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(SystemColor.desktop);
		
		btnSubmit.setBounds(590, 261, 86, 23);
		contentPane.add(btnSubmit);
		Image img2 = new ImageIcon (this.getClass().getResource("scrap_bg.jpg")).getImage();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(185, 66, 334, 2);
		contentPane.add(separator);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(SystemColor.text);
		lblBackground.setIcon(new ImageIcon(img2));
		lblBackground.setBounds(0, 0, 704, 325);
		contentPane.add(lblBackground);
		
		//Performs action when submit button is pressed.
		btnSubmit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	//Get Values from JTextFields
            	sPTNO = PTNO.getText().toUpperCase();            	
            	sID_Operator= ID_Operator.getText();
            	sQty = Qty.getText();
            	iShift = (int) comboBoxShift.getSelectedItem();
            	sDefect = (String) comboBoxDefect.getSelectedItem();
            	
            	 //Check for errors values
                if(iShift == 0)
                {				
               	 JOptionPane.showMessageDialog(null,"Error: Choose a valid shift number. / Escoja un número de turno correcto.");                
       		    }
                else if(sDefect.equals(ScrapGUI.getNone()))
                {
               	 JOptionPane.showMessageDialog(null,"Error: Choose a valid defect. / Escoja un defecto valido.");
                }
                else if(sID_Operator.length() < 9 || sID_Operator.length() > 9 )
                {
               	 JOptionPane.showMessageDialog(null,"Error: Enter a valid SSO number. / Entre un número valido de SSO.");
                }
                else if(!(sQty).matches("[0-9]+") ) 
                {
               	 JOptionPane.showMessageDialog(null,"Error: Enter a valid quantity number. / Entre un número de cantidad valido.");
                }
                else if(!FileHandler.PTNOCheck(sPTNO,DatabaseConn.getAREA()) | sPTNO.equals("")) //The method PTNOCheck returns true if part number found.
                {
                 JOptionPane.showMessageDialog(null,"Error: Enter a valid part number. / Entre un número de pieza valido.");                	
                }
                else{    
                	
                	if (JOptionPane.showConfirmDialog(null, "Are you sure? / ¿Esta seguro de los datos?", "WARNING",
                	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                		// "Yes" option
                		//Input data into the database.
                		DatabaseConn.dbScrapInput(sPTNO,sID_Operator,iShift,sQty,sDefect);
                    	
                    	//Reset values in the GUI
                    	PTNO.setText(null);
                		Qty.setText(null);
                		ID_Operator.setText(null);
                		comboBoxDefect.setSelectedIndex(0);
                		comboBoxShift.setSelectedIndex(0);
                	} else {
                		// "No" option
                	}
                	
                	
                } 
            	            	
            	
            }
        }); 
		
		
	}
	
	/**
	 * This method returns the none variable (Type String).
	 * @return None Variable
	 */
	//Return the value of a final variable
	public static String getNone(){
		return NONE;
	}
	
	/**
	 * This method returns the version number of the program.
	 * @return VerNum
	 */
	public static String getVerNum() {
		return VerNum;
	}
	
	public ScrapGUI getObj(){ 
		
		if(obj==null){ 
			
			obj=new ScrapGUI(); 
			obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
			
		} 				
		return obj;		
	}	
	
}
