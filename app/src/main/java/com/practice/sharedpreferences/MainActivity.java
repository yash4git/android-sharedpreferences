package com.practice.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE = "messages" ;
    private Button button;
    private EditText editText;
    private TextView text_view;
    private SharedPreferences mPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        text_view = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString().trim();
                mPreference = getSharedPreferences(MESSAGE, MODE_PRIVATE );
                SharedPreferences.Editor editor = mPreference.edit();
                editor.putString("message",text);
                editor.apply();




            }
        });

        SharedPreferences getPreference = getSharedPreferences(MESSAGE , MODE_PRIVATE);
        String saved_text =  getPreference.getString("message","Not Found");
        text_view.setText(saved_text);
    }
}