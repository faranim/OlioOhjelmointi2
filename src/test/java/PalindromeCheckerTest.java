import static org.junit.jupiter.api.Assertions.*;
import org.example.Moduuli8.Moduuli8_2.PalindromeChecker;

import org.junit.jupiter.api.Test;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        // Test cases for palindromes
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("Was it a car or a cat I saw"));
        assertTrue(checker.isPalindrome("No lemon, no melon"));

        // Test cases for non-palindromes
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
        assertFalse(checker.isPalindrome("Java Programming"));
    }
}
