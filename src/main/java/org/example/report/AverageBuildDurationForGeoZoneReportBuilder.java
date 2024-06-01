package org.example.report;

import org.example.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The average build duration for each geoZone
public class AverageBuildDurationForGeoZoneReportBuilder implements ReportBuilder {

    @Override
    public Object buildReport(List<Record> records) {
        Map<String, List<Integer>> geoZoneToBuildDurations = new HashMap<>();
        for (Record record : records) {
            if (!geoZoneToBuildDurations.containsKey(record.getGeoZone())) {
                geoZoneToBuildDurations.put(record.getGeoZone(), new ArrayList<>());
            }
            String buildDurationWithoutSecondSymbol = record.getBuildDuration().substring(0, record.getBuildDuration().length() - 1);
            geoZoneToBuildDurations.get(record.getGeoZone()).add(Integer.parseInt(buildDurationWithoutSecondSymbol));
        }

        Map<String, Integer> reportResult = getAverageBuildDurationForGeoZoneReport(geoZoneToBuildDurations);

        return reportResult;
    }

    private static Map<String, Integer> getAverageBuildDurationForGeoZoneReport(Map<String, List<Integer>> geoZoneToBuildDurations) {
        Map<String, Integer> reportResult = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : geoZoneToBuildDurations.entrySet()) {
            int totalDuration = 0;
            for (Integer duration : entry.getValue()) {
                totalDuration += duration;
            }

            int averageDuration = totalDuration / entry.getValue().size(); //ignores the digits after the decimal point
            reportResult.put(entry.getKey(), averageDuration);
        }
        return reportResult;
    }
}
