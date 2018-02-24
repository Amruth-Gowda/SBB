package com.MavenProject.SmartBookBorrow.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MavenProject.SmartBookBorrow.model.User;
import com.MavenProject.SmartBookBorrow.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	UserService userService = new UserService();
	
	@POST
	public User addUser(User user) {
		return userService.addUser(user);
	}
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam("userId") int id) {
		return userService.getUser(id);
	}



}
