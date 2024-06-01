package org.example;

import org.example.output.AverageBuildDurationForGeoZoneOutputHandler;
import org.example.output.UniqueCustomerIdForContractIdOutputHandler;
import org.example.output.UniqueCustomerIdForGeoZoneOutputHandler;
import org.example.report.AverageBuildDurationForGeoZoneReportBuilder;
import org.example.report.UniqueCustomerIdForContractIdReportBuilder;
import org.example.report.UniqueCustomerIdForGeoZoneReportBuilder;

import java.util.*;

public class ReportExecutor {

    private final String inputData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
            "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
            "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
            "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
            "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

    public void execute() {

        // reading inputs from file
        List<Record> records = new RecordsBuilder().buildRecords(inputData);

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