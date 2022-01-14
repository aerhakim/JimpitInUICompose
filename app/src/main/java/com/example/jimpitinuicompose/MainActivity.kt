package com.example.jimpitinuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jimpitinuicompose.ui.HomeScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.jimpitinuicompose.ui.theme.JimpitInTheme

class MainActivity : ComponentActivity() {
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