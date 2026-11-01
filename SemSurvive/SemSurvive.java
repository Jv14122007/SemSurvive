import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class SemSurvive {

    static ArrayList<AcademicTask> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {

        loadTasks();
        ReminderThread reminder = new ReminderThread();
        reminder.start();
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n===== SemSurvive =====");
            System.out.println("1. Add Academic Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. View Upcoming Deadlines");
            System.out.println("6. Save Tasks");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        updateTaskStatus();
                        break;
                    case 4:
                        viewPendingTasks();
                        break;
                    case 5:
                        viewUpcomingDeadlines();
                        break;
                    case 6:
                        saveTasks();
                        break;
                    case 7:
                        System.out.println("Thank you for using SemSurvive!");
                        break;
                    default:
                        System.out.println("Invalid choice. Enter 1 to 7.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        sc.close();
    }

    static void addTask() {

        try {
            System.out.println("\nSelect Task Type:");
            System.out.println("1. Assignment");
            System.out.println("2. Slip Test");
            System.out.println("3. Class Test");
            System.out.println("4. Internal Examination");
            System.out.print("Enter task type: ");

            int type = Integer.parseInt(sc.nextLine());

            if (type < 1 || type > 4) {
                System.out.println("Invalid task type.");
                return;
            }

            System.out.print("Enter subject: ");
            String subject = sc.nextLine();

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            System.out.print("Enter days remaining: ");
            int days = Integer.parseInt(sc.nextLine());

            if (days < 0) {
                System.out.println("Days remaining cannot be negative.");
                return;
            }

            AcademicTask task;

            switch (type) {
                case 1:
                    task = new Assignment(nextId++, subject, description, days);
                    break;
                case 2:
                    task = new SlipTest(nextId++, subject, description, days);
                    break;
                case 3:
                    task = new ClassTest(nextId++, subject, description, days);
                    break;
                default:
                    task = new InternalExam(nextId++, subject, description, days);
            }

            tasks.add(task);
            System.out.println("Task added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet.");
            return;
        }

        for (AcademicTask task : tasks) {
            task.displayDetails();
        }
    }

    static void updateTaskStatus() {

        System.out.print("Enter task ID to mark as completed: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (AcademicTask task : tasks) {
                if (task.getTaskId() == id) {
                    task.markCompleted();
                    System.out.println("Task marked as completed!");
                    return;
                }
            }

            System.out.println("Task ID not found.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid task ID.");
        }
    }

    static void viewPendingTasks() {

        boolean found = false;

        for (AcademicTask task : tasks) {
            if (!task.isCompleted()) {
                task.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No pending tasks!");
        }
    }

    static void viewUpcomingDeadlines() {

        boolean found = false;

        for (AcademicTask task : tasks) {
            if (!task.isCompleted() && task.getDaysRemaining() <= 3) {
                task.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No upcoming deadlines within 3 days.");
        }
    }
    static void saveTasks() {

        Path path = Path.of("tasks.txt");

        try {
            StringBuilder data = new StringBuilder();

            for (AcademicTask task : tasks) {
                data.append(task.getTaskId()).append("|")
                    .append(task.getTaskType()).append("|")
                    .append(task.getSubject()).append("|")
                    .append(task.description).append("|")
                    .append(task.getDaysRemaining()).append("|")
                    .append(task.isCompleted()).append("\n");
            }

            Files.writeString(path, data.toString());

            System.out.println("Tasks saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    static void loadTasks() {

        Path path = Path.of("tasks.txt");

        if (!Files.exists(path)) {
            System.out.println("No saved tasks found. Starting fresh.");
            return;
        }

        try {
            tasks.clear();

            for (String line : Files.readAllLines(path)) {
                if (line.isBlank()) {
                    continue;
                }

                String[] data = line.split("\\|", -1);

                if (data.length != 6) {
                    System.out.println("Skipping invalid task record.");
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String type = data[1];
                String subject = data[2];
                String description = data[3];
                int days = Integer.parseInt(data[4]);
                boolean completed = Boolean.parseBoolean(data[5]);

                AcademicTask task;

                switch (type) {
                    case "Assignment":
                        task = new Assignment(id, subject, description, days);
                        break;
                    case "Slip Test":
                        task = new SlipTest(id, subject, description, days);
                        break;
                    case "Class Test":
                        task = new ClassTest(id, subject, description, days);
                        break;
                    case "Internal Examination":
                        task = new InternalExam(id, subject, description, days);
                        break;
                    default:
                        System.out.println("Skipping unknown task type: " + type);
                        continue;
                }

                if (completed) {
                    task.markCompleted();
                }

                tasks.add(task);

                if (id >= nextId) {
                    nextId = id + 1;
                }
            }

            System.out.println("Tasks loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Saved task data contains an invalid number.");
        }
    }
}