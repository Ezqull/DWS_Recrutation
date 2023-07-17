package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReader {

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonReader(String path){
        File jsonFile = new File(path);
        try {

            List<Status> statuses = mapper.readValue(jsonFile, new TypeReference<List<Status>>() {});

            statuses = statuses.stream()
                    .filter(status -> status.getKontaktTs().after(Timestamp.valueOf("2017-07-01 00:00:00")))
                    .collect(Collectors.toList());

            Collections.sort(statuses, new StatusComparator());

            List<String[]> listData = statuses.stream()
                                                .map(Status::toStringArray)
                                                .collect(Collectors.toList());

            try (CSVWriter writer = new CSVWriter(new FileWriter("filtered_statuses.csv"))) {
                writer.writeAll(listData);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
