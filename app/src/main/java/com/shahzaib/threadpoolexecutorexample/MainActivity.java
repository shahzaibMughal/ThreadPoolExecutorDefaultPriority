package com.shahzaib.threadpoolexecutorexample;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import threadPoolExecutor.ExecutorSupplier;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SHOW_LOG("Main "+getThreadId(Thread.currentThread()));

        ExecutorSupplier.getInstance().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++)
                {
                    SHOW_LOG(i+" -->  1st background work: "+getThreadId(Thread.currentThread()));
                }
            }
        });
        ExecutorSupplier.getInstance().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++)
                {
                    SHOW_LOG(i+" -->  2nd background work: "+getThreadId(Thread.currentThread()));
                }
            }
        });
        ExecutorSupplier.getInstance().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++)
                {
                    SHOW_LOG(i+" -->  3rd background work: "+getThreadId(Thread.currentThread()));
                }
            }
        });
        ExecutorSupplier.getInstance().forBackgroundTasks().execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++)
                {
                    SHOW_LOG(i+" -->  4th background work: "+getThreadId(Thread.currentThread()));
                }
            }
        });

    }




    public static void SHOW_LOG(String message)
    {
        Log.i("123456",  message);
    }

    public  String getThreadId(Thread thread)
    {
        return "Thread id: "+ thread.getId();
    }

}
