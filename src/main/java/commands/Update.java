package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.MusicBand;
import helpers.*;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

public class Update implements CommandInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public Update(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        String[] argsList = args.split("\\|");
        MusicBand myMap;
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create();
        if (argsList.length != 1){
            myMap = gson.fromJson(argsList[1], MusicBand.class);
        }
        else{
            myMap = new MusicBand();
            UserFriendlyCreateObject creator = new UserFriendlyCreateObject();
            myMap = creator.create(myMap);
        }

        FindElementWithId finder = new FindElementWithId();
        MusicBand res = finder.findById(collection, argsList);
        collection.remove(res);
        myMap.setId(res.getId());
        myMap.setCreationDate(res.getCreationDate());
        collection.add(myMap);

        SortCollection sorter = new SortCollection(collection);
        sorter.sort(null);

        System.out.printf("Collection element at id %s has been updated\n", argsList[0]);}

    @Override
    public void description() {
        System.out.println("Update element by id\nusage: update id {element} or update id");
    }
}
