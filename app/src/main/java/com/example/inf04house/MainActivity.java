package com.example.inf04house;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button like, unlike;
    TextView textView;

    int likes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        like = findViewById(R.id.button);
        unlike = findViewById(R.id.button2);
        textView = findViewById(R.id.textView3);
        like.setOnClickListener(
                view -> {
                    likes++;
                    textView.setText(String.valueOf(likes) + " polubień");
                }
        );
        unlike.setOnClickListener(
                view -> {
                    if (likes > 0){
                        likes--;
                        textView.setText(String.valueOf(likes) + " polubień");
                    }
                }
        );
    }
}