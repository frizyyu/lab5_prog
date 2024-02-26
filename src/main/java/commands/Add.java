package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.*;
import helpers.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * This class for add element to collection
 *
 * @author frizyy
 */
public class Add implements CommandInterface {
    private final LinkedHashSet<MusicBand> collection;

    public Add(LinkedHashSet collection) {
        this.collection = collection;
    }

    /**
     * Execute method
     * @param args json-type string for create class instance
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        ClassObjectCreator creator = new ClassObjectCreator(collection);
        MusicBand myMap = creator.create(args);
        collection.add(myMap);
        SortCollection sorter = new SortCollection(collection);
        sorter.sort(null);
        System.out.println("Element added to collection");
    }

    /**
     *
     * Method for print description of command
     */
    @Override
    public void description() {
        System.out.println("This command adds an item to the collection\nusage: add {element} or add");
    }
}
