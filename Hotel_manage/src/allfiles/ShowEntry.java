package allfiles;

import java.sql.*;


public class ShowEntry {

	void show()
	{
		try
		{
			// loading drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			///setting up connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minesql","root", 
				"Maltare123@");
			///executing query
			PreparedStatement st = con.prepareStatement("select * from hotel_entry"); 
		 ResultSet rs = st.executeQuery();
		 if(rs.isBeforeFirst()) {
				//,Address,Room_type,No_of_people,No_of_bed
				System.out.println("All Entries are : ");
				
				while(rs.next()) {
					System.out.println(rs.getInt("Room_no") +
				" : " + rs.getString("Name_p") + " : " + rs.getString(3) + " : " + rs.getString(4) + " : " +
				rs.getInt(5) + " : " + rs.getInt(6));
				}
			}
			else
				System.out.println("no records found"
						+ " in the database");
				
				//7) close the database Connection.
				con.close();
		}
		 catch (ClassNotFoundException |
	    			SQLException e) {
	    				e.printStackTrace();
	    			}
	    			catch(NullPointerException exc) {
	    				System.out.println("problem with "
	    						+ "database connection : " 
	    						+ exc);	
	    			}
	     
	}
}
