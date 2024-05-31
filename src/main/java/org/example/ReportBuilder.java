package org.example;

import java.util.List;

public interface ReportBuilder {

    Object buildReport(List<Record> records);
}
