package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.test.helpers.UiHelpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("My_Wallet");
        setSupportActionBar(myToolbar);
        UiHelpers ui = new UiHelpers(MainActivity.this);
        Button alert = (Button) findViewById(R.id.button);
        EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty()) {
                    email.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
                    ui.alertPopup("Erro", "Preencha o campo email");
                } else if(password.getText().toString().isEmpty()) {
                    password.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
                    ui.alertPopup("Erro", "Preencha o campo senha");
                } else {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("email", email.getText().toString().toLowerCase());
                    startActivity(intent);
                    finish();
                }
            }
        });

    }






}