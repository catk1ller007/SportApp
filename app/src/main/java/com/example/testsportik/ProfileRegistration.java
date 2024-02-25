package com.example.testsportik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile_registration);

        EditText text = findViewById(R.id.nameEdit);


        Button button = findViewById(R.id.btnCall);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("myTag", text.toString());
            }
        });
    }


}