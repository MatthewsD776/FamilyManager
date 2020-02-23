package dev.darrenmatthews.etherblocks.ui.blocks;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.web3j.protocol.core.methods.response.EthBlock.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class BlocksViewModel extends ViewModel{
    private MutableLiveData<BigInteger> number;
    private MutableLiveData<String> miner;
    private MutableLiveData<BigInteger> nonce;
    private MutableLiveData<String> parent;
    private MutableLiveData<BigInteger> size;
    private MutableLiveData<BigInteger> timestamp;
    private MutableLiveData<BigInteger> difficulty;
    private MutableLiveData<List<TransactionResult>> transactions;
    private MutableLiveData<String> requestType;

    public BlocksViewModel(){
        number = new MutableLiveData<>();
        miner = new MutableLiveData<>();
        nonce = new MutableLiveData<>();
        parent = new MutableLiveData<>();
        size = new MutableLiveData<>();
        timestamp = new MutableLiveData<>();
        transactions = new MutableLiveData<>();
        difficulty = new MutableLiveData<>();
        requestType = new MutableLiveData<>();
    }

    public BlocksViewModel(Block block, String type) {
        number = new MutableLiveData<>(block.getNumber());
        miner = new MutableLiveData<>(block.getMiner());
        nonce = new MutableLiveData<>(block.getNonce());
        parent = new MutableLiveData<>(block.getParentHash());
        size = new MutableLiveData<>(block.getSize());
        timestamp = new MutableLiveData<>(block.getTimestamp());
        transactions = new MutableLiveData<>(block.getTransactions());
        difficulty = new MutableLiveData<>(block.getDifficulty());
        requestType = new MutableLiveData<>(type);
    }

    public void updateBlock(Block block, String type) {
        number.postValue(block.getNumber());
        miner.postValue(block.getMiner());
        nonce.postValue(block.getNonce());
        parent.postValue(block.getParentHash());
        size.postValue(block.getSize());
        timestamp.postValue(block.getTimestamp());
        transactions.postValue(block.getTransactions());
        difficulty.postValue(block.getDifficulty());
        requestType.postValue(type);
    }

    public LiveData<BigInteger> getNumber() {
        return number;
    }

    public LiveData<String> getMiner() {
        return miner;
    }

    public LiveData<BigInteger> getNonce() {
        return nonce;
    }

    public LiveData<String> getParent() {
        return parent;
    }

    public LiveData<BigInteger> getSize() {
        return size;
    }

    public LiveData<BigInteger> getTimestamp() {
        return timestamp;
    }

    public LiveData<BigInteger> getDifficulty() {
        return difficulty;
    }

    public LiveData<List<TransactionResult>> getTransactions() {
        return transactions;
    }

    public LiveData<String> getType() {
        return requestType;
    }
}
