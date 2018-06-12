package com.demo.salminnella.intentservicesleeper;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private Button downloadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickListener(downloadButton);
    }

    private void initViews() {
        downloadButton = findViewById(R.id.download_button_main);
    }

    private void setClickListener(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentService();
            }
        });
    }

    private void startIntentService() {

    }
}
