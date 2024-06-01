package org.example.output;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AverageBuildDurationForGeoZoneOutputHandlerTest {

    @Test
    void printReportToOutput() {
        Map<String, Integer> report = new HashMap<>();
        report.put("us_east", 3000);
        report.put("us_west", 2500);
        report.put("eu_west", 3500);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputHandler outputHandler = new AverageBuildDurationForGeoZoneOutputHandler();
        outputHandler.printReportToOutput(report);

        Set<String> expectedOutputLines = new HashSet<>();
        expectedOutputLines.add("The average build duration for geoZone {us_east} is 3000");
        expectedOutputLines.add("The average build duration for geoZone {us_west} is 2500");
        expectedOutputLines.add("The average build duration for geoZone {eu_west} is 3500");

        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        for (String outputLine : outputLines) {
            assertTrue(expectedOutputLines.contains(outputLine));
        }
    }
}