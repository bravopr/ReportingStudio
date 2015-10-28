import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * This class connects to a SQL Server in order to input data.
 * @author Gustavo Bravo
 *
 */
/**
 * Copyright [2015] [Gustavo Bravo]
 */
public class DatabaseConn {
	
	private static String DATABASE_LOCATION = "//SERVERNAME";
	private static String DATABASE_INSTANCE = DATABASE_LOCATION.substring(2, DATABASE_LOCATION.length()) + "\\SQLEXPRESS";
	private static String DATABASE_PORT = "1433";
	private static String DATABASE_NAME = "DATABASENAME";
	private static String DATABASE_SCRAP_TABLE = "TABLE1";
	private static String DATABASE_SETUP_TABLE = "TABLE2";
	private static String DATABASE_PROD_TABLE = "TABLE3";
	private static String USER = "User1";
	private static String PASSWORD = "password";
	private static String AREA = "MOL2";
	
	
	/**
	 * This method establishes a connection to a database and executes an insert query in the SCRAP table.
	 * Return void.
	 * @param PTNO
	 * @param ID_Operator
	 * @param Shift
	 * @param Qty
	 * @param Defect
	 */
	public static void dbScrapInput ( String PTNO, String ID_Operator, int Shift , String Qty, String Defect ) 
	{
				
		// Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver:"+DATABASE_LOCATION+":"+DATABASE_PORT+";"+"databaseName="+DATABASE_NAME+";"+"user="+USER+";"+"password="+PASSWORD;

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
			      
	      try {
            
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
        
         stmt = con.createStatement();        
         
         String Wqry = "INSERT INTO "+DATABASE_SCRAP_TABLE+" (PTNO,ID_OPERATOR,INPUT_DATE,SHIFT,QTY,DEFECT,AREA) VALUES ('"+PTNO+"','"+ID_Operator+"',"+"GETDATE()"+",'"+Shift+"','"+Qty+"','"+Defect+"','"+getAREA()+"')";
		
         //Execute query in the database.
         stmt.execute(Wqry); 
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
    	  JOptionPane.showMessageDialog(null,"ERROR: CAN NOT INPUT DATA INTO DATABASE.\n"+"\nSQL SERVER EXPRESS"+"\n DATABASE Instance:     "+DATABASE_INSTANCE+"\n PORT:     "+DATABASE_PORT+"\n DATABASE NAME:     "+DATABASE_NAME+"\n DATABASE TABLE:     "+DATABASE_SCRAP_TABLE+"\n\nPOSIBLE DATABASE CONNECTION ERROR");
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
   }
	
	
	/**
	 * This method establishes a connection to a database and executes an insert query in the SCRAP table.
	 * @param MOLD_NUM
	 * @param ID_Operator
	 * @param Shift
	 * @param Qty
	 * @param Defect
	 */
	public static void dbSetupInput ( String MOLD_NUM, String ID_Operator, int Shift , String SETUP_TIME, String FAIL_REASON, int sMachine_Num) 
	{
		if(FAIL_REASON.equals(SetupGUI.getNone()))
		{		
		// Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver:"+DATABASE_LOCATION+":"+DATABASE_PORT+";"+"databaseName="+DATABASE_NAME+";"+"user="+USER+";"+"password="+PASSWORD;

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
			      
	      try {
            
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
        
         stmt = con.createStatement();        
         
         String Wqry = "INSERT INTO "+DATABASE_SETUP_TABLE+" (MOLD_NUM,ID_OPERATOR,INPUT_DATE,SHIFT,SETUP_TIME,AREA,MACHINE_NUM) VALUES ('"+MOLD_NUM+"','"+ID_Operator+"',"+"GETDATE()"+",'"+Shift+"','"+SETUP_TIME+"','"+getAREA()+"','"+sMachine_Num+"')";
		
         //Execute query in the database.
         stmt.execute(Wqry); 
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
    	  JOptionPane.showMessageDialog(null,"ERROR: CAN NOT INPUT DATA INTO DATABASE.\n"+"\nSQL SERVER EXPRESS"+"\n DATABASE Instance:     "+DATABASE_INSTANCE+"\n PORT:     "+DATABASE_PORT+"\n DATABASE NAME:     "+DATABASE_NAME+"\n\nPOSIBLE DATABASE CONNECTION ERROR");
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
	      
	}
		else{
			
			// Create a variable for the connection string.
		      String connectionUrl = "jdbc:sqlserver:"+DATABASE_LOCATION+":"+DATABASE_PORT+";"+"databaseName="+DATABASE_NAME+";"+"user="+USER+";"+"password="+PASSWORD;

		      // Declare the JDBC objects.
		      Connection con = null;
		      Statement stmt = null;
		      ResultSet rs = null;
				      
		      try {
	            
	         // Establish the connection.
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	        
	         stmt = con.createStatement();        
	         
	         String Wqry = "INSERT INTO "+DATABASE_SETUP_TABLE+" (MOLD_NUM,ID_OPERATOR,INPUT_DATE,SHIFT,AREA,FAIL_REASON,MACHINE_NUM) VALUES ('"+MOLD_NUM+"','"+ID_Operator+"',"+"GETDATE()"+",'"+Shift+"','"+getAREA()+"','"+FAIL_REASON+"','"+sMachine_Num+"')";
			
	         //Execute query in the database.
	         stmt.execute(Wqry); 
	      }

	      // Handle any errors that may have occurred.
	      catch (Exception e) {
	    	  JOptionPane.showMessageDialog(null,"ERROR: CAN NOT INPUT DATA INTO DATABASE.\n"+"\nSQL SERVER EXPRESS"+"\n DATABASE Instance:     "+DATABASE_INSTANCE+"\n PORT:     "+DATABASE_PORT+"\n DATABASE NAME:     "+DATABASE_NAME+"\n\nPOSIBLE DATABASE CONNECTION ERROR");
	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }		
			
		}
	
   }

	public static void dbProdInput ( String PTNO, String ID_Operator, int Shift , String Qty) 
	{
				
		// Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver:"+DATABASE_LOCATION+":"+DATABASE_PORT+";"+"databaseName="+DATABASE_NAME+";"+"user="+USER+";"+"password="+PASSWORD;

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
			      
	      try {
            
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
        
         stmt = con.createStatement();        
         
         String Wqry = "INSERT INTO "+DATABASE_PROD_TABLE+" (PTNO,ID_OPERATOR,INPUT_DATE,SHIFT,QTY,AREA) VALUES ('"+PTNO+"','"+ID_Operator+"',"+"GETDATE()"+",'"+Shift+"','"+Qty+"','"+getAREA()+"')";
		
         //Execute query in the database.
         stmt.execute(Wqry); 
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
    	  JOptionPane.showMessageDialog(null,"ERROR: CAN NOT INPUT DATA INTO DATABASE.\n"+"\nSQL SERVER EXPRESS"+"\n DATABASE Instance:     "+DATABASE_INSTANCE+"\n PORT:     "+DATABASE_PORT+"\n DATABASE NAME:     "+DATABASE_NAME+"\n\nPOSIBLE DATABASE CONNECTION ERROR");
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
   }

	public static String getAREA() {
		return AREA;
	}
	
	}


