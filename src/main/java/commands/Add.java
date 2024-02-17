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

public class Add implements CommandInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;

    public Add(LinkedHashSet collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String args) throws IOException {
        ClassObjectCreator creator = new ClassObjectCreator(collection);
        MusicBand myMap = creator.create(args);
        collection.add(myMap);
        SortCollection sorter = new SortCollection(collection);
        sorter.sort(null);
        System.out.println("Element added to collection");
    }

    @Override
    public void description() {
        System.out.println("This command adds an item to the collection\nusage: add {element} or add");
    }
}
