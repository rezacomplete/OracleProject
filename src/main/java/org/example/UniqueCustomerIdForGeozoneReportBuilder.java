package org.example;

import java.util.*;

// The number of unique customerId for each geozone and
// The list of unique customerId for each geozone
public class UniqueCustomerIdForGeozoneReportBuilder implements ReportBuilder {

    @Override
    public Object buildReport(List<Record> records) {
        Map<String, Set<String>> geozoneToCustomerIds = new HashMap<>();
        for (Record record : records) {
            if (!geozoneToCustomerIds.containsKey(record.getGeoZone())) {
                geozoneToCustomerIds.put(record.getGeoZone(), new HashSet<>());
            }
            geozoneToCustomerIds.get(record.getGeoZone()).add(record.getCustomerId());
        }

        return geozoneToCustomerIds;
    }
}
