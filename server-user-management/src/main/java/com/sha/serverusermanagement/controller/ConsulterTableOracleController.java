package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.model.ID_details;
import com.sha.serverusermanagement.model.Nom_columne;
import com.sha.serverusermanagement.service.ConsulterIdTableService;
import com.sha.serverusermanagement.service.ConsulterTableOracleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConsulterTableOracleController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private ConsulterTableOracleService consulterTableOracleService;
    @GetMapping("/consulterTableOracle")
    public ResponseEntity<List<Nom_columne>> consulterTableOracle(@RequestParam String user, @RequestParam String password, @RequestParam String table)  {
        log.debug("REST request to find accespoint {}");
        List<Nom_columne> response = consulterTableOracleService.doconsulter(user, password, table);
        return ResponseEntity.ok(response);
    }
}
