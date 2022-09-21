import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {
    private StringEvaluation stringEvaluation;
    private String testInput = null;
    private ByteArrayOutputStream outputStreamCaptor;
    private InputStream in;

    @BeforeEach
    protected void setUp(){
        stringEvaluation = new StringEvaluation();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    protected void tearDown(){
        stringEvaluation = null;
        outputStreamCaptor = null;
        System.setOut(new PrintStream(System.out));
        System.setIn(System.in);
    }

    @Test
    public void testMainCheckAnagram_InputStringsAreAnagrams()  {
        testInput = "2\ninch\nchin\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The two strings are anagrams"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainCheckAnagram_EmptyFirstInputStringsAreAnagrams()  {
        testInput = "2\n\ninch\nchin\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The two strings are anagrams"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith("Exiting game."));
        assertTrue(outputStreamCaptor.toString().contains("Enter first string and hit enter: \nEmpty string entered. Please enter a valid non-empty string:\n"));
    }
    @Test
    public void testMainCheckAnagram_EmptySecondInputStringsAreAnagrams()  {
        testInput = "2\ninch\n\nchin\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The two strings are anagrams"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith("Exiting game."));
        assertTrue(outputStreamCaptor.toString().contains("Enter second string and hit enter: \nEmpty string entered. Please enter a valid non-empty string:\n"));
    }
    @Test
    public void testMainCheckAnagram_InputStringsDifferentLengths()  {
        testInput = "2\ninches\nchin\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The two strings are not anagrams"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainCheckAnagram_InputStringsSameLengthNotAnagrams()  {
        testInput = "2\ninch\nchip\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The two strings are not anagrams"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainCheckPalindrome_InputIsPalindrome()  {
        testInput = "4\nracecar\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("String is a palindrome"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }

    @Test
    public void testMainCheckPalindrome_InputIsNotPalindrome()  {
        testInput = "4\nroadcar\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("String is not a palindrome"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainFindMaxChar_ValidInitialInput()  {
        testInput = "1\nmillennium\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The first Maximum Occurring Character = m"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainReverseString_ValidFirstInput()  {
        testInput = "3\nbicycle\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Reversed string is: elcycib"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainFindMaxOccurringChar_EmptyInitialInput(){
        testInput = "1\n\nmillennium\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Enter text to check and hit enter\nEmpty string entered. Please enter a valid non-empty string:\n"));
        assertTrue(outputStreamCaptor.toString().contains("The first Maximum Occurring Character = m"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith("Exiting game."));
    }
    @Test
    public void testMain_UnavailableMenuOptionSelected()  {
        testInput = "6\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Option not available, please try again!"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMain_ExitOptionSelected()  {
        testInput = "5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
}
