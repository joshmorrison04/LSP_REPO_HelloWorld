package org.howard.edu.lsp.midterm.question2;

public class Main {
    public static void main(String[] args) {
        // Normal valid calls
        System.out.println("Circle radius 3.0 → area = " + AreaCalculator.area(3.0));
        System.out.println("Rectangle 5.0 x 2.0 → area = " + AreaCalculator.area(5.0, 2.0));
        System.out.println("Triangle base 10, height 6 → area = " + AreaCalculator.area(10, 6));
        System.out.println("Square side 4 → area = " + AreaCalculator.area(4));

        // Demonstrate exception
        try {
            System.out.println("Invalid circle test → area = " + AreaCalculator.area(-1.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }
}
