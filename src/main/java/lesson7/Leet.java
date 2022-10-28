package lesson7;

import java.util.Arrays;

public class Leet {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * A word is a maximal substring consisting of non-space characters only.
     *
     * @param s - string s consisting of words and spaces
     * @return - length of the last word
     */
    public static int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        String[] arr = trimmed.split(" ");
        int length = arr[arr.length - 1].length();

        return length;
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
     * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
     * and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * @param s String to check
     * @return true or false
     */
    public static boolean isPalindrome(String s) {
        String alphaNumericsOnly = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll("\\s+", "").toLowerCase();
        System.out.println(alphaNumericsOnly);
        for (int i = 0, j = alphaNumericsOnly.length() - 1; i <= alphaNumericsOnly.length() / 2 && j >= alphaNumericsOnly.length() / 2; i++, j--) {
            if (alphaNumericsOnly.charAt(i) != alphaNumericsOnly.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     *
     * @param strs Array of strings
     * @return longest common prefix or " "
     */
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int n = strs.length;
        String[] sorted = sort(strs);
        String shortest = sorted[0];
        String longest = sorted[n - 1];
        for (int i = 0; i < shortest.length(); i++) {
            if (shortest.charAt(i) != longest.charAt(i)) break;
            prefix = prefix + shortest.charAt(i);
        }
        return prefix;
    }

    private static String[] sort(String[] strs) {
        int size = strs.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (strs[i].compareTo(strs[j]) > 0) {
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }

        return strs;
    }
}
