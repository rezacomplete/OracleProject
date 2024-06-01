package org.example.output;

import java.util.Map;
import java.util.Set;

// The number of unique customerId for each contractId
public class UniqueCustomerIdForContractIdOutputHandler implements OutputHandler {

    @Override
    @SuppressWarnings("unchecked")
    public void printReportToOutput(Object report) {
        Map<String, Set<String>> contractIdToCustomerIds = (Map<String, Set<String>>) report;
        for (Map.Entry<String, Set<String>> entry : contractIdToCustomerIds.entrySet()) {
            System.out.println("The number of unique customerId for contractId {" + entry.getKey() + "} is " + entry.getValue().size());
        }
    }
}
