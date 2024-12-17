package bg.tu_varna.sit.pmiu_exam3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bg.tu_varna.sit.pmiu_exam3.model.Datasource
import bg.tu_varna.sit.pmiu_exam3.model.Place
import bg.tu_varna.sit.pmiu_exam3.ui.theme.Pmiu_exam3Theme
import kotlinx.coroutines.delay

class DataActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pmiu_exam3Theme {

                DataApp()

            }
        }
    }
}

@Composable
fun DataApp() {

    val places = remember { mutableStateListOf<Place>() }

    LaunchedEffect(Unit) {
        insertPlace(places)
    }

    LazyColumn {
        items(places) { place ->
            PlaceCard(
                place = place
            )

        }
    }

}

private suspend fun insertPlace(places: SnapshotStateList<Place>) { //MutableList<Place>
    while (true) {
        delay(2000)
        places.add(Datasource().createPlace())
    }
}


@Composable
fun PlaceCard(place: Place, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(place.drawableResourceId),
                contentDescription = place.description,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(195.dp)
            )

            Text(
                text = place.description,
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier.padding(16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PlaceCardPreview() {
    Pmiu_exam3Theme {
        PlaceCard(Datasource().createPlace())
    }
}