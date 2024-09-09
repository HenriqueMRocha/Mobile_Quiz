package com.example.bandeiragem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnOpt1, btnOpt2, btnOpt3, btnOpt4;
    ImageView imageView;

    List<CountryItem> list;

    Random random;

    int turn = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        imageView = (ImageView) findViewById(R.id.imageView);

        btnOpt1 = (Button) findViewById(R.id.btnOpt1);
        btnOpt2 = (Button) findViewById(R.id.btnOpt2);
        btnOpt3 = (Button) findViewById(R.id.btnOpt3);
        btnOpt4 = (Button) findViewById(R.id.btnOpt4);

        list = new ArrayList<>();
        list.add(new CountryItem("Brasil", R.drawable.brasil));

        for(int i = 0; i < new Database().names.length; i++) {
            list.add(new CountryItem(new Database().names[i], new Database().flags[i])) ;
        };

        Collections.shuffle(list);

        newQuestion(turn);

        btnOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOpt1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        btnOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOpt2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        btnOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOpt3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        btnOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOpt4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(MainActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Errou!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Fim de jogo!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
    private void newQuestion(int number) {
        // Renderizando a imagem da bandeira na tela do usuário
        imageView.setImageResource(list.get(number - 1).getImage());

        int correctAnswer = random.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correctAnswer) {
            case 1:
                btnOpt1.setText(list.get(firstButton).getName());

                do {
                    secondButton = random.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = random.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = random.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                btnOpt2.setText(list.get(secondButton).getName());
                btnOpt3.setText(list.get(thirdButton).getName());
                btnOpt4.setText(list.get(forthButton).getName());

                break;
            case 2:
                btnOpt2.setText(list.get(firstButton).getName());

                do {
                    secondButton = random.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = random.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = random.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                btnOpt1.setText(list.get(secondButton).getName());
                btnOpt3.setText(list.get(thirdButton).getName());
                btnOpt4.setText(list.get(forthButton).getName());
                break;
            case 3:
                btnOpt3.setText(list.get(firstButton).getName());

                do {
                    secondButton = random.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = random.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = random.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                btnOpt2.setText(list.get(secondButton).getName());
                btnOpt1.setText(list.get(thirdButton).getName());
                btnOpt4.setText(list.get(forthButton).getName());
                break;
            case 4:
                btnOpt4.setText(list.get(firstButton).getName());

                do {
                    secondButton = random.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = random.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = random.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                btnOpt2.setText(list.get(secondButton).getName());
                btnOpt3.setText(list.get(thirdButton).getName());
                btnOpt1.setText(list.get(forthButton).getName());
                break;

        }
    };
}