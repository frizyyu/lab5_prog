package helpers;

import supportive.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class FindMax {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public MusicBand getMax(MusicBand el1, MusicBand el2) throws IOException {
        LinkedHashSet<MusicBand> forCheckMax = new LinkedHashSet<>();
        forCheckMax.add(el1);
        forCheckMax.add(el2);

        SortCollection sorterForCheck = new SortCollection(forCheckMax);
        sorterForCheck.sort(null);
        List<MusicBand> checkMaxList = new ArrayList<>(forCheckMax);
        return checkMaxList.get(forCheckMax.size() - 1);
    }
}
