package dev.darrenmatthews.familymanager.app.main;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.reactivestreams.Subscription;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.websocket.WebSocketService;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Provider;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import dev.darrenmatthews.familymanager.R;
import dev.darrenmatthews.familymanager.app.async.GenerateWeb3;
import dev.darrenmatthews.familymanager.app.async.OnEventListener;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private Web3j web3;
    private Disposable web3Subscription;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupBouncyCastle();
        unsafeThreadPolicy();

        String peerUrl = "wss://mainnet.infura.io/ws/v3/73ac281be9e54b2a85353e2aea8f9629";

        //Dont need async task to connect to web3;
        web3 = null;
        try {
            WebSocketService web3jService = new WebSocketService(peerUrl, true);
            web3jService.connect();

            web3 = Web3j.build(web3jService);
            Web3ClientVersion version = web3.web3ClientVersion().sendAsync().get();

            if(!version.hasError()){
                Toast.makeText(getApplicationContext(), "Connection Success", Toast.LENGTH_LONG).show();
                Log.i("Web3", peerUrl);
                Block block = web3.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send().getBlock();
                visualiseBlock(block);
            } else {
                Toast.makeText(getApplicationContext(), "Connection Failure", Toast.LENGTH_LONG).show();
                Log.i("Web3", version.getError().getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(web3 != null) {
            Disposable web3subscription = web3.blockFlowable(false).subscribe(
                    ethBlock -> {
                        Log.i("Web3", "Got new Block");
                        Block block = ethBlock.getBlock();
                        visualiseBlock(block);
                    },
                    Throwable::printStackTrace
            );
        }

        //Connect to Web 3 via Async Thing
        /*
        GenerateWeb3 web3Generator = new GenerateWeb3(getApplicationContext(), new OnEventListener<Web3j>(){
            @Override
            public void onSuccess(Web3j web3) {
                Toast.makeText(getApplicationContext(), "Successfully Connected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        web3Generator.execute();
        */
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == 1){
            Toast.makeText(getApplicationContext(), "Ouch!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        web3Subscription.dispose();
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void visualiseBlock(Block block){
        BigInteger bNumber = block.getNumber();
        String bMiner = block.getMiner();
        BigInteger bNonce = block.getNonce();
        String bParent = block.getParentHash();
        BigInteger bSize = block.getSize();

        long millis = block.getTimestamp().longValue();
        Instant instant = Instant.ofEpochSecond(millis);
        Date date = Date.from(instant);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a (dd-MM-yyyy)", Locale.getDefault());
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String bTime = format.format(date);

        int bTransactions = block.getTransactions().size();
        BigInteger bDifficulty = block.getDifficulty();

        runOnUiThread(() -> {
            ((TextView) findViewById(R.id.blockDifficulty)).setText(bDifficulty.toString());
            ((TextView) findViewById(R.id.blockMiner)).setText(bMiner);
            ((TextView) findViewById(R.id.blockNonce)).setText(bNonce.toString());
            ((TextView) findViewById(R.id.blockNumber)).setText(bNumber.toString());
            ((TextView) findViewById(R.id.blockParent)).setText(bParent);
            ((TextView) findViewById(R.id.blockSize)).setText(bSize.toString() + " bytes");
            ((TextView) findViewById(R.id.blockTimestamp)).setText(bTime);
            ((TextView) findViewById(R.id.blockTransactions)).setText(String.valueOf(bTransactions));
        });
    }

    private void unsafeThreadPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
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
