package com.zennetlabs.zenapi.services.v1;

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
		System.out.print("[DEBUG INFO] UsersResource::getUserByID -> Routine Started\n");
		if (userId == null) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{\"error\":\"Not Authoized. The param userId cannot be empty\", \"status\":\"FAIL\"}")
					.build();
		}

		try {
			User user = BusinessManager.getInstance().findUser(userId);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {

		}
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("{\"error\":\"Not Authoized. The param userId cannot be empty\", \"status\":\"FAIL\"}").build();

	}

}
