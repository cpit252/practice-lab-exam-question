## Problem
A Java application uses a fixed thread pool to execute some tasks by a fixed number of worker threads. Creating threads is always expensive, regardless of the platform your code is running on. This app uses a thread pool, but it ended up creating the thread pool two times and may repeat that multiple times. Fix the current implementation of the `MyThreadPool.java` class, so it creates a thread pool ONLY once and clients can use it multiple times throughout the life of the application.

## Usage

Clone and import the project into your IDE (e.g., IntelliJ IDEA or Apache NetBeans). You can also build and run the program from the terminal using:

```bash
mvn compile exec:java
```

and to run the test, use:

```bash
mvn test
```

## Submission
Push your code into GitHub to kick off GitHub Actions for auto-grading.

