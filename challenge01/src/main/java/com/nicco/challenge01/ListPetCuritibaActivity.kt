package com.nicco.challenge01

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicco.challenge01.Const.ARGUMENT
import com.nicco.challenge01.repo.PetRepo
import com.nicco.challenge01.ui.theme.ComposePathwayCuritibaTheme

object Const {
    val ARGUMENT = "ok"
}

class ListPetCuritibaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePathwayCuritibaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PetScreen()
                }
            }
        }
    }
}

@Composable
fun PetScreen(modifier: Modifier = Modifier) {
    val listSize = PetRepo.getSize()
    val scrollState = rememberLazyListState()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Pet screen Curitiba")
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            LazyColumn(state = scrollState, modifier = Modifier.fillMaxWidth()) {
                items(listSize) {
                    BodyContent(it, onNameClicked = {
                        val intent = Intent(context, DetailComposeActivity::class.java).apply {
                            putExtra(ARGUMENT, it)
                        }
                        context.startActivity(intent)
                    })
                }
            }
        }
    }
}

@Composable
fun BodyContent(index: Int, modifier: Modifier = Modifier, onNameClicked: (Int) -> Unit) {
    Column(modifier = modifier
        .padding(8.dp)
        .clickable {
            onNameClicked(index)
        }) {

        Image(
            painter = painterResource(PetRepo.getPetByDrawable(index)),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(5.dp))

        Text("Nome: ${PetRepo.getPetById(index).name}", fontSize = 24.sp)
        Text("Descricao: ${PetRepo.getPetById(index).description}", fontSize = 16.sp)

        Spacer(Modifier.height(5.dp))

        val pet = PetRepo.getPetById(index)

        Column(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Row(modifier = Modifier.fillMaxHeight()) {
                CardCuritiba("Idade: ${pet.idade}")
                Spacer(Modifier.width(5.dp))
                CardCuritiba("Peso: ${pet.peso}")
                Spacer(Modifier.width(5.dp))
                Image(
                    painter = painterResource(PetRepo.getBySex(pet.sex)),
                    contentDescription = null,
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .clip(shape = RoundedCornerShape(4.dp)).align(Alignment.CenterVertically),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        Line()
    }
}

@Composable
fun CardCuritiba(text: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Cyan, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.background(Color.Cyan),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(4.dp)
                    .border(1.dp, Color.Cyan)
                    .padding(4.dp)
                    .border(1.dp, Color.Cyan)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun Line() {
    Spacer(Modifier.height(5.dp))
    Text("", modifier = Modifier.background(Color.Black).height(1.dp).fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePathwayCuritibaTheme {
        PetScreen()
    }
}