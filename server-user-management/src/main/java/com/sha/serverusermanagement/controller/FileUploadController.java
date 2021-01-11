package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.service.ConvertionXmlExcelService;
import com.sha.serverusermanagement.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileUploadController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private FileUploadService fileUploadService;
    @GetMapping("/processFileUpload")
    public ResponseEntity<String> processFileUpload() throws IOException {
        log.debug("REST request to find accespoint {}");
        String response = fileUploadService.processFileUpload();
        return ResponseEntity.ok(response);
    }
}
