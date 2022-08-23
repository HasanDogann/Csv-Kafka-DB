package com.example.csvtokafka.csvoperation;

import com.example.csvtokafka.entity.Trial;
import com.example.csvtokafka.repository.TrialRepository;
import com.example.csvtokafka.kafka.KafkaProducer;
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

    private TrialRepository repository;
    public void save(MultipartFile file,String msg) {
        try {
            List<Trial> trials = CSVHelper.csvToTutorials(file.getInputStream());
            for (int i=0;i<trials.size();i++) {
                if(trials.get(i).getSeriesTitle3().startsWith(msg)){
                kafkaProducer.writeMessage(trials.get(i).getSeriesTitle3()+","+trials.get(i).getPeriod()+"-> "+trials.get(i).getDataValue());}
            }
            repository.saveAll(trials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public List<Trial> getAllTutorials() {
        return repository.findAll();
    }
}