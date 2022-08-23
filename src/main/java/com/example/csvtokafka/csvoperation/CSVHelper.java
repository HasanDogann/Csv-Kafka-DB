package com.example.csvtokafka.csvoperation;

/**
 * @author Hasan DOĞAN
 * @Project IntelliJ IDEA
 * @Date 23.08.2022
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.csvtokafka.entity.Trial;
import com.example.csvtokafka.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
public class CSVHelper {

    private KafkaProducer kafkaProducer;
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Trial> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Trial> trials = new ArrayList<Trial>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Trial trial = new Trial(
                       csvRecord.get("Series_reference"),
                       csvRecord.get("Period"),
                       Long.parseLong(csvRecord.get("Data_value")),
                       csvRecord.get("Suppressed"),
                       csvRecord.get("STATUS"),
                       csvRecord.get("UNITS"),
                       csvRecord.get("Magnitude"),
                       csvRecord.get("Subject"),
                       csvRecord.get("Group"),
                       csvRecord.get("Series_title_1") ,
                        csvRecord.get("Series_title_2"),
                        csvRecord.get("Series_title_3"),
                        csvRecord.get("Series_title_4"),
                        csvRecord.get("Series_title_5")
                );
                trials.add(trial);
            }

            return trials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}