package commands;

import helpers.ClassObjectCreator;
import helpers.ContinueAction;
import helpers.FindMax;
import supportive.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveLower implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public RemoveLower (LinkedHashSet collection){
        this.collection = collection;
    }

    @Override
    public void execute(String args) throws IOException {
        ClassObjectCreator creator = new ClassObjectCreator(collection);
        MusicBand myMap = creator.create(args);
        List<MusicBand> mb = new ArrayList<>(collection);
        List<Integer> indexes = new ArrayList<>();

        for (int i=0; i <= collection.size() - 1; i++){
            FindMax maxer = new FindMax();
            MusicBand maxElement = maxer.getMax(mb.get(i), myMap);
            if (maxElement != mb.get(i))
                indexes.add(i);
            else
                break;
        }
        if (indexes.size() == 0)
            System.out.println("Nothing removed. No elements that are lower than input");
        else {
            System.out.print("Start removing? y/n\n");
            System.out.print(">>> ");
            ContinueAction cont = new ContinueAction();
            int contAction = cont.continueAction(null, "Elements are not deleted", "Action skipped. Invalid answer");
            if (contAction == 1) {
                for (int i = 0; i <= indexes.size() - 1; i++) {
                    collection.remove(mb.get(i));
                    System.out.printf("Element with id %s has been removed\n", mb.get(i).getId());
                }
            }
        }
    }

    @Override
    public void description() {
        System.out.println("Remove elements that are lower than input\nusage remove_lower or remove_greater {element}");
    }
}
