

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class StringEvaluation {

    public char findMaxChar(Scanner scanner) {

        System.out.println("Enter text to check and hit enter");
        String text = readStringWithEmptyCheck(scanner).replaceAll("\\s+", "");

        char maxChar = '\0';
        int max = -1;
        int[] frequency = calculateCharFrequencies(text);
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (max < frequency[ch]) {
                max = frequency[ch];
                maxChar = ch;
            }
        }
        return maxChar;
    }

    private String readStringWithEmptyCheck(Scanner sc) {
        while (true) {
            String enteredText = sc.nextLine();
            if (!enteredText.isEmpty()) {
                return enteredText;
            } else {
                System.out.println("Empty string entered. Please enter a valid non-empty string:");
            }
        }
    }


    private static int[] calculateCharFrequencies(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        return frequency;
    }

    public boolean checkAnagram(Scanner sc) {

        System.out.println("Enter first string and hit enter: ");
        String firstString = readStringWithEmptyCheck(sc).replaceAll("\\s+", "");
        System.out.println("Enter second string and hit enter: ");
        String secondString = readStringWithEmptyCheck(sc).replaceAll("\\s+", "");

        if (firstString.length() != secondString.length())
            return false;

        char[] chars1 = convertToSortedCharArray(firstString);
        char[] chars2 = convertToSortedCharArray(secondString);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }
        return true;
    }

    private static char[] convertToSortedCharArray(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    public String reverseString(Scanner sc) {
        System.out.println("Enter string to be reversed: ");
        String text = readStringWithEmptyCheck(sc);

        char[] chars = text.toCharArray();
        int length = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public boolean checkPalindrome(Scanner sc) {
        System.out.println("Enter string to check and hit enter");

        String text = readStringWithEmptyCheck(sc).replaceAll("\\s|[^a-zA-Z0-9]","").toLowerCase();;

        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1))
                return false;
        }
        return true;
    }

}
