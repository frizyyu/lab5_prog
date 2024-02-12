package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.MusicBand;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class ElementValidCheck {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public boolean elementValidCheck(String[] str){
        try {
            LinkedHashSet<MusicBand> res = new LinkedHashSet<MusicBand>();

            //str[1] = str[1].replaceFirst("\"", String.format("\"id\": %s, \"", 50));

            if (!Objects.equals(str[1], "{}")){
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter())
                        .create();
                MusicBand myMap = gson.fromJson(str[1], MusicBand.class);
                res.add(myMap);
                if (myMap.getName() == null || Objects.equals(myMap.getName(), "")){
                    System.out.println("Error in name field");
                    return false;}
                if (myMap.getCoordinates() == null || myMap.getCoordinates().getX() == null || myMap.getCoordinates().getX() >= 268 || myMap.getCoordinates().getY() >= 55){
                    System.out.println("Error in coordinates field");
                    return false;}
                if (myMap.getNumberOfParticipants() <= 0){
                    System.out.println("Error in number of participants field");
                    return false;}
                if (myMap.getAlbumsCount() == null || myMap.getAlbumsCount() <= 0){
                    System.out.println("Error in albums count field");
                    return false;}
                if (myMap.getGenre() == null){
                    System.out.println("Error in genre field");
                    return false;}
                if (myMap.getStudio() == null || myMap.getStudio().getName() == null || myMap.getStudio().getAddress() == null){
                    System.out.println("Error in studio field");
                    return false;}
            }
            else {
                System.out.println("Invalid argument");
                return false;
            }
            return true;
        } catch (Exception er) {
            System.out.println("Invalid argument");
            return false;
        }
    }
}
