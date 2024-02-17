package helpers;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ContinueAction {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public int continueAction(String done, String notDone, String passed){
        Scanner input = new Scanner(System.in);
        String YorN = input.nextLine();
        if (YorN.equals("y")){
            if (done != null)
                System.out.println(done);
            return 1;
        } else if (YorN.equals("n")){
            if (notDone != null)
                System.out.println(notDone);
            return -1;
        }
        else{
            if (passed != null)
                System.out.println(passed);
            return 0;
            }
    }
}
