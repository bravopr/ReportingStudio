import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ComboBoxModel;
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
import java.awt.Color;

/**
 * This class creates the GUI of the program.
 * @author Gustavo Bravo
 *
 */

/**
 * Copyright [2015] [Gustavo Bravo]
 */
public class SetupGUI extends JFrame {

	
	private static final long serialVersionUID = 6036043929219636485L;
	public JPanel contentPane;
	public JTextField Mold_Num;
	public JTextField ID_Operator;
	public JTextField Date;
	public JTextField Qty;
	private static String VerNum = "V1.5.6";
	private static final String NONE = " NONE / NINGUNO ";
	
	private static SetupGUI obj=null;
	
	String sMold_Num,sQty,sID_Operator,sSETUP_FAIL;
	int iShift,iMachine_Num;
	
	Integer[] shiftArray = new Integer[] {0,1,2,3};
	static Integer[] MOL1_MA_Array = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
	static Integer[] MOL2_MA_Array = new Integer[] {0,35,36,37,38,39,40,41,42,43,44,45};
	String[] SETUP_FAIL_Array = new String[] {NONE,"FALTA HERRAMIENTA", "FALTA MATERIAL","FALTA HEATERS", "MOLDE DEFECTUOSO", "OTRA RAZÓN"};
	
	/**
	 * Create the frame of the NCM Program.
	 * 
	 */
	public SetupGUI()  {
		
		//Set Frame Settings
		setTitle("[SQL Server Database]");
		setResizable(false);					
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss a");		
		Calendar cal = Calendar.getInstance();
		String DATE = dateFormat.format(cal.getTime());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Setup Report");
		lblTitle1.setForeground(SystemColor.text);
		lblTitle1.setBounds(271, 39, 167, 30);
		contentPane.add(lblTitle1);
		
		JLabel lblPartNumber = new JLabel("Mold Number/N\u00FAmero de Molde\r\n:");
		lblPartNumber.setForeground(SystemColor.text);
		lblPartNumber.setBounds(26, 229, 258, 20);
		contentPane.add(lblPartNumber);
		
		JLabel lblIdOperator = new JLabel("ID Operator/ID Operador:");
		lblIdOperator.setForeground(SystemColor.text);
		lblIdOperator.setBounds(26, 124, 157, 20);
		contentPane.add(lblIdOperator);
		
		JLabel lblDate = new JLabel("Date/Fecha: (MM/DD/YYYY)");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDate.setBounds(365, 235, 154, 14);		
		//contentPane.add(lblDate);
		
		JLabel lblQty = new JLabel("Quantity of Time/Cantidad de tiempo (minutos) :");
		lblQty.setForeground(SystemColor.text);
		lblQty.setBounds(26, 262, 283, 14);
		contentPane.add(lblQty);
				
		Mold_Num = new JTextField();
		Mold_Num.setBounds(340, 230, 145, 20);
		contentPane.add(Mold_Num);
		Mold_Num.setColumns(10);
		
		ID_Operator = new JTextField();
		ID_Operator.setBounds(340, 125, 145, 20);
		contentPane.add(ID_Operator);
		ID_Operator.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(518, 232, 84, 20);
		Date.setText(DATE);
		Date.setEditable(false);
		//contentPane.add(Date);
		Date.setColumns(10);
		
		Qty = new JTextField();
		Qty.setBounds(340, 260, 145, 20);
		contentPane.add(Qty);
		Qty.setColumns(10);
				
		JLabel lblTitle2 = new JLabel("Time");
		lblTitle2.setForeground(SystemColor.text);
		lblTitle2.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle2.setBounds(329, 80, 51, 20);
		contentPane.add(lblTitle2);
		
		
		
		JLabel lblShift = new JLabel("Shift/Turno: ");
		lblShift.setForeground(SystemColor.text);
		lblShift.setFont(new Font("Arial", Font.BOLD, 13));
		lblShift.setBounds(26, 158, 84, 18);
		contentPane.add(lblShift);
		
		JLabel lblVegaAltaPlant = new JLabel("Powered by bravopr");
		lblVegaAltaPlant.setForeground(SystemColor.text);		
		lblVegaAltaPlant.setFont(new Font("Arial", Font.BOLD, 12));
		lblVegaAltaPlant.setBounds(26, 389, 167, 14);
		contentPane.add(lblVegaAltaPlant);
		
		/*
		JComboBox comboBoxShift = new JComboBox();
		comboBoxShift.setBounds(340, 157, 145, 22);
		contentPane.add(comboBoxShift);*/
		
		
		JComboBox<Integer> comboBoxShift = new JComboBox<Integer>(shiftArray);
		comboBoxShift.setBounds(340, 157, 145, 22);
		contentPane.add(comboBoxShift);
		/*
		JComboBox comboBoxFail = new JComboBox();
		comboBoxFail.setBounds(405, 348, 167, 22);
		contentPane.add(comboBoxFail); */
		
		JComboBox<String> comboBoxFail = new JComboBox<String>(SETUP_FAIL_Array);
		comboBoxFail.setBounds(405, 348, 167, 22);
		contentPane.add(comboBoxFail);
				
		/*JComboBox comboBoxMachineNum = new JComboBox();
		comboBoxMachineNum.setBounds(340, 196, 145, 22);
		contentPane.add(comboBoxMachineNum); */
				
		JComboBox<Integer> comboBoxMachineNum = new JComboBox<Integer>(getAreaArray());
		comboBoxMachineNum.setBounds(340, 196, 145, 22);
		contentPane.add(comboBoxMachineNum); 
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(SystemColor.desktop);
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 12));
		btnSubmit.setBounds(592, 380, 86, 23);
		contentPane.add(btnSubmit);
		
		Image img2 = new ImageIcon (this.getClass().getResource("scrap_bg.jpg")).getImage();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(181, 66, 345, 2);
		contentPane.add(separator);
		
		JLabel lblReason = new JLabel("If the setup could not be completed please specify the reason:");
		lblReason.setForeground(Color.WHITE);
		lblReason.setFont(new Font("Arial", Font.BOLD, 13));
		lblReason.setBounds(26, 316, 369, 30);
		contentPane.add(lblReason);
		
		JLabel lblReason2 = new JLabel("Si usted no pudo completar el setup por favor indique la raz\u00F3n:");
		lblReason2.setForeground(Color.WHITE);
		lblReason2.setFont(new Font("Arial", Font.BOLD, 13));
		lblReason2.setBounds(26, 343, 369, 30);
		contentPane.add(lblReason2);
						
		JLabel lblMachineNum = new JLabel("Machine Number / N\u00FAmero de M\u00E1quina: ");
		lblMachineNum.setForeground(Color.WHITE);
		lblMachineNum.setFont(new Font("Arial", Font.BOLD, 13));
		lblMachineNum.setBounds(26, 197, 258, 18);
		contentPane.add(lblMachineNum);
		
		
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(SystemColor.text);
		lblBackground.setIcon(new ImageIcon(img2));
		lblBackground.setBounds(0, 0, 704, 428);
		contentPane.add(lblBackground);
		
		//Performs action when submit button is pressed.
		btnSubmit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	//Get Values from JTextFields
            	sMold_Num = Mold_Num.getText().toUpperCase();            	
            	sID_Operator= ID_Operator.getText();
            	sQty = Qty.getText();
            	iShift = (int) comboBoxShift.getSelectedItem();
            	sSETUP_FAIL = (String) comboBoxFail.getSelectedItem();
            	iMachine_Num = (int) comboBoxMachineNum.getSelectedItem();
            	
            	
            	 //Check for errors values
                if(iShift == 0)
                {				
               	 JOptionPane.showMessageDialog(null,"Error: Choose a valid shift number. / Escoja un número de turno correcto.");                
       		    }
                
                else if(sID_Operator.length() < 9 || sID_Operator.length() > 9 )
                {
               	 JOptionPane.showMessageDialog(null,"Error: Enter a valid SSO number. / Entre un número valido de SSO.");
                }     
                
                else if(iMachine_Num == 0 )
                {
               	 JOptionPane.showMessageDialog(null,"Error: Pleae choose a valid machine. / Por favor escoja número de maquina valido.");
                } 
                else if(!FileHandler.PTNOCheck(sMold_Num,DatabaseConn.getAREA()) | sMold_Num.equals("")) //The method PTNOCheck returns true if part number found.
                {
                 JOptionPane.showMessageDialog(null,"Error: Enter a valid mold number. / Entre un número de molde valido.");  
                }
               /* else if( Integer.parseInt(sQty) > 480 && Integer.parseInt(sQty) < 0) 
                {
              	 JOptionPane.showMessageDialog(null,"Error: Enter a valid quantity number. / Entre un número de cantidad valido.");                               	
                }*/   
                else{    
                	
                	if (JOptionPane.showConfirmDialog(null, "Are you sure? / ¿Esta seguro de los datos?", "WARNING",
                	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                		// "Yes" option
                		//Input data into the database.
                		
                		if(sSETUP_FAIL.equals(NONE)){
                		
                		DatabaseConn.dbSetupInput(sMold_Num,sID_Operator,iShift,sQty,sSETUP_FAIL,iMachine_Num);
                		
                    	//Reset values in the GUI
                    	Mold_Num.setText(null);
                		Qty.setText(null);
                		ID_Operator.setText(null);
                		comboBoxShift.setSelectedIndex(0);
                		comboBoxFail.setSelectedIndex(0);
                		comboBoxMachineNum.setSelectedIndex(0);
                		}
                		else if(!sSETUP_FAIL.equals(NONE)){
                			
                			sQty = "0";
                			DatabaseConn.dbSetupInput(sMold_Num,sID_Operator,iShift,sQty,sSETUP_FAIL,iMachine_Num);
                    		
                        	//Reset values in the GUI
                        	Mold_Num.setText(null);
                    		Qty.setText(null);
                    		ID_Operator.setText(null);
                    		comboBoxShift.setSelectedIndex(0);
                    		comboBoxFail.setSelectedIndex(0);
                    		comboBoxMachineNum.setSelectedIndex(0);
                		}
                		
                		
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
	
		public static SetupGUI getObj(){ 
		
			if(obj==null){ 
			
				obj=new SetupGUI(); 
				obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			}	return obj; 
			
		}
		
		private static Integer[] getAreaArray(){
			
			if (DatabaseConn.getAREA().equals("MOL1")){
				return MOL1_MA_Array;
			}
		
			else {
				return MOL2_MA_Array;
				}			
		
		}
		
}		
		

