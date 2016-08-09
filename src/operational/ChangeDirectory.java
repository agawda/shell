package operational;

import tools.Tools;

import java.io.File;

public class ChangeDirectory implements CommandOperational{

    @Override
    public void execute(String path) {
        Tools tools = new Tools();
        if (path.equals("..")) {
            String dir = tools.getWorkingPath();
            File directory = new File(dir);
            tools.setWorkingPath(directory.getParent());
            return;
        }

        StringBuilder dir = new StringBuilder(tools.getWorkingPath());
        if (!dir.toString().endsWith("\\")) {
            dir.append(File.separator);
        }
        dir.append(path);
        File directory = new File(dir.toString());
        if (directory.isDirectory()) {
            tools.setWorkingPath(dir.toString());
        } else {
            System.out.println("Wrong directory name");
        }
    }
}
