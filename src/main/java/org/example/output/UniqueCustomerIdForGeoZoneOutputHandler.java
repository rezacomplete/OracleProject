package org.example.output;

import java.util.Map;
import java.util.Set;

// The number of unique customerId for each geoZone and
// The list of unique customerId for each geoZone
public class UniqueCustomerIdForGeoZoneOutputHandler implements OutputHandler {

    @Override
    @SuppressWarnings("unchecked")
    public void printReportToOutput(Object report) {
        Map<String, Set<String>> geoZoneToCustomerIds = (Map<String, Set<String>>) report;
        for (Map.Entry<String, Set<String>> entry : geoZoneToCustomerIds.entrySet()) {
            System.out.println("The number of unique customerId for geoZone {" + entry.getKey() + "} is " + entry.getValue().size());

            System.out.print("The list of unique customerIds for geoZone {" + entry.getKey() + "} is ");
            for (String customerId : entry.getValue()) {
                System.out.print(customerId + " ");
            }
            System.out.println();
        }
    }
}
