package com.pds.demo.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {
    @Autowired
    Environment environment;


    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    static final String  ERROR="FAIL to upload file!";
    private final Path rootLocation = Paths.get("upload-dir");


    public String store(MultipartFile file, Path path, String name) {

        try {
            if ((path.resolve(name)).toFile().exists()) {
                Files.delete(path.resolve(name));
            }
            Files.copy(file.getInputStream(), path.resolve(name));
            return  path.resolve(name).toString();
        } catch (Exception e) {
            log.debug(e.getMessage());
            return null;
        }
    }

    public void deleteAll(Path path) {

        FileSystemUtils.deleteRecursively(path.toFile());


    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);


        } catch (IOException e) {
            log.debug(e.getMessage());
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

}
