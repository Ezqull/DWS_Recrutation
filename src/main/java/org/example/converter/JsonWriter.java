package org.example.converter;

import com.opencsv.CSVWriter;
import org.example.model.Status;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonWriter {

    private static final String OUTPUT_FILE_NAME = "filtered_statuses.csv";

    public JsonWriter(List<Status> filteredData){
        writeDataToCsv(filteredData);
    }

    private void writeDataToCsv(List<Status> dataToWrite) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.writeAll(convertToStringArrayList(dataToWrite));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    private List<String[]> convertToStringArrayList(List<Status> dataToConvert){
        return dataToConvert.stream()
                .map(Status::toStringArray)
                .collect(Collectors.toList());
    }
}