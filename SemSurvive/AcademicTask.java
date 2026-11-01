public abstract class AcademicTask implements Displayable {

    protected int taskId;
    protected String subject;
    protected String description;
    protected int daysRemaining;
    protected boolean completed;

    public AcademicTask(int taskId, String subject, String description,
                        int daysRemaining) {
        this.taskId = taskId;
        this.subject = subject;
        this.description = description;
        this.daysRemaining = daysRemaining;
        this.completed = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getSubject() {
        return subject;
    }

    public int getDaysRemaining() {
        return daysRemaining;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public void displayCommonDetails() {
        System.out.println("Task ID: " + taskId);
        System.out.println("Subject: " + subject);
        System.out.println("Description: " + description);
        System.out.println("Days Remaining: " + daysRemaining);
        System.out.println("Status: " + (completed ? "Completed" : "Pending"));
    }

    public abstract String getTaskType();
}