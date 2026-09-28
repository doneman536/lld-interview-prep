package lld.basic.learning;

public class Main {
    public static void main() {
        TaskManagerService managerService = new TaskManagerService();

        for(int i=0;i<100;i++){
            String value = Integer.toString(i);
            managerService.addTask( value, "Task-" + value);
        }
        for(int i=0;i<100;i++){
            String value = Integer.toString(i);
            managerService.processTask(value);
        }
    }
}
