package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import helpers.ZonedDateTimeTypeAdapter;
import supportive.MusicBand;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * This class for print elements from collection which filtered by albums count
 *
 * @author frizyy
 */
public class FilterByAlbumsCount implements CommandInterface{
    private final LinkedHashSet<MusicBand> collection;
    public FilterByAlbumsCount(LinkedHashSet collection){
        this.collection = collection;
    }

    /**
     * Execute command
     * @param args string with arguments
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        List<MusicBand> mb = new ArrayList<>(collection);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create();
        int c=0;
        for (int i=0; i <= collection.size() - 1; i++){
            if (mb.get(i).getAlbumsCount() == Integer.parseInt(args)){
                System.out.println(gson.toJson(mb.get(i)));
                c += 1;
            }
        }
        if (c == 0)
            System.out.println("No matches found");
    }

    /**
     *
     * Description of command
     */
    @Override
    public void description() {
        System.out.println("Prints elements from collection with same albumsCount as input\nusage: filter_by_albums_count");
    }
}
