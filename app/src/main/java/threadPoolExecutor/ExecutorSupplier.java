package threadPoolExecutor;

import android.os.Process;
import android.support.annotation.NonNull;

import com.shahzaib.threadpoolexecutorexample.MainActivity;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorSupplier {
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int NUMBER_OF_TASKS = 6;

    private static ExecutorSupplier sInstance;

    private final ThreadPoolExecutor mForBackgroundTasks;
//    private final ThreadPoolExecutor mForNetwork;
//    private final ThreadPoolExecutor mForDecoding;


    private ExecutorSupplier() {
        //setting the threadPoolExecutor for background tasks
        mForBackgroundTasks = new ThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>()
        );
    }

    public static ExecutorSupplier getInstance() {
        if (sInstance == null) {
            synchronized (ExecutorSupplier.class) {
                sInstance = new ExecutorSupplier();
            }
            return sInstance;
        }
        return sInstance;
    }



    public ThreadPoolExecutor forBackgroundTasks() {
        return mForBackgroundTasks;
    }


}
