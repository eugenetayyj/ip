import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.ErrorCommand;
import duke.main.Parser;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Duke {
    Scanner scanner = new Scanner(System.in);

    public Duke(String filePath) {
        Ui ui = new Ui(scanner);
        ui.greet();
        Storage storage = new Storage(filePath);
        Parser parser = new Parser();
        TaskList taskList = new TaskList(storage.loadTasks());
        ui.list(taskList);

        while (true) {
            try {
                String inputCommand = ui.readInput();
                if (inputCommand.equals("bye")) {
                    new ByeCommand().execute(taskList,ui, storage);
                    break;
                }
                Command command = parser.parse(inputCommand);
                command.execute(taskList, ui, storage);
            } catch (InputMismatchException | IndexOutOfBoundsException |
                    NumberFormatException | NullPointerException e) {
                    new ErrorCommand().execute(taskList, ui, storage);
            }
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke("./data/Duke.txt");
    }
}
