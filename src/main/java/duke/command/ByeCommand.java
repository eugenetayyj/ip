package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;


/**
 * Represents a command that is used to print out a bye message.
 */
public class ByeCommand extends Command {

    /**
     * Execute method that is used to print out a bye message through ui.
     *
     * @param taskList
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList taskList, TaskList archiveTaskList, Storage storage,
                          Storage archiveStorage, Ui ui) {
        return ui.bye();
    }
}
