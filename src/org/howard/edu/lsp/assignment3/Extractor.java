package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Extracts raw records from a source (e.g., CSV file).
 * @param <T> the record type
 */
public interface Extractor<T> {
    List<T> extract() throws IOException;
}
