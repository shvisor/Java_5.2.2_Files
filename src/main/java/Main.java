import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String PATH = "C:/Users/HP/Documents/Netology/JavaDeveloper/Games/savegames";
    public static final String ZIP = "C:/Users/HP/Documents/Netology/JavaDeveloper/Games/savegames/zip.zip";

    public static void main(String[] args) {
        Saving saving = new Saving();

        GameProgress progress_1 = new GameProgress(150, 423, 15, 623);
        GameProgress progress_2 = new GameProgress(95, 358, 21, 854);
        GameProgress progress_3 = new GameProgress(128, 530, 22, 739);

        List<String> saveFiles = new ArrayList<>();
        saveFiles.add(PATH + "/save1.dat");
        saveFiles.add(PATH + "/save2.dat");
        saveFiles.add(PATH + "/save3.dat");

        saving.saveGame(PATH + "/save1.dat", progress_1);
        saving.saveGame(PATH + "/save2.dat", progress_2);
        saving.saveGame(PATH + "/save3.dat", progress_3);
        saving.zipFiles(ZIP, saveFiles);

        for (String item : saveFiles) {
            new File(item).delete();
        }
    }
}
