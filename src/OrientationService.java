import java.util.*;
import java.util.concurrent.CountDownLatch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrientationService { 
	
	// JDBC driver name and database URL
	String DB_URL="jdbc:mysql://127.0.0.1:3306/mobile-infra?autoReconnect=true&useSSL=false";
	
	//  Database credentials
	String USER = "root";
	String PASSWORD = "";
	
	public OrientationService() {
		super();
	}
	
	public List<Orientation> getAllOrientations() throws ClassNotFoundException, SQLException {
		List<Orientation> orientations = new ArrayList<Orientation>();
		
		// Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
			 
	    // Open a connection
	    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

          // Execute SQL query
          Statement stmt = conn.createStatement();
          String query = "SELECT * FROM students";
          ResultSet rs = stmt.executeQuery(query);
          
          // Extract data from result set
          while(rs.next()){
              //Retrieve by column name
             int id  = rs.getInt("id");
             int age = rs.getInt("age");
             String name = rs.getString("name");
             
             Orientation orientation = new Orientation(id, name, age);
                      
             orientations.add(orientation);
          }
        
          // Clean-up environment
          rs.close();
          stmt.close();
          conn.close();
          
          return orientations;
	}
	
	public Orientation getOrientation(int orientationId) throws SQLException, ClassNotFoundException, InterruptedException {
			
			Orientation orientation = null;
			
		  	// Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");
				 
		    // Open a connection
		    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

	          // Execute SQL query
	          Statement stmt = conn.createStatement();
	          String query = "SELECT * FROM students WHERE id = " + orientationId;
	          ResultSet rs = stmt.executeQuery(query);
	          	          
	          // Extract data from result set
	          while(rs.next()){
	              //Retrieve by column name
	             int id  = rs.getInt("id");
	             String name = rs.getString("name");
	             int age = rs.getInt("age");
	             
	             orientation = new Orientation(id, name, age);
	             
	          }
	          
	          // Clean-up environment
	          rs.close();
	          stmt.close();
	          conn.close();
	          
	          return orientation;
	        
	  }
	
	public String createOrientation(int id, String name, int age) throws SQLException, ClassNotFoundException {
				
		// Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
			 
	    // Open a connection
	    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

          // Execute SQL query
          Statement stmt = conn.createStatement();
          String query = "INSERT INTO students VALUES (" + id + ", '" + name + "', " + age + ")" ;
          stmt.executeUpdate(query);          
          
          stmt.close();
          conn.close();
		
		return "New Orientation added";
		
	}
	
	public String updateOrientation(int id, String name, int age) throws SQLException, ClassNotFoundException {
		
		// Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
			 
	    // Open a connection
	    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	    
	    System.out.println(id);
	    System.out.println(name);
	    System.out.println(age);

          // Execute SQL query
          Statement stmt = conn.createStatement();
          String query = "UPDATE students SET name = '" + name + "', age = " + age + " WHERE id = " + id ;
          stmt.executeUpdate(query);          
          
          stmt.close();
          conn.close();
		
		return "Orientation updated";
		
	}

	
}
