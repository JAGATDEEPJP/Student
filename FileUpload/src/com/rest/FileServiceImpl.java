package com.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
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


 
@Path("/fileservice")
public class FileServiceImpl implements IFileService {
	
    public static final String UPLOAD_FILE_SERVER = "/home/jagatdeep/File/";
 
    // <a class="vglnk" href="http://localhost:8080/Jersey-UP-DOWN-Image-File/rest/fileservice/download/image" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Jersey</span><span>-</span><span>UP</span><span>-</span><span>DOWN</span><span>-</span><span>Image</span><span>-</span><span>File</span><span>/</span><span>rest</span><span>/</span><span>fileservice</span><span>/</span><span>download</span><span>/</span><span>image</span></a>
    @GET
    @Path("/download/image")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadImageFile() {
 
        // set file (and path) to be download
        File file = new File("D:/Demo/download/MyImageFile.png");
 
        ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
        return responseBuilder.build();
    }
 
    // <a class="vglnk" href="http://localhost:8080/Jersey-UP-DOWN-Image-File/rest/fileservice/upload/images" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Jersey</span><span>-</span><span>UP</span><span>-</span><span>DOWN</span><span>-</span><span>Image</span><span>-</span><span>File</span><span>/</span><span>rest</span><span>/</span><span>fileservice</span><span>/</span><span>upload</span><span>/</span><span>images</span></a>
    @POST
    @Path("/upload/images")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
    		@FormDataParam("name") String name,
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
    	
    	//jsonPart
    	System.out.println(name);
    	//jsonPart.set](MediaType.APPLICATION_JSON_TYPE);
       // Employee emp = jsonPart.getValueAs(Employee.class);
 
        // local variables
        String fileName = null;
        String uploadFilePath = null;
        //String name = bean.getName();
        //String rollNo =  bean.getRollNo();
 
        try {
            fileName = fileFormDataContentDisposition.getFileName();
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
            // release resources, if any
        }
        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
    }
 
    /**
     * write input stream to file server
     * @param inputStream
     * @param fileName
     * @throws IOException
     */
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = UPLOAD_FILE_SERVER+fileName;
 
        try {
        	//outpuStream = new FileOutputStream(new File(filePath));
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            //release resource, if any
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }

	@Override
	public Response uploadImageFile(InputStream fileInputStream,
			FormDataContentDisposition fileFormDataContentDisposition) {
		// TODO Auto-generated method stub
		return null;
	}
}
