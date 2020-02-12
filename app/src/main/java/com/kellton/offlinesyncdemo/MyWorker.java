package com.kellton.offlinesyncdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String message = SharedPref.getMessage(getApplicationContext());
        if(message!=null)
        {
            NotificationUtils.addNotification(getApplicationContext(), "Message", message);
            SharedPref.removeMessage(getApplicationContext());
        }
        return Result.RETRY;
    }
}
