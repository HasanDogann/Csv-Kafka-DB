package com.example.csvtokafka.entity;

/**
 * @author Hasan DOĞAN
 * IntelliJ IDEA
 * 25.08.2022
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trials")
public class Trial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String symbol;

    private String name;


    public Trial(String code, String symbol, String name) {
        this.code = code;
        this.symbol = symbol;
        this.name = name;
    }
}
