package org.example;

import java.util.*;


// The number of unique customerId for each contractId
public class UniqueCustomerIdForContractIdReportBuilder implements ReportBuilder {

    @Override
    public Object buildReport(List<Record> records) {
        Map<String, Set<String>> contractIdToCustomerIds = new HashMap<>();
        for (Record record : records) {
            if (!contractIdToCustomerIds.containsKey(record.getContractId())) {
                contractIdToCustomerIds.put(record.getContractId(), new HashSet<>());
            }
            contractIdToCustomerIds.get(record.getContractId()).add(record.getCustomerId());
        }

        return contractIdToCustomerIds;
    }
}
