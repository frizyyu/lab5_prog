package commands;

import jsonHelper.ReadFromJson;
import jsonHelper.WriteToJson;
import supportive.MusicBand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;

public class Save implements CommandInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    String fileName;
    public Save(LinkedHashSet collection, String fileName) {
        this.collection = collection;
        this.fileName = fileName;
    }

    @Override
    public void execute(String args) throws IOException {
        WriteToJson writer = new WriteToJson(collection, null);
        writer.write();
        Files.delete(Path.of(new File("tmp.json").getAbsolutePath()));
    }

    @Override
    public void description() {
        System.out.println("Save collection to .json file\nusage: save");
    }
}
