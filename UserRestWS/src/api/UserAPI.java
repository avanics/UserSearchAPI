package api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.JResponse;

import dao.UserDAO;
import bean.User;
@Path("/UserAPI")
public class UserAPI {

	 
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User();
		u1.setUserName("Avani");
		UserDAO userDAO =  new UserDAO();
		ArrayList<User> lstUsers = new ArrayList<User>();
		try {
			lstUsers = userDAO.fetchListOfUsers(u1);
			if(lstUsers!= null)
				System.out.println("Database operation successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@GET
	@Consumes("text/plain")
	@Path("/{id}/{name}/{dateJoined}")
	@Produces("application/xml")
	public Response getUserData( @PathParam("id") Integer id , @PathParam("name") String name , @PathParam("dateJoined")String dateJoined)
	{
		 
		UserDAO userDAO =  new UserDAO();
		User u1 = new User();
		u1.setUserId(id);
		u1.setUserName(name);
		Date dateJoined1 = null;
		u1.setDateJoined(dateJoined1);
		ArrayList<User> lstUsers = new ArrayList<User>();
		GenericEntity<List<User>> entity = null;
		
		
		try {
			
			lstUsers = userDAO.fetchListOfUsers(u1);
			entity = new GenericEntity<List<User>>(lstUsers) {};
			

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(entity).build();
	}

}
