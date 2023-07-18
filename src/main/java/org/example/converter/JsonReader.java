package org.example.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.model.Status;
import org.example.model.comparator.StatusComparator;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class JsonReader {

    private static final String TIMESTAMP_FILTER = "2017-07-01 00:00:00";
    private final List<Status> dataToWrite;


    public JsonReader(String path){
        dataToWrite = readData(path);
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
}
