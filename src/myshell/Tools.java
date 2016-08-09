package myshell;

public class Tools {
    public String getWorkingPath() {
        return System.getProperty("user.dir");
    }

    public String printIndent(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        while (indent --> 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void setWorkingPath(String path) {
        try {
            System.setProperty("user.dir", path);
        } catch (NullPointerException e) {
            System.out.println("This directory doesn\'t have a parent");
        }
    }
}
