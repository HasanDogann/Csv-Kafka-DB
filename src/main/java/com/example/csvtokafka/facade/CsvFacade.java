package com.example.csvtokafka.facade;

import com.example.csvtokafka.csv.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 27.08.2022
 */
public interface CsvFacade {

    ResponseEntity<ResponseMessage> csvToDb(MultipartFile file);
}
