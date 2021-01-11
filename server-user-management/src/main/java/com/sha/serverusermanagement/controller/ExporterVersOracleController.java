package com.sha.serverusermanagement.controller;

import com.sha.serverusermanagement.service.DB2CSVService;
import com.sha.serverusermanagement.service.ExporterVersOracleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExporterVersOracleController {
    private final Logger log = LoggerFactory.getLogger(ConvertionXmlExcelController.class);
    @Autowired
    private ExporterVersOracleService exporterVersOracleService;
    @GetMapping("/loadcsvoracle")
    public ResponseEntity<Boolean> loadcsvoracle() throws Exception {
        log.debug("REST request to find accespoint {}");
        boolean response = exporterVersOracleService.load_csv_oracle();
        return ResponseEntity.ok(response);
    }
}
