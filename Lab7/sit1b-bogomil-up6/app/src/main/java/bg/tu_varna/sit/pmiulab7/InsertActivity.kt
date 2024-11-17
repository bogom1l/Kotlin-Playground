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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import bg.tu_varna.sit.pmiulab7.data.Constant
import bg.tu_varna.sit.pmiulab7.data.Contact
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

    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    var isValidEmail by remember { mutableStateOf(true) }
    var isValidPhone by remember { mutableStateOf(true) }


    var context = LocalContext.current
    var intent = Intent(context, DisplayActivity::class.java)


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        if (!(isValidEmail && isValidPhone)) {
            Text(
                text = stringResource(R.string.error_message),
                modifier = modifier
            )
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(stringResource(R.string.enter_email))
            },
            label = {
                Text(stringResource(R.string.enter_email))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            isError = !isValidEmail
        )

        TextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = {
                Text(stringResource(R.string.enter_phone))
            },
            label = {
                Text(stringResource(R.string.enter_phone))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            singleLine = true,
            isError = !isValidPhone
        )

        Button(
            onClick = {

                isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                isValidPhone = Patterns.PHONE.matcher(phone).matches()

                if ((isValidEmail && isValidPhone)) {
                    val contact = Contact(name, email, phone)
                    intent.putExtra(Constant.EXTRA_CONTACT, contact)
//                    intent.putExtra(Constant.EXTRA_NAME, name)
//                    intent.putExtra(Constant.EXTRA_EMAIL, email)
//                    intent.putExtra(Constant.EXTRA_PHONE, phone)
                    context.startActivity(intent)
                }
            }) {
            Text(stringResource(R.string.next))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    PMIULab7Theme {
        InsertCompose("Android")
    }
}