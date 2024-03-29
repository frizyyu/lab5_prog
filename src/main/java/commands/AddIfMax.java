package commands;

import helpers.ClassObjectCreator;
import helpers.FindMax;
import helpers.SortCollection;
import supportive.Coordinates;
import supportive.MusicBand;
import supportive.Studio;

import java.io.IOException;
import java.util.*;

/**
 * This class for add element if his value more then value of another element
 *
 * @author frizyy
 */
public class AddIfMax implements CommandInterface {

    private final LinkedHashSet<MusicBand> collection;

    /**
     *
     * @param collection our collection
     */
    public AddIfMax(LinkedHashSet collection){
        this.collection = collection;
    }

    /**
     * Execute method
     * @param args input string with element
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        SortCollection sorted = new SortCollection(collection);
        sorted.sort(null);
        List<MusicBand> mb = new ArrayList<>(collection);

        MusicBand maxMusicBandInstance = mb.get(collection.size() - 1);

        ClassObjectCreator creator = new ClassObjectCreator(collection);
        MusicBand myMap = creator.create(args);

        FindMax maxer = new FindMax();
        MusicBand maxElement = maxer.getMax(maxMusicBandInstance, myMap);

        if (maxElement == myMap){
            collection.add(myMap);
            SortCollection sorter = new SortCollection(collection);
            sorter.sort(null);
            System.out.println("Element has been added to collection");
        }
        else
            System.out.println("Element not added. His value is not more than value of maximum element of this collection");
    }
    /**
     *
     * Method for print description of command
     */
    @Override
    public void description() {
        System.out.println("Add element to collection, if his value is more than value of maximum element of this collection\nusage: add_if_max {element} or add_if_max");
    }
}
