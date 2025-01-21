package com.templateshop.templateshop.service;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadService {
    private final ServletContext servletContext;
    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    public String handleSaveUploadFile(MultipartFile file, String targetFolder)  {
        if(file.isEmpty()){
            return "";
        }
        // Creating the directory to store file
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();
            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();
            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

            stream.write(bytes);
            stream.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return finalName;
    }

    public Object handleSaveUploadMultipleFile(MultipartFile[] files, String targetFolder)  {
        if (files.length < 0) {
            return "Mandatory information missing";
        }
        String[] nameFiles = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                nameFiles[i] = handleSaveUploadFile(file, targetFolder);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        return nameFiles;
    }
}
