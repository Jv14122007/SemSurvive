public class ClassTest extends AcademicTask {

    public ClassTest(int taskId, String subject, String description,
                     int daysRemaining) {
        super(taskId, subject, description, daysRemaining);
    }

    @Override
    public String getTaskType() {
        return "Class Test";
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Class Test Details ---");
        displayCommonDetails();
        System.out.println("Task Type: " + getTaskType());
    }
}