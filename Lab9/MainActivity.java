package com.example.getpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner proSpinner;
    private EditText domainText;
    private String seletedPro;
    private String inputURL;
    private String pageSoucrce;
    private TextView sourceShower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proSpinner = (Spinner) findViewById(R.id.html_spinner);
        domainText = (EditText) findViewById(R.id.URLInput);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

    }

    public void getResource(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        seletedPro = proSpinner.getSelectedItem().toString();
        inputURL = domainText.getText().toString();
        String finalUrl = seletedPro+inputURL;
        System.out.println(finalUrl);
        pageSoucrce = HTMLService.getHTML(finalUrl);
        sourceShower = findViewById(R.id.textView);
        sourceShower.setText(pageSoucrce);
        sourceShower.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}