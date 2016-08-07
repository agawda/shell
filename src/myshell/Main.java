package myshell;

import java.util.Scanner;

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

                    } else if (comm.length == 2 && comm[1].equals("$cwd")) {

                    } else {

                    }
                } else if(command.equals("dir")) {

                } else if (command.equals("tree")) {

                } else if(command.equals("cd")) {

                } else {
                    System.out.println(command + " : " + "unknown command");
                }
            }
        }
    }
}
