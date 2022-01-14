package com.example.jimpitinuicompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jimpitinuicompose.model.Agenda
import com.example.jimpitinuicompose.ui.theme.TextBlack
import com.example.jimpitinuicompose.ui.theme.poppins


@Composable
fun AgendaCard(
    item: Agenda
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        modifier = Modifier
            .size(350.dp, 220.dp)
            .absolutePadding(left = 15.dp)
    ) {
        Box {
            Image(
                painter = painterResource(item.image),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp)
            ) {
                DifficultySurface(item.category)
                ShortInfoSurface(
                    title = item.title,
                    time = item.time,
                    date = item.date
                )
            }
        }
    }
}

@Composable
fun DifficultySurface(level: String) {
    Surface(
        shape = CircleShape,
        color = Color.Gray.copy(0.7f),
        modifier = Modifier
            .widthIn(20.dp, 100.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = level,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontFamily = poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp)
        )
    }
}

@Composable
fun ShortInfoSurface(
    title: String,
    date: String,
    time: String
) {
    Surface(
        color = TextBlack.copy(0.7f),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)) {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$date | $time",
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = poppins
            )
        }
    }
}



