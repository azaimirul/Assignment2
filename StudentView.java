import java.sql.*;
import java.util.Scanner;

public class StudentView {
	
	public void printStudentDetails(int n) {
		StudentModel student = new StudentModel();
		StudentController controller = new StudentController(student, this);
		
		Scanner input = new Scanner(System.in);
		
		if (n == 1) {
			
			try {
				System.out.println("Enter New Data.");
				System.out.print("Student ID: ");
				int id = input.nextInt();
				
				System.out.print("Student name: ");
				String name = input.next();
				
				input.nextLine();
				System.out.print("Please enter the department: ");
				String department = input.nextLine();
		
				System.out.print("Please enter the math mark: ");
				double math = input.nextDouble();
				
				System.out.print("Please enter the science mark: ");
				double science = input.nextDouble();
				
				// Inserting the data through controller
				StudentController.newStudent(id, name, department, math, science);
			} catch (SQLException e) {
				e.printStackTrace();				
			}
		}else if (n == 2) {
			// Reading student's id from user
			System.out.print("Please enter the Student ID: ");
			int id = input.nextInt();
			try {
				// Reading data from database through controller
				StudentController.getStudent(id);
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}
		
	}
	
	public void printStudentDetails(int stuID, String stuName, double stuMath, double stuSci, String department) {
		System.out.println("ID: "+ stuID);
		System.out.println("Name: "+ stuName);
		System.out.println("Math Score: "+ stuMath);
		System.out.println("Science Score: "+stuSci);
		System.out.println("Department: "+ department);
	}

}
