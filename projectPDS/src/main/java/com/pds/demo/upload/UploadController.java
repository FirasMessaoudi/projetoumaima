package com.pds.demo.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/fileupload")
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    StorageService storageService;
    @Autowired
    Environment environment;

    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") List<MultipartFile> file) {
        log.info("upload path : "+environment.getProperty("upload.path"));
        String message = "";
        try {

            if (!file.isEmpty()) {
                Path root = Paths.get(environment.getProperty("upload.path"));

                for (MultipartFile mf : file) {
                    message = storageService.store(mf, root, mf.getOriginalFilename());
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @PostMapping(value = "/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@RequestBody String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
