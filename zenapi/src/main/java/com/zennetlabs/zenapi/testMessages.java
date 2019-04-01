package com.zennetlabs.zenapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/message")
public class testMessages {

    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg()
    {
         return "API is Running.-";
    }
}
