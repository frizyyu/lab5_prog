package commands;

import supportive.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AverageOfAlbumsCount implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    private final LinkedHashSet<MusicBand> collection;
    public AverageOfAlbumsCount(LinkedHashSet collection){
        this.collection = collection;
    }
    @Override
    public void execute(String args) throws IOException {
        List<MusicBand> mb = new ArrayList<>(collection);
        int c=0;
        int counter = 0;
        for (int i=0; i <= collection.size() - 1; i++){
            c += mb.get(i).getAlbumsCount();
            counter += 1;
        }
        System.out.printf("Average of albumsCount: %s\n", c/counter);
    }

    @Override
    public void description() {
        System.out.println("Prints average of albumsCount\nusage: average_of_albums_count");
    }
}
