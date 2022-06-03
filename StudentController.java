import java.sql.*;
public class StudentController {
	private StudentModel model;
	private StudentView view;
	
	public StudentController (StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public static void newStudent(int id, String name, String department, double math, double science) throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
			    "user=root&password=Ahmad01.&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		Statement stmt = conn.createStatement();
		
		// Inserting data into database
		stmt.executeUpdate("INSERT INTO STUDENT VALUES (" + id + ", '" + name + "', '" + department + "', " + math + ", " + science + ");");

		// Send a notification
		System.out.println("Data is saved into database.");
	}
	
	// Read data from database and put it on Model class and send it back to view
	public static void getStudent(int id)throws SQLException{
		// Create an object for model class
		StudentModel student = new StudentModel();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
			    "user=root&password=Ahmad01.&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		
		// Searching for specific student from the database
		String mySQL = "SELECT * FROM STUDENT WHERE ID = " + id;
		
		// Execute the statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(mySQL);
		
		if(rs.next()) {
			student.setid(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setDepartment(rs.getString("department"));
			student.setScienceMark(rs.getDouble("science"));
			student.setMathMark(rs.getDouble("math"));
		}
	}
	
	public void updateView() {
		view.printStudentDetails(model.getid(), model.getName(), model.getMathMark(), model.getScienceMark(), model.getDepartment());
	}
}
