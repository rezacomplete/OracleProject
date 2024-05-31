package org.example;

import java.util.Map;
import java.util.Set;

// The number of unique customerId for each geozone and
// The list of unique customerId for each geozone
public class UniqueCustomerIdForGeozoneOutputHandler implements OutputHandler {

    @Override
    @SuppressWarnings("unchecked")
    public void printReportToOutput(Object report) {
        Map<String, Set<String>> geozoneToCustomerIds = (Map<String, Set<String>>) report;
        for (Map.Entry<String, Set<String>> entry : geozoneToCustomerIds.entrySet()) {
            System.out.println("The number of unique customerId for geozone {" + entry.getKey() + "} is " + entry.getValue().size());

            System.out.print("The list of unique customerIds for geozone {" + entry.getKey() + "} is ");
            for (String customerId : entry.getValue()) {
                System.out.print(customerId + " ");
            }
            System.out.println();
        }
    }
}
