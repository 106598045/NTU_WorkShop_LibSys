
import controller.CommandHandler;
import controller.InputHandler;

import java.util.Queue;

/**
 * Created by gunch on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {
        String path = "";
        path = ""+ InputHandler.class.getClassLoader().getResource("");
        path = path.substring(6)+"sampleInput";
        InputHandler inputHandler = new InputHandler(path);
        Queue<String> commandList = inputHandler.getCommandByFile();
        CommandHandler commandHandler = new CommandHandler(commandList);
        commandHandler.runBehaviorByCommand();
    }
}
