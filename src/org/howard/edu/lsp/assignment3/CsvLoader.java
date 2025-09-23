package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * CSV loader that writes a list of Map<header, value> rows.
 * Ensures stable header order by using first row's key order.
 */
public class CsvLoader implements Loader<Map<String, String>> {
    private final Path outputPath;

    public CsvLoader(Path outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void load(List<Map<String, String>> records) throws IOException {
        Files.createDirectories(outputPath.getParent());
        List<String> lines = new ArrayList<>();
        if (records.isEmpty()) {
            // If A2 behavior wrote only header on empty input, do that here instead.
            // lines.add(String.join(",", ...headers...));
            Files.write(outputPath, lines);
            return;
        }
        // Header from first row key order:
        List<String> headers = new ArrayList<>(records.get(0).keySet());
        lines.add(String.join(",", headers));

        for (Map<String, String> r : records) {
            List<String> cols = new ArrayList<>(headers.size());
            for (String h : headers) {
                cols.add(r.getOrDefault(h, ""));
            }
            lines.add(String.join(",", cols));
        }
        Files.write(outputPath, lines);
    }
}

