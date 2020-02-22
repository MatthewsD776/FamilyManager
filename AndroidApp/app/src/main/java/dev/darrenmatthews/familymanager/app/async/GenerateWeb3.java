package dev.darrenmatthews.familymanager.app.async;

import android.content.Context;
import android.os.AsyncTask;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

import dev.darrenmatthews.familymanager.app.async.OnEventListener;

public class GenerateWeb3 extends AsyncTask<Void, Void, Web3j> {
    private Exception exception;

    private Context myContext;
    private OnEventListener<Web3j> myCallBack;

    public GenerateWeb3(Context context, OnEventListener callback){
        this.myCallBack = callback;
        this.myContext = context;
    }

    @Override
    protected Web3j doInBackground(Void... context) {
        return Web3j.build(new HttpService("https://mainnet.infura.io/v3/73ac281be9e54b2a85353e2aea8f9629"));
    }

    protected void onPostExecute(Web3j result){
        if(this.myCallBack != null) {
            if(this.exception == null){
                myCallBack.onSuccess(result);
            } else {
                myCallBack.onFailure(exception);
            }
        }
    }
}
