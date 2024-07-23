package Practice.CRUDoperations;

public class Employee {
	 private  int employeeid;
	 private String employeeName;
	 private String employeeAddress;
	 private double employeeSalary;
	 
	 
	 
	public Employee(String employeeName, String employeeAddress, double employeeSalary) {
		
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
		
	}// End of  Employee parametrized constructor for insert employee details
	
	
	public Employee(int employeeid, String employeeName, String employeeAddress, double employeeSalary) {
		super();
		this.employeeid = employeeid;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
		
	} //end of Employee constructor of show allemployeedetails  






	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	 
	
	

}
