package jsonHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.MusicBand;
import helpers.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class WriteToJson {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    LinkedHashSet<MusicBand> collection;
    String fileName;
    public WriteToJson(LinkedHashSet<MusicBand> collection, String fileName){
        this.fileName = fileName;
        this.collection = collection;
    }
    public void write() throws IOException {
        SortCollection sorter = new SortCollection(collection);
        sorter.sort(null);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                .create();
        String json = gson.toJson(collection);
        json = json.replace("[", "{1: ").replace("]", "}");
        List<Integer> indexes = new ArrayList<>();
        for (int i=2; i <= json.length()-7; i++){
            if (("}},{\"id\"").equals(json.substring(i - 2, i+6))){
                indexes.add(i);
            }
        }
        int indexrange = 0;
        int id = 2;
        for (int i=0; i <= indexes.size()-1; i++){
            json = json.substring(0, indexes.get(i)+indexrange) + String.format(", %s: ", id) + json.substring(indexes.get(i)+1+indexrange);
            indexrange += 4;
            id += 1;
        }
        String file = ReadFromJson.fileName;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(json.getBytes());
        System.out.println(String.format("Collection saved in \"%s\"", file));
        fileOutputStream.close();
    }
}
