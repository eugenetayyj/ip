package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;
import duke.task.Todo;

/**
 * Represents a command that is used to add a Todo task into a tasklist, save the Todo
 * and print out the Todo that was added.
 */
public class AddTodoCommand extends Command {
    private String taskName;

    /**
     * Constructor for the AddEventCommand.
     *
     * @param task
     */
    public AddTodoCommand(String task) {
        int taskIndex = 5;
        this.taskName = task.substring(taskIndex);
    }

    /**
     * Execute method that is used to add a Todo task to a tasklist, save the Todo
     * and print out the Todo that was added through tasklist, ui and storage.
     *
     * @param taskList
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task todo = new Todo(taskName);
        taskList.addTasks(todo);
        storage.saveTasks(taskList);
        String response = todo + "added";
        return response;
    }

}
