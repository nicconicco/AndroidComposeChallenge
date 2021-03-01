package com.nicco.basicmodule.lesson6

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicco.basicmodule.R
import com.nicco.basicmodule.lesson6.ui.theme.ComposePathwayCuritibaTheme


class ButtonsComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePathwayCuritibaTheme {
               setContent {
                   ButtonCuritiba2("Hola Android Curitiba.")
               }
            }
        }
    }
}

@Composable
fun ButtonCuritiba(text: String, modifier: Modifier = Modifier) {
   Button(onClick = { /*TODO*/ }
   ) {
        Text(text = text)
   }
}


@Composable
fun ButtonCuritiba2(text: String, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Image(
            painter = painterResource(R.drawable.header),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(16.dp))

        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")

        Spacer(Modifier.height(16.dp))

        ButtonCuritiba("Hola Android Curitiba.")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposePathwayCuritibaTheme {
        ButtonCuritiba("Hola Android Curitiba.")
    }
}