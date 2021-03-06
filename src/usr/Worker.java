package usr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import contracts.MainContract;

public class Worker {
	
	
	String department;
	String name;
	WorkerLevel level;
	double baseSalary;
	private ArrayList<MainContract> contractList = new ArrayList<>();
	
	
	public Worker() {}
	
	public Worker(String department,String name, WorkerLevel level, double baseSalary) {
		this.department = department;
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}
	
	
	public void realizeContract(Date data, double valueHour, double duration) {
		contractList.add(new MainContract(data,valueHour,duration));
	
	}
	
	public ArrayList<MainContract> getContract(){
		return this.contractList;
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public WorkerLevel getLevel() {
		return level;
	}


	public void setLevel(WorkerLevel level) {
		this.level = level;
	}


	public double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double income(int year, int month) {
		double result = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (MainContract x : this.getContract()) {
			cal.setTime(x.getDate());
			int x_year =  cal.get(Calendar.YEAR);
			int x_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == x_year && month == x_month) {
				result += x.getTotalValue();	
			}
		}
		return result;
		
	}
}
