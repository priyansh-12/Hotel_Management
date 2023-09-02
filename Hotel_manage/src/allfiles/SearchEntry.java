package allfiles;
import java.sql.*;
import java.util.*;


public class SearchEntry {

 void search()
 {
	 Scanner sc = new Scanner(System.in);
	System.out.println("\n enter the room no. for getting details ");
	int r_no= sc.nextInt();
	try
	{
		//loading jdbc drivers
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establishing connection 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minesql","root", 
				 "Maltare123@");
		//executing statement
		PreparedStatement st = con.prepareStatement("select * from hotel_entry where Room_no = ? ");
		st.setInt(1, r_no);
		ResultSet rs = st.executeQuery();		
		if(rs.isBeforeFirst()) {
			rs.next();
			System.out.println(rs.getInt("Room_no") +
					" : " + rs.getString("Name_p") + " : " + rs.getString(3) + " : " + rs.getString(4) + " : " +
					rs.getInt(5) + " : " + rs.getInt(6));
			}
		else
			System.out.println("no such product found"
					+ " in the database");
			
			//7) close the database Connection.
			con.close();
		
	}
	
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	catch(NullPointerException exe)
	{
		System.out.println("problem with "
				+ "database connection : " 
				+ exe);
	}
 }

}
