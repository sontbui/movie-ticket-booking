package com.example.movieticketbookingkotlin.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieticketbookingkotlin.R

class WelcomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreenUI()
        }
    }
}
@Preview
@Composable
fun WelcomeScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        // Logo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "MBooKing",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = { /* TODO: Đổi ngôn ngữ */ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(text = "🇬🇧 English", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Ảnh phim
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Avengers Poster",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Tiêu đề
        Text(
            text = "MBooking hello!",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Enjoy your favorite movies",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Chỉ báo trang
//        Row(horizontalArrangement = Arrangement.Center) {
//            Box(
//                modifier = Modifier
//                    .size(8.dp)
//                    .background(Color.Yellow, shape = RoundedCornerShape(50))
//            )
//            Spacer(modifier = Modifier.width(4.dp))
//            Box(
//                modifier = Modifier
//                    .size(8.dp)
//                    .background(Color.Gray, shape = RoundedCornerShape(50))
//            )
//            Spacer(modifier = Modifier.width(4.dp))
//            Box(
//                modifier = Modifier
//                    .size(8.dp)
//                    .background(Color.Gray, shape = RoundedCornerShape(50))
//            )
//        }

        Spacer(modifier = Modifier.height(30.dp))

        // Nút Sign in
        Button(
            onClick = { /* TODO: Xử lý đăng nhập */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFD700)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Sign in", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Nút Sign up

        OutlinedButton(
            onClick = { /* TODO: Xử lý đăng ký */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Sign up", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Chính sách
        Text(
            text = "By signing in or signing up, you agree to our Terms of Service and Privacy Policy",
            color = Color.Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 40.dp)
        )
    }
}
