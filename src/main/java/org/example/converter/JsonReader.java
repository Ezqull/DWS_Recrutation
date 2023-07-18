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
    // The timestamp used for filtering data
    private static final String TIMESTAMP_FILTER = "2017-07-01 00:00:00";
    private final List<Status> dataToWrite;

    /**
     * Constructor that reads and filters JSON data from the specified path.
     * @param path The path to the JSON file.
     */
    public JsonReader(String path){
        dataToWrite = readData(path);
    }

    /**
     * Reads data from the JSON file and applies filtering.
     * @param path The path to the JSON file.
     * @return The filtered list of Status objects.
     */
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


    /**
     * Filters the provided data based on the timestamp and sorts it using a custom comparator.
     * @param dataToFilter The data to be filtered.
     * @return The filtered and sorted list of Status objects.
     */
    private List<Status> filterData(List<Status> dataToFilter){
        return dataToFilter.stream()
                .filter(status -> status.getKontaktTs().after(Timestamp.valueOf(TIMESTAMP_FILTER)))
                .sorted(new StatusComparator())
                .collect(Collectors.toList());
    }
}
