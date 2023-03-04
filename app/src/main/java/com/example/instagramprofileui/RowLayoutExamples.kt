package com.example.instagramprofileui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowExampleOne(){

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        OneRowItem(image = painterResource(id = R.drawable.image))
        OneRowItem(image = painterResource(id = R.drawable.and))
        OneRowItem(image = painterResource(id = R.drawable.third))
        OneRowItem(image = painterResource(id = R.drawable.forth))
        OneRowItem(image = painterResource(id = R.drawable.fifth))
        OneRowItem(image = painterResource(id = R.drawable.sixth))
        OneRowItem(image = painterResource(id = R.drawable.kotlin_icon))
        OneRowItem(image = painterResource(id = R.drawable.discord))
        OneRowItem(image = painterResource(id = R.drawable.youtube))
        OneRowItem(image = painterResource(id = R.drawable.telegram))

    }
}

@Composable
fun OneRowItem(image: Painter){
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .border(2.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
            .background(Color.DarkGray),
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.width(5.dp))
}

@Preview(showSystemUi = true)
@Composable
fun RowExamplePreview(){
    RowExampleOne()
}