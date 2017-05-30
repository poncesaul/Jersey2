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

	 //...........db operation..
	 //suppose we get these value from database
	 //............
	 String randomName = "random" + UUID.randomUUID().toString().substring(0,4);
	 int randomAge = new Random().nextInt(100);

	 //returns the value received from database
	 return new EmployeeModel(randomName,randomAge);
	 //return new EmployeeModel("Tom", 21);

	}
	
	@POST
	@Path("/json/object")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public EmployeeModel postEmployee(EmployeeModel employee) {
	 //We receive the object from client
	 //Client might have send the json string as {"name":"hello","age":"24"}
	 //do some processing ..save in database
	 //return the output in xml format....
	 return employee;
	}
	
}
