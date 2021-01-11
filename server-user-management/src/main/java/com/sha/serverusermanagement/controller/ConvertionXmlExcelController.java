package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.service.ConvertionXmlExcelService;
import com.sha.serverusermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
@RestController
public class ConvertionXmlExcelController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private ConvertionXmlExcelService convertionXmlExcelService;
    @GetMapping("/convertionXmlExcel")
    public ResponseEntity<Boolean> convertionXmlExcel()  {
        log.debug("REST request to find accespoint {}");
        boolean response = convertionXmlExcelService.convertionXmlExcelMethod();
        return ResponseEntity.ok(response);
    }
}
