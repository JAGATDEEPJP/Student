package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.student.*;
import java.util.*;


 

@Path("/json")
public class JSONService
{
	@POST
	@Path("/create_student")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveStudent_(StudentGetSet sgt)
	{
		SaveStudent stu = new SaveStudent(sgt.getName_(), sgt.getRollno_(),sgt.getPhy_(),sgt.getChem_(),sgt.getMath_(),sgt.getDob_());
		stu.saveStudent();
	}
	
	@POST
	@Path("/show_student")
	@Consumes(MediaType.APPLICATION_JSON)
	public RetrieveStudent showDetails_(StudentGetSet sgt)
	{
		System.out.println(sgt.getRollno_());
		RetrieveStudent stu = new RetrieveStudent(sgt.getRollno_());
		return stu;
	}
	
}