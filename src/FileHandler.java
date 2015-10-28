import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * Copyright [2015] [Gustavo Bravo]
 */
public class FileHandler {

	
	public static boolean PTNOCheck(String PTNO, String Area)
	{
		
		try {
			FileInputStream fstream = new FileInputStream("\\\\ind-mj01q7qt.logon.ds.ge.com\\SDATA\\MRS_PROGRAM\\MOLDING_DATABASES\\"+Area+"_PTNO_Database.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String readLine;

			//Read File Line By Line
			while ((readLine = br.readLine()) != null)   {
			  // Gather the content on a String
				String PTNOread = readLine.substring(0, readLine.indexOf(','));
			  		  
			  if (PTNOread.equals(PTNO.toUpperCase()))
			  {
				//Part Found!
				return true;  
			  }
			  
			}

			//Close the input stream		
				br.close();
				
			} catch (Exception e) {
			//	JOptionPane.showMessageDialog(null,"Error: Enter a valid part number. / Entre un número de pieza valido.");
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		 //Part Not Found!
		
		return false;
		
	}
	
	public static void PTNOWriter(String PTNO, String Area)
	{				
			//FileInputStream fstream = new FileInputStream("\\\\ind-mj01q7qt.logon.ds.ge.com\\SDATA\\MRS_PROGRAM\\MOLDING_DATABASES\\"+Area+"_PTNO_Database.txt");
			
		String filename= "\\\\ind-mj01q7qt.logon.ds.ge.com\\SDATA\\MRS_PROGRAM\\MOLDING_DATABASES\\"+Area+"_PTNO_Database.txt";
			
			    
			    BufferedWriter bw;

			    try {
			        bw = new BufferedWriter(new FileWriter(filename, true));
			        bw.write(PTNO+",");
			        bw.newLine();
			        bw.flush();
			        bw.close();	 
			    } catch (IOException ioe) {
			        ioe.printStackTrace();
			   	}
			
		
     }
}
	

