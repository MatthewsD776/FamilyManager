package dev.darrenmatthews.familymanager;

import android.content.Context;
import android.os.AsyncTask;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

import dev.darrenmatthews.familymanager.ui.login.OnEventListener;

public class GenerateWeb3 extends AsyncTask<Void, Void, String> {
    private Exception exception;

    private Context myContext;
    private OnEventListener<String> myCallBack;

    public GenerateWeb3(Context context, OnEventListener callback){
        this.myCallBack = callback;
        this.myContext = context;
    }

    @Override
    protected String doInBackground(Void... context) {
        try {
            Web3j web3 = Web3j.build(new HttpService("http://192.168.0.58:7545"));
            Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
            return web3ClientVersion.getWeb3ClientVersion();
        } catch (IOException e) {
            exception = e;
        }

        return null;
    }

    protected void onPostExecute(String result){
        if(this.myCallBack != null) {
            if(this.exception == null){
                myCallBack.onSuccess(result);
            } else {
                myCallBack.onFailure(exception);
            }
        }
    }
}
