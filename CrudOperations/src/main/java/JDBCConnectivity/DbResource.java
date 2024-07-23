package JDBCConnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbResource
{
	private static final String DRIVER_Path="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/employee ";
	private static final  String USERNAME="root";
	private static final String PASSWORD="Raghu4027";
	public void DbResourse() 
	{
		try {
			Class.forName(DRIVER_Path);
		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong "+ e);
			e.printStackTrace();
		}
	}//End of Constructor
	public Connection getConnection() throws SQLException {
		
			return DriverManager.getConnection(URL, USERNAME,PASSWORD);
		
	}//End of get connection
}
