package com.sha.serverusermanagement.service;

import com.sha.serverusermanagement.model.Datasource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
@Service
public class ConvertionXmlExcelService {
    public boolean convertionXmlExcelMethod(){
        try {
            Datasource datasource = new Datasource();
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("java -jar C:/Users/crok0/Desktop/docpfe/XML2CSVGenericConverter_V1.0.0(1).jar -i C:/Users/crok0/Desktop/docpfe/incomestatements.xml");
            //Process pr = rt.exec("C:/Users/USER mkdir crok");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line=null;

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);

        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return true;
    }
}
