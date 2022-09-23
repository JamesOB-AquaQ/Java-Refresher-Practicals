



import java.sql.SQLOutput;
import java.util.Scanner;

public class StringExerciseMenu {

    public static final String OPTION_FIND_MAX_CHAR = "1";
    public static final String OPTION_CHECK_ANAGRAM = "2";
    public static final String OPTION_REVERSE_STRING = "3";
    public static final String OPTION_CHECK_IS_PALINDROME = "4";
    public static final String OPTION_EXIT = "5";

    private static StringEvaluation stringEvaluation;

    public StringExerciseMenu(StringEvaluation stringEvaluation) {
        this.stringEvaluation = stringEvaluation;
    }

    public void handleUserInput(Scanner scanner) {
        System.out.println("Welcome to the String Exercise Menu, please select an option:");
        String selected;

        do {
            showOptions();
            selected = scanner.nextLine();
            switch (selected) {
                case OPTION_FIND_MAX_CHAR:
                    System.out.println("\nThe first Maximum Occurring Character = " +  stringEvaluation.findMaxChar(scanner));
                    break;
                case OPTION_CHECK_ANAGRAM:
                    if(stringEvaluation.checkAnagram(scanner))
                        System.out.println("The two strings are anagrams");
                    else
                        System.out.println("The two strings are not anagrams");
                    break;
                case OPTION_REVERSE_STRING:
                    System.out.println("Reversed string is: "+stringEvaluation.reverseString(scanner));
                    break;
                case OPTION_CHECK_IS_PALINDROME:
                    if(stringEvaluation.checkPalindrome(scanner))
                        System.out.println("String is a palindrome");
                    else
                        System.out.println("String is not a palindrome");
                    break;
                case OPTION_EXIT:
                    System.out.println("Exiting game.");
                    break;
                default:
                    System.out.println("Option not available, please try again!");
            }

        } while (!selected.equals(OPTION_EXIT));
    }

    private static void showOptions() {
        System.out.println();
        System.out.println("Problem Menu:");
        System.out.println(OPTION_FIND_MAX_CHAR + ": Find max occurring char in String");
        System.out.println(OPTION_CHECK_ANAGRAM + ": Check 2 Strings are an anagrams of each other");
        System.out.println(OPTION_REVERSE_STRING + ": Reverse entered String");
        System.out.println(OPTION_CHECK_IS_PALINDROME + ": Check if String is a Palindrome");
        System.out.println(OPTION_EXIT + ": Exit");
    }

}

