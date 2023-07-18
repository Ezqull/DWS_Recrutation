package org.example;

import org.example.converter.JsonReader;
import org.example.converter.JsonWriter;

public class Main {
    public static void main(String[] args) {
        JsonReader reader = new JsonReader("statuses.json");
        new JsonWriter(reader.getDataToWrite());
    }
}