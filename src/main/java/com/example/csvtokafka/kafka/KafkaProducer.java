package com.example.csvtokafka.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
@Service
@AllArgsConstructor
public class KafkaProducer {

    private static final String TOPIC= "hd_trial";


    private KafkaTemplate<String,String> kafkaTemplate;

    public void writeMessage(String msg){
        this.kafkaTemplate.send(TOPIC,msg);
    }
}
