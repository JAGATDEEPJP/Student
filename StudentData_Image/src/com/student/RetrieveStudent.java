package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class RetrieveStudent {
	String name;
	int rollno;
	int phy;
	int chem;
	int math;
	String dob;
	String path;
	public RetrieveStudent(int rno)
	{
		
		String url = "jdbc:mysql://127.0.0.1:3306/student_image?useSSL=false";
        String user = "Jagatdeep";
        String password = "Semraj@135";
	    
	    String query = "SELECT * FROM student_image.Student_Details WHERE(`Roll No` = '"+rno+"')";
	    try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();){
        		System.out.println("Hello");
        		ResultSet rs = st.executeQuery(query);
        		System.out.println("Hello1");
        		while(rs.next())
        		{
        			name = rs.getString("Name");
            		rollno = rs.getInt("Roll No");
            		phy = rs.getInt("Physics");
            		chem = rs.getInt("Chemistry");
            		math = rs.getInt("Mathematics");
            		dob = rs.getString("DOB");
            		path = rs.getString("Path");
        		}
        		}
	    catch (SQLException ex) {
                Logger lgr = Logger.getLogger(SaveStudent.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            } 
	}
}
