package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.model.Classenomtable;
import com.sha.serverusermanagement.model.Constraint_details;
import com.sha.serverusermanagement.model.Nom_table_oracle;
import com.sha.serverusermanagement.service.AfficherContrainteService;
import com.sha.serverusermanagement.service.AfficherTableOracleService;
import com.sha.serverusermanagement.service.AfficherTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AfficherTableController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private AfficherTableService afficherTableService;
    @GetMapping("/afficherTable")
    public ResponseEntity<List<Classenomtable>> afficherTable(@RequestParam String user, @RequestParam String password, @RequestParam String nom_table)  {
        log.debug("REST request to find accespoint {}");
        List<Classenomtable> response = afficherTableService.nom_table_base(user, password,nom_table);
        return ResponseEntity.ok(response);
    }
}
