package dev.darrenmatthews.familymanager;

import android.os.AsyncTask;
import android.util.Log;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class Web3Task extends AsyncTask<String, Void, String> {

    private Exception exception;

    @Override
    protected String doInBackground(String... url) {
        try {
            Web3j web3 = Web3j.build(new HttpService("http://192.168.56.1:7545"));
            Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();

            return "THIS IS THE CLIENT VERSION " + clientVersion;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    protected void onPostExecute(String version){
        if(this.exception == null) {
            Log.i("Web3 Tag", version);
        } else {
            this.exception.printStackTrace();
        }
    }
}
