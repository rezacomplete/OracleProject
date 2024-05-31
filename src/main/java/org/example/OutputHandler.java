package org.example;

// Marker interface for all output handlers. Each output handler should format and print the report to its specific output
public interface OutputHandler {

    void printReportToOutput(Object report);

}
