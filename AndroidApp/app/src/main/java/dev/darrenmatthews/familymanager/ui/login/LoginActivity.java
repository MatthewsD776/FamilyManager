package dev.darrenmatthews.familymanager.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.security.Provider;
import java.security.Security;

import dev.darrenmatthews.familymanager.R;
import dev.darrenmatthews.familymanager.GenerateWeb3;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupBouncyCastle();

        //Dont need async task to connect to web3;
        Web3j web3 = Web3j.build(new HttpService("http://192.168.0.58:7545"));

        //Connect to Web 3
        GenerateWeb3 web3Generator = new GenerateWeb3(getApplicationContext(), new OnEventListener<String>(){
            @Override
            public void onSuccess(String result) {
                Toast.makeText(getApplicationContext(), "Success: " + result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        web3Generator.execute();

    }

    private void setupBouncyCastle() {
        final Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider == null) {
            return;
        }
        if (provider.getClass().equals(BouncyCastleProvider.class)) {
            return;
        }
        Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }
}
