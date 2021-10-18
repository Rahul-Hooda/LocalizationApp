package com.rh.localizationapp.viewModel

import com.tngtech.java.junit.dataprovider.DataProvider

class LocalizationViewModelTestData {
    companion object {
        @DataProvider
        @JvmStatic
        fun updateTextTestData(): Array<Array<Any>> {
            return arrayOf(
                arrayOf<Any>("","","Invalid Data"),
                arrayOf<Any>("Chinese","","Invalid Data"),
                arrayOf<Any>("","Hello World","Invalid Data"),
                arrayOf<Any>("Hindi","नमस्ते दुनिया","नमस्ते दुनिया")
                )
        }
    }
}