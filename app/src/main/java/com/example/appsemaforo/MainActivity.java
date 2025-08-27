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
    ImageView ivLed;
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

        Drawable drawable = ivLed.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable(){
                    boolean encendido = true;
                    @Override
                    public void run() {
                        while (true) {
                            for (int i = 0; i <= 5; i++) {
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
                            if (encendido) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        gradientDrawable.setColor(Color.parseColor("#9b9b9b"));
                                    }
                                });
                            }
                            else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        gradientDrawable.setColor(Color.parseColor("#FF0000"));
                                    }
                                });
                            }
                            encendido = !encendido;
                        }
                    }
                });
                thread.start();
            }
        });
    }
}