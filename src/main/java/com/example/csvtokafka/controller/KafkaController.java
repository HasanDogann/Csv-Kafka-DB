package com.example.csvtokafka.controller;

import com.example.csvtokafka.csv.ResponseMessage;
import com.example.csvtokafka.facade.CsvFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
@RestController
@AllArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private CsvFacade csvFacade;

    @PostMapping("/uploads")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file) {
       return csvFacade.csvToDb(file);
    }


}
