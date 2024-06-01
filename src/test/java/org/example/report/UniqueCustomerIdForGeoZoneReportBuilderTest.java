package org.example.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Record;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCustomerIdForGeoZoneReportBuilderTest {

    private ReportBuilder reportBuilder;

    @BeforeEach
    void setUp() {
        reportBuilder = new UniqueCustomerIdForGeoZoneReportBuilder();
    }

    @Test
    void buildReport() {
        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(RecordsUtil.buildRecords());

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(1, result.get("us_east").size());
        assertEquals(new HashSet<>(List.of("2343225")), result.get("us_east"));
        assertEquals(2, result.get("us_west").size());
        assertEquals(new HashSet<>(List.of("1223456", "1233456")), result.get("us_west"));
        assertEquals(2, result.get("eu_west").size());
        assertEquals(new HashSet<>(List.of("3244332", "3244132")), result.get("eu_west"));
    }

    @Test
    void buildReportWithEmptyList() {
        List<Record> records = Collections.emptyList();
        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(records);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void buildReportWithDuplicateCustomerIds() {
        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(RecordsUtil.buildReportWithDuplicateCustomerIdsInSameGeoZone());

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(new HashSet<>(List.of("2343225")), result.get("us_east"));
        assertEquals(new HashSet<>(List.of("3244332")), result.get("us_west"));
    }


}