package com.example.jimpitinuicompose.ui

import android.graphics.PorterDuff
import android.widget.RatingBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jimpitinuicompose.BottomMenuContent
import com.example.jimpitinuicompose.R
import com.example.jimpitinuicompose.image
import com.example.jimpitinuicompose.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            AutoSliding()
            Text(
                modifier = Modifier
                    .absolutePadding(left = 15.dp)
                    .absolutePadding(bottom = 10.dp),
                text = "Iuran",
                style = MaterialTheme.typography.h1,
                color = TextBlack
            )
            Sampah()
            Jimpitan()
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Transaksi", R.drawable.ic_history),
            BottomMenuContent("Profile", R.drawable.ic_user),
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
                style = MaterialTheme.typography.body2
            )
            Text(
                text = name,
                style = MaterialTheme.typography.h1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_notifications),
            contentDescription = "Notification",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = WhiteDark,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Gray,
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
            .background(White)
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
    color: Color = White
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .absolutePadding(left = 15.dp)
            .absolutePadding(right = 15.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(1.dp),
                clip = true
            )
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
                color = TextBlack
            )
        }
    }
}
@Composable
fun Jimpitan(
    color: Color = White
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .absolutePadding(left = 15.dp)
            .absolutePadding(right = 15.dp)
            .absolutePadding(top = 15.dp)
            .absolutePadding(bottom = 20.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(1.dp),
                clip = true
            )
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
                color = TextBlack
            )
        }
    }
}
@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = WhiteDark,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Gray,
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
                .background(White)
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
                    color = TextBlack
                )
                Sampah()
                Jimpitan()

            }
            BottomMenu(items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Transaksi", R.drawable.ic_history),
                BottomMenuContent("Profile", R.drawable.ic_user),
            ), modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}


@ExperimentalPagerApi
@Composable
fun AutoSliding() {
    val pagerState = rememberPagerState(
        pageCount = image.size,
        initialOffscreenLimit = 2
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 15.dp, 0.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                val image = image[page]
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(
                            id = when (page) {
                                1 -> R.drawable.g1
                                2 -> R.drawable.g2
                                3 -> R.drawable.g3
                                4 -> R.drawable.g4
                                5 -> R.drawable.g5
                                else -> R.drawable.g5
                            }
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .padding(25.dp)
                    ) {
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                    }

                }
            }
        }


    }
}