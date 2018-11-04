/*package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "Jagatdeep";
        String password = "Semraj@135";
        
        String query = "SELECT VERSION()";
		String qry = "INSERT INTO `student`.`Student_Details` (`Name`, `Roll No`, `Physics`, `Chemistry`, `Mathematics`, `DOB`) VALUES ('pp', '5', '84', '84', '22', '1996-02-03');";
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ) {
        		int rs = st.executeUpdate(qry);
                /*if (rs.next()) {
                    
                    System.out.println(rs.getString(1));
                }

            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(DBConnect.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            } 
	}

}*/
