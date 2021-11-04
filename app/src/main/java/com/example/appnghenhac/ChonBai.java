package com.example.appnghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ChonBai extends AppCompatActivity implements View.OnClickListener {
    TextView txtId, txtBai1, txtBai2, txtBai3, txtBai4, txtBai5, txtBai6, btnChon;
    int bai = 0;
    String ten = "";
    ArrayList<String> listBai = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_bai);
        getView();
        listBai.add("Ái Nộ - Masew x Khôi Vũ");
        listBai.add("All falls down - Alan Walker");
        listBai.add("Exs hate me - AMEE x Bray x Masew");
        listBai.add("Lạc - Rhymastic");
        listBai.add("MBB - Fell Good");
        listBai.add("Nụ Cười - Rhymastic");
        //getIdBai();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtBai1:
                txtId.setText("1");
                bai = R.raw.ai_no_masew_x_khoi_vu;
                ten = listBai.get(0);
                break;
            case R.id.txtBai2:
                txtId.setText("2");
                bai = R.raw.all_falls_down_alan_walker;
                ten = listBai.get(1);
                break;
            case R.id.txtBai3:
                txtId.setText("3");
                bai = R.raw.exs_hate_me_amee_x_b_ray_masew;
                ten = listBai.get(2);
                break;
            case R.id.txtBai4:
                txtId.setText("4");
                bai = R.raw.lac_rhymastic;
                ten = listBai.get(3);
                break;
            case R.id.txtBai5:
                txtId.setText("5");
                bai = R.raw.mbb_feel_good;
                ten = listBai.get(4);
                break;
            case R.id.txtBai6:
                txtId.setText("6");
                bai = R.raw.nu_cuoi_rhymastic_official;
                ten = listBai.get(5);
                break;
            case R.id.btnChon:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("idBai", txtId.getText());
                intent.putExtra("ten", ten);
                intent.putExtra("khoa", bai);
                startActivity(intent);
                break;
        }
    }

    private void getView() {
        txtId = (TextView) findViewById(R.id.txtId);
        txtBai1 = (TextView) findViewById(R.id.txtBai1);
        txtBai2 = (TextView) findViewById(R.id.txtBai2);
        txtBai3 = (TextView) findViewById(R.id.txtBai3);
        txtBai4 = (TextView) findViewById(R.id.txtBai4);
        txtBai5 = (TextView) findViewById(R.id.txtBai5);
        txtBai6 = (TextView) findViewById(R.id.txtBai6);
        btnChon = (TextView) findViewById(R.id.btnChon);
        txtBai1.setOnClickListener(this);
        txtBai2.setOnClickListener(this);
        txtBai3.setOnClickListener(this);
        txtBai4.setOnClickListener(this);
        txtBai5.setOnClickListener(this);
        txtBai6.setOnClickListener(this);
        btnChon.setOnClickListener(this);
    }
}