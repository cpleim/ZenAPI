package com.zennetlabs.zenapi.services.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.zennetlabs.zenapi.BusinessManager;

@Path("/v1/users")
public class UsersResource {

	// GET user by ID
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByID(@PathParam("userId") String userId) {

		System.out.print("[DEBUG INFO] UsersResource::getUserByID -> Routine Started. userId =" + userId + "\n");
		if (userId == null) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{\"error\":\"Not Authoized. The param userId cannot be empty\", \"status\":\"FAIL\"}")
					.build();
		}

		try {
			User user = BusinessManager.getInstance().findUsers(userId);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"User not found.\", \"status\":\"FAIL\"}").build();

	}

	// GET all users
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {

		try {
			List<User> users = BusinessManager.getInstance().findUsers();
			UsersHolder usersHolder = new UsersHolder();
			usersHolder.setUsers(users);
			return Response.status(Response.Status.OK).entity(usersHolder).build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"User not found.\", \"status\":\"FAIL\"}").build();

	}

	// CREATE user
	@POST
	@Path("/")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createUser(User user) {
		try {
			User newUser = BusinessManager.getInstance().addUser(user);
			return Response.status(Response.Status.CREATED).entity(newUser).build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Could not create user.\", \"status\":\"FAIL\"}").build();
	}

	// UPDATE user
	@PUT
	@Path("/{userId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateUser(@PathParam("userId") String userId, String jsonString) {
		/*
		 * { "name":"Armando Paredes" }
		 */

		String name;

		try {
			Object obj = JSONValue.parse(jsonString);
			JSONObject jsonObject = (JSONObject) obj;
			name = (String) jsonObject.get("name");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{\"error\":\"Invalid or missing fields.\", \"status\":\"FAIL\"}").build();
		}

		try {
			User updatedUser = BusinessManager.getInstance().updateUserAttribute(userId, "name", name);
			return Response.status(Response.Status.OK).entity(updatedUser).build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Could not update user.\", \"status\":\"FAIL\"}").build();
	}

	@DELETE
	@Path("/{userId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteUser(@PathParam("userId") String userId) {
		try {
			BusinessManager.getInstance().deleteUser(userId);
			return Response.status(Response.Status.OK).entity("{}").build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Could not update user.\", \"status\":\"FAIL\"}").build();
	}

}
