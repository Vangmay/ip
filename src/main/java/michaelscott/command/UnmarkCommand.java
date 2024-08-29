package michaelscott.command;

import michaelscott.MichaelScottException;
import michaelscott.task.Task;
import michaelscott.task.TaskList;

/**
 * Represents a command to unmark a task.
 */
public class UnmarkCommand implements Command {
    private final int taskIndex;

    public UnmarkCommand(String args) throws MichaelScottException {
        try {
            this.taskIndex = Integer.parseInt(args.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new MichaelScottException("Please enter a valid number");
        }
    }

    @Override
    public String execute(TaskList tasks) throws MichaelScottException {
        Task task  = tasks.getTask(this.taskIndex);
        task.undoTask();
        return "OK, I've marked this task as not done yet: \n" + task.toString();
    }
}
