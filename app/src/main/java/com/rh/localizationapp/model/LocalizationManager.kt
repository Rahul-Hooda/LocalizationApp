package com.rh.localizationapp.model

import android.app.Application

object LocalizationManager {

    fun initLocalization(){
        //TODO Perform logic to download the localization csv file here
    }

    fun getValue(applicationContext: Application, langName: String, fallbackValue: String): String{
        val csvValue: String = CSVReader(langName,applicationContext).getValue()
        return if (csvValue.isNotEmpty()) csvValue else fallbackValue
    }
}