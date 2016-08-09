package operational;

import tools.Tools;

public class Prompt {

    private String customPrompt;

    public Prompt() {
        customPrompt = "$";
    }

    public void executeCommand(String command) {
        if (command.equals("$cwd")) {
            cwd();
            return;
        }

        if (command.equals("reset")) {
            customPrompt = "$";
            return;
        }

        customPrompt = command;
    }

    public void printPrompt() {
        String prompt = ("[MyShell] " + customPrompt + ">");
        System.out.print(prompt);
    }


    private void cwd() {
        Tools tools = new Tools();
        System.out.println(tools.getWorkingPath());
    }


}
