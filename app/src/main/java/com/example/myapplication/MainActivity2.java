package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.app.Activity;



    public class MainActivity2 extends AppCompatActivity {

        private Button share_btn = findViewById(R.id.Share);
        private Button calculator_btn;
        private TextView result_save;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            calculator_btn = findViewById(R.id.Сalculator);
            result_save = findViewById(R.id.result_field);

            share_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (share_btn.getText().toString() != null){
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,result_save.getText().toString());
                        intent.setType("text/plain");
                        startActivity(intent);
                    }
                }
            });

            calculator_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivityForResult(intent, 1);
                }
            });

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK && data != null);
            result_save.setText(data.getStringExtra("result"));
        }
}
