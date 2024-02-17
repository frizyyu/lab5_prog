package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.checkerframework.checker.units.qual.C;
import supportive.Coordinates;
import supportive.MusicBand;
import supportive.MusicGenre;
import supportive.Studio;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class ClassObjectCreator {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public ClassObjectCreator(LinkedHashSet collection){
        this.collection = collection;
    }
    public MusicBand create(String args) throws IOException {
        MusicBand myMap;
        if (args != null) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                    .create();
            myMap = gson.fromJson(args, MusicBand.class);
        }
        else {
                myMap = new MusicBand();
                UserFriendlyCreateObject creator = new UserFriendlyCreateObject();
                myMap = creator.create(myMap);
        }
        try {
            myMap.setGenre(MusicGenre.valueOf(args.split("\"genre\":")[1].replace(" ", "").replaceFirst("\"", "").split("\",")[0].toUpperCase()));
        }catch (Exception ignored){
        }
        SortCollection sorter = new SortCollection(collection);
        sorter.sortById(null);
        List<MusicBand> mb = new ArrayList<>(collection);
        if (mb.size() == 0)
            myMap.setId(1);
        else {
            if (myMap.getId() == 0)
                myMap.setId(mb.get(mb.size() - 1).getId() + 1);
        }
        if (myMap.getCreationDate() == null)
            myMap.setCreationDate(ZonedDateTime.now());
        //sorter.sort(null);
        return myMap;
    }
}
