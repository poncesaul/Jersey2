package com.example.rest;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.model.EmployeeModel;

@Path("/service")
public class ExampleService {

	private static final String text = "status :Server is running " + "\ntime : %s";
		
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getText() {
		String response = String.format(text, new Date());
	 return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeModel getJson() {
	 String randomName = "random" + UUID.randomUUID().toString().substring(0,4);
	 int randomAge = new Random().nextInt(100);
	 return new EmployeeModel(randomName,randomAge);	 
	}
	
	@POST
	@Path("/json/object")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public EmployeeModel postEmployee(EmployeeModel employee) {
	
	 return employee;
	}
	
}
