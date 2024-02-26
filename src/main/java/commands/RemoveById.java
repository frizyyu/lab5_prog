package commands;

import helpers.ContinueAction;
import helpers.FindElementWithId;
import supportive.MusicBand;
import helpers.SortCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * This class for remove element from collection by id
 *
 * @author frizyy
 */
public class RemoveById implements CommandInterface{
    private final LinkedHashSet<MusicBand> collection;
    public RemoveById(LinkedHashSet collection){
        this.collection = collection;
    }

    /**
     * Execute command
     * @param args string with arguments
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        args = args.replaceFirst(" ", "|");
        String [] argsList = args.split("\\|");
        ContinueAction cont = new ContinueAction();
        System.out.printf("Are you sure to delete element with id %s? y/n\n", argsList[0]);
        System.out.print(">>> ");
        int contAction = cont.continueAction(String.format("Element from id %s deleted", argsList[0]), "Element not deleted", "Action skipped. Invalid answer");
        if (contAction == 1){
            FindElementWithId finder = new FindElementWithId();
            collection.remove(finder.findById(collection, argsList));
            SortCollection sorter = new SortCollection(collection);
            sorter.sort(null);

        }

    }

    /**
     *
     * Description of command
     */
    @Override
    public void description() {
        System.out.println("Remove element by id\nusage: remove_by_id id");
    }
}
