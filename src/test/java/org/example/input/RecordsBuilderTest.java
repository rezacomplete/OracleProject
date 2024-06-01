package org.example.input;

import org.example.RecordsBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.example.Record;

import static org.junit.jupiter.api.Assertions.*;

class RecordsBuilderTest {

    @Test
    void buildRecords() {
        String inputData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";


        List<Record> records = new RecordsBuilder().buildRecords(inputData);

        assertNotNull(records);
        assertEquals(5, records.size());

        Record record1 = records.get(0);
        assertEquals("2343225", record1.getCustomerId());
        assertEquals("2345", record1.getContractId());
        assertEquals("us_east", record1.getGeoZone());
        assertEquals("RedTeam", record1.getTeamCode());
        assertEquals("ProjectApple", record1.getProjectCode());
        assertEquals("3445s", record1.getBuildDuration());

        Record record2 = records.get(1);
        assertEquals("1223456", record2.getCustomerId());
        assertEquals("2345", record2.getContractId());
        assertEquals("us_west", record2.getGeoZone());
        assertEquals("BlueTeam", record2.getTeamCode());
        assertEquals("ProjectBanana", record2.getProjectCode());
        assertEquals("2211s", record2.getBuildDuration());
    }
}