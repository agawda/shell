package printable;

import tools.Tools;

import java.io.File;

public class Dir implements CommandPrintable {

    @Override
    public String initialize() {
        Tools tools = new Tools();
        String dir = tools.getWorkingPath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ");
        stringBuilder.append(dir);
        File directory = new File(dir);

        execute(directory, stringBuilder);
        return stringBuilder.toString();
    }

    private void execute(File directory, StringBuilder stringBuilder) {
        for (File file : directory.listFiles()) {
            stringBuilder.append("\n");
            if (file.isDirectory()) {
                stringBuilder.append("DIR     ");
            } else {
                stringBuilder.append("FILE    ");
            }
            stringBuilder.append(file.getName());
        }
    }
}
