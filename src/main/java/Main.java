import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import commandHelpers.CommandInitializator;
import commands.Update;
import helpers.ContinueAction;
import helpers.ZonedDateTimeTypeAdapter;
import jsonHelper.ReadFromJson;
import jsonHelper.WriteToJson;
import supportive.MusicBand;
//C:/Users/artyo/Documents/res.json
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public String fileName;
    public static void main(String[] args) throws IOException {
        File tmpFile = new File(new File("tmp.json").getAbsolutePath());
        List<String> needToParse = new ArrayList<>();
        needToParse.add("add");
        needToParse.add("update");
        needToParse.add("remove_greater");
        needToParse.add("remove_lower");
        needToParse.add("add_if_max");
        needToParse.add("remove_by_id");
        needToParse.add("clear");
        String fileName;
        LinkedHashSet<MusicBand> res;
        Scanner input = new Scanner(System.in);
        LinkedHashSet<MusicBand> collection;
        if (tmpFile.exists()) {
            System.out.println("Incorrect termination of the program was detected. Restore the data? y/n");
            ContinueAction cont = new ContinueAction();
            System.out.print(">>> ");
            int c = cont.continueAction("Data has been loaded\n", "Data has not been loaded\n", "Action skipped. Invalid answer\n");
            if (c == 1) {
                fileName = "tmp";
                ReadFromJson readertmp = new ReadFromJson();
                collection = readertmp.read(fileName);
                //Files.delete(Path.of(new File("tmp.json").getAbsolutePath()));
                ReadFromJson.fileName = null;
            } else {
                while (true) {
                    System.out.println("Enter file name:"); //create file, if not exist
                    System.out.print(">>> ");
                    fileName = input.nextLine();
                    if (Objects.equals(fileName, "tmp")) {
                        System.out.println("Sorry, this name cannot be assigned");
                    } else
                        break;
                }
                ReadFromJson reader = new ReadFromJson();
                res = reader.read(fileName);
                collection = res;
                System.out.println("File loaded\n");
            }
        } else {
            while (true) {
                System.out.println("Enter file name:"); //create file, if not exist
                System.out.print(">>> ");
                fileName = input.nextLine();
                if (Objects.equals(fileName, "tmp")) {
                    System.out.println("Sorry, this name cannot be assigned");
                } else
                    break;
            }
            ReadFromJson reader = new ReadFromJson();
            res = reader.read(fileName);
            collection = res;
            System.out.println("File loaded\n");
        }

        ///if (reader.read("tmp") != collection){
        // System.out.println("ASDASDSADSADASDASDSD");
        //}
        CommandInitializator commandsInitializator = new CommandInitializator(collection, fileName);
        WriteToJson savertmp = new WriteToJson(collection, "tmp.json");
        String currCommand;
        boolean needSaveTmp = false;
        while (true) {
            System.out.print(">>> ");
            currCommand = input.nextLine();
            commandsInitializator.validateAndExecute(currCommand, false);
            if (needToParse.contains(currCommand.split(" ")[0].strip().toLowerCase())) {
                needSaveTmp = true;
            }
            if (needSaveTmp){
                savertmp.write();
                needSaveTmp = false;
            }
        }
    }
}