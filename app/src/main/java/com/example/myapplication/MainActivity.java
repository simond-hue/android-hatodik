package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnKo, btnPapir, btnOllo;
    private TextView textEredmeny;
    private ImageView imageGep, imageUser;
    private Random rnd;
    private int gepPontszam, jatekosPontszam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnKo.setOnClickListener(this);
        btnOllo.setOnClickListener(this);
        btnPapir.setOnClickListener(this);
    }

    private void init(){
        btnKo = findViewById(R.id.btnKo);
        btnOllo = findViewById(R.id.btnOllo);
        btnPapir = findViewById(R.id.btnPapir);

        textEredmeny = findViewById(R.id.textEredmeny);

        imageGep = findViewById(R.id.imageGep);
        imageUser = findViewById(R.id.imageUser);

        rnd = new Random();

        gepPontszam = 0;
        jatekosPontszam = 0;
    }

    @Override
    public void onClick(View v) {
        String jatekosValasztas = "";
        switch (v.getId()){
            case R.id.btnKo:
                jatekosValasztas = "Kő";
                imageUser.setImageResource(R.drawable.rock);
                break;
            case R.id.btnPapir:
                jatekosValasztas = "Papír";
                imageUser.setImageResource(R.drawable.paper);
                break;
            case R.id.btnOllo:
                jatekosValasztas = "Olló";
                imageUser.setImageResource(R.drawable.scissors);
                break;
        }
        int gepGeneralt = rnd.nextInt(3);
        String gepValasztas = "";
        switch (gepGeneralt){
            case 0:
                gepValasztas = "Kő";
                imageGep.setImageResource(R.drawable.rock);
                break;
            case 1:
                gepValasztas = "Papír";
                imageGep.setImageResource(R.drawable.paper);
                break;
            case 2:
                gepValasztas = "Olló";
                imageGep.setImageResource(R.drawable.scissors);
                break;
        }
        String uzenet = "";

        if(gepValasztas.equals("Kő") && jatekosValasztas.equals("Olló")){
            gepPontszam++;
            uzenet = "A kő erősebb, mint az olló. Vesztettél!";
        }
        else if(gepValasztas.equals("Kő") && jatekosValasztas.equals("Papír")){
           jatekosPontszam++;
           uzenet = "A papír erősebb, mint a kő. Nyertél!";
        }
        else if(gepValasztas.equals("Papír") && jatekosValasztas.equals("Olló")){
            jatekosPontszam++;
            uzenet = "Az olló erősebb, mint a papír. Nyertél!";
        }
        else if(gepValasztas.equals("Papír") && jatekosValasztas.equals("Kő")){
            gepPontszam++;
            uzenet = "A papír erősebb, mint a kő. Vesztettél!";
        }
        else if(gepValasztas.equals("Olló") && jatekosValasztas.equals("Papír")){
            gepPontszam++;
            uzenet = "Az olló erősebb, mint a papír. Vesztettél!";
        }
        else if(gepValasztas.equals("Olló") && jatekosValasztas.equals("Kő")){
            jatekosPontszam++;
            uzenet = "A kő erősebb, mint az olló. Nyertél!";
        }
        else{
            uzenet = "Döntetlen!";
        }

        textEredmeny.setText(String.format("Eredmény: Gép: %d - Játékos: %d",gepPontszam,jatekosPontszam));
        Toast.makeText(MainActivity.this, uzenet, Toast.LENGTH_SHORT).show();
    }
}
