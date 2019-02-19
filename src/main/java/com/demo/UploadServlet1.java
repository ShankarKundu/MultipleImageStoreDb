package com.demo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

@WebServlet("/UploadServlet1")
@MultipartConfig
class UploadServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "D:/abc";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multipart = new ServletFileUpload( new DiskFileItemFactory( ) ).parseRequest( (RequestContext) new ServletRequestContext( request ) );
                for (FileItem item : multipart) {
                    if (!item.isFormField( )) {
                        name = new File( item.getName( ) ).getName( );
                        item.write( new File( UPLOAD_DIRECTORY + File.separator + name ) );
                    }
                }

                int ar[] = new int[name.length( ) - 1];
                System.out.println( "ar" + Arrays.toString(ar));

                Connection con = DbServlet.getCon( );
                String sql = "insert into multiimage (image)value('" + name + "')";
                PreparedStatement ps =con.prepareStatement(sql);
                ps.executeUpdate();

                request.setAttribute( "message", "fileupload successfully" );
            } catch (Exception e) {
                request.setAttribute( "message", "fileupload faild" + e );
            }
        }
    }
}