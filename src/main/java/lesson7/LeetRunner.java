package lesson7;

public class LeetRunner {
    public static void main(String[] args) {
        Leet.isPalindrome("A man, a plan, a canal: Panama");
        Leet.isPalindrome("race a car");
        Leet.isPalindrome(" ");

        String[] str1 = {"flower", "flow", "flight"};
        System.out.println(Leet.longestCommonPrefix(str1));
        String[] str2 = {"dog","racecar","car"};
        System.out.println(Leet.longestCommonPrefix(str2));
    }
}
