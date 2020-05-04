package com.delevry.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

     //   Button btn1 =findViewById(R.id.btn_chatbot);
        Button btn2 =findViewById(R.id.welcome_show_restaurants_btn);
/*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcom.this, ChatBot.class);
                startActivity(intent);
            }
        });

*/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcom.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
