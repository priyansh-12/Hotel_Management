package allfiles;
import java.sql.*;
import java.util.Scanner;

public class InsertEntry {
	void insert()
	{
      Scanner sc = new Scanner(System.in);
     System.out.println("\n Enter Following Things ");
     
     System.out.println("\n Enter Room Number : ");
     int rn = sc.nextInt();		
     
     System.out.println("\n Enter Name : ");
     String nm = sc.next();
     
     System.out.println("\n Enter Address : ");
     String address = sc.next();
     
     System.out.println("\n Enter Room Type : ");
     String room_t = sc.next();
     
     System.out.println("\n Enter Member's in family : ");
     int f_m = sc.nextInt();		
     
     System.out.println("\n Enter Number of bed : ");
     int no_bed = sc.nextInt();		
     
     try
     {
    	 //loading database drivers
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 
    	 //making connection
    	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minesql","root", 
"Maltare123@");
    	 
    	 //create statement to execute query
    	 PreparedStatement st = con.prepareStatement("insert into  hotel_entry"+
    	 "(Room_no,Name_p,Address,Room_type,No_of_people,No_of_bed) values(?,?,?,?,?,?)");
    	 
    	 st.setInt(1, rn);
    	 st.setString(2, nm);
    	 st.setString(3, address);
    	 st.setString(4, room_t);
    	 st.setInt(5, f_m);
    	 st.setInt(6, no_bed);
    	 
    		
 		int count = st.executeUpdate();
 	
 		if(count > 0)
 			System.out.println("product inserted");
 		else
 			System.out.println("product insertion "
 					+ "failed");
 		
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
