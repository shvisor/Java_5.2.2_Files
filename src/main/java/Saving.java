import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Saving {

    public void saveGame(String PATH, GameProgress progress) {
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String ZIP, List<String> PATH) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP))) {
            for (String name : PATH) {
                try (FileInputStream fis = new FileInputStream(name)) {
                    ZipEntry entry = new ZipEntry(name);
                    zos.putNextEntry(entry);
                    zos.write(fis.read());
                    zos.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
