package michaelscott;

import java.util.Scanner;

public class Ui {
    Scanner sc;

    public Ui () {
        this.sc = new Scanner(System.in);
    }

    public void showWelcome() {
        println("Running michaelscott.MichaelScott.exe");
        printLine();
        println("Hello! I'm Michael Scott");
        println("What can I do for you?");
        printLine();
    }

    public void showGoodBye() {
        printLine();
        println("Catch you on the flippity flip!");
        printLine();
        this.sc.close();
    }

    public void showError(String message) {
        printLine();
        println(message);
        printLine();
    }

    public void showLoadingError() {
        System.out.println("Error loading data. Starting with an empty task list.");
    }

    public void showResponse(String message) {
        printLine();
        println(message);
        printLine();
    }

    public String readCommand() {
        return this.sc.nextLine();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void println(String sentence) {
        System.out.println(sentence);
    }
}
