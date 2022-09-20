import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        StringExerciseMenu stringExerciseMenu = new StringExerciseMenu(new StringEvaluation());
        stringExerciseMenu.handleUserInput(new Scanner(System.in));
    }

}
