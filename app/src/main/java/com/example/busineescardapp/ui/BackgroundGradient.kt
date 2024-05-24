package com.example.busineescardapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.busineescardapp.CreateBusinessCard
import com.example.busineescardapp.ui.theme.BusinessCardBackground
import com.example.busineescardapp.ui.theme.BusinessCardVividTang

@Composable
fun BackgroundGradient(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        BusinessCardBackground,
                        BusinessCardVividTang

                    ),
                    center = Offset(0.0f, Float.POSITIVE_INFINITY),
                    radius = 6000f
                )
            )
    ){



    }

}

@Preview
@Composable
fun ComponentGradientBackground(){
    BackgroundGradient()
}