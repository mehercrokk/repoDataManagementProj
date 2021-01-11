package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.service.ConvertionXmlExcelService;
import com.sha.serverusermanagement.service.DB2CSVService;
import com.sha.serverusermanagement.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
public class DB2CSVController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private DB2CSVService db2CSVService;
    @GetMapping("/db2CSVMethode")
    public ResponseEntity<Boolean> fileUpload(@RequestParam String user, @RequestParam String password, @RequestParam String nom_table) throws Exception {
        log.debug("REST request to find accespoint {}");
        boolean response = db2CSVService.db2CSVMethode(user, password,nom_table);
        return ResponseEntity.ok(response);
    }
}
