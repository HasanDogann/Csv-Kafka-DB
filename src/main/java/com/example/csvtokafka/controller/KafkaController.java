package com.example.csvtokafka.controller;

import com.example.csvtokafka.core.ResponseMessage;
import com.example.csvtokafka.facade.CsvFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hasan DOĞAN
 * IntelliJ IDEA
 * 27.08.2022
 */
@RestController
@AllArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private CsvFacade csvFacade;

    @PostMapping("/uploadCsv")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file) {
        return csvFacade.csvToDb(file);
    }


}
