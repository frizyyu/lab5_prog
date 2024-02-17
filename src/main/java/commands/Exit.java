package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import helpers.ContinueAction;
import helpers.ZonedDateTimeTypeAdapter;
import jsonHelper.ReadFromJson;
import supportive.MusicBand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Exit implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */

    private final LinkedHashSet<MusicBand> collection;
    public Exit(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        ContinueAction cont = new ContinueAction();
        ReadFromJson reader = new ReadFromJson();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create();
        String json1 = gson.toJson(collection);
        String json2 = gson.toJson(reader.read(ReadFromJson.fileName.replace(".json", "")));
        if (!Objects.equals(json1, json2)){
            System.out.println("Collection unsaved. Save and exit? y/n");
            System.out.print(">>> ");
            int c = cont.continueAction("Saved. Exiting", "Not saved. Exit cancelled", "Action skipped. Invalid answer");
            if (c == 1) {
                Save saver = new Save(collection, ReadFromJson.fileName.replace(".json", ""));
                saver.execute(null);
                try {
                    Files.delete(Path.of(new File("tmp.json").getAbsolutePath()));
                } catch (Exception ignored) {
                }
                System.exit(0);
            }
        }
        else {
            System.out.println("Are you sure to exit? y/n");
            System.out.print(">>> ");
            int c = cont.continueAction("Exiting", "Exit cancelled", "Action skipped. Invalid answer");
            if (c == 1) {
                try {
                    Files.delete(Path.of(new File("tmp.json").getAbsolutePath()));
                } catch (Exception ignored) {
                }
                System.exit(0);
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Exit program\nusage: exit");
    }
}
