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

import com.student.StudentGetSet;


 
@Path("/fileservice")
public class FileServiceImpl implements IFileService {
	
    public static final String UPLOAD_FILE_SERVER = "/home/jagatdeep/File/";
 
    @GET
    @Path("/download/image")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadImageFile(StudentGetSet sgt) {
    	int rno = sgt.getRollno_();
    	String path = sgt.getPath_();
        // set file (and path) to be download
    	int i = path.lastIndexOf('/');
    	String fname = path.substring(i+1);
    	System.out.println(fname);
        File file = new File(path);
        ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename="+fname);
        return responseBuilder.build();
    }
 
    
    @POST
    @Path("/upload/images")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
    		@FormDataParam("rollno") int rollno,
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
    	
        // local variables
        String fileName = null;
        String uploadFilePath = null;
        String modifiedFileName = null;
 
        try {
            fileName = fileFormDataContentDisposition.getFileName();
            String ext = null;
            int i = fileName.lastIndexOf('.');
            if(i>0)
            	ext = fileName.substring(i);
            modifiedFileName = rollno+ext;
            uploadFilePath = writeToFileServer(fileInputStream, modifiedFileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
            // release resources, if any
        }
        System.out.println(Response.ok(uploadFilePath).build());
        return Response.ok(uploadFilePath).build();
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


	@Override
	public Response downloadImageFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
