import java.util.Scanner;
public class StudentDemo {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
		StudentView view = new StudentView();
		
		boolean loop = true;
				
		while(loop) {
			System.out.println("Please insert:\n"
					+ "1: create new data\n"
					+ "2: check student marks");
			int choose = input.nextInt();
			
			while(choose != 1 && choose != 2) {
				System.out.println("Invalid input. Please try again.");
				System.out.println("Please insert:\n"
						+ "1: create new data\n"
						+ "2: check student marks");
				choose = input.nextInt();
			}
			
			view.printStudentDetails(choose);
			
			System.out.println("Enter 1 to continue, 2 to exit");
			if(input.nextInt()==1)
				loop = true;
			else loop = false;
	}
	System.out.println("Program ended.");
	System.exit(0);
	}
	
}
