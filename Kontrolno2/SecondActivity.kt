package bg.tu_varna.sit.pmiulab7

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.pmiulab7.data.Constant
import bg.tu_varna.sit.pmiulab7.ui.theme.PMIULab7Theme

class InsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra(Constant.EXTRA_NAME)

        enableEdgeToEdge()
        setContent {
            PMIULab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InsertCompose(
                        name = name!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InsertCompose(name: String, modifier: Modifier = Modifier) {

    var context = LocalContext.current
    var intent = Intent(context, DisplayActivity::class.java)

    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    var isValidEmail by remember { mutableStateOf(true) }
    var isValidPhone by remember { mutableStateOf(true) }
    var isValidAddress by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.dobro_utro),
            modifier = modifier
                .padding(
                    top = 100.dp
                ),
            textAlign = TextAlign.Center,
            color = Color.Yellow,
            fontSize = 68.sp
        )
        Text(
            text = name,
            modifier = modifier
                .padding(
                    bottom = 16.dp
                ),
            textAlign = TextAlign.Center,
            color = Color.Yellow,
            fontSize = 68.sp
        )

        if (!(isValidEmail && isValidPhone && isValidAddress)) {
            Text(
                text = stringResource(R.string.error_message),
                color = Color.Red,
                modifier = modifier
            )
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    stringResource(R.string.enter_email)
                )
            },
            label = {
                Text(
                    stringResource(R.string.enter_email),
                    color = Color.Red
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            isError = !isValidEmail,
            modifier = modifier
                .padding(bottom = 16.dp)
        )

        TextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = {
                Text(stringResource(R.string.enter_phone))
            },
            label = {
                Text(
                    stringResource(R.string.enter_phone),
                    color = Color.Red
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            singleLine = true,
            isError = !isValidPhone,
            modifier = modifier
                .padding(bottom = 16.dp)
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            placeholder = {
                Text(stringResource(R.string.enter_address))
            },
            label = {
                Text(
                    stringResource(R.string.enter_address),
                    color = Color.Red
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri
            ),
            singleLine = true,
            isError = !isValidAddress,
            modifier = modifier
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                isValidPhone = Patterns.PHONE.matcher(phone).matches()
                isValidAddress = Patterns.WEB_URL.matcher(address).matches()

                if (isValidEmail && isValidPhone && isValidAddress) {
                    intent.putExtra(Constant.EXTRA_NAME, name)
                    intent.putExtra(Constant.EXTRA_EMAIL, email)
                    intent.putExtra(Constant.EXTRA_PHONE, phone)
                    intent.putExtra(Constant.EXTRA_ADDRESS, address)
                    context.startActivity(intent)
                }
            }
        ) {
            Text(stringResource(R.string.pokaji))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InsertComposePreview() {
    PMIULab7Theme {
        InsertCompose("Иван")
    }
}