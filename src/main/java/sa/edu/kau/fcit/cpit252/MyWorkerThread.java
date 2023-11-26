package sa.edu.kau.fcit.cpit252;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyWorkerThread implements Runnable{
    private String taskName;

    public MyWorkerThread(String taskName){
        this.taskName=taskName;
    }

    private String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    @Override
    public void run() {
        System.out.println(getTime() + "\t" + Thread.currentThread().getName()+ " performing a task = " + taskName);
        performTask();
        System.out.println(getTime() + "\t" + Thread.currentThread().getName()+ " completed a task = " + taskName);
    }

    private void performTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.taskName;
    }
}
