package com.cmf.grupof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText E1;
    Button B1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E1 = (EditText) findViewById(R.id.et);
        B1 = (Button) findViewById(R.id.btn);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                if (E1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Escriba una url...", Toast.LENGTH_SHORT).show();
                }else{
                    i.setData(Uri.parse("https://" + E1.getText().toString()));
                    if (i.resolveActivity(getPackageManager()) != null) {
                        startActivity(i);
                    };
                }
            };

        });
    }
}
