package commands;

import helpers.ContinueAction;

import java.io.IOException;

public class Exit implements CommandInterface{
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    @Override
    public void execute(String args) throws IOException {
        ContinueAction cont = new ContinueAction();
        System.out.println("Are you sure to exit? y/n");
        System.out.print(">>> ");
        int c = cont.continueAction("Exiting", "Exit cancelled", "Action skipped. Invalid answer");
        if (c == 1)
            System.exit(0);
    }

    @Override
    public void description() {
        System.out.println("Exit program\nusage: exit");
    }
}
