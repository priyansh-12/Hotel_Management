package allfiles;
import java.sql.*;
import java.util.*;
public class DeleteEntry {
	void delete()
	{
		try
		{
	 Scanner sc = new Scanner(System.in);
	 System.out.println("\n Enter the Room no. to delete ");
	 int r_n = sc.nextInt();
			//loading jdbc drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			//	setting up the connection
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minesql","root", 
					 "Maltare123@");
			
			//execute query
			PreparedStatement st = con.prepareStatement("delete from hotel_entry where Room_no=?");
			st.setInt(1, r_n);
		
			int count = st.executeUpdate();
			
			if(count > 0)
				System.out.println("product deleted");
			else
				System.out.println("no such product found");
			
			//7) close the database Connection.
			con.close();
		} 
			
			
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException exc) {
			System.out.println("problem with "
					+ "database connection : " 
					+ exc);	
		}
		
	}

}
