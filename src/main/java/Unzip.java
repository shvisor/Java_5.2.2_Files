import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

    public void openZip(String zip, String path) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fos.write(c);
                }
                fos.flush();
                zin.closeEntry();
                fos.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public GameProgress openProgress(String path) {
        GameProgress progress = null;
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            progress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return progress;
    }
}
