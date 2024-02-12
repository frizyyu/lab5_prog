import commandHelpers.CommandInitializator;
import commands.Update;
import jsonHelper.ReadFromJson;
import jsonHelper.WriteToJson;
import supportive.MusicBand;
//C:/Users/artyo/Documents/res.json
import java.io.IOException;
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
        System.out.println("Enter file name:"); //create file, if not exist
        System.out.print(">>> ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        ReadFromJson reader = new ReadFromJson();
        LinkedHashSet<MusicBand> collection = reader.read(fileName);


        CommandInitializator commandsInitializator = new CommandInitializator(collection, fileName);
        while (true){
            System.out.print(">>> ");
            commandsInitializator.validateAndExecute(input.nextLine(), false);
        }
    }
}