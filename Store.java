package prob1;
import emps.Employee;
public class Store {
	private Employee[] emps = new Employee[20] ;
	private int numEmployees;
	//getters
	public int getNumEmployees() {
		return numEmployees;
	}
	//Constructor sets numEmployees=0
	public Store() {
		super();
		this.numEmployees = 0;
	}
	//add employees if array is not full
public void addEmployee(Employee e) {
	if(numEmployees < emps.length) {
		emps[numEmployees] = e;
		numEmployees++;
	}
}
//provided the index, loop through the array and retrieve the employee object
public Employee getEmployee(int i) {
	if(i >= 0 && i < 20) 
		return emps[i];
	return null;
	}
//add up the totalHours from each individual employee and return the grand total
public double getTotalHours() {
	double totalHours = 0;
	for(int i = 0; i < numEmployees; i++) {
		totalHours += emps[i].getTotalHours();
	}
	return totalHours;
}
//add up the totalPay from each individual employee and return the grand total
public double getTotalPay() {
	double totalpay = 0;
	for(int i = 0; i < numEmployees; i++) {
		totalpay += emps[i].getPay();
	}
	return totalpay;

}
public Employee removeEmployee(int i) {
	if(i>=0 && i<numEmployees) {
		Employee returnedEmp = emps[i];
		for(int j = i + 1 ; j < numEmployees; j++) {
			emps[j-1] = emps[j];
			}
			numEmployees--;
			return returnedEmp;
	}
	return null;
}

public Employee getEmployeeWithName(String findName) {
   for(int i = 0; i < numEmployees; i++) {
	   if(emps[i].getName().equals(findName)) {
		return emps[i];
	   }}
	return null;
}
@Override
public String toString() {
	String msg = " Payroll Report\n";
	
	msg += String.format("\n Num employees: %d,total hrs: %.2f, total pay= $%.2f \r\n", getNumEmployees() , getTotalHours(), getTotalPay());
	for(int i = 0; i < numEmployees; i++) {
	msg +=String.format("\n\n Pay Stub\n --------");            
	msg += String.format("\n Name: %s, Pay Rate $%.2f \r\n", emps[i].getName() ,emps[i].getPayRate());
	msg += String.format(" Hours:Mon: %.2f Tue: %.2f Wed: %.2f Thu: %.2f Fri: %.2f Sat: %.2f Sun:%.2f \r\n" , emps[i].getHours(0) , emps[i].getHours(1) , emps[i].getHours(2), emps[i].getHours(3) , emps[i].getHours(4), emps[i].getHours(5) , emps[i].getHours(6)); 
	msg += String.format(" Days worked: %d, Total Hours: %.2f" ,emps[i].getNumDaysWorked() , emps[i].getTotalHours());
	msg += String.format("\n Weekday hours: %.2f, Weekend hours: %.2f", emps[i].getWeekdayHours(), emps[i].getWeekendHours());
	msg += String.format("\n Total pay: $%.2f" , emps[i].getPay());
			}
	return msg;
}
}
