package com.example.csvtokafka.kafka;

import com.example.csvtokafka.entity.Trial;
import com.example.csvtokafka.repository.TrialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
@Service
@Slf4j
public class KafkaConsumer {

    private TrialRepository trialRepository;

    List<Trial> trials = new ArrayList();

    public KafkaConsumer(TrialRepository trialRepository) {
        this.trialRepository = trialRepository;
    }

    @KafkaListener(topics = "hd_trial",groupId = "hd_trial_id")
    public void getMessage(String message){

       List<String> kafkaListener = Arrays.asList(message.split(","));

       Trial trial = new Trial();

        trial.setName(kafkaListener.get(0));
        trial.setCode(kafkaListener.get(1));
        trial.setSymbol(kafkaListener.get(2));

        trials.add(trial);

       trialRepository.save(trial);

    }

}
