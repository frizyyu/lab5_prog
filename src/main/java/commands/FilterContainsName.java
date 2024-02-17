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

public class FilterContainsName implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public FilterContainsName(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        List<MusicBand> mb = new ArrayList<>(collection);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create();
        int c=0;
        for (int i=0; i <= collection.size() - 1; i++){
            if (mb.get(i).getName().contains(args)){
                System.out.println(gson.toJson(mb.get(i)));
                c += 1;
            }
        }
        if (c == 0)
            System.out.println("No matches found");
    }

    @Override
    public void description() {
        System.out.println("Prints elements from collection with same name as input\nusage: filter_contains_name");
    }
}
