package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReader {

    private static final String TIMESTAMP_FILTER = "2017-07-01 00:00:00";
    private static final String OUTPUT_FILE_NAME = "filtered_statuses.csv";


    public JsonReader(String path){
        List<Status> dataToWrite = readData(path);
        writeDataToCsv(dataToWrite);
    }

    private void writeDataToCsv(List<Status> dataToWrite){
        try (CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.writeAll(convertToStringArrayList(dataToWrite));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Status> readData(String path){
        File jsonFile = new File(path);
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Status> statuses = mapper.readValue(jsonFile, new TypeReference<List<Status>>() {});
            return filterData(statuses);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Status> filterData(List<Status> dataToFilter){
        return dataToFilter.stream()
                .filter(status -> status.getKontaktTs().after(Timestamp.valueOf(TIMESTAMP_FILTER)))
                .sorted(new StatusComparator())
                .collect(Collectors.toList());
    }

    private List<String[]> convertToStringArrayList(List<Status> dataToConvert){
        return dataToConvert.stream()
                .map(Status::toStringArray)
                .collect(Collectors.toList());
    }
}
