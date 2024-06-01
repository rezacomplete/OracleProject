package org.example.input;

import org.example.Record;

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

                String customerId = tokens[0];
                String contractId = tokens[1];
                String geoZone = tokens[2];
                String teamCode = tokens[3];
                String projectCode = tokens[4];
                String buildDuration = tokens[5];

                Record record = new Record.RecordBuilder()
                        .setCustomerId(customerId)
                        .setContractId(contractId)
                        .setGeoZone(geoZone)
                        .setTeamCode(teamCode)
                        .setProjectCode(projectCode)
                        .setBuildDuration(buildDuration)
                        .build();

                records.add(record);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }
}
