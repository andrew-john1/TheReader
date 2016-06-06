import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

import java.sql.SQLException;
 
@Path("/orientationsensor")
public class OrientationSensor {
	
	OrientationService orientationService = new OrientationService();
	  
	  @GET
	  @Produces("application/json")
	  public String getOrientation() throws ClassNotFoundException, SQLException {
		  // create a new Gson instance
		 Gson gson = new GsonBuilder().create();
		  List<Orientation> listOfOrientations = orientationService.getAllOrientations();
		  // convert your list to json
		  String jsonOrientationList = gson.toJson(listOfOrientations);
		  return jsonOrientationList;
	  }
 
	  @GET
	  @Path("{sensorId}")
	  @Produces("application/json")
	  public String getOrientationById(@PathParam("sensorId")int id) throws ClassNotFoundException, SQLException, InterruptedException {
		  // create a new Gson instance
		  Gson gson = new GsonBuilder().create();
		  Orientation orientation = orientationService.getOrientation(id);
		  // convert your list to json
		  String jsonOrientation = gson.toJson(orientation);
		  return jsonOrientation;
	  }
	  
	  @POST
	  @Path("/create")
	  @Produces("application/json")
	  public String addOrientation(
		  @FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("age") int age) throws ClassNotFoundException, SQLException {
		  
		  String result = orientationService.createOrientation(id, name, age);
		  
		  return result;
	          
	  }
	  
	  @PUT
	  @Path("/update")
	  @Produces("application/json")
	  public String updateOrientation( 
			  @FormParam("id") int id,
		      @FormParam("name") String name,
		      @FormParam("age") int age) throws ClassNotFoundException, SQLException {
		
		  return orientationService.updateOrientation(id, name, age);
	  }
//	  
//	  @DELETE
//	  @Path("/delete/{id}")
//	  @Produces("application/json")
//	  public void deleteOrientation(@PathParam("id")int id) {
//		  orientationService.deleteOrientation(id);
//	  }
//	  public String delete(@PathParam("sensorId") float sensorId) throws ClassNotFoundException, SQLException {
//		  return "Sensor " + sensorId + " succesfull deleted";
//		  
////			// Register JDBC driver
////			Class.forName("com.mysql.jdbc.Driver");
////				 
////			// Open a connection
////			Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
////
////	          // Execute SQL query
////	          Statement stmt = conn.createStatement();
////	          String query = "DELETE FROM students WHERE id = " + sensorId;
////	          stmt.executeQuery(query);
////	          
////	          stmt.close();
////	          conn.close();
////	          
////	          return "Sensor " + sensorId + " succesfull deleted";	          
//	          
//	  }
	  
}