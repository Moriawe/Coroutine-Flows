package com.moriawe.coroutinebasics.bird

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moriawe.coroutinebasics.R

@Composable
fun BirdWindowScreen(
    viewModel: BirdWindowInterface,
    modifier: Modifier = Modifier
) {
    var birdname by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = birdname,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOfBirds.forEach {
                IconButton(
                    modifier = Modifier
                        .size(50.dp),
                    onClick = {
                        birdname = it.name
                        viewModel.onClickBirdIcon(it)
                    }
                ) {
                    Icon(
                        contentDescription = "Bird songs",
                        imageVector = ImageVector.vectorResource(R.drawable.bird),
                        tint = it.color,
                    )
                }
            }
            IconButton(
                modifier = Modifier
                    .size(50.dp),
                onClick = { viewModel.closeWindow() }
            ) {
                Icon(
                    contentDescription = "Close Window",
                    imageVector = ImageVector.vectorResource(R.drawable.window)
                )
            }
        }

    }
}
