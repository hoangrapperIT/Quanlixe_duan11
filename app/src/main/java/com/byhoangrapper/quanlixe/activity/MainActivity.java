package com.byhoangrapper.quanlixe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.byhoangrapper.quanlixe.R;

public class MainActivity extends AppCompatActivity {
private Button btDanhsach,btThem,btThongtin,btAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btDanhsach=findViewById(R.id.btDanhsachxe);
        btThem=findViewById(R.id.btThem);
        btThongtin=findViewById(R.id.btThongtin);

        btAccount=findViewById(R.id.btAccount);
        btDanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btDanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ds =new Intent(getApplication(),DanhsachActivity.class);
                startActivity(ds);
            }
        });
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent them =new Intent(getApplication(),AddActivity.class);
                startActivity(them);
            }
        });
        btThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    Intent tt = new Intent(getApplication(),Thongtinactivity.class);
    startActivity(tt);
            }
        });

        btAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    Intent doimk = new Intent(getApplication(),DoimkActivity.class);
    startActivity(doimk);
            }
        });

    }
}
