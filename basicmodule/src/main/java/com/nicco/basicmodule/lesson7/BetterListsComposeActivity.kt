package com.nicco.basicmodule.lesson7

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicco.basicmodule.lesson7.ui.theme.ComposePathwayCuritibaTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

class BetterListsComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePathwayCuritibaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ImageList()
                }
            }
        }
    }
}

/**
 *
 * As Column doesn't handle scrolling by default, some items aren't
 * visible as they're outside of the screen. Add the verticalScroll
 * modifier to enable scrolling within the Column:
 */
@Composable
fun SimpleList() {
    Column {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

/**
 *
 * The Column renders all the list items, even the ones not
 * visible on the screen, which is a performance issue when
 * the list size gets bigger. To avoid this problem, use LazyColumn,
 * which renders only the visible items on screen, allowing performance
 * gains and doesn't need to scroll modifier.
 */
@Composable
fun SimpleList2() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()

    Column(
        Modifier.verticalScroll(scrollState)
            // adicionei isso pra pegar toda a tela.
            .fillMaxWidth()
    ) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState, modifier = Modifier.fillMaxWidth()) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CoilImage(
            data = "https://developer.android.com/images/brand/Android_Robot.png",
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ImageList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row (modifier = Modifier.fillMaxWidth()){
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }, modifier = Modifier.weight(1f).padding(5.dp)) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }, modifier = Modifier.weight(1f).padding(5.dp)) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState, modifier = Modifier.fillMaxWidth()) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposePathwayCuritibaTheme {
        ImageList()
    }
}