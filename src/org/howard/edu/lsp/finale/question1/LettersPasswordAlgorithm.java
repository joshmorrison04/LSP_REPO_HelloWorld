package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Letters algorithm: generates passwords using letters only
 * (A-Z, a-z).
 */
public class LettersPasswordAlgorithm implements PasswordAlgorithm {
    private static final String LETTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz";

    private final Random random = new Random();

    @Override
    public String generate(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(LETTERS.length());
            char c = LETTERS.charAt(index);
            builder.append(c);
        }
        return builder.toString();
    }
}
