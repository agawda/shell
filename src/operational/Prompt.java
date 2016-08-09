package operational;

import tools.Tools;

public class Prompt implements CommandOperational {

    @Override
    public void execute(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MyShell] ");
        if (command.equals("$cwd")) {
            Tools tools = new Tools();
            stringBuilder.append("$>");
            stringBuilder.append(tools.getWorkingPath());
            System.out.print(stringBuilder.toString());
            return;
        }

        if (command.equals("reset")) {
            stringBuilder.append("$>");
            System.out.print(stringBuilder.toString());
            return;
        }

        stringBuilder.append(command);
        stringBuilder.append(">");
        System.out.print(stringBuilder.toString());
    }

    public void printDefault() {
        System.out.print("[MyShell] ");
    }


}
