package commands;

import helpers.ClassObjectCreator;
import helpers.ContinueAction;
import helpers.FindMax;
import supportive.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveGreater implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public RemoveGreater(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        ClassObjectCreator creator = new ClassObjectCreator(collection);
        MusicBand myMap = creator.create(args);
        List<MusicBand> mb = new ArrayList<>(collection);
        FindMax maxer = new FindMax();
        int ind=collection.size();
        for (int i=0; i <= collection.size() - 1; i++){
            MusicBand maxElement = maxer.getMax(mb.get(i), myMap);
            if (maxElement == mb.get(i) && ind == collection.size()) {
                ind = i+1;
                break;
            }

        }
        if (ind == collection.size())
            System.out.println("Nothing removed. No elements that are greater than input");
        else {
            System.out.print("Start removing? y/n\n");
            System.out.print(">>> ");
            ContinueAction cont = new ContinueAction();
            int contAction = cont.continueAction(null, "Elements are not deleted", "Action skipped. Invalid answer");
            if (contAction == 1) {
                for (int i = ind; i <= collection.size(); i++) {
                    collection.remove(mb.get(i));
                    System.out.printf("Element with id %s has been removed\n", mb.get(i).getId());
                }
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Remove elements that are greater than input\nusage remove_greater {element} or remove_greater");
    }
}
