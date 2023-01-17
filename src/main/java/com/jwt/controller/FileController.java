package com.jwt.controller;

import com.jwt.model.FileResponse;
import com.jwt.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${file.upload-dir}")
    private String path;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<FileResponse> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = null;
        filename = this.fileService.uploadImage(path, file);
        return new ResponseEntity<>(new FileResponse(filename, "Image uploaded"), HttpStatus.OK);
    }
}
