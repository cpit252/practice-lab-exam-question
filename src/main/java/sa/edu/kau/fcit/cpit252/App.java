package sa.edu.kau.fcit.cpit252;

public class App
{
    private static final int poolSize = 5;

    private static String [] storageTasks = new String[]{"copy", "rename", "upload",
            "delete", "backup", "archive", "share", "publish",
            "secure", "purge" ,  "recover", "create"};

    private static String[] computeTasks = new String[]{"provision", "create", "stop",
        "start", "pause", "restart", "delete", "clone"};

    public static void submitSomeTasks(MyThreadPool pool, String[] tasks){
        for (int i = 0; i < tasks.length; i++) {
            Runnable worker = new MyWorkerThread(tasks[i]);
            pool.getThreadPoolExecutor().submit(worker);
        }
    }

    public static void terminate(MyThreadPool pool){
        pool.getThreadPoolExecutor().shutdown();
        while (!pool.getThreadPoolExecutor().isTerminated()) {
        }
    }

    public static void main( String[] args ) {
        MyThreadPool myThreadPool = MyThreadPool.getInstance();
        // Pass storage related tasks to the workers
        submitSomeTasks(myThreadPool, storageTasks);
        // Pass compute related tasks to the workers
        MyThreadPool myThreadPool2 = MyThreadPool.getInstance();
        submitSomeTasks(myThreadPool2, computeTasks);
        terminate(myThreadPool);
        terminate(myThreadPool2);
    }
}
