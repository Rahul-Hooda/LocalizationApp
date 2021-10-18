package com.rh.localizationapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rh.localizationapp.R
import com.rh.localizationapp.model.LocalizationManager

class LocalizationViewModel(application: Application): AndroidViewModel(application) {

    var helloWorldText: MutableLiveData<String> = MutableLiveData()
    val applicationContext = application

    fun updateText(langName: String, fallbackValue: String){
        if (langName.isEmpty() || fallbackValue.isEmpty())
            helloWorldText.value = applicationContext.getString(R.string.invalid_data)
        helloWorldText.value = LocalizationManager.getValue(applicationContext,langName,fallbackValue)
    }
}