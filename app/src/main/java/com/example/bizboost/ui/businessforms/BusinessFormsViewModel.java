package com.example.bizboost.ui.businessforms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BusinessFormsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BusinessFormsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Business Forms fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}