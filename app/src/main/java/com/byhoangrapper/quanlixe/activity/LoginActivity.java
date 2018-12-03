package com.byhoangrapper.quanlixe.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.byhoangrapper.quanlixe.R;

import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private EditText edUser, edPassword;
    private Button btLogin;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btn_login);
        tv=findViewById(R.id.link_signup);
        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(edUser.getText().toString().equals("admin") &&
                        edPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Xin Chào:  "+  edUser.getText() +  "  Ban đã đăng nhâp thành công!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplication(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sai username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nhanhnhanh.club/sign-up.php"));
                startActivity(browserIntent);
            }
        });
    }
}



