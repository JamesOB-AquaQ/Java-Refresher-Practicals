import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class StringEvaluationTest {
    private StringEvaluation stringEvaluation;
    private String testInput = null;
    private InputStream in;
    private ByteArrayOutputStream outputStreamCaptor;
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
    public void testFindMaxOccurringChar_ValidFirstInput(){
        testInput = "millennium\n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        char result = stringEvaluation.findMaxChar(new Scanner((System.in)));

        assertEquals('m',result);
    }
    @Test
    public void testFindMaxOccurringChar_EmptyFirstInput(){
        testInput = "\nmillennium";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        char result = stringEvaluation.findMaxChar(new Scanner((System.in)));
        String expectedOutput = "Enter text to check and hit enter \nEmpty string entered. Please enter a valid non-empty string:\n";
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains(expectedOutput.replaceAll("\\s+","")));
        assertEquals('m',result);
    }

    @Test
    public void testCheckPalindrome_InputIsPalindrome(){
        testInput = "Was it a car or a cat I saw? \n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));

        assertEquals(true,result);
    }

    @Test
    public void testCheckPalindrome_InputIsNotPalindrome(){
        testInput = "Was it a cat or a car I saw? \n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));

        assertEquals(false,result);
    }
    @Test
    public void testCheckPalindrome_EmptyFirstSecondInputIsNotPalindrome(){
        testInput = "\nWas it a car or a cat I saw? \n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkPalindrome(new Scanner((System.in)));
        String expectedOutput = "Enter string to check and hit enter \nEmpty string entered. Please enter a valid non-empty string:\n";
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains(expectedOutput.replaceAll("\\s+","")));
        assertEquals(true,result);
    }


    @Test
    public void testReverseString_ValidFirstInput(){
        testInput = "little\n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        String result = stringEvaluation.reverseString(new Scanner((System.in)));

        assertEquals("elttil",result);
    }
    @Test
    public void testReverseString_EmptyFirstInput(){
        testInput = "\nlittle\n";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        String result = stringEvaluation.reverseString(new Scanner((System.in)));
        String expectedOutput = "Enter string to be reversed:  \nEmpty string entered. Please enter a valid non-empty string:\n";
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains(expectedOutput.replaceAll("\\s+","")));
        assertEquals("elttil",result);

    }
    @Test
    public void testCheckAnagram_InputsAreAnagrams(){
        testInput = "inch\nchin";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));

        assertEquals(true,result);
    }
    @Test
    public void testCheckAnagram_DifferentLengthInputs(){
        testInput = "inch\nchins";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));

        assertEquals(false,result);
    }
    @Test
    public void testCheckAnagram_SameLengthInputsNotAnagrams(){
        testInput = "itchy\nchins";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));

        assertEquals(false,result);
    }
    @Test
    public void testCheckAnagram_FirstInputEmptyStringsAreAnagrams()  {
        testInput = "\ninch\nchin";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));
        String expectedOutput = "Enter first string and hit enter: \nEmpty string entered. Please enter a valid non-empty string:\n";
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains(expectedOutput.replaceAll("\\s+","")));
        assertEquals(result,true);
    }
    @Test
    public void testCheckAnagram_SecondInputEmptyStringsAreAnagrams()  {

        testInput = "inch\n\nchin";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        boolean result = stringEvaluation.checkAnagram(new Scanner((System.in)));
        String expectedOutput = "Enter second string and hit enter: \nEmpty string entered. Please enter a valid non-empty string:\n";
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains(expectedOutput.replaceAll("\\s+","")));
        assertEquals(result,true);
    }
}
