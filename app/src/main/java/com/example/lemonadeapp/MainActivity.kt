package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeAppWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeAppWithButtonAndImage(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(counter) {
            1 -> ImageAndTextLayout(
                inputText = stringResource(id = R.string.tap_to_select),
                image = painterResource(id = R.drawable.lemon_tree),
                description = stringResource(id = R.string.tree_description),
                onClick = {
                    counter = 2
                })
 
            2 -> ImageAndTextLayout(
                inputText = stringResource(id = R.string.tap_to_squeeze),
                image = painterResource(id = R.drawable.lemon_squeeze),
                description = stringResource(id = R.string.lemon_description),
                onClick = {
                    counter = 3
                })

            3 -> ImageAndTextLayout(
                inputText = stringResource(id = R.string.tap_to_drink),
                image = painterResource(id = R.drawable.lemon_drink),
                description = stringResource(id = R.string.lemonade_description),
                onClick = {
                    counter = 4
                })

            else -> ImageAndTextLayout(
                inputText = stringResource(id = R.string.tap_to_restart),
                image = painterResource(id = R.drawable.lemon_restart),
                description = stringResource(id = R.string.glass_description),
                onClick = {
                    counter = 1
                })
        }
    }
}

@Composable
fun ImageAndTextLayout(inputText: String, image: Painter, description: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = inputText,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = image,
            contentDescription = description,
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    onClick()
                }
        )
    }
}