package core.utility;

public class Command {

    private Command() {
    }

    public static void runCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            Logging.fail("command exception.", e);
        }
    }
}
