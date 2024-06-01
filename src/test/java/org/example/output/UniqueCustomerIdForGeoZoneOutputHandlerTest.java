package org.example.output;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCustomerIdForGeoZoneOutputHandlerTest {

    @Test
    void printReportToOutput() {
        Map<String, Set<String>> report = new HashMap<>();
        Set<String> customerIds1 = new HashSet<>();
        customerIds1.add("2343225");
        customerIds1.add("1223456");
        report.put("us_east", customerIds1);

        Set<String> customerIds2 = new HashSet<>();
        customerIds2.add("3244332");
        report.put("us_west", customerIds2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputHandler outputHandler = new UniqueCustomerIdForGeoZoneOutputHandler();
        outputHandler.printReportToOutput(report);

        Set<String> expectedOutputLines = new HashSet<>();
        expectedOutputLines.add("The number of unique customerId for geoZone {us_east} is 2");
        expectedOutputLines.add("The number of unique customerId for geoZone {us_west} is 1");
        expectedOutputLines.add("The list of unique customerIds for geoZone {us_east} is 2343225 1223456 ");
        expectedOutputLines.add("The list of unique customerIds for geoZone {us_west} is 3244332 ");

        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        for (String outputLine : outputLines) {
            assertTrue(expectedOutputLines.contains(outputLine));
        }
    }
}