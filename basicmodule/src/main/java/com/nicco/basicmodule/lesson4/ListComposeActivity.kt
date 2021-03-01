package com.nicco.basicmodule.lesson4

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class ListComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListWithBug(addItens())
        }
    }
}

fun addItens(): MutableList<String> {
    val myList: MutableList<String> = mutableListOf()

    myList.add("1")
    myList.add("2")
    myList.add("3")
    myList.add("4")
    myList.add("5")

    return myList
}

/**
 *
 * This code is side-effect free, and transforms the input list to UI.
 * This is great code for displaying a small list. However, if the
 * function writes to a local variable, this code is not be thread-safe or correct:
 *
 */
@Composable
fun ListComposable(myList: List<String>) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            for (item in myList) {
                Text("Item: $item")
            }
        }
        Text("Count: ${myList.size}")
    }
}

@Composable
@Deprecated("Example with bug")
fun ListWithBug(myList: List<String>) {
    var items = 0

    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            for (item in myList) {
                Text("Item: $item")
                items++ // Avoid! Side-effect of the column recomposing.
            }
        }
        Text("Count: $items")
    }
}

@Composable
fun CuritibaItens(name: String, onNameClicked: (String) -> Unit) {
    Text(name, Modifier.clickable(onClick = { onNameClicked(name) }))
}

/**
 * Display a single name the user can click.
 */
@Composable
fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ListWithBug(addItens())
}