package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun MovieScreen(){
    Surface(
        color = Color.White
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val(menuButton, coverImage, titleText, genreText, ratingText,
            castText,castImage1, castImage2, castImage3, castImage4,
            descText, bottomSurface, bookButton, cinemaNameContainer,) = createRefs()

            val startGuideline = createGuidelineFromStart(16.dp)
            
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .constrainAs(menuButton) {
                        start.linkTo(startGuideline)
                        top.linkTo(parent.top, 16.dp)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.brijesh),
                contentDescription = "cover image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(coverImage){
                        start.linkTo(startGuideline)
                        top.linkTo(menuButton.bottom, 20.dp)
                        end.linkTo(titleText.start, 10.dp)
                    }.aspectRatio(2f / 3f)
            )

            Text(
                text = "The Originals",
                style = TextStyle(color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.constrainAs(titleText){
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(coverImage.top)
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieScreenPreview(){
    MovieScreen()
}