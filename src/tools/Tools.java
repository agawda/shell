package tools;

public class Tools {
    public String getWorkingPath() {
        return System.getProperty("user.dir");
    }

    public void setWorkingPath(String path) {
        try {
            System.setProperty("user.dir", path);
        } catch (NullPointerException e) {
            System.out.println("This directory doesn\'t have a parent");
        }
    }
}
