package com.example.eta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.Hello;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(Hello.sayHello());
        // Build Error: class file for eta.runtime.stg.Closure not found
        // textView.setText(Integer.toString(Hello.myInt()));
        // Runtime Error: Didn't find class "eta.runtime.thunk.Ap2Upd"
    }
}
