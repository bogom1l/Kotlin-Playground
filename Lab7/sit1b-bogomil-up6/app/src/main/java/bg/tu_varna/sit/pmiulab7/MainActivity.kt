package bg.tu_varna.sit.pmiulab7

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.TextFieldCharSequence
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
import bg.tu_varna.sit.pmiulab7.ui.theme.PMIULab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMIULab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainCompose(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainCompose(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }

    var context = LocalContext.current
    var intent = Intent(context, InsertActivity::class.java)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(stringResource(R.string.enter_name))
            },
            label = {
                Text(stringResource(R.string.enter_name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true
        )

        Button(
            onClick = {
                intent.putExtra(Constant.EXTRA_NAME, name)
                context.startActivity(intent)
            }) {
            Text(stringResource(R.string.next))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainComposePreview() {
    PMIULab7Theme {
        MainCompose()
    }
}