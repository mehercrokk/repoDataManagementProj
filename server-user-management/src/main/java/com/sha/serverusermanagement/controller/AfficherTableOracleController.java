package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.model.Nom_table_oracle;
import com.sha.serverusermanagement.service.AfficherTableOracleService;
import com.sha.serverusermanagement.service.ConvertionXmlExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AfficherTableOracleController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private AfficherTableOracleService afficherTableOracleService;
    @GetMapping("/afficherTableOracle")
    public ResponseEntity<List<Nom_table_oracle>> afficherTableOracle(@RequestParam String user, @RequestParam String password)  {
        log.debug("REST request to find accespoint {}");
        List<Nom_table_oracle> response = afficherTableOracleService.connecter_afficher_table_oracle( user,  password);
        return ResponseEntity.ok(response);
    }
}
