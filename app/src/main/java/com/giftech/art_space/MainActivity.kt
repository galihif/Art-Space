package com.giftech.art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.giftech.art_space.model.Art
import com.giftech.art_space.ui.theme.ArtSpaceTheme
import com.giftech.art_space.utils.artDummyData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    val arts = artDummyData()
    var index by remember {
        mutableStateOf(1)
    }
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
            ArtPoster(arts[index].image)
        }
        ArtDescription(arts[index])
        Spacer(modifier = Modifier.height(16.dp))
        ArtNavigator(
            index = index,
            totalArts = arts.size,
            onIndexChange = { index = it }
        )
    }
}

@Composable
fun ArtNavigator(
    index: Int,
    totalArts: Int,
    onIndexChange: (Int) -> Unit
) {
    Row(Modifier.fillMaxWidth()) {
        Box(Modifier.weight(1f)) {
            Button(
                onClick = {
                    if (index == 0) {
                        onIndexChange(totalArts - 1)
                    } else {
                        onIndexChange(index - 1)
                    }
                },
                Modifier.fillMaxWidth(),
            ) {
                Text("Previous")
            }
        }
        Spacer(Modifier.width(8.dp))
        Box(Modifier.weight(1f)) {
            Button(
                onClick = {
                    if (index == totalArts - 1) {
                        onIndexChange(0)
                    } else {
                        onIndexChange(index + 1)
                    }
                },
                Modifier.fillMaxWidth(),
            ) {
                Text("Next")
            }
        }

    }
}

@Composable
fun ArtDescription(art: Art) {
    Card(
        Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = art.title,
                style = MaterialTheme.typography.h3,
                fontSize = 24.sp
            )
            Row {
                Text(
                    text = art.artist,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "(${art.year})",
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}

@Composable
fun ArtPoster(
    image: String
) {
    Surface(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.DarkGray)
    ) {
        AsyncImage(
            model = image,
            contentDescription = "",
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}