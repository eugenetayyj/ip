package duke.command;

import duke.main.Ui;
import duke.main.TaskList;
import duke.main.Storage;
import duke.task.Task;

public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(String index) {
        this.index = Integer.parseInt(index);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task task = taskList.getTask(index - 1);
        taskList.deleteTasks(index - 1);
        storage.saveTasks(taskList);
        ui.repeater(task + " deleted!");
    }
}
