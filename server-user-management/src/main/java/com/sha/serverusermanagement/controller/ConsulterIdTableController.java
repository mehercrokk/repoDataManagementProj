package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.model.ID_details;
import com.sha.serverusermanagement.service.AfficherContrainteService;
import com.sha.serverusermanagement.service.ConsulterIdTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConsulterIdTableController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private ConsulterIdTableService consulterIdTableService;
    @GetMapping("/doconsulterID")
    public ResponseEntity<List<ID_details>> doconsulterID(@RequestParam  String user, @RequestParam String password, @RequestParam String table)  {
        log.debug("REST request to find accespoint {}");
        List<ID_details> response = consulterIdTableService.doconsulter_ID(user, password, table);
        return ResponseEntity.ok(response);
    }
}
