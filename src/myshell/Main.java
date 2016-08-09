package myshell;

import operational.ChangeDirectory;
import operational.Prompt;
import printable.CommandPrintable;
import printable.Dir;
import printable.Tree;

import java.util.Scanner;

public class Main {

    private static void processCommand(String command, Prompt prompt) {
        String comm[] = command.split("\\s");

        if (comm[0].equals("prompt")) {
            prompt.executeCommand(command.substring(7));
            return;
        }

        if (comm[0].equals("cd")) {
            ChangeDirectory cd = new ChangeDirectory();
            cd.execute(command.substring(3));
            return;
        }

        CommandPrintable cp = null;

        if (command.equals("dir")) {
            cp = new Dir();
        }

        if (command.equals("tree")) {
            cp = new Tree();
        }

        if (cp != null) {
            System.out.println(cp.initialize());
            return;
        }

        System.out.println("Unknown command: " + command);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command;
        Prompt prompt = new Prompt();

        while (true) {
            prompt.printPrompt();
            command = in.nextLine();

            if (command.equals("exit")) {
                System.out.println("Closing...");
                break;
            }

            processCommand(command, prompt);
        }

    }
}
