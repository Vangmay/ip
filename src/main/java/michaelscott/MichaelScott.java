package michaelscott;

import michaelscott.command.CommandParser;
import michaelscott.task.TaskList;
import michaelscott.command.Command;

public class MichaelScott {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;
    private final CommandParser parser;

    public MichaelScott() {
        ui = new Ui();
        parser = new CommandParser();
        tasks = new TaskList();
        storage = new Storage(tasks);
    }

    public void run() {
        ui.showWelcome();
        boolean isRunning = true;
        while (isRunning) {
            try {
                String fullCommand = ui.readCommand();
                Command cmd = parser.parse(fullCommand);
                String response = cmd.execute(tasks);

                ui.showResponse(response);
                storage.saveTasks(tasks.getTasks());
                isRunning = !cmd.isExit();
            } catch (MichaelScottException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new MichaelScott().run();
    }
}
