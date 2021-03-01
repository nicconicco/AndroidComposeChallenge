/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nicco.challenge01.repo

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.nicco.challenge01.R

@Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
data class Pet(
    val id: Int,
    val name: String,
    val idade: String,
    val peso: String,
    val thumbUrl: Int,
    val description: String = "",
    val sex: String = "masc",
)

object PetRepo {
    fun getPetById(petId: Int): Pet = pets.find { it.id == petId }!!
    fun getPetByDrawable(petId: Int): Int = pets[petId].thumbUrl
    fun getSize(): Int = pets.size
    fun getByColor(index: Int): Color {
        return when (index) {
            index % 2 -> Color.Yellow
            index % 3 -> Color.Cyan
            3 -> Color.Green
            2 -> Color.Cyan
            1 -> Color.LightGray
            0 -> Color.Cyan
            else -> {
                Color.Red
            }
        }
    }

    fun getBySex(sex: String): Int {
        return when(sex) {
            "masc" -> R.drawable.masc
            "fem" -> R.drawable.fem
            else -> {
                R.drawable.masc
            }
        }
    }
}

val pets = listOf(
    Pet(
        id = 0,
        name = "Jairo",
        description = "Procurando um lar!",
        thumbUrl = R.drawable.dog1,
        idade = "2 anos",
        peso = "5 kilos",
        sex = "masc",
    ),
    Pet(
        id = 1,
        name = "Martin",
        description = "Oi procurando um novo lar",
        thumbUrl = R.drawable.dog2,
        idade = "2 anos",
        peso = "5 kilos",
        sex = "fem"
    ),
    Pet(
        id = 2,
        name = "Zezin",
        description = "Procurando encrenca!",
        thumbUrl = R.drawable.dog3,
        idade = "2 anos",
        peso = "5 kilos",
        sex = "fem"
    ),
    Pet(
        id = 3,
        name = "Deca",
        description = "Sou calminho",
        thumbUrl = R.drawable.dog4,
        idade = "1 anos",
        peso = "5 kilos",
        sex = "fem"
    ),
    Pet(
        id = 4,
        name = "Tito",
        description = "Aqui estou mais um dia",
        thumbUrl = R.drawable.dog5,
        idade = "2 anos",
        peso = "10 kilos",
        sex = "fem"
    ),
    Pet(
        id = 5,
        name = "robert",
        description = "Lelele lalala",
        thumbUrl = R.drawable.dog6,
        idade = "5 anos",
        peso = "3 kilos",
        sex = "fem"
    ),
    Pet(
        id = 6,
        name = "Manoel",
        description = "Adoro brincar",
        thumbUrl = R.drawable.dog1,
        idade = "5 anos",
        peso = "4 kilos",
        sex = "fem"
    ),
    Pet(
        id = 7,
        name = "Matias",
        description = "Uau uau!",
        thumbUrl = R.drawable.dog2,
        idade = "5 anos",
        peso = "15 kilos",
        sex = "fem"
    ),
    Pet(
        id = 8,
        name = "Rick",
        description = "Nao me espere, to indo.",
        thumbUrl = R.drawable.dog3,
        idade = "15 anos",
        peso = "20 kilos",
        sex = "fem"
    ),
    Pet(
        id = 9,
        name = "Muriel",
        description = "Bom dia brasil",
        thumbUrl = R.drawable.dog4,
        idade = "1 anos",
        peso = "15 kilos",
        sex = "masc"
    ),
    Pet(
        id = 10,
        name = "Gigo",
        description = "Dormindo... zzzzz",
        thumbUrl = R.drawable.dog5,
        idade = "2 anos",
        peso = "16 kilos",
        sex = "masc"
    ),
    Pet(
        id = 11,
        name = "Cris",
        description = "Mais um dia",
        thumbUrl = R.drawable.dog6,
        idade = "5 meses",
        peso = "17 kilos",
        sex = "masc"
    ),
    Pet(
        id = 12,
        name = "Fabian",
        description = "zzzz.. ocupado!",
        thumbUrl = R.drawable.dog1,
        idade = "5 anos",
        peso = "18 kilos",
        sex = "masc"
    )
)
