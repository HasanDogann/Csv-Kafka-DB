package com.example.csvtokafka.kafka;

import com.example.csvtokafka.csvoperation.CSVHelper;
import com.example.csvtokafka.csvoperation.CSVService;
import com.example.csvtokafka.csvoperation.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    private KafkaProducer kafkaProducer;
    private CSVService fileService;

    @PostMapping(path="/upload/{message1}")
    public void writeMessageToTopic(@PathVariable String message1){
        this.kafkaProducer.writeMessage(message1);
    }
    @PostMapping("/uploads/{msg}")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file, @PathVariable String msg) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {

                fileService.save(file,msg);
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
