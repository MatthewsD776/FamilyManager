package dev.darrenmatthews.etherblocks;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.websocket.WebSocketService;

import java.io.IOException;

import dev.darrenmatthews.etherblocks.ui.blocks.BlocksViewModel;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private BlocksViewModel blocksViewModel;
    private Web3j web3;
    private Disposable web3Subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectToWeb3("wss://mainnet.infura.io/ws/v3/73ac281be9e54b2a85353e2aea8f9629");
        blocksViewModel = new BlocksViewModel();
        if(web3 != null){
            createLatestBlockSubscription();
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_account, R.id.navigation_blocks, R.id.navigation_settings).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    public BlocksViewModel getBlocksViewModel() {
        return blocksViewModel;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == 1){
            Toast.makeText(getApplicationContext(), "Ouch!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public void displayGenesisBlock() {
        //Stop the subscription
        if(web3Subscription != null && !web3Subscription.isDisposed()){
            web3Subscription.dispose();
        }

        try {
            EthBlock.Block block = web3.ethGetBlockByNumber(DefaultBlockParameterName.EARLIEST, false).send().getBlock();
            blocksViewModel.updateBlock(block, "Genesis");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createLatestBlockSubscription() {
        if(web3Subscription == null || web3Subscription.isDisposed()){
            try {
                EthBlock.Block ethblock = web3.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send().getBlock();
                blocksViewModel.updateBlock(ethblock, "Latest");
            } catch (IOException e){
                Log.e("Web3", e.getMessage());
            }

            web3Subscription = web3.blockFlowable(false).subscribe(
                    ethBlock -> {
                        Log.i("Web3", "Got new Block");
                        blocksViewModel.updateBlock(ethBlock.getBlock(), "Latest");
                    },
                    Throwable::printStackTrace
            );
        }
    }

    private void connectToWeb3(String peerUrl) {
        web3 = null;
        try {
            WebSocketService web3jService = new WebSocketService(peerUrl, true);
            web3jService.connect();

            web3 = Web3j.build(web3jService);
            Web3ClientVersion version = web3.web3ClientVersion().sendAsync().get();

            if(!version.hasError()){
                Toast.makeText(getApplicationContext(), "Connection Success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Connection Failure", Toast.LENGTH_LONG).show();
                Log.i("Web3", version.getError().getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
