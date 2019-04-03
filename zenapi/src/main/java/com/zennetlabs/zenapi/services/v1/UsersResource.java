package com.zennetlabs.zenapi.services.v1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zennetlabs.zenapi.BusinessManager;

@Path("/v1/users")
public class UsersResource {
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

}
