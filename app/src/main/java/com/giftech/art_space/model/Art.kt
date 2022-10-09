package com.giftech.art_space.model

import java.util.UUID

data class Art(
    val id:UUID = UUID.randomUUID(),
    val image:String,
    val title:String,
    val artist:String,
    val year:String
)
