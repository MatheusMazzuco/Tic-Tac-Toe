package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    HashMap<String, ImageView> imageIdByIndex = new HashMap<>();
    int round = 1;
    int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    boolean gameLock = false;

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

        this.setupImagesIndex();
    }

    private void setupImagesIndex() {
        this.imageIdByIndex.put("0" + "0", (ImageView) findViewById(R.id.topLeft));
        this.imageIdByIndex.put("0" + "1", (ImageView) findViewById(R.id.topMiddle));
        this.imageIdByIndex.put("0" + "2", (ImageView) findViewById(R.id.topRight));
        this.imageIdByIndex.put("1" + "0", (ImageView) findViewById(R.id.middleLeft));
        this.imageIdByIndex.put("1" + "1", (ImageView) findViewById(R.id.middle));
        this.imageIdByIndex.put("1" + "2", (ImageView) findViewById(R.id.middleRight));
        this.imageIdByIndex.put("2" + "0", (ImageView) findViewById(R.id.bottomLeft));
        this.imageIdByIndex.put("2" + "1", (ImageView) findViewById(R.id.bottomMiddle));
        this.imageIdByIndex.put("2" + "2", (ImageView) findViewById(R.id.bottomRight));
    }

    private void gerarEscolha() {
        while (round % 2 != 1 && round < 9) {
        int cpuRow = new Random().nextInt(3);
        int cpuCol = new Random().nextInt(3);
        ImageView imageView = this.imageIdByIndex.get(String.valueOf(cpuRow) + String.valueOf(cpuCol));
        if (board[cpuRow][cpuCol] == 0) {
            round++;
            board[cpuRow][cpuCol] = 2;
            imageView.setImageResource(R.drawable.o);
        }
        }
    }

    private void verificarGanhador() {

        TextView text_resultado = findViewById(R.id.text_resultado);

        if (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1 ||
                board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1 ||
                board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1 ||
                board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1 ||
                board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1 ||
                board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1 ||
                board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 ||
                board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1 ) {
            text_resultado.setText("Ganhou");
            gameLock = true;
        }  else {
            if (round > 9) {
                text_resultado.setText("Empate");
            }
        }

        if (!gameLock) {
            gerarEscolha();
            if (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2 ||
                board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2 ||
                board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2 ||
                board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2 ||
                board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2 ||
                board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2 ||
                board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2 ||
                board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2 ) {
                text_resultado.setText("Perdeu");
                gameLock = true;
            }
        }


    }

    public void clickButton(View view) {
        switch(view.getId()){
            case R.id.topLeft:
                if (board[0][0] == 0 && !gameLock) {
                    verificarGanhador();
                    board[0][0] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.topMiddle:
                if (board[0][1] == 0 && !gameLock) {
                    verificarGanhador();
                    board[0][1] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.topRight:
                if (board[0][2] == 0 && !gameLock) {
                    verificarGanhador();
                    board[0][2] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.middleLeft:
                if (board[1][0] == 0 && !gameLock) {
                    verificarGanhador();
                    board[1][0] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.middle:
                if (board[1][1] == 0 && !gameLock) {
                    verificarGanhador();
                    board[1][1] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.middleRight:
                if (board[1][2] == 0 && !gameLock) {
                    verificarGanhador();
                    board[1][2] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.bottomLeft:
                if (board[2][0] == 0 && !gameLock) {
                    verificarGanhador();
                    board[2][0] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.bottomMiddle:
                if (board[2][1] == 0 && !gameLock) {
                    verificarGanhador();
                    board[2][1] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
            case R.id.bottomRight:
                if (board[2][2] == 0 && !gameLock) {
                    verificarGanhador();
                    board[2][2] = 1;
                    ImageView imageView = findViewById(view.getId());
                    imageView.setImageResource(R.drawable.x);
                    round++;
                    verificarGanhador();
                }
                break;
        }
    }
}