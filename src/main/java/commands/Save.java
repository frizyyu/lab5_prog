package commands;

import jsonHelper.ReadFromJson;
import jsonHelper.WriteToJson;
import supportive.MusicBand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;

/**
 * This class for save collection in file
 *
 * @author frizyy
 */
public class Save implements CommandInterface {
    private final LinkedHashSet<MusicBand> collection;
    String fileName;
    public Save(LinkedHashSet collection, String fileName) {
        this.collection = collection;
        this.fileName = fileName;
    }
    /**
     * Execute command
     * @param args null, because command hasn`t got arguments
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        WriteToJson writer = new WriteToJson(collection, null);
        writer.write();
        Files.delete(Path.of(new File("tmp.json").getAbsolutePath()));
    }

    /**
     *
     * Description of command
     */
    @Override
    public void description() {
        System.out.println("Save collection to .json file\nusage: save");
    }
}
