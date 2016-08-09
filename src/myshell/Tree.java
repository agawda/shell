package myshell;

import java.io.File;

public class Tree implements Command {

    @Override
    public String initialize(String path) {
        Tools tools = new Tools();
        File directory = new File(path);
        int initialIndent = 0;
        StringBuilder stringBuilder = new StringBuilder();

        tree(directory, initialIndent, stringBuilder, tools);
        return stringBuilder.toString();
    }

    private void tree(File directory, int indent, StringBuilder stringBuilder, Tools tools) {
        stringBuilder.append(tools.printIndent(indent));
        stringBuilder.append(directory.getName());
        stringBuilder.append("\n");
        for (File file: directory.listFiles()) {
            if (file.isDirectory()) {
                tree(file, indent + 1, stringBuilder, tools);
            }
        }
    }
}
