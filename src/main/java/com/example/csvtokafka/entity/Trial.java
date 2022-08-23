package com.example.csvtokafka.entity;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "trials")
public class Trial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "series")
    private String seriesReference;

    @Column(name = "period")
    private String period;

    @Column(name = "data_value")
    private long dataValue;

    @Column(name = "suppressed")
    private String suppressed;

    @Column(name = "status")
    private String status;

    @Column(name = "units")
    private String units;

    @Column(name = "magnitude")
    private String magnitude;

    @Column(name = "subject")
    private String subject;

    @Column(name = "group")
    private String group;

    @Column(name = "seriesTitle1")
    private String seriesTitle1;
    @Column(name = "seriesTitle2")
    private String seriesTitle2;
    @Column(name = "seriesTitle3")
    private String seriesTitle3;
    @Column(name = "seriesTitle4")
    private String seriesTitle4;
    @Column(name = "seriesTitle5")
    private String seriesTitle5;



    public Trial() {
    }

    public Trial(String seriesReference, String period, long data_value, String suppressed, String status, String units, String magnitude, String subject, String group, String seriesTitle1, String seriesTitle2, String seriesTitle3, String seriesTitle4, String seriesTitle5) {
        this.seriesReference = seriesReference;
        this.period = period;
        this.dataValue = data_value;
        this.suppressed = suppressed;
        this.status = status;
        this.units = units;
        this.magnitude = magnitude;
        this.subject = subject;
        this.group = group;
        this.seriesTitle1 = seriesTitle1;
        this.seriesTitle2 = seriesTitle2;
        this.seriesTitle3 = seriesTitle3;
        this.seriesTitle4 = seriesTitle4;
        this.seriesTitle5 = seriesTitle5;
    }
}