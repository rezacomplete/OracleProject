package org.example.report;

import org.example.Record;

import java.util.Arrays;
import java.util.List;

public class RecordsUtil {

    public static List<Record> buildRecords() {
        return List.of(
                new Record.RecordBuilder()
                        .setCustomerId("2343225")
                        .setContractId("2345")
                        .setGeoZone("us_east")
                        .setTeamCode("RedTeam")
                        .setProjectCode("ProjectApple")
                        .setBuildDuration("3445s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("1223456")
                        .setContractId("2345")
                        .setGeoZone("us_west")
                        .setTeamCode("BlueTeam")
                        .setProjectCode("ProjectBanana")
                        .setBuildDuration("2211s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("3244332")
                        .setContractId("2346")
                        .setGeoZone("eu_west")
                        .setTeamCode("YellowTeam3")
                        .setProjectCode("ProjectCarrot")
                        .setBuildDuration("4322s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("1233456")
                        .setContractId("2345")
                        .setGeoZone("us_west")
                        .setTeamCode("BlueTeam")
                        .setProjectCode("ProjectDate")
                        .setBuildDuration("2221s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("3244132")
                        .setContractId("2346")
                        .setGeoZone("eu_west")
                        .setTeamCode("YellowTeam3")
                        .setProjectCode("ProjectEgg")
                        .setBuildDuration("4122s")
                        .build()
        );
    }

    public static List<Record> buildReportWithDuplicateCustomerIdsInSameGeoZone() {
        return List.of(
                new Record.RecordBuilder()
                        .setCustomerId("2343225")
                        .setContractId("2345")
                        .setGeoZone("us_east")
                        .setTeamCode("RedTeam")
                        .setProjectCode("ProjectApple")
                        .setBuildDuration("3445s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("3244332")
                        .setContractId("2345")
                        .setGeoZone("us_west")
                        .setTeamCode("BlueTeam")
                        .setProjectCode("ProjectBanana")
                        .setBuildDuration("2211s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("3244332")
                        .setContractId("2346")
                        .setGeoZone("us_west")
                        .setTeamCode("YellowTeam3")
                        .setProjectCode("ProjectCarrot")
                        .setBuildDuration("4322s")
                        .build()
        );
    }

    public static List<Record> BuildRecordsWithDuplicateCustomerIdsInSameContract() {
        return List.of(
                new Record.RecordBuilder()
                        .setCustomerId("2343225")
                        .setContractId("2345")
                        .setGeoZone("us_east")
                        .setTeamCode("RedTeam")
                        .setProjectCode("ProjectApple")
                        .setBuildDuration("3445s")
                        .build(),
                new Record.RecordBuilder()
                        .setCustomerId("2343225")
                        .setContractId("2345")
                        .setGeoZone("us_west")
                        .setTeamCode("BlueTeam")
                        .setProjectCode("ProjectBanana")
                        .setBuildDuration("2211s")
                        .build()
        );
    }
}
