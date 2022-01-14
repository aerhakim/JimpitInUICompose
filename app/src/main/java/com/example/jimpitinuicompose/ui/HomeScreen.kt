package com.example.jimpitinuicompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jimpitinuicompose.ui.theme.*
import com.example.jimpitinuicompose.R


@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()

        }
    }
}


@Composable
fun GreetingSection(
    name: String = "AR Hakim"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Halo,",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = name,
                style = MaterialTheme.typography.h2
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_notifications),
            contentDescription = "Notification",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JimpitInTheme() {
        GreetingSection()
    }
}