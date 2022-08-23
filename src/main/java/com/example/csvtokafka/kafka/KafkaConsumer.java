package com.example.csvtokafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "hd_trial",groupId = "hd_trial_id")
    public void getMessage(String message){

        System.out.println(message);

    }

}
