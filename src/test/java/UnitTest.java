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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
//    @Test
//    public void testFindMaxOccurringChar2(){
//        testInput = "millennium\n";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        char result = stringEvaluation.findMaxChar(new Scanner((System.in)));
//
//        assertEquals('m',result);
//    }
//    @Test
//    public void testFindMaxOccurringChar_ShouldPrintEmptyStringMessageThenReturnMaxChar(){
//        testInput = "\nmillennium";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        char result = stringEvaluation.findMaxChar(new Scanner((System.in)));
//
//        assertEquals("Enter text to check and hit enter\nEmpty string entered. Please enter a valid non-empty string:\n",outputStreamCaptor.toString());
//        assertEquals('m',result);
//    }
//    @Test
//    public void testCheckPalindrome_ShouldReturnTrue(){
//        testInput = "Was it a car or a cat I saw? \n";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));
//
//        assertEquals(true,result);
//    }
//
//    @Test
//    public void testCheckPalindrome_ShouldReturnFalse(){
//        testInput = "Was it a cat or a car I saw? \n";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));
//
//        assertEquals(false,result);
//    }
//
//    @Test
//    public void testCheckPalindrome_ShouldReturnFalseFirstAndLastCharDifferent(){
//        testInput = "Testing\n";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));
//
//        assertEquals(false,result);
//    }
//
//    @Test
//    public void testReverseString_ShouldReturnReversedString(){
//        testInput = "little\n";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        String result = stringEvaluation.reverseString(new Scanner((System.in)));
//
//        assertEquals("elttil",result);
//    }
//    @Test
//    public void testCheckAnagram(){
//        testInput = "inch\nchin";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));
//
//        assertEquals(true,result);
//    }
//    @Test
//    public void testCheckAnagram_ShouldReturnFalseDueToLengthDifference(){
//        testInput = "inch\nchins";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));
//
//        assertEquals(false,result);
//    }
//    @Test
//    public void testCheckAnagram_ShouldReturnFalseDueToCharacterDifference(){
//        testInput = "itchy\nchins";
//        in = new ByteArrayInputStream(testInput.getBytes());
//        System.setIn(in);
//
//        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));
//
//        assertEquals(false,result);
//    }
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
    public void testMainCheckAnagram_InputStringsNotAnagramsSameLength()  {
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
    public void testMainCheckPalindrome_InputIsNotPalindromeFirstAndLastCharsDiffer()  {
        testInput = "4\nracecars\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("String is not a palindrome"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainCheckPalindrome_InputIsNotPalindromeFirstAndLAstCharSame()  {
        testInput = "4\nroadcar\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("String is not a palindrome"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainFindMaxChar()  {
        testInput = "1\nmillennium\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("The first Maximum Occurring Character = m"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainReverseString()  {
        testInput = "3\nbicycle\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Reversed string is: elcycib"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
    @Test
    public void testMainFindMaxOccurringChar_ShouldPrintEmptyStringMessageThenReturnMaxChar(){
        testInput = "1\n\nmillennium\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Enter text to check and hit enter\nEmpty string entered. Please enter a valid non-empty string:\n"));
        assertTrue(outputStreamCaptor.toString().contains("The first Maximum Occurring Character = m"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith("Exiting game."));
    }
    @Test
    public void testMain_UnavailableOptionSelected()  {
        testInput = "6\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Main.main(null);

        assertTrue(outputStreamCaptor.toString().contains("Option not available, please try again!"));
        assertTrue(outputStreamCaptor.toString().trim().endsWith(
                "Exiting game."));
    }
}
