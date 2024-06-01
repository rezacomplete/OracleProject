package org.example;

import java.util.ArrayList;
import java.util.List;

// Builds the records list from input string
public class RecordsBuilder {

    public List<Record> buildRecords(String inputData) {
        List<Record> records = new ArrayList<>();

        String[] reportLines = inputData.split("\\n");
        for (String reportLine : reportLines) {
            String[] tokens = reportLine.split(",");

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

        return records;
    }
}
