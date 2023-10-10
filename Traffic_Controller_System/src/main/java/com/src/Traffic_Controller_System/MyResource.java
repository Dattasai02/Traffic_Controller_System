
package com.src.Traffic_Controller_System;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.src.interfacess.AdminServiceInterface;
import com.src.model.Routes;
import com.src.services.AdminService;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {

	AdminServiceInterface asi = new AdminService();

	@GET
	@Path("/hi")
	@Produces("text/plain")
	public String getIt() {
		return "Hi there!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getroutes")
	public List<Routes> getRoutes() {
		Response.status(Response.Status.OK).entity("Added Successfully").build();
		return asi.admin_allRoutes();
	}

	@DELETE
	@Path("/deleteroute/{id}")
	public Response deleteRoute(@PathParam("id") String id) {
		Routes r = new Routes(id);
		int res = asi.admin_DeleteRoute(r);
		if (res > 0) {
			return Response.status(Response.Status.OK).entity("Deleted Successfully").build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).entity("Not Deleted/ID not found ").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addroute")
	public Response addRoute(Routes r) {
		int res = asi.admin_AddRoute(r);
		if (res > 0) {
			return Response.status(Response.Status.CREATED).entity("Added Successfully").build();
		} else {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Not Added Successfully ").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateroute/{id}")
	public Response updateRoute(@PathParam("id") String id, Routes r) {
		int res = asi.admin_UpdateRoute(r);
		if (res > 0) {
			return Response.status(Response.Status.CREATED).entity("Updated Successfully").build();
		} else
			return Response.status(Response.Status.NO_CONTENT).entity("Not Updated/ID not found ").build();
	}

}
