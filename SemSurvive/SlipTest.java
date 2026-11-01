public class SlipTest extends AcademicTask {

    public SlipTest(int taskId, String subject, String description,
                    int daysRemaining) {
        super(taskId, subject, description, daysRemaining);
    }

    @Override
    public String getTaskType() {
        return "Slip Test";
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Slip Test Details ---");
        displayCommonDetails();
        System.out.println("Task Type: " + getTaskType());
    }
}