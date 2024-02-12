package helpers;

import supportive.MusicBand;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class FindElementWithId {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public MusicBand findById(LinkedHashSet collectionToCheck, String[] str){
        MusicBand checkForId = new MusicBand();
        List<MusicBand> mb = new ArrayList<>(collectionToCheck);
        for (int i=0; i <= collectionToCheck.size()-1; i++){
            if (mb.get(i).getId() == Integer.parseInt(str[0])){
                checkForId.setId(mb.get(i).getId());
                checkForId.setCreationDate(mb.get(i).getCreationDate());
                return mb.get(i);
            }
        }
        if (checkForId.getId() == 0){
            System.out.printf("Element with id %s not found\n", str[0]);
            return null;
        }
        return null;
    }
}
