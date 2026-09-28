package lld.basic.learning;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.lang.Thread;

public class TaskManagerService {
    private final Map<String , Task > taskDatabase = new HashMap<>();


    public void addTask(String id, String title){
        taskDatabase.put(id , new Task(id , title , false));
        System.out.println("Added the task");
    }

    public void processTask(String taskId){
        try{
            if(taskDatabase.containsKey((taskId))){
                Task processingTask = taskDatabase.remove(taskId);
                Thread.sleep(1000);
                System.out.println(MessageFormat.format("Task {0} processed and completed", taskId));
                return;
            }
            System.out.println(MessageFormat.format("Task is {0} already completed", taskId));
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(MessageFormat.format("Task is {0} failed", taskId));
        }
    }


}