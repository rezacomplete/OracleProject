package org.example.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Record;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCustomerIdForContractIdReportBuilderTest {

    private ReportBuilder reportBuilder;

    @BeforeEach
    void setUp() {
        reportBuilder = new UniqueCustomerIdForContractIdReportBuilder();
    }

    @Test
    void buildReport() {
        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(RecordsUtil.buildRecords());

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(3, result.get("2345").size());
        assertEquals(new HashSet<>(List.of("2343225", "1223456", "1233456")), result.get("2345"));
        assertEquals(2, result.get("2346").size());
        assertEquals(new HashSet<>(List.of("3244332", "3244132")), result.get("2346"));
    }

    @Test
    void testBuildReportWithEmptyList() {
        List<Record> records = Collections.emptyList();

        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(records);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testBuildReportWithDuplicateCustomerIdsInSameContract() {
        Map<String, Set<String>> result = (Map<String, Set<String>>) reportBuilder.buildReport(RecordsUtil.BuildRecordsWithDuplicateCustomerIdsInSameContract());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(new HashSet<>(Collections.singletonList("2343225")), result.get("2345"));
    }
}