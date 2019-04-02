package com.zennetlabs.zenapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/users")
public class UsersResource {
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getUserByID(@PathParam("userId") String userId)
    {
         if (userId == null) {
        	 return Response.status(Response.Status.BAD_REQUEST)
        			 .entity("{\"error\":\"Not Authoized. The param userId cannot be empty\", \"status\":\"FAIL\"}")
        			 .build();
         }
         
         //Set new default user
         User user = new User();
         
         user.setId("0001");
         user.setName("Juan Perez");
         
         return Response.status(Response.Status.OK).entity(user).build();
    }

}
