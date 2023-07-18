package org.example.converter;

import com.opencsv.CSVWriter;
import org.example.model.Status;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonWriter {

    // The name of the output CSV file
    private static final String OUTPUT_FILE_NAME = "filtered_statuses.csv";

    /**
     * Constructor that takes a list of filtered data and writes it to a CSV file.
     * @param filteredData The list of filtered data to be written.
     */
    public JsonWriter(List<Status> filteredData){
        writeDataToCsv(filteredData);
    }

    /**
     * Writes the provided data to a CSV file.
     * @param dataToWrite The data to be written.
     */
    private void writeDataToCsv(List<Status> dataToWrite) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.writeAll(convertToStringArrayList(dataToWrite));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * Converts a list of Status objects to a list of String arrays.
     * @param dataToConvert The data to be converted.
     * @return The converted data as a list of String arrays.
     */
    private List<String[]> convertToStringArrayList(List<Status> dataToConvert){
        return dataToConvert.stream()
                .map(Status::toStringArray)
                .collect(Collectors.toList());
    }
}