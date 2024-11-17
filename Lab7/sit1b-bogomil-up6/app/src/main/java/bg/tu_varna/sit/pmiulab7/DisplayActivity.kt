package bg.tu_varna.sit.pmiulab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.pmiulab7.data.Constant
import bg.tu_varna.sit.pmiulab7.data.Contact
import bg.tu_varna.sit.pmiulab7.ui.theme.PMIULab7Theme

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val name = intent.getStringExtra(Constant.EXTRA_NAME)
//        val email = intent.getStringExtra(Constant.EXTRA_EMAIL)
//        val phone = intent.getStringExtra(Constant.EXTRA_PHONE)

        var contact = intent.getParcelableExtra(Constant.EXTRA_CONTACT, Contact::class.java)

        enableEdgeToEdge()
        setContent {
            PMIULab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = contact!!.name,
                        email = contact!!.email,
                        phone = contact!!.phone,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, email: String, phone: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            text = "your email is $email",
            modifier = modifier,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.Green,
            textAlign = TextAlign.Center
        )
        Text(
            text = "your phone is $phone",
            modifier = modifier,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    PMIULab7Theme {
        Greeting4("Android", "email@email.bg", "088134313")
    }
}