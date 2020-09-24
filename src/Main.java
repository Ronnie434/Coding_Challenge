import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static Employee createDeveloper() {
		return new Employee("Developer", 2000,null);
	}
	
	public static Employee createQA() {
		return new Employee("QA", 1000,null);
	}
	
	public static Employee createManager(List<Employee> Employees) {
		return new Employee("Manager",600,Employees);
	}
	

	public static Department testDepartment() {
		Department department = new Department();

		List<Employee> reporteesToB = new ArrayList<Employee>();
		reporteesToB.add(createDeveloper());
		reporteesToB.add(createQA());
		Employee managerB = createManager(reporteesToB);
		
		List<Employee> reporteesToA = new ArrayList<Employee>();
		reporteesToA.add(managerB);
		Employee managerA = createManager(reporteesToA);

		Employee managerD = createManager(null);

		List<Employee> employesOfC = new ArrayList<Employee>();
		employesOfC.add(managerD);
		
		Employee managerC = createManager(employesOfC);

		List<Employee> reporteesToE = new ArrayList<Employee>();
		reporteesToE.add(createDeveloper());
		Employee managerE = createManager(reporteesToE);

		List<Employee> managers = new ArrayList<Employee>();
		managers.add(managerA);
		managers.add(managerE);
		managers.add(managerC);

		department.setEmployees(managers);
		
		System.out.println("Manager A "+ costOfEmployee(managerA));
		System.out.println("Manager B "+ costOfEmployee(managerB));
		System.out.println("Manager C "+ costOfEmployee(managerC));
		System.out.println("Manager D "+ costOfEmployee(managerD));
		System.out.println("Manager E "+ costOfEmployee(managerE));

		return department;
	}

	public static int costOfDepartment(Department dept) {
		int totalcost = 0;

		for (Employee e : dept.getEmployees()) {
			totalcost += costOfEmployee(e);
		}

		return totalcost;
	}

	public static int costOfEmployee(Employee employee) {
		int totalCost = employee.getMonthlyCost();
		if (employee.getReportees() != null) {
			for (Employee e : employee.getReportees()) {
				totalCost += costOfEmployee(e);
			}
		}
		return totalCost;
	}

	public static void main(String[] args) {
		Department dept = testDepartment();
		int cost = costOfDepartment(dept);
		System.out.println("cost of department is " + cost);
	}
}

