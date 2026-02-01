package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCard(
                name = "Morgan Lowe",
                bio = "Ready to graduate in May 2026! Let's see what awaits.",
            )
        }
    }
}

@Composable
fun ProfileCard(name: String, bio: String, modifier: Modifier = Modifier) {
    //Column arrangement to stack components vertically
    Column(
        modifier = modifier
            .fillMaxSize()
            //Adds background color
            .background(Color(0xFFC8EDFE))
            //Adds padding around entire layout
            .padding(16.dp),
        //Centers and add spacing between elements
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ){
        //Adds image from drawable folder and clips to circle shape
        Image(
            painter = painterResource(id = R.drawable.cutekitty),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        //Name and Bio text layout with name being larger than bio
        Text(
            text = name,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = bio,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ProfileCardTheme {
        ProfileCard("Morgan Lowe", bio = "Ready to Graduate in May 2026!")
    }
}