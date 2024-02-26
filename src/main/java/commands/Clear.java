package commands;

import helpers.ContinueAction;
import supportive.MusicBand;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * This class for clear collection
 *
 * @author frizyy
 */
public class Clear implements CommandInterface{
    private final LinkedHashSet<MusicBand> collection;

    /**
     *
     * @param collection our collection
     */
    public Clear(LinkedHashSet collection){
        this.collection = collection;
    }

    /**
     * Execute method
     * @param args null, because command hasn`t got arguments
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        System.out.println("Are you sure about deleting the collection? y/n");
        System.out.print(">>> ");
        ContinueAction cont = new ContinueAction();
        int c = cont.continueAction("Collection has been cleared", "The collection has not been cleared", "Action skipped. Invalid answer");
        if (c == 1)
            collection.clear();
    }
    /**
     *
     * Method for print description of command
     */
    @Override
    public void description() {
        System.out.println("Clear the collection\nusage: clear");
    }
}
