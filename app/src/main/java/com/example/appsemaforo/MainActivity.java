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
    ImageView ivLedRojo1 , ivLedRojo2, ivLedAmarillo1, ivLedAmarillo2, ivLedVerde1, ivLedVerde2;
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

        ivLedRojo1 = findViewById(R.id.ivLedRojo1);
        ivLedRojo2 = findViewById(R.id.ivLedRojo2);
        ivLedAmarillo1 = findViewById(R.id.ivLedAmarillo1);
        ivLedAmarillo2 = findViewById(R.id.ivLedAmarillo2);
        ivLedVerde1 = findViewById(R.id.ivLedVerde1);
        ivLedVerde2 = findViewById(R.id.ivLedVerde2);

        GradientDrawable drawableRojo1 = (GradientDrawable) ivLedRojo1.getBackground();
        GradientDrawable drawableRojo2 = (GradientDrawable) ivLedRojo2.getBackground();

        GradientDrawable drawableAmarillo1 = (GradientDrawable) ivLedAmarillo1.getBackground();
        GradientDrawable drawableAmarillo2 = (GradientDrawable) ivLedAmarillo2.getBackground();

        GradientDrawable drawableVerde1 = (GradientDrawable) ivLedVerde1.getBackground();
        GradientDrawable drawableVerde2 = (GradientDrawable) ivLedVerde2.getBackground();



        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawableRojo1.setColor(Color.parseColor("#FF0000"));
                drawableRojo2.setColor(Color.parseColor("#FF0000"));
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
                            //000000
                            switch (color){
                                case 1:
                                    drawableRojo1.setColor(Color.parseColor("#787575"));
                                    drawableAmarillo1.setColor(Color.parseColor("#FFFF00"));
                                    drawableVerde1.setColor(Color.parseColor("#787575"));
                                    color = 2;
                                    break;
                                case 2:
                                    drawableRojo1.setColor(Color.parseColor("#787575"));
                                    drawableAmarillo1.setColor(Color.parseColor("#787575"));
                                    drawableVerde1.setColor(Color.parseColor("#0DFF00"));
                                    color = 3;
                                    break;
                                case 3:
                                    drawableRojo1.setColor(Color.parseColor("#FF0000"));
                                    drawableAmarillo1.setColor(Color.parseColor("#787575"));
                                    drawableVerde1.setColor(Color.parseColor("#787575"));
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
                            //000000
                            switch (color){
                                case 1:
                                    drawableRojo2.setColor(Color.parseColor("#787575"));
                                    drawableAmarillo2.setColor(Color.parseColor("#FFFF00"));
                                    drawableVerde2.setColor(Color.parseColor("#787575"));
                                    color = 2;
                                    break;
                                case 2:
                                    drawableRojo2.setColor(Color.parseColor("#787575"));
                                    drawableAmarillo2.setColor(Color.parseColor("#787575"));
                                    drawableVerde2.setColor(Color.parseColor("#0DFF00"));
                                    color = 3;
                                    break;
                                case 3:
                                    drawableRojo2.setColor(Color.parseColor("#FF0000"));
                                    drawableAmarillo2.setColor(Color.parseColor("#787575"));
                                    drawableVerde2.setColor(Color.parseColor("#787575"));
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