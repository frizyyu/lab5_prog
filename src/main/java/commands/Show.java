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

/**
 * This class for show collection
 *
 * @author frizyy
 */
public class Show implements CommandInterface {
    private final LinkedHashSet<MusicBand> collection;
    public Show(LinkedHashSet collection) {
        this.collection = collection;
    }
    /**
     * Execute command
     * @param args null, because command hasn`t got arguments
     * @throws IOException if happened some strange
     */
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

    /**
     *
     * Description of command
     */
    @Override
    public void description() {
        System.out.println("Shows all the elements of the collection in a string representation\nusage: show");
    }
}
