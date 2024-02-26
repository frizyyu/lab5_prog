package commands;

import supportive.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Class for print info about collection
 *
 * @author frizyy
 */
public class Info implements CommandInterface{
    private final LinkedHashSet<MusicBand> collection;
    public Info(LinkedHashSet collection) {
        this.collection = collection;
    }
    /**
     * Execute command
     * @param args null, because command hasn`t got arguments
     * @throws IOException if happened some strange
     */
    @Override
    public void execute(String args) throws IOException {
        try {
            List<MusicBand> mb = new ArrayList<>(collection);
            System.out.printf("""
                About collection:
                Type: %s
                Type of elements inside: %s
                Size: %s items
                Initialization date: %s
                """, collection.getClass().getName(), mb.get(0).getClass().getName(),collection.size(), mb.get(0).getCreationDate());
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("""
                About collection:
                Type: null
                Type of elements inside: null
                Size: 0 items
                Initialization date: null""");
        }
    }

    /**
     *
     * Description of command
     */
    @Override
    public void description() {
        System.out.println("Shows information about collection\nusage: info");
    }
}
