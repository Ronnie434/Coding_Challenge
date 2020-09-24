import java.util.List;

public class Employee {

	String jobFunction;
	int monthlyCost;
	List<Employee> reportees;
	
	public Employee(String jobFunction,int monthlyCost,List<Employee> reportees){
		this.jobFunction=jobFunction;
		this.monthlyCost=monthlyCost;
		this.reportees=reportees;
	}
	public String getJobFunction() {
		return jobFunction;
	}

	public int getMonthlyCost() {
		return monthlyCost;
	}

	public List<Employee> getReportees() {
		return reportees;
	}
}