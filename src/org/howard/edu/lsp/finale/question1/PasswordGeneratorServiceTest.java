package org.howard.edu.lsp.finale.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for PasswordGeneratorService.
 */
public class PasswordGeneratorServiceTest {

    private PasswordGeneratorService service;

    @BeforeEach
    public void setup() {
        service = PasswordGeneratorService.getInstance();
    }

    @Test
    public void checkInstanceNotNull() {
        assertNotNull(service);
    }

    @Test
    public void checkSingleInstanceBehavior() {
        PasswordGeneratorService second = PasswordGeneratorService.getInstance();
        assertSame(service, second);
    }

    @Test
    public void generateWithoutSettingAlgorithmThrowsException() {
        PasswordGeneratorService s = PasswordGeneratorService.getInstance();

        assertThrows(IllegalStateException.class, () -> {
            s.generatePassword(10);
        });
    }

    @Test
    public void basicAlgorithmGeneratesCorrectLengthAndDigitsOnly() {
        service.setAlgorithm("basic");
        String p = service.generatePassword(10);

        assertEquals(10, p.length());
        assertTrue(p.chars().allMatch(ch -> Character.isDigit((char) ch)),
                "Basic algorithm should generate digits only");
    }

    @Test
    public void enhancedAlgorithmGeneratesCorrectCharactersAndLength() {
        service.setAlgorithm("enhanced");
        String p = service.generatePassword(12);

        assertEquals(12, p.length());
        assertTrue(p.chars().allMatch(ch -> Character.isLetterOrDigit((char) ch)),
                "Enhanced algorithm should generate letters and digits only");
    }

    @Test
    public void lettersAlgorithmGeneratesLettersOnly() {
        service.setAlgorithm("letters");
        String p = service.generatePassword(8);

        assertEquals(8, p.length());
        assertTrue(p.chars().allMatch(ch -> Character.isLetter((char) ch)),
                "Letters algorithm should generate letters only");
    }

    @Test
    public void switchingAlgorithmsChangesBehavior() {
        service.setAlgorithm("basic");
        String p1 = service.generatePassword(10);

        service.setAlgorithm("letters");
        String p2 = service.generatePassword(10);

        service.setAlgorithm("enhanced");
        String p3 = service.generatePassword(10);

        assertTrue(p1.chars().allMatch(ch -> Character.isDigit((char) ch)),
                "Basic algorithm output should be digits only");

        assertTrue(p2.chars().allMatch(ch -> Character.isLetter((char) ch)),
                "Letters algorithm output should be letters only");

        assertTrue(p3.chars().allMatch(ch -> Character.isLetterOrDigit((char) ch)),
                "Enhanced algorithm output should be letters or digits");
    }
}
