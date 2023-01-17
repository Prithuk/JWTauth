package com.jwt.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileService {

    public String uploadImage(String path, MultipartFile file) throws IOException {
//Filename
        String name = file.getOriginalFilename();
        System.out.printf("Printing filename: " + file.getOriginalFilename());

        //full path
        String filePath = path + File.separator + name;
        System.out.printf("filepath:"+filePath);
        //create folder if not created
        File newFile = new File(path);
        //file copy
        if (!newFile.exists()) {
            newFile.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return name;
    }


}
