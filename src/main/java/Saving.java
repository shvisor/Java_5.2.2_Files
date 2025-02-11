import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Saving {

    public void saveGame(String path, GameProgress progress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String zip, List<String> path) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip))) {
            for (String name : path) {
                try (FileInputStream fis = new FileInputStream(name)) {
                    ZipEntry entry = new ZipEntry(name);
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
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
