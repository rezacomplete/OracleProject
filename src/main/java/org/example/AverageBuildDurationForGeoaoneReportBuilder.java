package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The average build duration for each geozone
public class AverageBuildDurationForGeoaoneReportBuilder implements ReportBuilder{

    @Override
    public Object buildReport(List<Record> records) {
        Map<String, List<Integer>> geozoneToBuildDurations = new HashMap<>();
        for (Record record : records) {
            if (!geozoneToBuildDurations.containsKey(record.getGeoZone())) {
                geozoneToBuildDurations.put(record.getGeoZone(), new ArrayList<>());
            }
            String buildDurationWithoutSecondSymbol = record.getBuildDuration().substring(0, record.getBuildDuration().length() - 1);
            geozoneToBuildDurations.get(record.getGeoZone()).add(Integer.parseInt(buildDurationWithoutSecondSymbol));
        }

        return geozoneToBuildDurations;
    }
}
