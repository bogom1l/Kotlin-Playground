package com.example.kontrolnotest2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kontrolnotest2.data.Constant
import com.example.kontrolnotest2.ui.theme.KontrolnoTest2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KontrolnoTest2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var context = LocalContext.current
    var intent = Intent(context, SecondActivity::class.java)

    var name by remember { mutableStateOf("") }
    var isInputValid by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.dobro_utro),
            modifier = modifier
                .padding(
                    bottom = 16.dp,
                    top = 100.dp
                ),
            color = Color.Yellow,
            fontSize = 68.sp
            // lineHeight = 100.sp,
        )
        TextField(
            value = name,
            onValueChange = {
                name = it
                isInputValid = it.length >= 3
            },
            placeholder = {
                Text(stringResource(R.string.enter_name))
            },
            label = {
                Text(stringResource(R.string.whats_your_name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = modifier.padding(bottom = 16.dp),
            singleLine = true
        )

        Button(
            onClick = {
                intent.putExtra(Constant.EXTRA_NAME, name)
                context.startActivity(intent)
            }) {
            Text(stringResource(R.string.nachalo))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KontrolnoTest2Theme {
        Greeting()
    }
}