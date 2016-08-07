package myshell;

import java.util.Scanner;
import static myshell.MyShell.*;

public class Main {
    public static void main(String[] args) {
        final String MY_SHELL = "[MyShell] ";
        String customPrompt = "$";
        Scanner in = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print(MY_SHELL + customPrompt + ">");
            command = in.nextLine();
            if (command.equals("exit")) {
                System.out.println(MY_SHELL + "Closing...");
                break;
            } else {
                String comm[] = command.split("\\s");
                if (comm[0].equals("prompt")) {
                    if (comm.length == 2 && comm[1].equals("reset")) {
                        customPrompt = "$";
                    } else if (comm.length == 2 && comm[1].equals("$cwd")) {
                        System.out.println(printCurrentWorkingDirectory());
                    } else {
                        customPrompt = command.substring(7);
                    }
                } else if(comm[0].equals("cd")) {
                    String path = command.substring(3);
                    changeWorkingDirectory(path);
                } else if(command.equals("dir")) {
                    System.out.println(printDirectoryContents());
                } else if (command.equals("tree")) {
                    System.out.println(displayTree());
                } else {
                    System.out.println(command + " : " + "unknown command");
                }
            }
        }
    }
}
