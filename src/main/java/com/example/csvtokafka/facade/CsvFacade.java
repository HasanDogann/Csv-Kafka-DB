package com.example.csvtokafka.facade;

import com.example.csvtokafka.core.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hasan DOĞAN
 * IntelliJ IDEA
 * 27.08.2022
 */
public interface CsvFacade {

    ResponseEntity<ResponseMessage> csvToDb(MultipartFile file);
}
