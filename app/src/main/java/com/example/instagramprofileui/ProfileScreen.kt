package com.example.instagramprofileui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.instagramprofileui.ui.*
import com.example.instagramprofileui.ui.theme.gray
import com.example.instagramprofileui.ui.theme.gray2
import com.example.instagramprofileui.ui.theme.linkColor


@Composable
fun ProfileScreen(viewModel: InstaProfileViewModel){
    ConstraintLayout {

        val (topAppBar, userName, dropDownIcon, createPostIcon, menuIcon) = createRefs()

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topAppBar) {
                    width = Dimension.fillToConstraints
                    height = Dimension.value(56.dp)
                    start.linkTo(parent.start, 0.dp)
                    end.linkTo(parent.end, 0.dp)
                    top.linkTo(parent.top, 0.dp)
                },
            backgroundColor = Color.White,
            elevation = 0.6.dp
        ) {}

        Text(
            text = "brijesh.d3v",
            modifier = Modifier
                .constrainAs(userName) {
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    start.linkTo(topAppBar.start, 16.dp)
                    top.linkTo(topAppBar.top, 8.dp)
                    bottom.linkTo(topAppBar.bottom, 8.dp)
                },
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "drop down icon",
            tint = Color.DarkGray,
            modifier = Modifier
                .constrainAs(dropDownIcon) {
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    start.linkTo(userName.end, 3.dp)
                    top.linkTo(userName.top, 0.dp)
                    bottom.linkTo(userName.bottom, 0.dp)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.add_square_svgrepo_com),
            contentDescription = "insta create icon",
            tint = Color.Black,
            modifier = Modifier
                .constrainAs(createPostIcon) {
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                    top.linkTo(topAppBar.top, 8.dp)
                    bottom.linkTo(topAppBar.bottom, 8.dp)
                    end.linkTo(menuIcon.start, 16.dp)
                }
        )

        Icon(
            painter = painterResource(id = R.drawable.burger_menu_svgrepo_com),
            contentDescription = "menu icon",
            tint = Color.Black,
            modifier = Modifier
                .constrainAs(menuIcon) {
                    width = Dimension.value(24.dp)
                    height = Dimension.value(24.dp)
                    end.linkTo(topAppBar.end, 16.dp)
                    top.linkTo(topAppBar.top, 8.dp)
                    bottom.linkTo(topAppBar.bottom, 8.dp)
                }
        )

        val horizontalTopGuide = createGuidelineFromTop(60.dp)
        val verticalStartGuide = createGuidelineFromStart(16.dp)

        val (profleImage, rowContent) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.brijesh),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(profleImage) {
                    width = Dimension.value(80.dp)
                    height = Dimension.value(80.dp)
                    start.linkTo(verticalStartGuide)
                    top.linkTo(horizontalTopGuide)
                }
                .border(color = Color.Gray, shape = CircleShape, width = 0.7.dp)
                .clip(CircleShape)
                .background(color = Color.Black)
                .padding(0.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .constrainAs(rowContent) {
                    width = Dimension.fillToConstraints
                    height = Dimension.value(70.dp)
                    start.linkTo(profleImage.end, 20.dp)
                    top.linkTo(horizontalTopGuide)
                    end.linkTo(parent.end, 16.dp)
                }
//                .border(width = 1.dp, color = Color.Black)
//                .padding(8.dp)
        ) {
            EachRowCell(cellTitle = "Posts", cellValue = "547")
            EachRowCell(cellTitle = "Followers", cellValue = "220K")
            EachRowCell(cellTitle = "Following", cellValue = "345")
        }

        val (columnNameInterestBio) = createRefs()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
//                .border(color = Color.Black, width = 1.dp)
                .constrainAs(columnNameInterestBio) {
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    start.linkTo(verticalStartGuide)
                    top.linkTo(profleImage.bottom, 2.dp)
                }
                .padding(end = 0.dp) // margin
                .padding(end = 16.dp) /// padding

        ) {
            Text(
                text = "brijesh | code | design | programming",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Science, technology and engineering",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = gray
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB android\n" +
                        "\uD83D\uDCDA coding\n" +
                        "\uD83D\uDD30 design",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "https://github.com/123Brijesh44aa",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = linkColor
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(   //Followed by philipplackner_official, miakhalifa and 21 others hello
                text = buildAnnotatedString {
                        append("Followed by ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ){
                        append("philipplackner_official, miakhalifa ")
                    }
                    append("and ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ){
                        append("21 others")
                    }
                },
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
            )
        }

        val (professionsDashboard, editProfile, shareProfile) = createRefs()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .constrainAs(professionsDashboard) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    start.linkTo(verticalStartGuide)
                    top.linkTo(columnNameInterestBio.bottom, 14.dp)
                    end.linkTo(parent.end, 16.dp)
                }
                .padding(0.dp) // margin  = 0dp
                .background(color = gray2, shape = RoundedCornerShape(5.dp))
                .clickable { }
                .padding(16.dp)  // padding = 16dp
        ) {
            Text(
                text = "Professional dashboard",
                fontWeight = FontWeight.Black,
                fontSize = 14.sp,
            )
            Text(
                text = "675 accounts reached in the last 30 days",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = gray
            )
        }

        Text(
            text = "Edit Profile",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(editProfile) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    start.linkTo(verticalStartGuide)
                    top.linkTo(professionsDashboard.bottom, 8.dp)
                    end.linkTo(shareProfile.start, 4.dp)
                }
                .clickable { }
                .background(color = gray2, shape = RoundedCornerShape(8.dp))
                .padding(vertical = 6.dp)
        )

        Text(
            text = "Share profile",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(shareProfile) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(professionsDashboard.bottom, 8.dp)
                    start.linkTo(editProfile.end, 4.dp)
                }
                .clickable { }
                .background(color = gray2, shape = RoundedCornerShape(8.dp))
                .padding(vertical = 6.dp)
        )

        val (storyHighlight, arrowUpIcon, storyText, stories) = createRefs()

        Text(
            text = "Story Highlights",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier
                .constrainAs(storyHighlight){
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    top.linkTo(editProfile.bottom, 8.dp)
                    start.linkTo(verticalStartGuide)
                }
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = "arrow up",
            tint = gray,
            modifier = Modifier
                .constrainAs(arrowUpIcon){
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    top.linkTo(shareProfile.bottom, 8.dp)
                    end.linkTo(shareProfile.end)
                }
        )

        Text(
            text = "Keep your favourite stories on your profile",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .constrainAs(storyText){
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                    start.linkTo(storyHighlight.start)
                    top.linkTo(storyHighlight.bottom, 4.dp)
                }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .constrainAs(stories) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    start.linkTo(parent.start, 8.dp)
                    top.linkTo(storyText.bottom, 4.dp)
                    end.linkTo(parent.end, 8.dp)
                }
                .horizontalScroll(rememberScrollState())
//                .border(width = 1.dp, color = Color.Black)
        ) {
            FavouriteStory(
                painter = painterResource(id = R.drawable.first),
                storyTitle = "code",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.kotlin_icon),
                storyTitle = "icons",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.castimage),
                storyTitle = "poster",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.fifth),
                storyTitle = "codes",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.sixth),
                storyTitle = "code file",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.forth),
                storyTitle = "image",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.post_thumbnail),
                storyTitle = "util",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
            FavouriteStory(
                painter = painterResource(id = R.drawable.second),
                storyTitle = "component",
                borderWidth = 1.dp,
                bgColor = Color.Gray
            )
        }

        val (rowTab, tabContainer) = createRefs()

//        var tabIndex by remember {
//            mutableStateOf(0)
//        }

        val tabIndex = viewModel.tabIndex.observeAsState()

        val tabs = listOf("Posts", "Reels", "Igtv", "Tags")

        TabRow(
            selectedTabIndex = tabIndex.value!!,
            backgroundColor = Color.White,
            modifier = Modifier
                .constrainAs(rowTab){
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(stories.bottom, 8.dp)
                },
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(it[tabIndex.value!!]),
                    color = Color(0xFF000000),
                    height = 1.dp
                )
            }
        ) {
            viewModel.tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title)},
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                    selected = tabIndex.value!! == index,
                    onClick = { viewModel.updateTabIndex(index) },
                    icon = {
                        when(index){
                            0 -> Icon(
                                painter = painterResource(id = R.drawable.insta_posts),
                                tint = if (tabIndex.value!! == 0) Color.Black else Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 30.dp, height = 30.dp)
                            )
                            1 -> Icon(
                                painter = painterResource(id = R.drawable.insta_video_reel),
                                tint = if (tabIndex.value!! == 1) Color.Black else Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 30.dp, height = 30.dp)
                            )
                            2 -> Icon(
                                painter = painterResource(id = R.drawable.insta_igtv),
                                tint = if (tabIndex.value!! == 2) Color.Black else Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 30.dp, height = 30.dp)
                            )
                            3 -> Icon(
                                painter = painterResource(id = R.drawable.insta_tags),
                                tint = if (tabIndex.value!! == 3) Color.Black else Color.Gray,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 30.dp, height = 30.dp)
                            )
                        }
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .constrainAs(tabContainer) {
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(rowTab.bottom)
                    bottom.linkTo(parent.bottom)
                }

        ) {

            when(tabIndex.value!!){
                0 -> HomeScreen(viewModel = viewModel)
                1 -> ReelsScreen(viewModel = viewModel)
                2 -> IgtvScreen(viewModel = viewModel)
                3 -> TagsScreen(viewModel = viewModel)
            }
            
        }

    }
}

// Each Row Cell Content
@Composable
fun EachRowCell(cellTitle: String, cellValue: String){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = cellValue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Text(
            text = cellTitle,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

// Favourite Story
@Composable
fun FavouriteStory(painter: Painter , storyTitle: String, borderWidth: Dp, bgColor: Color){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 6.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 70.dp, height = 70.dp)
                .border(width = borderWidth, color = gray, shape = CircleShape)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = storyTitle,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
        )
    }
}















