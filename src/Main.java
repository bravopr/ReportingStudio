import java.awt.EventQueue;

/**
 * Copyright [2015] [Gustavo Bravo]
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardGUI MainGUIframe = new DashboardGUI();
					MainGUIframe.setTitle("Reporting Studio ");
					MainGUIframe.setLocationRelativeTo(null);					
					MainGUIframe.setVisible(true);					
					MainGUIframe.setResizable(false);	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
