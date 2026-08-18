package com.ifsc.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        rng = new Random();

        setContentView(R.layout.activity_main); /// constraint, button e Textview
        TextView tv = findViewById(R.id.text);
        tv.setText("Sorteio");
        Button btn = findViewById(R.id.button);
        btn.setText("Sortear");
        EditText edMin = findViewById(R.id.edMin);
        EditText edMax = findViewById(R.id.edMax);
        btn.setOnClickListener(v -> {
            String sMin = edMin.getText().toString();
            String sMax = edMax.getText().toString();

            if (sMin.isEmpty()) {
                edMin.setError("Informe um número");
                return;
            }
            if (sMax.isEmpty()) {
                edMax.setError("Informe um número");
                return;
            }

            int min = Integer.parseInt(sMin);
            int max = Integer.parseInt(sMax);

            if (min >= max) {
                Toast.makeText(this, "O número mínimo é maior que o número máximo", Toast.LENGTH_SHORT).show();
                return;
            }

            Integer rngNumber = rng.nextInt(min, max);

            tv.setText(String.valueOf(rngNumber));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}