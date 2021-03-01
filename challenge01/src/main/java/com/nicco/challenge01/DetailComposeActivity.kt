package com.nicco.challenge01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicco.challenge01.Const.ARGUMENT
import com.nicco.challenge01.repo.Pet
import com.nicco.challenge01.repo.PetRepo
import com.nicco.challenge01.ui.theme.ComposePathwayCuritibaTheme

class DetailComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras?.get(ARGUMENT) as Int

        val pet = PetRepo.getPetById(id)
        setContent {
            ComposePathwayCuritibaTheme {
                ScreenDetail(pet)
            }
        }
    }
}

@Composable
fun ScreenDetail(pet: Pet) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(PetRepo.getPetByDrawable(pet.id)),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(30.dp))

            Text("Nome: ${PetRepo.getPetById(pet.id).name}", fontSize = 24.sp)
            Text("Descricao: ${PetRepo.getPetById(pet.id).description}", fontSize = 16.sp)
            Spacer(Modifier.height(20.dp))

            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                CardCuritiba("Idade: ${pet.idade}")
                Spacer(Modifier.height(10.dp))
                CardCuritiba("Peso: ${pet.peso}")
                Spacer(Modifier.height(10.dp))
                Image(
                    painter = painterResource(PetRepo.getBySex(pet.sex)),
                    contentDescription = null,
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(16.dp))
        }

        Row(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp, start = 20.dp, end = 20.dp)) {
            Button(
                onClick = { /*TODO*/
                    Toast.makeText(context, "Doguinho adotado!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.height(50.dp).fillMaxWidth()
            ) {
                Text(text = "Adote-me ja!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposePathwayCuritibaTheme {
        ScreenDetail(PetRepo.getPetById(1))
    }
}