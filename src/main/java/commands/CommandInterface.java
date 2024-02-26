package commands;

import java.io.IOException;

/**
 * Interface for create commands
 *
 * @author frizyy
 */
public interface CommandInterface {
    /**
     * Execute method
     * @param args string with arguments
     * @throws IOException if happened some strange
     */
    void execute(String args) throws IOException;

    /**
     *
     * Description of command
     */
    void description();
}
