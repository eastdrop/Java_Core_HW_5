package Task_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Backup.checkexists(Backup.directory);
        Backup.makebackupDir(Backup.backupDirectory);
        Backup.makeBackUp();
    }

}
