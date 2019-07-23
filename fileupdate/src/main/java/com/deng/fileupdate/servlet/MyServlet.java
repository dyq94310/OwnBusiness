package com.deng.fileupdate.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author DengYongQi
 * @date 2019-07-14
 **/
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");

        resp.getOutputStream().println(">>>>>>>>>>using uploadfile<<<<<<<<<<<");

        if (!ServletFileUpload.isMultipartContent(req)) {
            resp.getOutputStream().println("no MultipartContent");
        }

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            for (FileItem fileItem : upload.parseRequest(req)) {
                if (fileItem.isFormField()) {
                    System.out.printf("name=%s,value=%s", fileItem.getFieldName(), fileItem.getString());
                    System.out.println();
                } else {
                    FileOutputStream fileOutputStream = null;
                    try (InputStream inputStream = fileItem.getInputStream()) {
                        String name = fileItem.getName();
//                        name = name.substring(name.lastIndexOf("\\") + 1);
                        name = "../ss";

                        String realPath = this.getServletContext().getRealPath("/tempFile/temp");
                        File file = new File(realPath, name);
                        System.out.println(file.getCanonicalPath());
                        System.out.println(file.getAbsolutePath());
                        if (file.getCanonicalPath().equals(file.getAbsolutePath()))
                        fileOutputStream = new FileOutputStream(file);
                        int len;
                        byte[] bytes = new byte[1024];
                        while ((len = inputStream.read(bytes)) != -1) {
                            fileOutputStream.write(bytes, 0, len);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

}
