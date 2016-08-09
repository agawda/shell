package printable;

import tools.Tools;
import java.io.File;

public class Tree implements CommandPrintable {

    @Override
    public String initialize() {
        Tools tools = new Tools();
        String path = tools.getWorkingPath();
        File directory = new File(path);
        int initialIndent = 0;
        StringBuilder stringBuilder = new StringBuilder();

        tree(directory, initialIndent, stringBuilder, tools);
        return stringBuilder.toString();
    }

    private void tree(File directory, int indent, StringBuilder stringBuilder, Tools tools) {
        stringBuilder.append(printIndent(indent));
        stringBuilder.append(directory.getName());
        stringBuilder.append("\n");
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                tree(file, indent + 1, stringBuilder, tools);
            }
        }
    }

    private String printIndent(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        while (indent-- > 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

}
