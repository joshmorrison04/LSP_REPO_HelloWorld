package org.howard.edu.lsp.assignment3;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        try {
            Path input = Path.of("data", "products.csv");
            Path output = Path.of("data", "transformed_products.csv"); // required path
            CsvExtractor extractor = new CsvExtractor(input);
            ProductTransform transform = new ProductTransform();
            CsvLoader loader = new CsvLoader(output);
            EtlPipeline<java.util.Map<String, String>, java.util.Map<String, String>> pipeline =
                    new EtlPipeline<>(extractor, transform, loader);
            pipeline.run();
            System.out.println("A3 pipeline completed. Output -> " + output.toString());
        } catch (Exception e) {
            // Mirror A2 error handling style/messages as closely as possible.
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}

