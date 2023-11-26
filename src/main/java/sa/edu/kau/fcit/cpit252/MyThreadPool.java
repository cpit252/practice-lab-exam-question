package sa.edu.kau.fcit.cpit252;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    private ExecutorService executorService;
    private final int THREAD_POOL_SIZE = 5;
    

    public MyThreadPool(){
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public ExecutorService getThreadPoolExecutor(){
        return this.executorService;
    }

    public MyThreadPool getInstance(){
        return new MyThreadPool();
    }

}
