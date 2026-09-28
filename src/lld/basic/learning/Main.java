package lld.basic.learning;

//public class Main {
//    public static void main() {
//        TaskManagerService managerService = new TaskManagerService();
//
//        for(int i=0;i<100;i++){
//            String value = Integer.toString(i);
//            managerService.addTask( value, "Task-" + value);
//        }
//        for(int i=0;i<100;i++){
//            String value = Integer.toString(i);
//            managerService.processTask(value);
//        }
//    }
//}

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        TaskManagerServiceMT service = new TaskManagerServiceMT();

        // Create a fixed pool of 4 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 1; i <= 100000; i++) {
            final int taskId = i;
            executor.submit(() -> {
//                System.out.println("Aded" + taskId);
                service.addTask(String.valueOf(taskId), "Task #" + taskId);
            });
        }

        // Shut down pool and wait for all threads to finish
        executor.shutdown();
//        service.addTask(String.valueOf(1000222), "Task #" + 1000222); // Not accepted
        executor.awaitTermination(5, TimeUnit.SECONDS);
        Instant end = Instant.now();

        System.out.println("--- Execution Done ---");
        System.out.println("Total tasks inserted safely: " + service.getTaskCount());
        System.out.println("Time Taken: " + Duration.between(start, end).toMillis()/1000.000);

    }
}
