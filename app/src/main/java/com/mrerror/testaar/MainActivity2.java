package com.mrerror.testaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android7.rewind.glessand.MainActivity;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

public class MainActivity2 extends AppCompatActivity {

    Button download,open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SplitCompat.install(this);
        download = findViewById(R.id.button2);
        open = findViewById(R.id.button);

        SplitInstallManager manager =
            SplitInstallManagerFactory.create(this);
        download.setOnClickListener(view -> {
            SplitInstallRequest request = SplitInstallRequest.newBuilder()
                    .addModule("test")
                    .build();

            manager.startInstall(request);
        });
        open.setEnabled(false);
        manager.registerListener(state -> {
            switch (state.status()){
                case SplitInstallSessionStatus.DOWNLOADING:
                    Toast.makeText(MainActivity2.this, "downloading", Toast.LENGTH_SHORT).show();
                break;
                case SplitInstallSessionStatus.INSTALLED :
                    Toast.makeText(MainActivity2.this, "done ", Toast.LENGTH_SHORT).show();
                    updateDynamicFeatureButtonState();

            }
        });
    }

    private void updateDynamicFeatureButtonState() {

        open.setEnabled(true);
        open.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClassName(BuildConfig.APPLICATION_ID, "com.mrerror.test.OnDemandActivity");
            startActivity(intent);
        });
    }
}