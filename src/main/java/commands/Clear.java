package commands;

import helpers.ContinueAction;
import supportive.MusicBand;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Clear implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public Clear(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        System.out.println("Are you sure about deleting the collection? y/n");
        System.out.print(">>> ");
        ContinueAction cont = new ContinueAction();
        int c = cont.continueAction("Collection has been cleared", "The collection has not been cleared", "Action skipped. Invalid answer");
        if (c == 1)
            collection.clear();
    }

    @Override
    public void description() {
        System.out.println("Clear the collection\nusage: clear");
    }
}
