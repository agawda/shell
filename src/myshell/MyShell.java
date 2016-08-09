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




}
