package com.example.busineescardapp.ui.views

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.busineescardapp.ui.BackgroundGradient
import com.example.busineescardapp.ui.theme.BusineesCardAppTheme
import com.example.busineescardapp.ui.theme.BusinessCardTitle


class RegisterScreen: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusineesCardAppTheme {

            }

        }

    }

    @Preview
    @Composable
    fun RegisterScreenPreview(){
        RegisterScreenContainer()

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegisterScreenContainer(){
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .size(600.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
                ) {

                        Text(text = "Olá!", fontSize = 36.sp, color = BusinessCardTitle, fontWeight = FontWeight.Bold)
                        Text(text = "Bem vinde ao MyFolio", fontSize = 34.sp, color = BusinessCardTitle, fontWeight = FontWeight.Bold)
                        Text(text = "Por favor, registre-se:", fontSize = 30.sp, color = BusinessCardTitle, fontWeight = FontWeight.Bold)

                        Divider()

                        TextField(value = "Name", onValueChange = { })
                        TextField(value = "Email", onValueChange = { })



            }

        }




    }

}