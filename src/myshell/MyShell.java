package myshell;

import java.io.File;

class MyShell {
    static String printCurrentWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    static String printDirectoryContents() {
        String dir = System.getProperty("user.dir");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Contents of ");
        stringBuilder.append(dir);
        File directory = new File(dir);

        for (File file : directory.listFiles()) {
            stringBuilder.append("\n");
            if (file.isDirectory()) {
                stringBuilder.append("DIR     ");
            } else {
                stringBuilder.append("FILE    ");
            }
            stringBuilder.append(file.getName());
        }

        return stringBuilder.toString();
    }

    static void changeWorkingDirectory(String path) {
        String dir = System.getProperty("user.dir");
        if (path.equals("..")) {
            File directory = new File(dir);
            try {
                System.setProperty("user.dir", directory.getParent());
            } catch (NullPointerException e) {
                System.out.println("This directory doesn\'t have a parent");
            }
        } else {
            dir += File.separator + path;
            File directory = new File(dir);
            if (directory.isDirectory()) {
                System.setProperty("user.dir", dir);
            } else {
                System.out.println("Wrong directory name");
            }
        }
    }

    static String displayTree() {
        String path = System.getProperty("user.dir");
        File directory = new File(path);
        int initialIndent = 0;
        StringBuilder stringBuilder = new StringBuilder();

        tree(directory, initialIndent, stringBuilder);
        return stringBuilder.toString();
    }

    private static void tree(File directory, int indent, StringBuilder stringBuilder) {
        stringBuilder.append(printIndent(indent));
        stringBuilder.append(directory.getName());
        stringBuilder.append("\n");
        for (File file: directory.listFiles()) {
            if (file.isDirectory()) {
                tree(file, indent + 1, stringBuilder);
            }
        }
    }

    private static String printIndent(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        while (indent --> 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
