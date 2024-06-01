package org.example;

import org.example.input.FileInputHandler;
import org.example.output.AverageBuildDurationForGeoZoneOutputHandler;
import org.example.output.UniqueCustomerIdForContractIdOutputHandler;
import org.example.output.UniqueCustomerIdForGeoZoneOutputHandler;
import org.example.report.AverageBuildDurationForGeoZoneReportBuilder;
import org.example.report.UniqueCustomerIdForContractIdReportBuilder;
import org.example.report.UniqueCustomerIdForGeoZoneReportBuilder;

import java.util.*;

public class ReportExecutor {

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
        // The number of unique customerId for each geoZone and
        // The list of unique customerId for each geoZone
        // ****************************************************

        // Building the report
       report =  new UniqueCustomerIdForGeoZoneReportBuilder().buildReport(records);

        // Formatting the report and printing the result
        new UniqueCustomerIdForGeoZoneOutputHandler().printReportToOutput(report);

        // *******************************************
        // The average build duration for each geoZone
        // *******************************************

        // Building the report
        report = new AverageBuildDurationForGeoZoneReportBuilder().buildReport(records);

        // Formatting the report and printing the result
        new AverageBuildDurationForGeoZoneOutputHandler().printReportToOutput(report);

    }

}