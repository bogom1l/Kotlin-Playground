package com.example.kontrolnotest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kontrolnotest2.data.Constant
import com.example.kontrolnotest2.ui.theme.KontrolnoTest2Theme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra(Constant.EXTRA_NAME)
        val email = intent.getStringExtra(Constant.EXTRA_EMAIL)
        val phone = intent.getStringExtra(Constant.EXTRA_PHONE)
        val address = intent.getStringExtra(Constant.EXTRA_ADDRESS)

        enableEdgeToEdge()
        setContent {
            KontrolnoTest2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = name!!,
                        email = email!!,
                        phone = phone!!,
                        address = address!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(
    name: String,
    email: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.dobro_utro),
            modifier = modifier,
            fontSize = 68.sp,
            color = Color.Yellow,
            textAlign = TextAlign.Center
        )

        Text(
            text = name,
            modifier = modifier
                .padding(bottom = 16.dp),
            fontSize = 68.sp,
            color = Color.Yellow,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Твойте данни са",
            modifier = modifier
                .padding(bottom = 30.dp),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(30.dp)
                .width(300.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Име:",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " $name",
                        color = Color.White
                    )
                }

                Row {
                    Text(
                        text = "Телефон:",
                        color = Color.Gray
                    )
                    Text(
                        text = " $phone",
                        color = Color.White
                    )
                }

                Row {
                    Text(
                        text = "Имейл:",
                        color = Color.Gray
                    )
                    Text(
                        text = " $email",
                        color = Color.White
                    )
                }

                Row {
                    Text(
                        text = "Уеб адрес:",
                        color = Color.Gray
                    )
                    Text(
                        text = " $address",
                        color = Color.White
                    )
                }
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    KontrolnoTest2Theme {
        Greeting3("Иван", "email@email.dod", "052 234 543", "email.dod")
    }
}