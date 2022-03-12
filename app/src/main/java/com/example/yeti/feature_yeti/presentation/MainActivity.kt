package com.example.yeti.feature_yeti.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.yeti.R
import com.example.yeti.feature_yeti.domain.model.Player
import com.example.yeti.ui.theme.YetiTheme
import org.koin.androidx.compose.getViewModel
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YetiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    YetiScreen()
                }
            }
        }
    }
}

@Composable
fun YetiScreen() {
    val viewModel: GameViewModel by getViewModel()
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Box(
        Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    var side = (screenWidth - it.x) > 0f
                    if (side) {
                        offsetX -= 10f
                        offsetY += 10f
                    } else {
                        offsetX += 10f
                        offsetY += 10f
                    }
                }
            },
    contentAlignment = Alignment.TopCenter){

        Image(painter = painterResource(id = R.drawable.yeti_background), contentDescription = "background" )
        PlayerBox(offsetX = offsetX-200f, offsetY = offsetY, Color.Green)
        PlayerBox(offsetX = offsetX + 200f, offsetY = offsetY, Color.Red)
    }
    LaunchedEffect(Unit){
        viewModel.startUpdate()
    }

}
@Composable
fun PlayerBox(offsetX: Float, offsetY: Float, color: Color){
    Box(Modifier
        .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
        .background(color)
        .size(50.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YetiTheme {
        YetiScreen()
    }
}