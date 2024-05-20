package Task_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {
    public static final File directory = new File(".");
    public static final File backupDirectory = new File("backup");
    public static final File[] files = directory.listFiles();


    public File getDirectory() {
        return directory;
    }

    public static void checkexists(File file) {
        if(!file.exists()){
            System.out.println("Directory doesn't exists");
            return;
        }
    }
    public static void makebackupDir(File file){
        file.mkdir();
    }
    public static void makeBackUp(){
        for (File file: files) {
            if (file.getName().equals("Task_1/Backup.java") || file.getName().equals("Task_1/Main.java")) {
            }
            else{
            File backupFile = new File(backupDirectory.getPath(),file.getName());
            try (FileInputStream fis = new FileInputStream(file)) {
                try (FileOutputStream fos = new FileOutputStream(backupFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
