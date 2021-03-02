package com.example.catchthecovid19;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    int score;
    ImageView covid1;
    ImageView covid2;
    ImageView covid3;
    ImageView covid4;
    ImageView covid5;
    ImageView covid6;
    ImageView covid7;
    ImageView covid8;
    ImageView covid9;
    ImageView[] imageViews;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);
        covid1 = findViewById(R.id.covid1);
        covid2 = findViewById(R.id.covid2);
        covid3 = findViewById(R.id.covid3);
        covid4 = findViewById(R.id.covid4);
        covid5 = findViewById(R.id.covid5);
        covid6 = findViewById(R.id.covid6);
        covid7 = findViewById(R.id.covid7);
        covid8 = findViewById(R.id.covid8);
        covid9 = findViewById(R.id.covid9);
        imageViews = new ImageView[]{covid1, covid2, covid3, covid4, covid5, covid6, covid7, covid8, covid9};
        score = 0;
        for (ImageView image : imageViews) {
            image.setVisibility(View.INVISIBLE);
        }
    }

    public void upScore(View view) {
        score++;
        scoreText.setText("Score: " + score);
    }

    public void hideCovid() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageViews) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageViews[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 400);
            }
        };
        handler.post(runnable);
    }

    public void hideCovidEasy() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageViews) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageViews[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 800);
            }
        };
        handler.post(runnable);
    }

    public void hideCovidHard() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageViews) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageViews[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 200);
            }
        };
        handler.post(runnable);
    }

    public void basla(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Zorluk seviyesi");
        final String[] difficult = {"KOLAY", "ORTA", "ZOR"};
        final int checkedItem = 1;
        builder.setSingleChoiceItems(difficult, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (checkedItem) {
                    case 1:
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Zorluk seviyesi");
                        final String[] difficult = {"KOLAY", "ORTA", "ZOR"};
                        final int checkedItem = 1;
                        builder.setSingleChoiceItems(difficult, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                            }
                        });
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                
                            }
                        });
                        new CountDownTimer(10000, 1000) {
                            @Override
                            public void onTick(long l) {
                                timeText.setText("Time: " + l / 1000);
                            }

                            @Override
                            public void onFinish() {
                                timeText.setText("Time Off");
                                handler.removeCallbacks(runnable);
                                for (ImageView image : imageViews) {
                                    image.setVisibility(View.INVISIBLE);
                                }

                                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                alert.setTitle("Tekrar?");
                                alert.setMessage("Tekrar Oynamak İster Misin?");
                                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                });
                                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this, "Oyun Bitti", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                alert.show();
                            }
                        }.start();
                        hideCovidEasy();
                        break;
                    case 2:
                        new CountDownTimer(10000, 1000) {
                            @Override
                            public void onTick(long l) {
                                timeText.setText("Time: " + l / 1000);
                            }

                            @Override
                            public void onFinish() {
                                timeText.setText("Time Off");
                                handler.removeCallbacks(runnable);
                                for (ImageView image : imageViews) {
                                    image.setVisibility(View.INVISIBLE);
                                }

                                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                alert.setTitle("Tekrar?");
                                alert.setMessage("Tekrar Oynamak İster Misin?");
                                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                });
                                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this, "Oyun Bitti", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                alert.show();
                            }
                        }.start();
                        hideCovid();
                        break;
                    case 3:
                        new CountDownTimer(10000, 1000) {
                            @Override
                            public void onTick(long l) {
                                timeText.setText("Time: " + l / 1000);
                            }

                            @Override
                            public void onFinish() {
                                timeText.setText("Time Off");
                                handler.removeCallbacks(runnable);
                                for (ImageView image : imageViews) {
                                    image.setVisibility(View.INVISIBLE);
                                }

                                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                alert.setTitle("Tekrar?");
                                alert.setMessage("Tekrar Oynamak İster Misin?");
                                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                });
                                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this, "Oyun Bitti", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                alert.show();
                            }
                        }.start();
                        hideCovidHard();
                        break;
                }
            }
        });
        builder.setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}