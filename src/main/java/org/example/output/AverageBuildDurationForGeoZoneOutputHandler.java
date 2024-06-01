package org.example.output;

import java.util.List;
import java.util.Map;

// The average build duration for each geoZone
public class AverageBuildDurationForGeoZoneOutputHandler implements OutputHandler {

    @Override
    @SuppressWarnings("unchecked")
    public void printReportToOutput(Object report) {
        Map<String, Integer> reportResult = (Map<String, Integer>) report;
        for (Map.Entry<String, Integer> reportRecord : reportResult.entrySet()) {
            System.out.println("The average build duration for geoZone {" + reportRecord.getKey() + "} is " + reportRecord.getValue());
        }
    }
}
