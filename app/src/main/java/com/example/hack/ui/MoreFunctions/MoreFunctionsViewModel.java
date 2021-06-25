package com.example.hack.ui.MoreFunctions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoreFunctionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoreFunctionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("More functions are coming...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}