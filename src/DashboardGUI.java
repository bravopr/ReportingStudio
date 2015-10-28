import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DashboardGUI extends JFrame {
	private static String VerNum = "V1.2.1";
	private JPanel contentPane;

	
	/**
	 * Copyright [2015] [Gustavo Bravo]
	 */
	public DashboardGUI() {
		
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss a");		
		Calendar cal = Calendar.getInstance();
		String DATE = dateFormat.format(cal.getTime());
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
						
		JLabel lblArea = new JLabel("For: "+DatabaseConn.getAREA());
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblArea.setBounds(729, 32, 63, 14);
		contentPane.add(lblArea);
		
		JLabel lvlVer = new JLabel("Version: "+VerNum);
		lvlVer.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lvlVer.setBounds(729, 21, 63, 14);
		contentPane.add(lvlVer);
		
		JLabel label = new JLabel("Powered by bravopr");
		label.setForeground(SystemColor.text);
		label.setBounds(10, 433, 224, 29);
		contentPane.add(label);
		

		//Scrap button
		ImageIcon icon1 = new ImageIcon (this.getClass().getResource("scrap_icon.png"));		
		JButton btnScrap = new JButton("Report Scrap",icon1);		
		btnScrap.setVerticalTextPosition(SwingConstants.TOP);
		btnScrap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnScrap.setForeground(SystemColor.desktop);
		btnScrap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ScrapGUI frame = new ScrapGUI();					
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getObj().setVisible(true);
				//frame.setVisible(true);	
			}
		});
		btnScrap.setBounds(116, 185, 149, 130);
		contentPane.add(btnScrap);
		
		//Prod Button
		ImageIcon icon2 = new ImageIcon (this.getClass().getResource("prod_icon.png"));	
		JButton btnProd = new JButton("Report Prod",icon2);
		btnProd.setVerticalTextPosition(SwingConstants.TOP);
		btnProd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProd.setForeground(SystemColor.desktop);
		if(DatabaseConn.getAREA().equals("MOL1")){
		btnProd.setEnabled(false);}		
		btnProd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ProdGUI frame = new ProdGUI();					
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getObj().setVisible(true);
				//frame.setVisible(true);	
			}
		});
		btnProd.setBounds(316, 185, 149, 130);
		contentPane.add(btnProd);
		
		//Setup Button
		ImageIcon icon3 = new ImageIcon (this.getClass().getResource("time_icon.png"));	
		JButton btnSetup = new JButton("Report Setup",icon3);
		btnSetup.setVerticalTextPosition(SwingConstants.TOP);
		btnSetup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSetup.setForeground(SystemColor.desktop);
		
		btnSetup.setBounds(511, 185, 149, 130);
		//btnSetup.setEnabled(false);
		btnSetup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				SetupGUI frame = new SetupGUI();					
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getObj().setVisible(true);
				//frame.setVisible(true);	
			}
		});
		btnProd.setBounds(316, 185, 149, 130);
		contentPane.add(btnProd);
		contentPane.add(btnSetup);
		
						
		JLabel lblDash = new JLabel("Dashboard");
		lblDash.setForeground(Color.WHITE);
		
		lblDash.setBounds(341, 112, 107, 34);
		contentPane.add(lblDash);
		
		JLabel lblTitle = new JLabel("Molding Reporting Studio (MRS)");
		lblTitle.setForeground(SystemColor.text);
		
		lblTitle.setBounds(185, 48, 447, 40);
		contentPane.add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(198, 99, 397, 2);
		contentPane.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 792, 21);
		contentPane.add(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnOptions.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(null,"\n\nDevelop by Gustavo Bravo"+"\n"+getVerNum()+", Last opened: "+DATE);
            }
        });
		
		JMenuItem mntmAddPartNumber = new JMenuItem("Add Part Number");
		mntmAddPartNumber.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				AddPTNO frame = new AddPTNO();					
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//frame.getObj().setVisible(true);
				frame.setVisible(true);	
			}
		});
		//mnOptions.add(mntmAddPartNumber);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnOptions.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	System.exit(0);
            }
        }); 
		
		
		
		JLabel lblLogo = new JLabel("");		
		Image img = new ImageIcon (this.getClass().getResource("logo_full.jpg")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 21, 836, 452);
		contentPane.add(lblLogo);		
	
	
	}
			
	/**
	 * This method returns the version number of the program.
	 * @return VerNum
	 */
	public static String getVerNum() {
		return VerNum;
	}
}
