package com.example.csvtokafka.csv;

import com.example.csvtokafka.entity.Trial;
import com.example.csvtokafka.kafka.KafkaProducer;
import com.example.csvtokafka.repository.TrialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
@Service
@AllArgsConstructor
public class CSVService {

    private KafkaProducer kafkaProducer;


    public void save(MultipartFile file) {
        try {
            List<Trial> trials = CSVHelper.csvToTutorials(file.getInputStream());
            for (int i = 0; i < trials.size(); i++) {

                kafkaProducer.writeMessage(trials.get(i).getName() + "," + trials.get(i).getCode()+","+trials.get(i).getSymbol());
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

}