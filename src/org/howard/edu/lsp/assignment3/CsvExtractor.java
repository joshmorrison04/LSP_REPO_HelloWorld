package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * CSV extractor that returns each row as a Map<header, value>.
 * Encapsulates file I/O and parsing.
 */
public class CsvExtractor implements Extractor<Map<String, String>> {
    private final Path inputPath;

    public CsvExtractor(Path inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public List<Map<String, String>> extract() throws IOException {
        if (!Files.exists(inputPath)) {
            throw new IOException("Missing input file: " + inputPath.toString());
        }
        List<String> lines = Files.readAllLines(inputPath);
        if (lines.isEmpty()) return Collections.emptyList();

        String[] headers = lines.get(0).split(",", -1);
        List<Map<String, String>> out = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] cols = lines.get(i).split(",", -1);
            Map<String, String> row = new LinkedHashMap<>();
            for (int c = 0; c < headers.length; c++) {
                String key = headers[c].trim();
                String val = c < cols.length ? cols[c] : "";
                row.put(key, val);
            }
            out.add(row);
        }
        return out;
    }
}

