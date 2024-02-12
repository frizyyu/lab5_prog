package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.MusicBand;
import helpers.ZonedDateTimeTypeAdapter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Show implements CommandInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public Show(LinkedHashSet collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String args) throws IOException {
        //collection.forEach(System.out::println);
        if (collection.isEmpty())
            System.out.println("Collection is empty");
        else {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                    .create();
            List<MusicBand> mb = new ArrayList<>(collection);
            for (int i = 0; i <= collection.size() - 1; i++){
                System.out.println(gson.toJson(mb.get(i)));
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Shows all the elements of the collection in a string representation\nusage: show");
    }
}
