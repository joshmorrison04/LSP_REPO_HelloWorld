package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Basic algorithm: generates passwords using digits only (0-9)
 * with java.util.Random.
 */
public class BasicPasswordAlgorithm implements PasswordAlgorithm {
    private static final String DIGITS = "0123456789";
    private final Random random = new Random();

    @Override
    public String generate(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            char c = DIGITS.charAt(index);
            builder.append(c);
        }
        return builder.toString();
    }
}
