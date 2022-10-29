package lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LeetTest {

    @Test
    void checkLengthOfLastWord() {
        int length = Leet.lengthOfLastWord("Hello World");
        int length2 = Leet.lengthOfLastWord("   fly me   to   the moon  ");
        Assertions.assertEquals(5, length);
        Assertions.assertEquals(4, length2);
    }

    @Test
    void checkIfPalindrome() {
        boolean isPalindrome = Leet.isPalindrome("A man, a plan, a canal: Panama");
        boolean isPalindrome2 = Leet.isPalindrome("race a car");
        boolean isPalindrome3 = Leet.isPalindrome(" ");

        Assertions.assertTrue(isPalindrome);
        Assertions.assertFalse(isPalindrome2);
        Assertions.assertTrue(isPalindrome3);
    }

    @Test
    void checkLongestCommonPrefix() {
        String[] str1 = {"flower", "flow", "flight"};
        String commonPrefix1 = Leet.longestCommonPrefix(str1);
        String[] str2 = {"dog","racecar","car"};
        String commonPrefix2 = Leet.longestCommonPrefix(str2);

        Assertions.assertEquals("fl", commonPrefix1);
        Assertions.assertEquals("", commonPrefix2);
    }
}
