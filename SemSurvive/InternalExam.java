public class InternalExam extends AcademicTask {

    public InternalExam(int taskId, String subject, String description,
                        int daysRemaining) {
        super(taskId, subject, description, daysRemaining);
    }

    @Override
    public String getTaskType() {
        return "Internal Examination";
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Internal Examination Details ---");
        displayCommonDetails();
        System.out.println("Task Type: " + getTaskType());
    }
}