package com.example.csvtokafka.repository;

import com.example.csvtokafka.entity.Trial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
public interface TrialRepository extends JpaRepository<Trial,Long> {
}
