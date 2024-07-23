package Practice.CRUDoperations;

import java.sql.SQLException;
import java.util.Scanner;

import DatabaseService.DbService;
import JDBCConnectivity.DbResource;

public class App 
{
	
    public static void main( String[] args ) throws NumberFormatException, SQLException
    {
    
    	DbResource db = new DbResource();//DbResource Object
    	
    	DbService dbservice =new DbService();//DbService Object
    	
    	
    	try(Scanner sc=new Scanner(System.in);)
    	{
    		boolean isRunning =true;
    		while(isRunning)
            {
            	System.out.println("Enter a choice between 1 to 5 : ");
                System.out.println("1. Insert ");
                System.out.println("2. Select All ");
                System.out.println("3. Select employee by  an id");
                System.out.println("4. Delete employee");
                System.out.println("5. Update employee");
                System.out.println("6. Exit");
                
                
                int choice = Integer.parseInt(sc.nextLine());
                switch(choice)
                {
                case 1: 
                {
                	System.out.println("Enter name , address , salary :");
                	dbservice.insertEmployee(new Employee(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()) ));
                	
                	break;
                }
                case 2:
                {
                	dbservice.showAllEmployeesDetails();
                	break;
                }
                case 3:
                {
                	System.out.println("Enter Employee id :");
                	dbservice.getEmployeeIdDetails(Integer.parseInt(sc.nextLine()));
                	break;
                }
                case 4:
                {
                	System.out.println("Enter Employee id to be delete:");
                	dbservice.deleteEmployeeById(Integer.parseInt(sc.nextLine()));                                 	
                	break;
                }
                case 5:
                {
                	System.out.println("Enter Emloyee id :");
                	int updateId=Integer.parseInt(sc.nextLine());
                	boolean isFound=dbservice.getEmployeeIdDetails(updateId);
                	if(isFound=true)
                		
                	{
                		System.out.println("Enter Name , Address , Salary :");
                		 Employee employee=new Employee(updateId, sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
                		 dbservice.updateEmployeeDetail(employee);
                	}
               
                	break;
                }
                case 6:
                { 
                	isRunning=false;
                	System.out.println("Thank You. Visit again. ");
                	break;
                }
                default :
                
                  System.out.println("Incorrect choice");
                  break;
                }
                }
            } catch (Exception e ) {
            	throw new RuntimeException("Something went wrong ",e);
    	}
        
        
    }

}