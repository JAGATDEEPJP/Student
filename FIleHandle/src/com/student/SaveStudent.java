package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveStudent {
	String name,dob;
	int rollno,phy,chem,math;
	public SaveStudent(String name_, int rollno_, int phy_, int chem_, int math_, String dob_) {
		// TODO Auto-generated constructor stub
		name = name_;
		rollno = rollno_;
		phy = phy_;
		chem = chem_;
		math = math_;
		dob = dob_;
	}
	
	public void saveStudent()
	{
		
		String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "Jagatdeep";
        String password = "Semraj@135";
        
        String query = "INSERT INTO `student`.`Student_Details` (`Name`, `Roll No`, `Physics`, `Chemistry`, `Mathematics`, `DOB`) VALUES ('"+name+"','"+rollno+"','"+phy+"','"+chem+"','"+math+"','"+dob+"');";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ) {
        	System.out.println("Hello");
        		int rs = st.executeUpdate(query);
                
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(SaveStudent.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            } 
	}

}
