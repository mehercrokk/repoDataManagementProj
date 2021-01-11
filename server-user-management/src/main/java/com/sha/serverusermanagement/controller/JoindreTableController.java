package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.service.AfficherContrainteService;
import com.sha.serverusermanagement.service.JoindreTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoindreTableController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private JoindreTableService joindreTableService;
    @GetMapping("/joindreTable")
    public ResponseEntity<Boolean> joindreTable(@RequestParam String user, @RequestParam String password, @RequestParam String nom_table1
            ,@RequestParam String nom_table2, @RequestParam String column1,  @RequestParam String column2, @RequestParam String nom_constraint)  {
        log.debug("REST request to find accespoint {}");
        boolean response = joindreTableService.joindre_table( user,  password,  nom_table1, nom_table2,  column1,   column2,  nom_constraint);
        return ResponseEntity.ok(response);
    }
}
