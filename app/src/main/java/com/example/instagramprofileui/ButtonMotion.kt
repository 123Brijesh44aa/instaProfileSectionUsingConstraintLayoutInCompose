package com.example.instagramprofileui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ButtonMotion(){

    var animateButton by remember {
        mutableStateOf(false)
    }

    val animationProgress by animateFloatAsState(
        targetValue = if (animateButton) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    MotionLayout(
        ConstraintSet(
            """{
                button1: {
                 width: 100,
                 height: 60,
                start: ['parent', 'start', 16],
                end: ['button2','start', 8]
                },
                button2: {
                width: 100,
                height: 60,
                start: ['button1', 'end', 8],
                end: ['button3','start', 8]
                },
                button3: {
                width: 100,
                height: 60,
                start: ['button2', 'end', 16],
                end: ['parent','end', 16]
                }
                }"""
        ),
        ConstraintSet(
            """{
                button1: {
                width: 'spread',
                height: 60,
                start: ['parent','start', 16],
                end: ['parent','end', 16],
                top: ['parent','top', 16]
                },
                button2: {
                width: 'spread',
                height: 60,
                start: ['parent','start', 16],
                end: ['parent','end', 16],
                top: ['button1','bottom', 16]
                },
                button3: {
                width: 'spread',
                height: 60,
                start: ['parent','start', 16],
                end: ['parent','end', 16],
                top: ['button2','bottom', 16]
                }
                }"""
        ),
        progress = animationProgress,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        // button1
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button1")
        )
        {
          Text(
              text = "Button1"
          )
        }

        // button2
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button2")
        )
        {
            Text(
                text = "Button2"
            )
        }

        // button3
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button3")
        )
        {
            Text(
                text = "Button3"
            )
        }
    }

}