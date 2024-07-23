package DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConnectivity.DbResource;
import JDBCConnectivity.QueryUtil;
import Practice.CRUDoperations.Employee;

public class DbService {
	DbResource dbcon=new DbResource();
	

	public void insertEmployee(Employee employee) throws SQLException
	{
		try(Connection con=dbcon.getConnection();
			PreparedStatement preparedstatement=con.prepareStatement(QueryUtil.insertEmployeeQuery());){
			
			preparedstatement.setString(1, employee.getEmployeeName());
			preparedstatement.setString(2, employee.getEmployeeAddress());
			preparedstatement.setDouble(3, employee.getEmployeeSalary());
			
			int rows=preparedstatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Record created successfully.");
			}else {
				System.out.println("Insert record failed..");
			}
		}
		
		System.out.println("insert is done");
	}//End of Insert Employee details
	
	
	public void showAllEmployeesDetails() throws SQLException
	{
		try(Connection con=dbcon.getConnection();
				Statement statement=con.createStatement();
				ResultSet resultset=statement.executeQuery(QueryUtil.selectAllEmployeeQuery());)
		{
			while(resultset.next())
			{
				printEmployee(new Employee(resultset.getInt("employeeid"),resultset.getString("employeename"),
						resultset.getString("employeeaddress"),resultset.getDouble("employeesalary")));
			}
		}  
	}//End of showallemployeeDetails()
	
	
	private static void printEmployee(Employee employee)
	{
		System.out.println("Employee Id : "+ employee.getEmployeeid());
		System.out.println("Employee Name : "+ employee.getEmployeeName());
		System.out.println("Employee Address : "+ employee.getEmployeeAddress());
		System.out.println("Employee salary : "+ employee.getEmployeeSalary());
	}//End of PrintEmployee()
	
	
	public boolean getEmployeeIdDetails(int id)throws SQLException {
		boolean isFound=false;
		try(Connection con=dbcon.getConnection();
				Statement statement=con.createStatement();
				ResultSet resultset=statement.executeQuery(QueryUtil.selectEmpDetailsById(id))){
			if(resultset.next())
			{
				isFound=true;
				printEmployee(new Employee(resultset.getInt("employeeid"), resultset.getString("employeename"), resultset.getString("employeeaddress"),
						resultset.getDouble("employeesalary") ));
			}
			else
			{
				System.out.println("Record not found for an id : "+id);
			}
		}
		return isFound;
	}//End of getEmployeeDetails()
	
	public void deleteEmployeeById(int id) throws SQLException {
		try(Connection con=dbcon.getConnection();
				Statement statement=con.createStatement();
				)
		{
			int rows =statement.executeUpdate(QueryUtil.deleteEmpById(id));
			if(rows>0)
			{
				System.out.println("Employee  Record is deleted");
			}
			else {
				System.out.println("Something is wrong : ");

			}
		}
	}//End of deleteEmloyeeById()
	
	public void updateEmployeeDetail(Employee employee) throws SQLException
	{
		try(Connection con=dbcon.getConnection();
				PreparedStatement preparedstatement=con.prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmployeeid()));){

			preparedstatement.setString(1, employee.getEmployeeName());
			preparedstatement.setString(2, employee.getEmployeeAddress());
			preparedstatement.setDouble(3, employee.getEmployeeSalary());
			int rows=preparedstatement.executeUpdate();
			if(rows>0)
			{
				System.out.println("Record updated Successfully");
			}
			else
				{
				System.out.println("Failed to update record");	
				}
		}
	}//End of updateEmployeeDetails()

	
}
