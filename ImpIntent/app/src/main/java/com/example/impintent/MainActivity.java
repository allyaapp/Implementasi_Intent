package com.example.impintent;

import androidx.appcompat.app.AppCompatActivity;
import static android.icu.lang.UProperty.NAME;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //untuk deklarasi
    Button button;
    EditText editText;
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //untuk inisiasid dari deklarasi
        button = findViewById(R.id.button);
        editText =  findViewById(R.id.editText);
        //berikan aksi pada button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        //untuk inisiasid dari deklarasi
        name = (EditText) findViewById(R.id.editNama);
        btnSend = (Button) findViewById(R.id.buttonsubmit);
        //berikan aksi pada button send
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            //menyesuaikan dengan name yang dimasukkan
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    if (nama != ""){
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplication(), "SILAHKAN ISIKAN NAMA ANDA",Toast.LENGTH_SHORT);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, COBA LAGI !",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}