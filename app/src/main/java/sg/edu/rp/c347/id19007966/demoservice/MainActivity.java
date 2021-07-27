package sg.edu.rp.c347.id19007966.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStart, buttonStop, buttonBind, buttonUnbind;

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (MyService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonBind = findViewById(R.id.buttonBind);
        buttonUnbind = findViewById(R.id.buttonUnbind);

        buttonStart.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MyService.class);
            startService(i);
        });

        buttonStop.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MyService.class);
            stopService(i);
        });

        buttonBind.setOnClickListener(view -> {
            Intent bindIntent = new Intent(MainActivity.this, MyService.class);
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        });

        buttonUnbind.setOnClickListener(view -> {
            unbindService(connection);
        });
    }
}