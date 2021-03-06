package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import usr.Worker;
import usr.WorkerLevel;

public class Program {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		Scanner sc  = new Scanner(System.in);
		double result = 0;
		
		System.out.println("Enter worker data");
		System.out.println();
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.nextLine()) ;
		System.out.print("Base salary:");
		double baseSalary = sc.nextDouble();
		System.out.println();
		
		Worker worker = new Worker(department, name,level,baseSalary);
		System.out.println();
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n;i++) {
			System.out.println();
			System.out.println("Enter contract #" + (i+1)  + " data: ");
			sc.nextLine();
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			double duration = sc.nextDouble();
			
			worker.realizeContract(date, valueHour, duration);  
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY)");
		Date dateIncome = sdf1.parse(sc.next());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateIncome);
			
		int x_year =  cal.get(Calendar.YEAR);
		int x_month = 1 + cal.get(Calendar.MONTH);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+ worker.getDepartment());
		System.out.println("Level: " + worker.getLevel());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Income: R$"+ worker.income(x_year, x_month));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		sc.close();
	}

}
