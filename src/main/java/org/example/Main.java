package org.example;

import java.util.*;

public class Main {

    public void execute() {

        // reading inputs from file
        List<Record> records = new FileInputHandler().buildRecordsFromInput();

        // ***************************************************
        // The number of unique customerId for each contractId
        // ***************************************************

        // Building the report
        Object report =  new UniqueCustomerIdForContractIdReportBuilder().buildReport(records);

        // Formatting the report and printing the result
        new UniqueCustomerIdForContractIdOutputHandler().printReportToOutput(report);

        // ****************************************************
        // The number of unique customerId for each geozone and
        // The list of unique customerId for each geozone
        // ****************************************************

        // Building the report
       report =  new UniqueCustomerIdForGeozoneReportBuilder().buildReport(records);

        // Formatting the report and printing the result
        new UniqueCustomerIdForGeozoneOutputHandler().printReportToOutput(report);

        // *******************************************
        // The average build duration for each geozone
        // *******************************************

        // Building the report
        report = new AverageBuildDurationForGeoaoneReportBuilder().buildReport(records);

        // Formatting the report and printing the result
        new AverageBuildDurationForGeoaoneOutputHandler().printReportToOutput(report);

    }

}