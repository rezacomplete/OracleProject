package org.example;

public class Record {

    private final String customerId;
    private final String contractId;
    private final String geoZone;
    private final String teamCode;
    private final String projectCode;
    private final String buildDuration;

    public Record(RecordBuilder recordBuilder) {
        this.customerId = recordBuilder.customerId;
        this.contractId = recordBuilder.contractId;
        this.geoZone = recordBuilder.geoZone;
        this.teamCode = recordBuilder.teamCode;
        this.projectCode = recordBuilder.projectCode;
        this.buildDuration = recordBuilder.buildDuration;

    }

    public String getCustomerId() {
        return customerId;
    }

    public String getContractId() {
        return contractId;
    }
    public String getGeoZone() {
        return geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getBuildDuration() {
        return buildDuration;
    }

    public static class RecordBuilder {
        private String customerId;
        private String contractId;
        private String geoZone;
        private String teamCode;
        private String projectCode;
        private String buildDuration;

        public RecordBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public RecordBuilder setContractId(String contractId) {
            this.contractId = contractId;
            return this;
        }

        public RecordBuilder setGeoZone(String geoZone) {
            this.geoZone = geoZone;
            return this;
        }

        public RecordBuilder setTeamCode(String teamCode) {
            this.teamCode = teamCode;
            return this;
        }

        public RecordBuilder setProjectCode(String projectCode) {
            this.projectCode = projectCode;
            return this;
        }

        public RecordBuilder setBuildDuration(String buildDuration) {
            this.buildDuration = buildDuration;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
