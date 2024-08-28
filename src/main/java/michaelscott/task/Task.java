package michaelscott.task;

public abstract class Task {
    protected Boolean isDone;
    protected String desc;

    public Task(String desc) {
        this.isDone = false;
        this.desc = desc;
    }

    public Boolean isDone() {
        return this.isDone;
    }
    public String getDesc() {
        return this.desc;
    }

    public void completeTask() {
        this.isDone = true;
    }

    public void undoTask() {
        this.isDone = false;
    }

    public abstract String toString();

    public abstract String toFile();
}
