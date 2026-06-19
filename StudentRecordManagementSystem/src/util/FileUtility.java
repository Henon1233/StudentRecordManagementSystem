package util;

import java.io.File;
import java.util.Date;

public class FileUtility {

    public static void initializeFiles() {

        try {

            File dataDir = new File("data");
            File backupDir = new File("backup");

            if (!dataDir.exists())
                dataDir.mkdir();

            if (!backupDir.exists())
                backupDir.mkdir();

            new File("data/students.txt").createNewFile();
            new File("data/students.dat").createNewFile();
            new File("data/students.obj").createNewFile();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayFileInfo(String path) {

        File file = new File(path);

        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Last Modified: "
                + new Date(file.lastModified()));
    }
}
