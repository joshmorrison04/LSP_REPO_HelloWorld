package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Orchestrates Extract -> Transform -> Load.
 */
public class EtlPipeline<S, T> {
    private final Extractor<S> extractor;
    private final Transformer<S, T> transformer;
    private final Loader<T> loader;

    public EtlPipeline(Extractor<S> extractor, Transformer<S, T> transformer, Loader<T> loader) {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
    }

    public void run() throws IOException {
        List<S> raw = extractor.extract();
        List<T> xformed = transformer.transform(raw);
        loader.load(xformed);
    }
}

