package com.example.busineescardapp

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.busineescardapp.data.Project
import com.example.busineescardapp.ui.BackgroundGradient
import com.example.busineescardapp.ui.theme.BusineesCardAppTheme
import com.example.busineescardapp.ui.theme.BusinessCardVividTang

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusineesCardAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBusinessCard()
                }
            }
        }
    }
}


@Composable
fun CreateBusinessCard(){

    val buttonClickedState = remember {
        mutableStateOf(false)

    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp)
        )
        {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                CreateImageProfile(modifier = Modifier, painter = painterResource(id = R.drawable.profile))
                Divider(
                    color = Color.Transparent
                )
                CreateInfoSection()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    },
                    colors = ButtonDefaults.buttonColors(
                        BusinessCardVividTang
                    ),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "Portifolio")
                }
            }
            if(buttonClickedState.value){
                Content()

            } else {
                Box(){

                }
            }

        }
    }
}
@Composable
fun Content(){
    val projectsArray = listOf(
        Project("Itau", R.drawable.itau, "Banking Application"),
        Project("SOM.vc", R.drawable.som, "Sistema Operacional da Musica"),
        Project("In-telligent", R.drawable.intelligent, "In-telligent App")
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(7.dp)),
            ) {
            Portifolio(projectsArray)

        }
    }

}

@Composable
fun Portifolio(data: List<Project>){
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(modifier = Modifier
                    .padding(8.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp), painterResource(id = item.image))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = item.description, style = MaterialTheme.typography.bodySmall)



                    }

                }


            }
        }
    }


}

@Composable
private fun CreateInfoSection() {
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Mariane Santana",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Android Compose Programmer")
        Text(text = "@amarianesantana")

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier, painter: Painter) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(12.dp),
        shape = CircleShape,
        color = Color.Red,
        border = BorderStroke(0.5.dp, Color.White),
        shadowElevation = 5.dp
    ) {
        Image(
            painter = painter,
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusineesCardAppTheme {
        CreateBusinessCard()
    }
}