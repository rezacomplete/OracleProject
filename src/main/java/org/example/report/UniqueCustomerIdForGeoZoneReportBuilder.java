package org.example.report;

import org.example.Record;

import java.util.*;

// The number of unique customerId for each geoZone and
// The list of unique customerId for each geoZone
public class UniqueCustomerIdForGeoZoneReportBuilder implements ReportBuilder {

    @Override
    public Object buildReport(List<Record> records) {
        Map<String, Set<String>> geoZoneToCustomerIds = new HashMap<>();
        for (Record record : records) {
            if (!geoZoneToCustomerIds.containsKey(record.getGeoZone())) {
                geoZoneToCustomerIds.put(record.getGeoZone(), new HashSet<>());
            }
            geoZoneToCustomerIds.get(record.getGeoZone()).add(record.getCustomerId());
        }

        return geoZoneToCustomerIds;
    }
}
