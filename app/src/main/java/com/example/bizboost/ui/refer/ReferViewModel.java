package com.example.bizboost.ui.refer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReferViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReferViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Refer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}