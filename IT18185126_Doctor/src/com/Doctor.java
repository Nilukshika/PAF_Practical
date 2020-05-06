package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {
	
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =
					DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/practical", "root", "");
			// For testing
						System.out.println("Successfully connected---1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	} 

	// reading an items -------------------------
	public String readdoctor()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Doctor Name</th> <th>Doctor NIC</th> <th>Gender</th> <th>Register No</th> <th>Specialized</th> <th>Email</th>"+ "<th>Update</th><th>Remove</th></tr>";
			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next())
			{
				String Docid = Integer.toString(rs.getInt("DocID"));
				String name = rs.getString("DocName");
				String docNIC = rs.getString("DocNIC");
				String gender = rs.getString("Gender");
				String reqNo = rs.getString("ReqNo");
				String specialized = rs.getString("Specialized");
				String email = rs.getString("Email");
			
				 

				// Add into the html table
				output += "<tr><td><input id='hidDoctorIDUpdate'name='hidDoctorIDUpdate' type='hidden'value='" + Docid + "'>" + name + "</td>";output += "<td>" + docNIC + "</td>";output += "<td>" + gender + "</td>";output += "<td>" + reqNo + "</td>";output += "<td>" + specialized + "</td>";output += "<td>" + email + "</td>";
				// buttons
				//output += "<td><input name='btnUpdate' type='button'"+ "value='Update'"+"class='btnUpdate btn btn-secondary'></td>"+"<td><input name='btnRemove' type='button'"+" value='Remove'"+"class='btnRemove btn btn-danger' data-Docid='"+ DocID + "'>" + "</td></tr>";
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button'value='Remove' class='btnRemove btn btn-danger' data-Docid='"
						+ Docid + "'>" + "</td></tr>";			
			
			}
			con.close();
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading .";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//inserting---------------------
	public String insertDoctor(String name, String docNIC,String gender,String reqNo,String specialized,String email)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into doctor(`DocID`, `DocName`, `DocNIC`, `Gender`, `ReqNo`, `Specialized`, `Email`)"+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			System.out.println("h");
			// binding values
			preparedStmt.setInt(1, 0);
			//System.out.println("h");
			preparedStmt.setString(2, name);
			//System.out.println("h1");
			preparedStmt.setString(3, docNIC);
			//System.out.println("h2");
			preparedStmt.setString(4, gender);
			//System.out.println("h3");
			preparedStmt.setString(5,reqNo);
			//System.out.println("h4");
			preparedStmt.setString(6, specialized);
			//System.out.println("h5");
			preparedStmt.setString(7, email);
			//System.out.println("h6");
			//System.out.println("h7");
			
			// execute the statement
			preparedStmt.execute();
			
			 System.out.print("successfuly inserted");
			 
			con.close();
			String newDoctor = readdoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//update items
	public String updatedoctor(String Docid, String name, String docNIC, String gender, String reqNo,String specialized,String email)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE doctor SET DocName=?,DocNIC=?,Gender=?,ReqNo=?,Specialized=?,Email=? WHERE DocID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, docNIC);
			preparedStmt.setString(3, gender);
			preparedStmt.setString(4, reqNo);
			preparedStmt.setString(5, specialized);
			preparedStmt.setString(6, email);
			preparedStmt.setInt(7, Integer.parseInt(Docid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoctor = readdoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\":\"Error while updating the doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//delete items------------------------
	public String deletedoctor(String Docid) {
		String output = "";
		try  {
			Connection con = connect();
			if (con == null)
				return "Error while connecting to the database for deleting.";
			
			// create a prepared statement
			String query = "delete from doctor where DocID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Docid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Deleted successfully";
			String newdoctor = readdoctor();
			output = "{\"status\":\"success\", \"data\": \"" + newdoctor + "\"}";
		} catch (Exception e) {
			//output = "Error while deleting patient....";
			output = "{\"status\":\"error\", \"data\": \"Error while deleting doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}


}
