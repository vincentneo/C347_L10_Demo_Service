package sg.edu.rp.c347.id19007966.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStart, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MyService.class);
            startService(i);
        });

        buttonStop.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MyService.class);
            stopService(i);
        });
    }
}