package dev.darrenmatthews.etherblocks.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Gonna add some customisation here like Peer URL, Wallet file, Colour customisation etc...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}