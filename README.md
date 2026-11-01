# SemSurvive – Student Academic Task Management System

## About the Project

SemSurvive is a console-based Java application designed to help students organize and manage their academic tasks in one place. It allows students to record assignments, slip tests, class tests, and internal examinations, track their completion status, and identify upcoming deadlines.

The project demonstrates important Java programming concepts through a simple, practical application. It also supports saving and loading task records using Java NIO, so task information can be preserved between program runs.

## Features

- **Add Academic Tasks:** Create assignments, slip tests, class tests, and internal examinations.
- **View All Tasks:** Display task details, including subject, description, deadline, and status.
- **Update Task Status:** Mark tasks as completed using their task IDs.
- **View Pending Tasks:** Display tasks that have not yet been completed.
- **Upcoming Deadlines:** Identify pending tasks due within the next three days.
- **Save Tasks:** Store task information in a local text file.
- **Load Tasks:** Restore saved tasks when the application starts.
- **Reminder Service:** Use a separate thread to check for pending tasks with approaching deadlines.
- **Input Validation:** Handle invalid numeric input and file-related errors.

## Technologies Used

- **Programming Language:** Java
- **Development Environment:** Visual Studio Code
- **Data Storage:** Text file (`tasks.txt`)
- **File Handling:** Java NIO
- **Collection Framework:** ArrayList
- **Version Control:** Git and GitHub

## Java Concepts Demonstrated

This project applies the following concepts from the Java Programming syllabus:

| Concept | Implementation |
|---|---|
| Inheritance | Task classes extend the abstract `AcademicTask` class. |
| Method Overriding | Each task subclass provides its own implementation of task display methods. |
| Interfaces | The `Displayable` interface defines a common method for displaying task details. |
| Collections | `ArrayList<AcademicTask>` stores different types of academic tasks. |
| Multithreading | `ReminderThread` performs a separate reminder check. |
| Exception Handling | `try-catch` blocks handle invalid input and file operation errors. |
| Java NIO | `Path` and `Files` are used to save and load task records. |

## Project Structure

```text
SemSurvive/
├── Displayable.java
├── AcademicTask.java
├── Assignment.java
├── SlipTest.java
├── ClassTest.java
├── InternalExam.java
├── ReminderThread.java
├── SemSurvive.java
├── tasks.txt
└── README.md
```

**Note:** `tasks.txt` is created when tasks are saved. It may not exist in a fresh repository.

## Requirements

- Java Development Kit (JDK) compatible with the Java APIs used in the project.
- Visual Studio Code or another Java-compatible editor.
- Command Prompt or a terminal.

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Jv14122007/SemSurvive.git
```

### 2. Open the Project Folder

```bash
cd SemSurvive
```

### 3. Compile the Java Files

```bash
javac *.java
```

### 4. Run the Application

```bash
java SemSurvive
```

## Application Menu

When the program starts, it displays the following menu:

```text
===== SemSurvive =====
1. Add Academic Task
2. View All Tasks
3. Update Task Status
4. View Pending Tasks
5. View Upcoming Deadlines
6. Save Tasks
7. Exit
Enter your choice:
```

Enter the corresponding menu number to perform an operation.

## Data Storage

Task records are stored in a local file named `tasks.txt`. Each saved record contains:

- Task ID
- Task type
- Subject
- Description
- Days remaining
- Completion status

The application uses Java NIO file operations to write records to the file and read them when the program starts.

The current implementation uses the `|` character to separate fields. Avoid using this character in task subjects or descriptions.

## Project Limitations

- The application uses a console-based interface.
- Task deadlines are represented as the number of days remaining rather than calendar dates.
- The reminder service performs a one-time check when the application starts.
- Task data is stored locally in a text file.
- The application does not currently use a database or support multiple users.

## Future Enhancements

- Support actual calendar dates for deadlines.
- Add options to edit and delete tasks.
- Sort tasks by deadline, subject, or category.
- Introduce recurring reminders.
- Add a graphical user interface.
- Integrate a database for more advanced data management.

## Academic Information

**Course:** Java Programming  
**Course Code:** 22ITC02N  
**Assignment:** Assignment II  
**Project Title:** SemSurvive – Student Academic Task Management System

## Conclusion

SemSurvive demonstrates how core Java concepts can be combined to build a useful academic task management application. By organizing tasks through inheritance, method overriding, interfaces, collections, multithreading, exception handling, and Java NIO, the project connects classroom learning with practical programming.

The project also provides experience in developing a multi-class Java application, managing files, testing program functionality, and using GitHub for source code management.
