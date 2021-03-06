package com.example.appnghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView txtIdBai, txtTenBai, txtThoiGian, txtTrangthai;
    Button btnChon, btnPlay, btnPause;
    private MediaPlayer mediaPlayer;
    int khoa = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        actionChon();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            mediaPlayer.pause();
            txtIdBai.setText("Bài " + bundle.getString("idBai"));
            khoa = bundle.getInt("khoa");
            txtTenBai.setText(bundle.getString("ten"));
            mediaPlayer = MediaPlayer.create(this, khoa);
            int startTime = mediaPlayer.getDuration();
            txtThoiGian.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
        }else {
            mediaPlayer.pause();
            txtIdBai.setText("Bài 1");
            txtTenBai.setText("Ái Nộ - Masew x Khôi Vũ");
            mediaPlayer = MediaPlayer.create(this, R.raw.ai_no_masew_x_khoi_vu);
            int startTime = mediaPlayer.getDuration();
            txtThoiGian.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
        }
    }

    private void actionChon() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChonBai.class);
                startActivity(intent);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                txtTrangthai.setText("Đang chạy");
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                txtTrangthai.setText("Đã dừng chạy");
            }
        });
    }

    private void getView() {
        txtIdBai = (TextView) findViewById(R.id.txtIdBai);
        txtTenBai = (TextView) findViewById(R.id.txtTenBai);
        txtThoiGian = (TextView) findViewById(R.id.txtThoiGian);
        btnChon= (Button) findViewById(R.id.btnChonBai);
        btnPlay=(Button) findViewById(R.id.btnPlay);
        btnPause =(Button) findViewById(R.id.btnPause);
        mediaPlayer = MediaPlayer.create(this,R.raw.ai_no_masew_x_khoi_vu);
        txtTrangthai = (TextView) findViewById(R.id.txtTrangthai);
    }
}