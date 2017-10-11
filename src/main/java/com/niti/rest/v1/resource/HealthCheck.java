package com.niti.rest.v1.resource;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/health")
@Component
public class HealthCheck {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		
		LocalDate now = LocalDate.now();
		
		return "Server is up and running : Server Date : "  + now ;
		
	}
}
