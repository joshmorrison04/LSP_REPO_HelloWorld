package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Transforms input records into output records (1:1 or many:1 as needed).
 * @param <S> input record type
 * @param <T> output record type
 */
public interface Transformer<S, T> {
    List<T> transform(List<S> input);
}

