package dev.darrenmatthews.etherblocks.ui.account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AccountViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Add information about which wallet is being used and ether stats like amount of transactions sent");
    }

    public LiveData<String> getText() {
        return mText;
    }
}