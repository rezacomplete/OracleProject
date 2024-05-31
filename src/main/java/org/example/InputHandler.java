package org.example;

import java.util.List;

// A marker for all input handlers. Each implementation should handle its own way of reading the input
public interface InputHandler {

    List<Record> buildRecordsFromInput();
}
