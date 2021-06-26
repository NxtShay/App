package com.example.hack.ui.Challenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChallengeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChallengeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}