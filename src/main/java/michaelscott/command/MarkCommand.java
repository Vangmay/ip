package michaelscott.command;

import michaelscott.exception.MichaelScottException;
import michaelscott.task.Task;
import michaelscott.task.TaskList;

public class MarkCommand implements Command {
    private final int taskIndex;

    public MarkCommand(String args) throws MichaelScottException {
        try {
            this.taskIndex = Integer.parseInt(args.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new MichaelScottException("Please provide a valid task number.");
        }
    }

    @Override
    public String execute(TaskList tasks) throws MichaelScottException {
        Task task = tasks.getTask(this.taskIndex);
        task.completeTask();
        return "Nice! I've marked this task as done:\n" + task.toString();
    }
}
