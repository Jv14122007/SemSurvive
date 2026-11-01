public class ReminderThread extends Thread {

    @Override
    public void run() {
        System.out.println("\n[Reminder Service] Checking pending tasks...");

        for (AcademicTask task : SemSurvive.tasks) {
            if (!task.isCompleted() && task.getDaysRemaining() <= 3) {
                System.out.println(
                    "[REMINDER] " + task.getTaskType()
                    + " - " + task.getSubject()
                    + " is due in " + task.getDaysRemaining() + " day(s)!"
                );
            }
        }

        System.out.println("[Reminder Service] Check completed.");
    }
}