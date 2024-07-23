package JDBCConnectivity;

import java.sql.PreparedStatement;

import Practice.CRUDoperations.Employee;

public class QueryUtil {
 
	public static String insertEmployeeQuery() {
		return "INSERT INTO EMPLOYEEDETAILS (employeename,employeeaddress,employeesalary) VALUES(?,?,?)";
	}
	
	public static String selectAllEmployeeQuery() {
		return "SELECT * FROM EMPLOYEEDETAILS;";
	}
	public static String selectEmpDetailsById(int id) {
		return "SELECT * FROM EMPLOYEEDETAILS WHERE EMPLOYEEID = "+ id;
	}
	public static String deleteEmpById(int id) {
		return "DELETE FROM EMPLOYEEDETAILS WHERE EMPLOYEEID = "+ id;
	}
	public static String updateEmployeeQuery(int  employeeid)
	{
		return "UPDATE EMPLOYEEDETAILS SET EMPLOYEENAME = ? , EMPLOYEEADDRESS= ? , EMPLOYEESALARY = ? WHERE EMPLOYEEID = "+employeeid ;
		
	}
}
