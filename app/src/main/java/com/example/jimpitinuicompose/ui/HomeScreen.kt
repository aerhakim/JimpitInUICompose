package com.example.jimpitinuicompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jimpitinuicompose.BottomMenuContent
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
            Sampah()
            Jimpitan()

        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Transaksi", R.drawable.ic_history),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
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

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}
@Composable
fun Sampah(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .absolutePadding(left = 15.dp)
            .absolutePadding(right = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(5.dp)),
            shape = RectangleShape,
            elevation = 2.dp
        ) {
            Image(
                painterResource(R.drawable.sampah),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = "Uang Sampah",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Setiap 1 Kartu Keluarga",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
    }
}
@Composable
fun Jimpitan(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(5.dp)),
            shape = RectangleShape,
            elevation = 2.dp
        ) {
            Image(
                painterResource(R.drawable.ic_jipitan),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = "Uang Jimpitan",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Setiap Rumah",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
    }
}
@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    JimpitInTheme() {
        Box(
            modifier = Modifier
                .background(DeepBlue)
                .fillMaxSize()
        ) {
            Column {
                GreetingSection()
                Text(
                    modifier = Modifier
                        .absolutePadding(left = 15.dp)
                        .absolutePadding(bottom = 10.dp),
                    text = "Iuran",
                    style = MaterialTheme.typography.h1,
                    color = TextWhite
                )
                Sampah()
                Jimpitan()

            }
            BottomMenu(items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Transaksi", R.drawable.ic_history),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}