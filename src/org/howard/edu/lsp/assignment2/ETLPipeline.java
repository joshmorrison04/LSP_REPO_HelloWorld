package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class ETLPipeline {
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        ArrayList<String[]> rawData = extract(inputPath);
        if (rawData == null) return;

        ArrayList<String[]> transformedData = transform(rawData);
        load(outputPath, transformedData);

        // Summary
        int rowsRead = rawData.size();
        int rowsTransformed = transformedData.size() - 1; // exclude header
        int rowsSkipped = 0;
        if (rowsRead > 0) {
            rowsSkipped = rowsRead - 1 - rowsTransformed;
        }

        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file written: " + outputPath);
    }

    public static ArrayList<String[]> extract(String filePath) {
        ArrayList<String[]> data = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Error: Input file '" + filePath + "' not found.");
            return null;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] fields = line.split(",");
                    data.add(fields);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the input file.");
            return null;
        }

        return data;
    }

    public static ArrayList<String[]> transform(ArrayList<String[]> data) {
        ArrayList<String[]> result = new ArrayList<>();

        // Header
        String[] header = {"ProductID", "Name", "Price", "Category", "PriceRange"};
        result.add(header);

        // Skip if empty
        if (data.size() <= 1) return result;

        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            if (row.length < 4) continue;

            try {
                String productId = row[0].trim();
                String name = row[1].trim().toUpperCase();
                BigDecimal price = new BigDecimal(row[2].trim());
                String category = row[3].trim();

                // 10% discount if category is Electronics
                boolean isElectronics = category.equalsIgnoreCase("Electronics");
                if (isElectronics) {
                    price = price.multiply(BigDecimal.valueOf(0.9));
                }

                // Round to 2 decimal places (HALF_UP)
                price = price.setScale(2, RoundingMode.HALF_UP);

                // Category change if price > 500
                if (isElectronics && price.compareTo(BigDecimal.valueOf(500.00)) > 0) {
                    category = "Premium Electronics";
                }

                // PriceRange
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

                String[] newRow = {
                    productId,
                    name,
                    price.toString(),
                    category,
                    priceRange
                };
                result.add(newRow);

            } catch (Exception e) {
                // Skip malformed rows
                continue;
            }
        }

        return result;
    }

    public static void load(String filePath, ArrayList<String[]> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                writer.println(String.join(",", row));
            }
        } catch (IOException e) {
            System.out.println("Error writing to output file.");
        }
    }
}
