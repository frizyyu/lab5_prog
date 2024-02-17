package commands;

import java.io.IOException;

public interface CommandInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    void execute(String args) throws IOException;
    void description();
}
