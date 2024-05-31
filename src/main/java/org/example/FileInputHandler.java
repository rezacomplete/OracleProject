package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// reads the input from file
public class FileInputHandler implements InputHandler {

    @Override
    public List<Record> buildRecordsFromInput() {
        List<Record> records = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("input.txt")) {
            Scanner scanner = new Scanner(is);

            while (scanner.hasNext()) {
                String readLine = scanner.next();
                String[] tokens = readLine.split(",");

                Record record = new Record.RecordBuilder()
                        .setCustomerId(tokens[0])
                        .setContractId(tokens[1])
                        .setGeoZone(tokens[2])
                        .setTeamCode(tokens[3])
                        .setProjectCode(tokens[4])
                        .setBuildDuration(tokens[5])
                        .build();

                records.add(record);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }
}
