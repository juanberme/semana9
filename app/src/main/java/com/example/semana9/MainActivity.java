package com.example.semana9;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView pastel1;
    private ImageView pastel2;
    private ImageView pastel3;
    private ImageView pastel4;
    public UDPConnection udp;
    private String fechaStr;
    private pastel1 pas1;
    private pastel2 pas2;
    private pastel3 pas3;
    private pastel4 pas4;
    private int x = 0;
    private int y = 0;
    private int tam = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pastel1 = findViewById(R.id.pastel1);
        pastel2 = findViewById(R.id.pastel2);
        pastel3 = findViewById(R.id.pastel3);
        pastel4 = findViewById(R.id.pastel4);

        pastel1.setOnClickListener(this);
        pastel2.setOnClickListener(this);
        pastel3.setOnClickListener(this);
        pastel4.setOnClickListener(this);

        udp = new UDPConnection();
        udp.start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pastel1:
                Date date1 = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                fechaStr = sdf.format(date1);
                Log.e(">>>", fechaStr);
                //pas1 = new pastel1(x+20, y+20, tam);
                break;
            case R.id.pastel2:
                Date date2 = new Date();
                SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
                fechaStr = sdf2.format(date2);
                Log.e(">>>", fechaStr);
                //pas2 = new pastel2(x+90, y+20, tam);
                break;
            case R.id.pastel3:
                Date date3 = new Date();
                SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
                fechaStr = sdf3.format(date3);
                Log.e(">>>", fechaStr);
                //pas3 = new pastel3(x+160, y+20, tam);
                break;
            case R.id.pastel4:
                Date date4 = new Date();
                SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm:ss");
                fechaStr = sdf4.format(date4);
                Log.e(">>>", fechaStr);
                //pas1 = new pastel1(x+230, y+20, tam);
                break;
        }
        Gson gson = new Gson();
        String msg = gson.toJson(fechaStr);
        udp.sendMessage(msg);

    }
}