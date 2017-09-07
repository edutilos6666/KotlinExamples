import java.io.Console;

/**
 * Created by edutilos on 07.09.17.
 */
public class UserInputConsole {
    public static void main(String[] args) {
        console1();
    }


    //only works from terminal
    private static void console1() {
        Console console = System.console();
        if(console == null) {
            System.out.println("console is null");
            System.exit(0);
        }
        System.out.println("console is working.");
    }
}
