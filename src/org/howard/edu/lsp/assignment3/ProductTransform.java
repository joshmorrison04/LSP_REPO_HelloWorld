package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Transforms raw product rows into enriched product rows.
 * Implements the same transformations from Assignment 2.
 */
public class ProductTransform implements Transformer<Map<String, String>, Map<String, String>> {

    @Override
    public List<Map<String, String>> transform(List<Map<String, String>> input) {
        List<Map<String, String>> result = new ArrayList<>();

        // Skip if no data
        if (input.size() <= 1) return result;

        for (int i = 0; i < input.size(); i++) {  // skip header row
            Map<String, String> row = input.get(i);
            if (row.size() < 4) continue;

            try {
                String productId = row.getOrDefault("ProductID", "").trim();
                String name = row.getOrDefault("Name", "").trim().toUpperCase();
                BigDecimal price = new BigDecimal(row.getOrDefault("Price", "").trim());
                String category = row.getOrDefault("Category", "").trim();

                // 10% discount if Electronics
                boolean isElectronics = category.equalsIgnoreCase("Electronics");
                if (isElectronics) {
                    price = price.multiply(BigDecimal.valueOf(0.9));
                }

                // Round to 2 decimal places
                price = price.setScale(2, RoundingMode.HALF_UP);

                // Category change if Electronics and price > 500
                if (isElectronics && price.compareTo(BigDecimal.valueOf(500.00)) > 0) {
                    category = "Premium Electronics";
                }

                // PriceRange logic
                String priceRange;
                if (price.compareTo(BigDecimal.valueOf(10.00)) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(BigDecimal.valueOf(100.00)) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(BigDecimal.valueOf(500.00)) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // Build transformed row
                Map<String, String> newRow = new LinkedHashMap<>();
                newRow.put("ProductID", productId);
                newRow.put("Name", name);
                newRow.put("Price", price.toString());
                newRow.put("Category", category);
                newRow.put("PriceRange", priceRange);

                result.add(newRow);

            } catch (Exception e) {
                // Skip malformed rows
                continue;
            }
        }

        return result;
    }
}


