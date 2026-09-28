package lld.basic.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManagerServiceMT {
    // ConcurrentHashMap allows safe simultaneous writes across multiple threads
    private final Map<String, Task> taskDatabase = new ConcurrentHashMap<>();

    public void addTask(String id, String title) {
        Task newTask = new Task(id, title, false);
        taskDatabase.put(id, newTask);
        System.out.println(Thread.currentThread().getName() + " added: " + title);
    }

    public int getTaskCount() {
        return taskDatabase.size();
    }
}
