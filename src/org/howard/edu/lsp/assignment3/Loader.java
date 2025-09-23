package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Loads records into a sink (e.g., CSV file).
 * @param <T> the record type
 */
public interface Loader<T> {
    void load(List<T> records) throws IOException;
}

