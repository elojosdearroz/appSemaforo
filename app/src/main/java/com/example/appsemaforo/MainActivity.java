package com.example.appsemaforo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;
    TextView tvContador;
    ImageView ivLed, ivLed2;
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


        btnIniciar = findViewById(R.id.btnIniciar);
        tvContador = findViewById(R.id.tvContador);
        ivLed = findViewById(R.id.ivLed);
        ivLed2 = findViewById(R.id.ivLed2);

        Drawable drawable = ivLed.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;

        Drawable drawable2 = ivLed2.getBackground();
        GradientDrawable gradientDrawable2 = (GradientDrawable) drawable2;

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable(){
                    int color = 1;
                    @Override
                    public void run() {
                        while (true) {
                            for (int i = 1; i <= 5; i++) {
                                int dec = i;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvContador.setText("Contador: " + dec);
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            switch (color){
                                case 1:
                                    gradientDrawable.setColor(Color.parseColor("#F7FF00"));
                                    color = 2;
                                    break;
                                case 2:
                                    gradientDrawable.setColor(Color.parseColor("#1EFF00"));
                                    color = 3;
                                    break;
                                case 3:
                                    gradientDrawable.setColor(Color.parseColor("#FF0000"));
                                    color = 1;
                                    break;
                            }
                        }
                    }
                });
                thread.start();

                Thread thread2 = new Thread(new Runnable(){
                    int color = 1;
                    @Override
                    public void run() {
                        while (true) {
                            for (int i = 1; i <= 5; i++) {
                                int dec = i;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvContador.setText("Contador: " + dec);
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            switch (color){
                                case 1:
                                    gradientDrawable2.setColor(Color.parseColor("#F7FF00"));
                                    color = 2;
                                    break;
                                case 2:
                                    gradientDrawable2.setColor(Color.parseColor("#1EFF00"));
                                    color = 3;
                                    break;
                                case 3:
                                    gradientDrawable2.setColor(Color.parseColor("#FF0000"));
                                    color = 1;
                                    break;
                            }
                        }
                    }
                });
                thread2.start();
            }
        });
    }
}