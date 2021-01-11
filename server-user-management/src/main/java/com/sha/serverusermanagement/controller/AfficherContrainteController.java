package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.model.Constraint_details;
import com.sha.serverusermanagement.service.AfficherContrainteService;
import com.sha.serverusermanagement.service.FileUploadService;
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
public class AfficherContrainteController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private AfficherContrainteService afficherContrainteService;
    @GetMapping("/afficherContrainte")
    public ResponseEntity<List<Constraint_details>> afficherContrainte(@RequestParam String user, @RequestParam String password, @RequestParam String nom_table)  {
        log.debug("REST request to find accespoint {}");
        List<Constraint_details> response = afficherContrainteService.afficher_table_contraint(user, password, nom_table);
        return ResponseEntity.ok(response);
    }
}
