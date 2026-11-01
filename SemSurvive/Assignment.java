public class Assignment extends AcademicTask {

    public Assignment(int taskId, String subject, String description,
                      int daysRemaining) {
        super(taskId, subject, description, daysRemaining);
    }

    @Override
    public String getTaskType() {
        return "Assignment";
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Assignment Details ---");
        displayCommonDetails();
        System.out.println("Task Type: " + getTaskType());
    }
}