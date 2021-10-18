package com.rh.localizationapp.model

import android.app.Application
import com.rh.localizationapp.R
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

class CSVReader(val langName: String,val applicationContext: Application) {
    internal fun getValue(): String{
        val inputStream: InputStream = applicationContext.resources.openRawResource(R.raw.localization)
        val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
        reader.readLines().forEach {

            //get a string array of all items in this line
            val items = it.split(",")
            if (items[0].equals(langName,ignoreCase = true)){
                return items[1]
            }
        }
        return ""
    }
}