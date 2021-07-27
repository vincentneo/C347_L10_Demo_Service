package sg.edu.rp.c347.id19007966.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    boolean started;

    private DownloadBinder downloadBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    @Override
    public void onCreate() {
        Log.d("MyService", "Service created");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (started == false){
            started = true;
            Log.d("MyService", "Service started");
        } else {
            Log.d("MyService", "Service is still running");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "Service exited");
        super.onDestroy();
    }

}
