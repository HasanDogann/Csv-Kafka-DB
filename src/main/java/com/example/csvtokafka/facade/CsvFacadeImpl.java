package com.example.csvtokafka.facade;

import com.example.csvtokafka.csv.CSVHelper;
import com.example.csvtokafka.csv.CSVService;
import com.example.csvtokafka.csv.ResponseMessage;
import com.example.csvtokafka.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 27.08.2022
 */
@Service
@AllArgsConstructor
public class CsvFacadeImpl implements CsvFacade {

    private KafkaProducer kafkaProducer;
    private CSVService fileService;

    @Override
    public ResponseEntity<ResponseMessage> csvToDb(MultipartFile file) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {

                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message+" - "+e.getMessage()));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
