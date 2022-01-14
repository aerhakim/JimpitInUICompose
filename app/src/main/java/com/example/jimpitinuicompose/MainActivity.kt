package com.example.jimpitinuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jimpitinuicompose.ui.HomeScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.jimpitinuicompose.ui.theme.JimpitInTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JimpitInTheme() {
                HomeScreen()
            }
        }
    }
}