package org.howard.edu.lsp.finale.question1;

/**
 * Service for generating passwords using pluggable algorithms.
 * 
 * This class is implemented as a Singleton and delegates the actual
 * password-generation work to a Strategy selected at runtime.
 */
public class PasswordGeneratorService {

    // Singleton instance
    private static PasswordGeneratorService instance;

    // Currently selected algorithm (Strategy)
    private PasswordAlgorithm currentAlgorithm;

    // Private constructor to prevent direct instantiation
    private PasswordGeneratorService() {
    }

    /**
     * Returns the single instance of this service (Singleton).
     *
     * @return the singleton PasswordGeneratorService instance
     */
    public static PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }

    /**
     * Selects the password-generation algorithm by name.
     *
     * @param name algorithm name: "basic", "enhanced", or "letters"
     * @throws IllegalArgumentException if the name is not recognized
     */
    public void setAlgorithm(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Algorithm name must not be null");
        }

        String lower = name.toLowerCase();

        switch (lower) {
            case "basic":
                currentAlgorithm = new BasicPasswordAlgorithm();
                break;
            case "enhanced":
                currentAlgorithm = new EnhancedPasswordAlgorithm();
                break;
            case "letters":
                currentAlgorithm = new LettersPasswordAlgorithm();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }

    /**
     * Generates a password of the given length using the currently
     * selected algorithm.
     *
     * @param length desired password length
     * @return generated password
     * @throws IllegalStateException if no algorithm has been selected
     */
    public String generatePassword(int length) {
        if (currentAlgorithm == null) {
            throw new IllegalStateException("No algorithm selected");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Password length must be non-negative");
        }
        return currentAlgorithm.generate(length);
    }

    /*
     * Design Patterns Used:
     *
     * 1. Singleton:
     *    - Ensures there is only one PasswordGeneratorService instance
     *      in the application.
     *    - Provides a single shared access point via getInstance().
     *    - Matches the requirement that "only one instance of the
     *      service may exist" and "provide a single shared access point."
     *
     * 2. Strategy:
     *    - Encapsulates different password-generation algorithms
     *      behind the PasswordAlgorithm interface.
     *    - Allows the behavior to be swappable at run time through
     *      the setAlgorithm(String name) method.
     *    - Supports future expansion of algorithms without modifying
     *      client code, satisfying the requirement for extensible
     *      password-generation approaches.
     */
}
