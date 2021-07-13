package com.example.trocador_imagens;
//Alunos: Lucas Aguiar Cera e Renan Wenzel
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgApp;
    private ImageView imgPedra;
    private ImageView imgTesoura;
    private ImageView imgPapel;
    private TextView Win_or_Lose;
    int pointsPlayer = 0, pointsApp = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPedra = (ImageView) findViewById(R.id.imgPedra);
        imgTesoura = (ImageView) findViewById(R.id.imgTesoura);
        imgPapel = (ImageView) findViewById(R.id.imgPapel);

        imgPedra.setOnClickListener(new ChoiceListener());
        imgPapel.setOnClickListener(new ChoiceListener());
        imgTesoura.setOnClickListener(new ChoiceListener());
    }

    private class ChoiceListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            imgApp = (ImageView) findViewById(R.id.imgApp);
            imgPedra = (ImageView) findViewById(R.id.imgPedra);
            imgPapel = (ImageView) findViewById(R.id.imgPapel);
            imgTesoura = (ImageView) findViewById(R.id.imgTesoura);
            Random randomImage = new Random();
            int appChoice = randomImage.nextInt(4 - 1) + 1;
            ImageView imageClicked = (ImageView) view;
            Win_or_Lose = (TextView) findViewById(R.id.Win_or_Lose);
            System.out.println(appChoice);
            switch(appChoice){
                case 1:
                    imgApp.setImageResource(R.drawable.pedra);

                    if(imageClicked.getId() == R.id.imgPapel){ //Dúvida: Tem como otimizar o código nessa parte? Pensei em fazer uma função pra mudar a cor,
                        //porque ficou meio feio do jeito que está.
                        pointsPlayer += 1;
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#3930C11A"));
                    } if (imageClicked.getId() == R.id.imgTesoura){
                        pointsApp += 1;
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#6BD52929"));
                    } if (imageClicked.getId() == R.id.imgPedra){
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPedra.setBackgroundColor(Color.parseColor("#6BD5B329"));
                    }
                    Win_or_Lose.setText("Player: " + pointsPlayer + " VS Android: " + pointsApp);
                    break;
                case 2:
                    imgApp.setImageResource(R.drawable.tesoura);
                    if(imageClicked.getId() == R.id.imgPedra){
                        pointsPlayer +=1;
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPedra.setBackgroundColor(Color.parseColor("#3930C11A"));
                    } if (imageClicked.getId() == R.id.imgPapel){
                        pointsApp += 1;
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#6BD52929"));
                    } if (imageClicked.getId() == R.id.imgTesoura){
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#6BD5B329"));
                    }
                    Win_or_Lose.setText("Player: " + pointsPlayer + " VS Android: " + pointsApp);
                    break;
                case 3:
                    imgApp.setImageResource(R.drawable.papel);
                    if(imageClicked.getId() == R.id.imgTesoura){
                        pointsPlayer +=1;
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#3930C11A"));
                    } if (imageClicked.getId() == R.id.imgPedra){
                        pointsApp += 1;
                        imgPapel.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPedra.setBackgroundColor(Color.parseColor("#6BD52929"));
                    } if (imageClicked.getId() == R.id.imgPapel){
                        imgPedra.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgTesoura.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                        imgPapel.setBackgroundColor(Color.parseColor("#6BD5B329"));
                    }
                    Win_or_Lose.setText("Player: " + pointsPlayer + " VS Android: " + pointsApp);
                    break;
            }
        }
    }
}