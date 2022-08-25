package duke.command;

import duke.command.Command;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String index) {
        this.index = Integer.parseInt(index);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws NullPointerException,
            IndexOutOfBoundsException, NumberFormatException {
        Task task = taskList.getTask(index - 1);
        task.done();
        storage.saveTasks(taskList);
        ui.repeater(task + " marked!");
    }
}
