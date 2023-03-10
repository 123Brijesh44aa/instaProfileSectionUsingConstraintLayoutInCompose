package com.example.instagramprofileui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramprofileui.ui.InstaProfileViewModel
import com.example.instagramprofileui.ui.theme.InstagramProfileUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramProfileUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    
                    /*
ButtonMotion
Column {
Spacer(modifier = Modifier.height(300.dp))
ButtonMotion()
}
*/
                    // MotionLayoutCard
//                    MotionLayoutCard(context = LocalContext.current)

                    // ProfileScreen
                    ProfileScreen(viewModel = InstaProfileViewModel(this.application))
                    
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(viewModel = InstaProfileViewModel(MainActivity().application))
}
