package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.core.QuadraticEquation;
import com.core.FindQuadraticRoots;

@Path("/json")
public class JSONService
{

	@POST
	@Path("/find_roots")
	@Consumes(MediaType.APPLICATION_JSON)
	public FindQuadraticRoots findRootsQE(QuadraticEquation qe)
	{
		FindQuadraticRoots roots = new FindQuadraticRoots(qe.getA(), qe.getB(), qe.getC());
		return roots;
	}

}