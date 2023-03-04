package com.example.instagramprofileui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.instagramprofileui.LazyVerticalGridExample

@Composable
fun IgtvScreen(viewModel: InstaProfileViewModel){

    var isSwipeToTheLeft by remember {
        mutableStateOf(false)
    }
    val dragState = rememberDraggableState(onDelta = { delta ->
        isSwipeToTheLeft = delta > 0
    })

    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .draggable(
                state = dragState,
                orientation = Orientation.Horizontal,
                onDragStarted = { },
                onDragStopped = {
                    viewModel.updateTabIndexBasedOnSwipe(isSwipeToTheLeft = isSwipeToTheLeft)
                }
            )
    ) {
        val (text) = createRefs()

        Text(
            text = "IGTV Section",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .constrainAs(text){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}