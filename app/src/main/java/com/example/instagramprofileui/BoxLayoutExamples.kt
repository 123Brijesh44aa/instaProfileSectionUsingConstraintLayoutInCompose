package com.example.instagramprofileui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxLayoutExample(){
    Box(
//        contentAlignment = Alignment.CenterEnd
    modifier = Modifier.size(height = 90.dp, width = 290.dp)

    ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter", Modifier.align(Alignment.TopCenter))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter", Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun TextCell(
    text: String
){
    // to give the textCell an opaque background, we need to call the text composable from within
    // a Surface Component, when the preview is updated, only the last composable to be called by
    // the box will be visible because it is the uppermost child of the stack.
    Surface {
        Text(
            text = text,
            modifier = Modifier
                .padding(4.dp)
                .border(width = 2.dp, color = Color.Black)
                .padding(8.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun BoxPreview(){
    BoxLayoutExample()
}
