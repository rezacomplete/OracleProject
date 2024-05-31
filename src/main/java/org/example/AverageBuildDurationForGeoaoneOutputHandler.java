package org.example;

import java.util.List;
import java.util.Map;

// The average build duration for each geozone
public class AverageBuildDurationForGeoaoneOutputHandler implements OutputHandler {

    @Override
    @SuppressWarnings("unchecked")
    public void printReportToOutput(Object report) {
        Map<String, List<Integer>> geozoneToBuildDurations = (Map<String, List<Integer>>) report;
        for (Map.Entry<String, List<Integer>> entry : geozoneToBuildDurations.entrySet()) {
            int totalDuration = 0;
            for (Integer duration : entry.getValue()) {
                totalDuration += duration;
            }

            int averageDuration = totalDuration / entry.getValue().size(); //ignores the digits after the decimal point

            System.out.println("The average build duration for geozone {" + entry.getKey() + "} is " + averageDuration);
        }
    }
}
