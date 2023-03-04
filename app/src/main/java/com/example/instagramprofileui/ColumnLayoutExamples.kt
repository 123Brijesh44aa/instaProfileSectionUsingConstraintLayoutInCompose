package com.example.instagramprofileui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofileui.ui.theme.golden

@Composable
fun ColumnExampleOne(){

    val scrollState  = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)){
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "First image",
            modifier = Modifier.height(300.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "The Originals",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = "Nicklaus , Elijah, Marcel, Jackson",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = "Action | Horror | Family | Fantasy",
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "IMDB 9.9", color = golden, fontWeight = FontWeight.Bold)
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun ColumnExamplePreview(){
//    ColumnExampleOne()
}