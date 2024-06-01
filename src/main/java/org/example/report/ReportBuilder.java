package org.example.report;

import org.example.Record;

import java.util.List;

public interface ReportBuilder {

    Object buildReport(List<Record> records);
}
