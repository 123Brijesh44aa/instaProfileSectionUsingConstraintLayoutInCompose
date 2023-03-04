package com.example.instagramprofileui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.instagramprofileui.LazyVerticalGridExample
import com.example.instagramprofileui.ui.theme.golden

@Composable
fun HomeScreen(viewModel: InstaProfileViewModel){

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
        val (text, lazyVerticalGrid) = createRefs()

        LazyVerticalGridExample(
            modifier = Modifier
                .constrainAs(lazyVerticalGrid){
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            list = images
        )
    }
}