package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mcount = 0;
    private TextView mshowCount;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mshowCount = (TextView) findViewById(R.id.shower);
    }

    public void addCount(View view) {
        mcount++;
        if (mshowCount != null){
            mshowCount.setText(Integer.toString(mcount));
        }
    }

    public void launchSecondAcitivity(View view) {
        String message = String.valueOf(mcount);
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}