package commands;

import commandHelpers.CommandInitializator;
import supportive.MusicBand;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExecuteScript implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public String readedFile = "";
    private final LinkedHashSet<MusicBand> collection;
    private final String fileName;
    public List<String> needToParse = new ArrayList<>();
    public ExecuteScript(LinkedHashSet collection, String fileName){
        this.collection = collection;
        this.fileName = fileName;
        this.needToParse.add("add");
        this.needToParse.add("update");
        this.needToParse.add("remove_greater");
        this.needToParse.add("remove_lower");
        this.needToParse.add("add_if_max");
    }
    @Override
    public void execute(String args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(args).getAbsolutePath());
        CommandInitializator.scripts.add(String.format("execute_script %s", args));

        BufferedInputStream buffInputStr
                = new BufferedInputStream(
                inputStream);

        while (buffInputStr.available() > 0) {


            char c = (char) buffInputStr.read();

            this.readedFile += c;
        }
        if (Objects.equals(this.readedFile, ""))
            System.out.println("Script file is empty");
        else {
        System.out.printf("Executing file \"%s\"\n", args);
        String[] script = this.readedFile.replace("\n", "|").split("\\|");
        CommandInitializator exec = new CommandInitializator(collection, fileName);
        String scripti;
        for(int i=0; i <= script.length - 1; i++){
            if (!(CommandInitializator.scripts.contains(script[i]) || CommandInitializator.scripts.isEmpty() || (CommandInitializator.scripts.contains(script[i]) && CommandInitializator.scripts.contains(String.format("execute_script %s", args))))) {
                if (!Objects.equals(script[i], "skip") && !exec.validateAndExecute(script[i], true)) {
                    break;
                }
                try {
                    if (needToParse.contains(script[i].replaceFirst(" ", "|").split("\\|")[0])) {
                        scripti = script[i];
                        if (!(scripti.contains("{") && scripti.contains("}"))){
                            scripti = String.format("%s {\"name\":\"%s\",\"coordinates\":{\"x\":%s,\"y\":%s},\"numberOfParticipants\":%s,\"albumsCount\":%s,\"genre\":\"%s\",\"studio\":{\"name\":\"%s\",\"address\":\"%s\"}}", script[i].strip(), script[i + 1].strip(), script[i + 2].strip(), script[i + 3].strip(), script[i + 4].strip(), script[i + 5].strip(), script[i + 6].strip().toUpperCase(), script[i + 7].strip(), script[i + 8].strip());
                            for (int j = 1; j <= 8; j++){
                                script[i + j] = "skip";
                            }
                        }
                        if (!exec.validateAndExecute(scripti, true))
                            break;
                    }
                    else
                        scripti = script[i];
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Not enough elements");
                    break;
                }
                if (!Objects.equals(scripti, "skip")) {
                    if (i == 0)
                        System.out.println("-------------------\n");
                    System.out.printf("Execute command: %s\n\n", script[i]);
                    exec.validateAndExecute(scripti, false);
                    System.out.println("-------------------\n");
                }
            }
            else{
                System.out.println("Error in script file. Recursion found");
                break;
            }
        }
        System.out.printf("File \"%s\" has been executed\n", args); //CommandInitializator.scripts.removeAll(new ArrayList<>(CommandInitializator.scripts));
        this.readedFile = "";
        CommandInitializator.scripts.removeAll(new ArrayList<>(CommandInitializator.scripts));
        }

    }

    @Override
    public void description() {
        System.out.println("Executes commands from input file\nusage: execute_script file_name");
    }
}
