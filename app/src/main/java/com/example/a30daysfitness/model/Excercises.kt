package com.example.a30daysfitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Excercises (
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    val reps: Int,
    val sets: Int,
)