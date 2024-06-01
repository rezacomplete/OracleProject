package org.example.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import org.example.Record;

import static org.junit.jupiter.api.Assertions.*;

class AverageBuildDurationForGeoZoneReportBuilderTest {

    private ReportBuilder reportBuilder;

    @BeforeEach
    void setUp() {
        reportBuilder = new AverageBuildDurationForGeoZoneReportBuilder();
    }


    @Test
    void buildReport() {
        Map<String, Integer> result = (Map<String, Integer>) reportBuilder.buildReport(RecordsUtil.buildRecords());

        assertNotNull(result);
        assertEquals(3, result.size()); // We have 3 geoZones
        assertEquals(3445, result.get("us_east"));
        assertEquals(2216, result.get("us_west")); // (2211 + 2221) / 2 = 2216
        assertEquals(4222, result.get("eu_west")); // (4322 + 4122) / 2 = 4222
     }

    @Test
    void buildReportWithEmptyList() {
        List<Record> records = Collections.emptyList();
        Map<String, Integer> result = (Map<String, Integer>) reportBuilder.buildReport(records);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void buildReportWithZeroBuildDuration() {
        List<Record> records = List.of(
                new Record.RecordBuilder()
                        .setCustomerId("2343225")
                        .setContractId("2345")
                        .setGeoZone("us_east")
                        .setTeamCode("RedTeam")
                        .setProjectCode("ProjectApple")
                        .setBuildDuration("0s")
                        .build()
                );


        Map<String, Integer> result = (Map<String, Integer>) reportBuilder.buildReport(records);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(0, result.get("us_east"));
    }

}