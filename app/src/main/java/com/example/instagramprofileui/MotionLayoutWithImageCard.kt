package com.example.instagramprofileui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MotionLayoutCard(context: Context){



    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {

        // cover image
        Image(
            painter = painterResource(id = R.drawable.castimage),
            contentScale = ContentScale.Crop,
            contentDescription = "originals",
            modifier = Modifier.layoutId("headerImage")
        )
        // back arrow button
       Icon(
           imageVector = Icons.Default.ArrowBack,
           contentDescription = null,
           modifier = Modifier
               .layoutId("backMenu")
               .background(color = Color.White, shape = RoundedCornerShape(3.dp))
               .padding(5.dp),
           tint = Color.Black,

       )
        // content background box
        Box(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                .layoutId("contentBg")
                .fillMaxHeight()
        )
        // Title
        Text(
            text = "The Originals: War of Vampires",
            color = Color.Black,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .layoutId("title")
                .fillMaxWidth()
                .padding(10.dp)
                .padding(horizontal = 16.dp)
        )
        // TitleDivider
        Divider(
            modifier = Modifier
                .layoutId("titleDivider")
                .fillMaxWidth()
                .padding(horizontal = 32.dp)

        )
        // Subtitle
        Text(
            text = "by Julie Plec",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .layoutId("subtitle")
                .fillMaxWidth()
                .padding(10.dp)
                .padding(horizontal = 16.dp)
        )
        // Subtitle Divider
        Divider(
            modifier = Modifier
                .layoutId("subtitleDivider")
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        // Date
        Text(
            text = "November 2023",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(horizontal = 16.dp)
                .layoutId("date")
        )
        // row and its buttons 
        Row(
            modifier = Modifier
                .layoutId("rowButtonActions")
                .background(color = Color.DarkGray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // first icon button
            IconButton(onClick = {  }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "share icon",
                        tint = Color.White
                    )
                    Text(
                        text = "Share",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
            // second icon button
            IconButton(onClick = {  }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Like icon",
                        tint = Color.White
                    )
                    Text(
                        text = "Like",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
            // third icon button
            IconButton(onClick = {  }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "save icon",
                        tint = Color.White
                    )
                    Text(
                        text = "Save",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
        // long text
        val scrollState = rememberScrollState()
        Text(
            text = "The Originals, a spin-off of The Vampire Diaries," +
                    " centers on three of the Mikaelson siblings: Klaus, Elijah, and Rebekah." +
                    " The Mikaelson family are also commonly known as \"the Originals\" due to the fact " +
                    "that they are the first vampires ever to exist." +
                    " Klaus is the son of a witch and a werewolf, " +
                    "and his quest to unleash his hybrid nature was detailed in The Vampire Diaries. " +
                    "The backdoor pilot, \"The Originals\", which aired on April 25, 2013, " +
                    "also revealed that the werewolf Hayley, " +
                    "with whom Klaus had a drunken one-night stand in season 4 of The Vampire Diaries, " +
                    "is pregnant with his child the first ever tribrid. " +
                    "Elijah, Klaus, Rebekah and Hayley are all introduced in The Vampire" +
                    " Diaries as part of main or recurring cast from season 3 or 4 unlike" +
                    " the other cast of The Originals who are not introduced until the" +
                    " backdoor pilot or later on in the series. The series begins with the Mikaelson siblings returning" +
                    " to the city of New Orleans for the first time since 1919, " +
                    "where a pregnant Hayley has also settled and is under capture by the witches" +
                    " who use her to manipulate Klaus into helping them against Marcel's iron fist. " +
                    "Having originally built the French Quarter, they had been forced to abandon it" +
                    " when fleeing from their vengeful father, Mikael, who wished to kill them all" +
                    " and end the vampire species which he viewed as unnatural and evil. " +
                    "In their absence, Klaus's former protégé and adoptive son and Rebekah's former lover," +
                    " Marcel, took charge of the French Quarter as self-proclaimed king. " +
                    "Klaus resolves that they must take down Marcel and get back the city that" +
                    " once belonged to them while protecting their city from a war brewing between vampires," +
                    " werewolves, and witches.",
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(bottom = 10.dp)
                .layoutId("longText"),
            fontSize = 15.sp
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun MotionLayoutCardPreview(){
    MotionLayoutCard(context = LocalContext.current)
}
