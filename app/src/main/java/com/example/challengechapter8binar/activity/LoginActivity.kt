package com.example.challengechapter8binar.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengechapter8binar.R
import com.example.challengechapter8binar.ui.theme.ChallengeChapter8BinarTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeChapter8BinarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplayLoginUserInterface()
                }
            }
        }
    }
}

@Composable
fun DisplayLoginUserInterface() {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "img",
            modifier = Modifier.padding(bottom = 20.dp)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Input email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Input password") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (email == "patra@email.com" && password == "123") {
                    Toast.makeText(mContext, "Login berhasil", Toast.LENGTH_SHORT).show()
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))
                } else {
                    Toast.makeText(mContext, "Usernane/password salah", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = "Login")
        }
        Text(
            text = "Register here",
            Modifier.clickable {
                mContext.startActivity(
                    Intent(
                        mContext,
                        RegisterActivity::class.java
                    )
                )
            })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    ChallengeChapter8BinarTheme {
        DisplayLoginUserInterface()
    }
}