package com.rh.localizationapp.viewModel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.rh.localizationapp.R
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(DataProviderRunner::class)
class LocalizationViewModelTest {

    @InjectMocks
    private var viewModel: LocalizationViewModel? = null

    @Mock
    private lateinit var context: Application

    /**
     * Behind the scenes, this bypasses the main thread check, and immediately runs any tasks on your test thread,
     * allowing for immediate and predictable calls and therefore assertions.
     * */
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        //This will initialize the annotated mocks
        MockitoAnnotations.openMocks(this);
    }

    @After
    fun tearDown() {
    }

    @Test
    @UseDataProvider(location = [LocalizationViewModelTestData::class], value = "updateTextTestData")
    fun updateText(langName: String, fallbackValue: String, expectedValue: String) {
        Mockito.`when`(context.getString(R.string.invalid_data)).thenReturn("Invalid Data")
        viewModel?.updateText(langName,fallbackValue)
        viewModel!!.helloWorldText
            .test()
            .assertValue(expectedValue)
    }
}