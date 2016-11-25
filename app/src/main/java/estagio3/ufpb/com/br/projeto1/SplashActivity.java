package estagio3.ufpb.com.br.projeto1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable {

    private static final long delay = 3000;
    private DataBase dataBase;
    private SharedPreferences sPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        dataBase = new DataBase(this);
        sPreferences = getSharedPreferences("firstRun", MODE_PRIVATE);
        Handler handler = new Handler();
        handler.postDelayed(this,delay);
    }

    @Override
    public void run() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void createWords() {
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.esquilo),"ESQUILO"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.cat),"GATO"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.hipopotamo),"HIPOPÓTAMO"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.coala),"COALA"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.panda),"PANDA"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.leao),"LEÃO"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.car),"CARRO"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.borboleta),"BORBOLETA"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.sofa),"SOFÁ"));
        dataBase.insertWord(new Word(ContextCompat.getDrawable(this,R.drawable.clock),"RELÓGIO"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sPreferences.getBoolean("firstRun", true)) {
            sPreferences.edit().putBoolean("firstRun", false).apply();
            createWords();
        }
    }
}
