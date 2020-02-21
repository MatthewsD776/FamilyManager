package dev.darrenmatthews.familymanager.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.darrenmatthews.familymanager.R;
import dev.darrenmatthews.familymanager.Web3Task;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Web3Task().execute();
    }
}
