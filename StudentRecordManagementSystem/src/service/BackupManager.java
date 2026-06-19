package service;

import java.io.*;

public class BackupManager {

    public static void createBackup() {

        try {

            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream(
                                    "data/students.obj"));

            BufferedOutputStream bos =
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    "backup/students_backup.obj"));

            int data;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            bis.close();
            bos.close();

            System.out.println(
                    "Backup created successfully.");

        } catch (Exception e) {

            System.out.println(
                    "Backup failed: "
                            + e.getMessage());
        }
    }
}