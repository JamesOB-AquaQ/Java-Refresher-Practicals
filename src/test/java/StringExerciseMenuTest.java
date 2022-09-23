import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringExerciseMenuTest {
//    @Mock
//    private StringEvaluation stringEvaluation;
    private StringExerciseMenu stringExerciseMenu;
    private String testInput = null;
    private ByteArrayOutputStream outputStreamCaptor;
    private InputStream in;

    @BeforeEach
    protected void setUp(){
        //stringEvaluation = new StringEvaluation();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    protected void tearDown(){
        //stringEvaluation = null;
        outputStreamCaptor = null;
        System.setOut(new PrintStream(System.out));
        System.setIn(System.in);
    }

    @Test
    public void testCheckAnagramOption_ShouldPrintIsAnagram()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.checkAnagram(any(Scanner.class))).thenReturn(true);
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);


        testInput = "2\ninch\nchign\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("The two strings are anagrams".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }
    @Test
    public void testCheckAnagramOption_ShouldPrintIsNotAnagram()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.checkAnagram(any(Scanner.class))).thenReturn(false);
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);


        testInput = "2\ninch\nchign\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("The two strings are not anagrams".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }


    @Test
    public void testCheckPalindromeOption_ShouldPrintIsPalindrome()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.checkPalindrome(any(Scanner.class))).thenReturn(true);
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);

        testInput = "4\nracecar\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("String is a palindrome".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }
    @Test
    public void testCheckPalindromeOption_ShouldPrintIsNotPalindrome()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.checkPalindrome(any(Scanner.class))).thenReturn(false);
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);

        testInput = "4\nracecar\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("String is not a palindrome".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }


    @Test
    public void testFindMaxCharOption_ShouldPrintMaxCharOutput()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.findMaxChar(any(Scanner.class))).thenReturn('m');
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);
        testInput = "1\nmillennium\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("The first Maximum Occurring Character = m".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }
    @Test
    public void testReverseStringOption_ShouldPrintReverseStringOutput()  {
        StringEvaluation mockStringEvaluation = mock(StringEvaluation.class);
        when(mockStringEvaluation.reverseString(any(Scanner.class))).thenReturn("elcycib");
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(mockStringEvaluation);
        testInput = "3\nbicycle\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));


        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("Reversed string is: elcycib".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }

    @Test
    public void testUnavailableMenuOptionSelected_ShouldPrintNotAvailableOutput()  {
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(new StringEvaluation());
        testInput = "6\n5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").contains("Option not available, please try again!".replaceAll("\\s+","")));
        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }
    @Test
    public void testExitOption_ShouldPrintExitOutput()  {
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(new StringEvaluation());
        testInput = "5";
        in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        stringExerciseMenu.handleUserInput(new Scanner((System.in)));

        assertTrue(outputStreamCaptor.toString().replaceAll("\\s+","").endsWith("Exiting game.".replaceAll("\\s+","")));
    }
}
