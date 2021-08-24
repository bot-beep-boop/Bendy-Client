package clientname;

import java.io.*;

public class ModToggle
{
    public static File getFolder(final String mod) {
        final File file = new File(FileManager.MODS_DIR, mod);
        file.mkdirs();
        return file;
    }
    
    public static void saveIsEnabledToFile(final String mod, final Boolean b) {
        FileManager.writeJsonToFile(new File(getFolder(mod), "Enabled.json"), b);
    }
    
    public static Boolean loadEnabledFromFile(final String mod) {
        Boolean b = FileManager.readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
        if (b == null) {
            b = false;
            saveIsEnabledToFile(mod, b);
        }
        return b;
    }
}
