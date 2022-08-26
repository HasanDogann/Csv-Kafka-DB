package com.example.csvtokafka.kafka;

import com.example.csvtokafka.entity.Trial;
import com.example.csvtokafka.repository.TrialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hasan DOĞAN
 * IntelliJ IDEA
 * 25.08.2022
 */
@Service
@Slf4j
public class KafkaConsumer {

    private TrialRepository trialRepository;

    long totalMessageCount = 0;

    public KafkaConsumer(TrialRepository trialRepository) {
        this.trialRepository = trialRepository;
    }

    @KafkaListener(topics = "hd_trial", groupId = "hd_trial_id")
    public void getMessage(String message) {
        //Finding total number of messages
        totalMessageCount += 1;
        //Split kafka producer message to entity attribute
        List<String> kafkaListener = Arrays.asList(message.split(","));
        log.info(+totalMessageCount + "." + " message " + "is split");

        Trial trial = new Trial();
        trial.setName(kafkaListener.get(0));
        trial.setCode(kafkaListener.get(1));
        trial.setSymbol(kafkaListener.get(2));

        trialRepository.save(trial);
        log.info("******"+totalMessageCount + "." + " message is saved to DB ******");

    }

}
